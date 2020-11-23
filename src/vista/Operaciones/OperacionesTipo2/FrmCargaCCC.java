package vista.Operaciones.OperacionesTipo2;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static vista.FrmPrincipal.*;

public class FrmCargaCCC extends JDialog{
    private JTextField tbFechaVencimiento;
    private JTextField tbImporteTotal;
    private JTextField tbCCCID;
    private JTextField tbEmpresaCC;
    private JButton btnEnviar;
    private JPanel pnlCargaCCC;

    public FrmCargaCCC(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaCCC);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();
    }

    private void asociarEventos(){
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Certificados certificado = null;
                Socios socio = null;

                for(Socios item : socios){
                    if(item.getCuit().equals(Long.parseLong(cadenaOperacion))){
                        socio = item;
                    }
                }

                certificados.add(new Certificados(
                        contadorCertificados++
                ));

                for(Certificados item : certificados){
                    if(item.getNumCertificado().equals(contadorCertificados)){
                        certificado = item;
                    }
                }

                try {
                    CCC.add(new InformacionCuentasCorrientesComerciales(
                            Integer.parseInt(tbCCCID.getText()),
                            tbEmpresaCC.getText(),
                            Integer.parseInt(tbImporteTotal.getText()),
                            formato.parse(date()),
                            formato.parse(tbFechaVencimiento.getText()),
                            EstadoOperacion.INGRESADO,
                            certificado
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                for(InformacionCuentasCorrientesComerciales item2 : CCC){
                    if(item2.getInformacionCCCID().equals(Integer.parseInt(tbCCCID.getText()))){
                        socio.setTramiteCCC(item2);
                        socio.getTramiteCCC().setEstadoOperacion(EstadoOperacion.CON_CERTIFICADO_EMITIDO);
                    }
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
