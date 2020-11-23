package vista.Operaciones.OperacionesTipo1;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static vista.FrmPrincipal.*;

public class FrmCargaChequesPagare extends  JDialog{
    private JTextField tbCuitFirmante;
    private JTextField tbFechaVencimiento;
    private JTextField tbBanco;
    private JTextField tbNumero;
    private JButton btnEnviar;
    private JPanel pnlCargaChequesPagare;
    private MercadoArgentinoValores MAV;

    public FrmCargaChequesPagare(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaChequesPagare);
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
                    cheques.add(new InformacionCheques(
                            Integer.parseInt(tbNumero.getText()),
                            tbBanco.getText(),
                            formato.parse(date()),
                            formato.parse(tbFechaVencimiento.getText()),
                            Integer.parseInt(tbCuitFirmante.getText()),
                            EstadoOperacion.INGRESADO,
                            certificado,
                            MAV
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                for(InformacionCheques item2 : cheques){
                    if(item2.getNumDelCheque().equals(Integer.parseInt(tbNumero.getText()))){
                        socio.setTramitecheque(item2);
                        socio.getTramitecheque().setEstadoOperacion(EstadoOperacion.CON_CERTIFICADO_EMITIDO);
                    }
                }
                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
