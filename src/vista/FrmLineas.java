package vista;

import javax.swing.*;
import java.awt.*;

public class FrmLineas extends  JDialog{

    private JPanel pnlPrincipal;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public FrmLineas(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        button1.setPreferredSize(new Dimension(230,40));
        button2.setPreferredSize(new Dimension(230,40));
        button3.setPreferredSize(new Dimension(230,40));
        //asociarEventos();
    }
}
