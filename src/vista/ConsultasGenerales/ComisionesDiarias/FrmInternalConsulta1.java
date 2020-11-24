package vista.ConsultasGenerales.ComisionesDiarias;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import controlador.OperacionController;

public class FrmInternalConsulta1 extends JInternalFrame{

    private OperacionController controladorOperador = new OperacionController();
    private JPanel pnlPrincipal;
    private JTextField tbFechaIngresada;
    private JButton btnConsultar;
    private JTextField tbTotal;

    public FrmInternalConsulta1(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

    private void asociarEventos(){
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer valor = 0;

                valor = controladorOperador.totalComisionesDiarias(tbFechaIngresada.getText());

                tbTotal.setText(valor.toString());
            }
        });
    }
}
