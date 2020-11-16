package vista;

import modelo.Accionista;
import modelo.Documento;
import modelo.EstadoDocumento;
import modelo.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static vista.FrmPrincipal.documentos;
import static vista.FrmPrincipal.socios;
import static vista.FrmSocios.cadenaAccionista;
import static vista.FrmSocios.cadenaDocumento;

public class FrmCargarDocumentos extends JDialog{
    private JPanel pnlCargaDocumentos;
    private JTextField tbDocumentoID;
    private JTextField tbFechaRecepcion;
    private JTextField tbUsuario;
    private JButton btnEnviarDocumentos;
    private JComboBox cbTipoDocumento;
    private JComboBox cbEstadoDocumento;

    public FrmCargarDocumentos(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaDocumentos);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();
    }

    private void asociarEventos()
    {
        btnEnviarDocumentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    documentos.add(new Documento(
                            Integer.parseInt(tbDocumentoID.getText()),
                            cbTipoDocumento.getSelectedItem().toString(),
                            formato.parse(tbFechaRecepcion.getText()),
                            EstadoDocumento.valueOf(cbEstadoDocumento.getSelectedItem().toString()),
                            tbUsuario.getText()
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                for(Socios item : socios) {
                    if(cadenaAccionista.equals(item.getCuit().toString())) {
                        for (Documento item2 : documentos) {

                            Integer valor = Integer.parseInt(tbDocumentoID.getText());

                            if(valor == item2.getDocumentoID()){
                                item.setDocumentos(item2);

                                socios.add(item);
                            }
                        }
                        break;
                    }
                }

                JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el documento");
            }
        });
    }
}
