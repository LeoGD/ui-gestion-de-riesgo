package vista;

import javax.swing.*;
import java.awt.*;

public class FrmOperacionesTipo2 extends JDialog{
    private JPanel pnlPrincipal;
    private JButton btnCCC;
    private JButton btnTarjeta;

    public FrmOperacionesTipo2(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnCCC.setPreferredSize(new Dimension(230,40));
        btnTarjeta.setPreferredSize(new Dimension(230,40));
        //asociarEventos();
    }
}
