package vista;

import javax.swing.*;
import java.awt.*;

public class FrmSocios extends JDialog{

    private JPanel pnlPrincipal;

    public FrmSocios(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //asociarEventos();
    }
}
