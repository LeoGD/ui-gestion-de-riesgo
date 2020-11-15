package vista;

import modelo.Accionista;
import modelo.Documento;
import modelo.EstadoDocumento;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static vista.FrmPrincipal.accionistas;
import static vista.FrmPrincipal.documentos;

public class FrmCargarDocumentos extends JDialog{
    private JPanel pnlCargaDocumentos;
    private JTextField tbDocumentoID;
    private JTextField tbFechaRecepcion;
    private JTextField tbUsuario;
    private JButton btnEnviarDocumentos;
    private JComboBox cbTipoDocumento;
    private JComboBox cbEstadoDocumento;
    public static final List<Documento> documentosAlternos = new ArrayList<>();

    public FrmCargarDocumentos(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaDocumentos);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        //this.self = this;
    }

    private void asociarEventos()
    {
        btnEnviarDocumentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(Documento item : documentos) {

                    item.setDocumentoID(Integer.parseInt(tbDocumentoID.getText()));
                    item.setTipoDocumento(cbTipoDocumento.getSelectedItem().toString());
                    item.setFchRecepcion(Date.valueOf(tbFechaRecepcion.getText()));
                    item.setEstado(EstadoDocumento.valueOf(cbEstadoDocumento.getSelectedItem().toString()));
                    item.setUsuario(tbUsuario.getText());

                    documentosAlternos.add(item);
                }

                JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el accionista");
            }
        });
    }
}
