package vista.ConsultasGenerales.ConsultaSocio;

import controlador.SociosController;
import modelo.DatosConsulta;
import modelo.LineaDeCredito;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmInternalConsulta5 extends JInternalFrame{

    private SociosController socioControlador;
    private JPanel pnlPrincipal;
    private JTextField tbCUIT;
    private JButton btnConsulta;
    private JTextField tbUtilizadoDeLinea;
    private JTextField tbRiesgoVivo;

    public FrmInternalConsulta5(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

    private void asociarEventos(){
        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LineaDeCredito consulta = new LineaDeCredito();

                consulta = socioControlador.consultaRiesgoVivoyTotal(Long.parseLong(tbCUIT.getText()));

                tbRiesgoVivo.setText(consulta.getMonto().toString());
                tbUtilizadoDeLinea.setText(consulta.getUtilizadoDeLinea().toString());
            }
        });
    }
}
