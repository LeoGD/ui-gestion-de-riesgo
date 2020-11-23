package vista.ConsultasGenerales.ComisionesDiarias;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import controlador.OperacionController;

public class FrmInternalConsulta1 extends JInternalFrame{

    private OperacionController controladorOperador;
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
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Integer valor = 0;

                try {
                   valor = controladorOperador.totalComisionesDiarias(formato.parse(tbFechaIngresada.getText()));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                tbTotal.setText(valor.toString());
            }
        });
    }
}
