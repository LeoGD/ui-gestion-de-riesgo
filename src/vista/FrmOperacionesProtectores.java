package vista;

import javax.swing.*;
import java.awt.*;

public class FrmOperacionesProtectores extends JDialog{
    private JPanel pnlPrincipal;
    private JButton btnAporte;

    public FrmOperacionesProtectores(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAporte.setPreferredSize(new Dimension(230,40));
        //asociarEventos();
    }
}
