package vista.Operaciones.OperacionesTipo3;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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

    public FrmCargaPrestamos(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaPrestamos);
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
                    prestamos.add(new InformacionPrestamos(
                            Integer.parseInt(tbPrestamoID.getText()),
                            tbBancoPrestamista.getText(),
                            Integer.parseInt(tbImporteTotal.getText()),
                            Float.parseFloat(tbTasa.getText()),
                            formato.parse(date()),
                            formato.parse(tbFechaAcreditacion.getText()),
                            Integer.parseInt(tbCantidadCuotas.getText()),
                            SistemaPrestamos.valueOf(cbSistema.getSelectedItem().toString()),
                            EstadoOperacion.INGRESADO,
                            certificado
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                for(InformacionPrestamos item2 : prestamos){
                    if(item2.getInformacionPrestamoID().equals(Integer.parseInt(tbPrestamoID.getText()))){
                        socio.setTramiteprestamo(item2);
                        socio.getTramiteprestamo().setEstadoOperacion(EstadoOperacion.CON_CERTIFICADO_EMITIDO);
                    }
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
