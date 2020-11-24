package vista.Operaciones.OperacionesTipo3;

import modelo.Classes.*;
import modelo.Enum.EstadoComision;
import modelo.Enum.EstadoOperacion;
import modelo.Enum.SistemaPrestamos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static vista.FrmPrincipal.*;

public class FrmCargaPrestamos extends JDialog{
    private JTextField tbPrestamoID;
    private JTextField tbBancoPrestamista;
    private JTextField tbCantidadCuotas;
    private JTextField tbFechaAcreditacion;
    private JTextField tbTasa;
    private JTextField tbImporteTotal;
    private JButton btnEnviar;
    private JComboBox cbSistema;
    private JPanel pnlCargaPrestamos;
    private Calendar fecha = Calendar.getInstance();
    private String formatedDate;

    public FrmCargaPrestamos(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaPrestamos);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        tbPrestamoID.setText(IDPrestamo.toString());
        formatedDate = fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
    }

    private void asociarEventos(){
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Certificados certificado = null;
                Socios socio = null;
                boolean validacionFDR = false;

                if (Integer.parseInt(tbImporteTotal.getText()) > fondo.getMonto() * 0.05) {
                    validacionFDR = true;
                }

                for (Socios item : socios) {
                    if (item.getCuit().toString().equals(cadenaOperacion)) {
                        socio = item;
                    }
                }

                certificados.add(new Certificados(
                        contadorCertificados++
                ));

                for (Certificados item : certificados) {
                    if (item.getNumCertificado().equals(contadorCertificados)) {
                        certificado = item;
                    }
                }

                if (!validacionFDR) {
                    prestamos.add(new InformacionPrestamos(
                            Integer.parseInt(tbPrestamoID.getText()),
                            tbBancoPrestamista.getText(),
                            Integer.parseInt(tbImporteTotal.getText()),
                            Float.parseFloat(tbTasa.getText()),
                            formatedDate,
                            tbFechaAcreditacion.getText(),
                            Integer.parseInt(tbCantidadCuotas.getText()),
                            SistemaPrestamos.valueOf(cbSistema.getSelectedItem().toString()),
                            EstadoOperacion.INGRESADO,
                            certificado,
                            0.04f,
                            EstadoComision.Calculada,
                            null
                    ));

                    for (InformacionPrestamos item2 : prestamos) {
                        if (item2.getInformacionPrestamoID().equals(Integer.parseInt(tbPrestamoID.getText()))) {
                            socio.setTramiteprestamo(item2);
                            socio.getTramiteprestamo().setEstadoOperacion(EstadoOperacion.CON_CERTIFICADO_EMITIDO);

                            Cambios cambioEstadoOperacion = new Cambios(
                                    contadorCambio++,
                                    fecha.getTime(),
                                    String.valueOf(EstadoOperacion.INGRESADO),
                                    socio.getTramiteprestamo().getEstadoOperacion().toString(),
                                    "En Operacion",
                                    ""
                            );

                            socio.getTramiteprestamo().setEstadoOperacion(EstadoOperacion.MONETIZADO);


                            Cambios cambioEstadoOperacion2 = new Cambios(
                                    contadorCambio++,
                                    fecha.getTime(),
                                    String.valueOf(EstadoOperacion.CON_CERTIFICADO_EMITIDO),
                                    socio.getTramiteprestamo().getEstadoOperacion().toString(),
                                    "En Operacion",
                                    ""
                            );

                            socio.getTramiteprestamo().setEstadocomision(EstadoComision.Facturada);

                            Cambios cambioEstadoComision = new Cambios(
                                    contadorCambio++,
                                    fecha.getTime(),
                                    String.valueOf(EstadoComision.Facturada),
                                    socio.getTramiteprestamo().getEstadocomision().toString(),
                                    "En Comision",
                                    ""
                            );

                            contadorfactura++;

                            socio.getTramiteprestamo().setFactura(new Factura(contadorfactura));
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");

                    IDPrestamo = IDPrestamo + 1111;

                    tbPrestamoID.setText(IDPrestamo.toString());
                    tbImporteTotal.setText("");
                    tbCantidadCuotas.setText("");
                    tbFechaAcreditacion.setText("");
                    tbBancoPrestamista.setText("");
                    tbTasa.setText("");
                    cbSistema.setSelectedIndex(-1);
                }
                else if(validacionFDR) {
                    JOptionPane.showMessageDialog(null, "No es posible operar con montos mayores al 5% del fondo de riesgo");

                    tbImporteTotal.setText("");
                }
            }
        });
    }
}
