package vista.Socios.MenuSocios;

import modelo.Classes.Documento;
import modelo.Enum.EstadoDocumento;
import modelo.Classes.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static vista.FrmPrincipal.*;
import static vista.Socios.FrmSocios.cadenaAccionista;

public class FrmCargarDocumentos extends JDialog{
    private JPanel pnlCargaDocumentos;
    private JTextField tbDocumentoID;
    private JTextField tbFechaRecepcion;
    private JTextField tbUsuario;
    private JButton btnEnviarDocumentos;
    private JComboBox cbTipoDocumento;
    private JComboBox cbEstadoDocumento;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
    private Calendar fecha = Calendar.getInstance();
    private String formatedDate;


    public FrmCargarDocumentos(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaDocumentos);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        tbDocumentoID.setText(IDDocumento.toString());
        formatedDate = fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
        tbFechaRecepcion.setText(formatedDate);
    }

    private void asociarEventos()
    {
        btnEnviarDocumentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean validacion = false;

                for(Documento item : documentos){
                    if(item.getDocumentoID().equals(Long.parseLong(tbDocumentoID.getText()))){
                        validacion = true;
                    }
                }

                documentos.add(new Documento(
                        Long.parseLong(tbDocumentoID.getText()),
                        cbTipoDocumento.getSelectedItem().toString(),
                        formatedDate,
                        EstadoDocumento.valueOf(cbEstadoDocumento.getSelectedItem().toString()),
                        tbUsuario.getText()
                ));


                for(Socios item : socios) {
                    if(cadenaAccionista.equals(item.getCuit().toString())) {
                        for (Documento item2 : documentos) {

                            Integer valor = Integer.parseInt(tbDocumentoID.getText());

                            if(valor.equals(item2.getDocumentoID())){

                                item.setDocumentos(item2);
                            }
                        }
                        break;
                    }
                }

                JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el documento");

                IDDocumento = IDDocumento + 1111;

                tbDocumentoID.setText(IDDocumento.toString());
                tbFechaRecepcion.setText("");
                tbUsuario.setText("");
                cbTipoDocumento.setSelectedIndex(-1);
                cbEstadoDocumento.setSelectedIndex(-1);
            }
        });
    }
}
