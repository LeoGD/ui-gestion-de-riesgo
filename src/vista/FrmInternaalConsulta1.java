package vista;

import javax.swing.*;
import java.awt.*;

public class FrmInternaalConsulta1 extends JInternalFrame{

    private JPanel pnlPrincipal;

    public FrmInternaalConsulta1(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        //asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }
}
