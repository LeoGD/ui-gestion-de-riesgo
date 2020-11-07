package vista;

import javax.swing.*;

public class FrmInternalConsulta5 extends JInternalFrame{

    private JPanel pnlPrincipal;

    public FrmInternalConsulta5(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        //asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }
}
