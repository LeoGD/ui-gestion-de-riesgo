package vista;

import javax.swing.*;
import java.awt.*;

public class FrmSocios extends JDialog{

    private JPanel pnlPrincipal;
    private JButton btnAltaSocio;
    private JButton btnSubAcc;
    private JButton btnAltaDoc;

    public FrmSocios(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAltaDoc.setPreferredSize(new Dimension(230,40));
        btnAltaSocio.setPreferredSize(new Dimension(230,40));
        btnSubAcc.setPreferredSize(new Dimension(230,40));
        //asociarEventos();
    }
}
