package vista;

import javax.swing.*;
import java.awt.*;

public class FrmLineas extends  JDialog{

    private JPanel pnlPrincipal;
    private JButton btnAsignarSocio;
    private JButton btnAprobar;

    public FrmLineas(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAsignarSocio.setPreferredSize(new Dimension(230,40));
        btnAprobar.setPreferredSize(new Dimension(230,40));
        //asociarEventos();
    }
}
