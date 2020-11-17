package vista;

import javax.swing.*;

public class FrmInternalConsulta1 extends JInternalFrame{

    private JPanel pnlPrincipal;
    private JTextField tbFechaIngresada;
    private JButton btnConsultar;
    private JTextField tbTotal;

    public FrmInternalConsulta1(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        //asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }
}
