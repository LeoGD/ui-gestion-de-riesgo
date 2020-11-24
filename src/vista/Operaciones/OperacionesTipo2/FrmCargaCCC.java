package vista.Operaciones.OperacionesTipo2;

import modelo.Classes.Certificados;
import modelo.Classes.Factura;
import modelo.Classes.InformacionCuentasCorrientesComerciales;
import modelo.Classes.Socios;
import modelo.Enum.EstadoComision;
import modelo.Enum.EstadoOperacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static vista.FrmPrincipal.*;

public class FrmCargaCCC extends JDialog{
    private JTextField tbFechaVencimiento;
    private JTextField tbImporteTotal;
    private JTextField tbCCCID;
    private JTextField tbEmpresaCC;
    private JButton btnEnviar;
    private JPanel pnlCargaCCC;
    private String formatedDate;
    private Calendar fecha = Calendar.getInstance();

    public FrmCargaCCC(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaCCC);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        tbCCCID.setText(IDCuentaCorriente.toString());
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
                    CCC.add(new InformacionCuentasCorrientesComerciales(
                            Integer.parseInt(tbCCCID.getText()),
                            tbEmpresaCC.getText(),
                            Integer.parseInt(tbImporteTotal.getText()),
                            formatedDate,
                            tbFechaVencimiento.getText(),
                            EstadoOperacion.INGRESADO,
                            certificado,
                            0.03f,
                            EstadoComision.Calculada,
                            null
                    ));

                    for (InformacionCuentasCorrientesComerciales item2 : CCC) {
                        if (item2.getInformacionCCCID().equals(Integer.parseInt(tbCCCID.getText()))) {
                            socio.setTramiteCCC(item2);
                            socio.getTramiteCCC().setEstadoOperacion(EstadoOperacion.CON_CERTIFICADO_EMITIDO);
                            socio.getTramiteCCC().setEstadoOperacion(EstadoOperacion.MONETIZADO);

                            contadorfactura++;

                            socio.getTramiteCCC().setFactura(new Factura(contadorfactura));

                            if(socio.getTramiteCCC().getEstadoOperacion().equals(EstadoOperacion.MONETIZADO)){
                                riesgovivo.setMonto(riesgovivo.getMonto() + socio.getTramiteCCC().getImporteTotal());
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");

                    IDCuentaCorriente = IDCuentaCorriente + 1111;

                    tbCCCID.setText(IDCuentaCorriente.toString());
                    tbFechaVencimiento.setText("");
                    tbEmpresaCC.setText("");
                    tbImporteTotal.setText("");
                }
                else if(validacionFDR){
                    JOptionPane.showMessageDialog(null, "No es posible operar con montos mayores al 5% del fondo de riesgo");

                    tbImporteTotal.setText("");
                }
            }
        });
    }
}
