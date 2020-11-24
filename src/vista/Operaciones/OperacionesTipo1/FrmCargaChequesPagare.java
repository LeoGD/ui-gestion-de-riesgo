package vista.Operaciones.OperacionesTipo1;

import modelo.Classes.*;
import modelo.Enum.EstadoComision;
import modelo.Enum.EstadoOperacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static vista.FrmPrincipal.*;

public class FrmCargaChequesPagare extends  JDialog{
    private JTextField tbCuitFirmante;
    private JTextField tbFechaVencimiento;
    private JTextField tbBanco;
    private JTextField tbNumero;
    private JButton btnEnviar;
    private JPanel pnlCargaChequesPagare;
    private JTextField tbMontoCheque;
    private MercadoArgentinoValores MAV;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar fecha = Calendar.getInstance();
    private String formatedDate;

    public FrmCargaChequesPagare(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaChequesPagare);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        formatedDate = fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
    }

    private void asociarEventos(){
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Certificados certificado = null;
                Socios socio = null;
                boolean validacionFDR = false;

                if (Integer.parseInt(tbMontoCheque.getText()) > fondo.getMonto() * 0.05) {
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
                    cheques.add(new InformacionCheques(
                            Integer.parseInt(tbNumero.getText()),
                            tbBanco.getText(),
                            formatedDate,
                            tbFechaVencimiento.getText(),
                            Integer.parseInt(tbCuitFirmante.getText()),
                            EstadoOperacion.INGRESADO,
                            certificado,
                            MAV,
                            0.03f,
                            Integer.parseInt(tbMontoCheque.getText()),
                            EstadoComision.Calculada,
                            null
                    ));

                    for (InformacionCheques item2 : cheques) {
                        if (item2.getNumDelCheque().equals(Integer.parseInt(tbNumero.getText()))) {
                            socio.setTramitecheque(item2);
                            socio.getTramitecheque().setEstadoOperacion(EstadoOperacion.CON_CERTIFICADO_EMITIDO);
                            socio.getTramitecheque().setEstadoOperacion(EstadoOperacion.MONETIZADO);
                            socio.getTramitecheque().setEstadocomision(EstadoComision.Facturada);

                            contadorfactura++;

                            socio.getTramitecheque().setFactura(new Factura(contadorfactura));

                            if (socio.getTramitecheque().getEstadoOperacion().equals(EstadoOperacion.MONETIZADO)) {
                                riesgovivo.setMonto(riesgovivo.getMonto() + socio.getTramitecheque().getMontoCheque());
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");

                    tbNumero.setText("");
                    tbMontoCheque.setText("");
                    tbFechaVencimiento.setText("");
                    tbBanco.setText("");
                    tbCuitFirmante.setText("");
                }
                else if(validacionFDR){
                    JOptionPane.showMessageDialog(null, "No es posible operar con montos mayores al 5% del fondo de riesgo");

                    tbMontoCheque.setText("");
                }
            }
        });
    }
}
