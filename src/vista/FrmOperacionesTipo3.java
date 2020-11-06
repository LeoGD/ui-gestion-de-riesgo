package vista;

import javax.swing.*;
import java.awt.*;

public class FrmOperacionesTipo3 extends JDialog{
    private JPanel pnlPrincipal;
    private JButton btnPrestamos;

    public FrmOperacionesTipo3(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnPrestamos.setPreferredSize(new Dimension(230,40));
        //asociarEventos();
    }
}
