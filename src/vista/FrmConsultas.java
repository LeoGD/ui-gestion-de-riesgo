package vista;

import javax.swing.*;
import java.awt.*;

public class FrmConsultas extends JDialog{
    private JPanel pnlPrincipal;
    private JTabbedPane tpConsultas;
    private JDesktopPane dpConsulta1;

    public FrmConsultas(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(800,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //asociarEventos();

        FrmInternaalConsulta1 frameConsulta1 = new FrmInternaalConsulta1("Total comisiones diarias");
        frameConsulta1.setVisible(true);
        dpConsulta1.add(frameConsulta1);
    }
}
