package vista.ConsultasGenerales.ConsultaSocio;

import controlador.SociosController;
import modelo.Classes.LineaDeCredito;
import modelo.Classes.Socios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vista.FrmPrincipal.socios;

public class FrmInternalConsulta5 extends JInternalFrame{

    private SociosController socioControlador = new SociosController();
    private JPanel pnlPrincipal;
    private JTextField tbCUIT;
    private JButton btnConsulta;
    private JTextField tbUtilizadoDeLinea;
    private JTextField tbRiesgoVivo;
    private JComboBox cbCUIT;
    private DefaultComboBoxModel model = new DefaultComboBoxModel();

    public FrmInternalConsulta5(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        cbCUIT.setModel(model);

        for(Socios item : socios){
            model.addElement(item.getCuit());
        }
    }

    private void asociarEventos(){
        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LineaDeCredito consulta;

                consulta = socioControlador.consultaRiesgoVivoyTotal(Long.parseLong(tbCUIT.getText()));

                //tbRiesgoVivo.setText(consulta.getMonto().toString());
                tbRiesgoVivo.setText("0");
                tbUtilizadoDeLinea.setText(consulta.getUtilizadoDeLinea().toString());
            }
        });
    }
}
