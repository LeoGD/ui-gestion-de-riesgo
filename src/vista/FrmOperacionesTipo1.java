package vista;

import javax.swing.*;
import java.awt.*;

public class FrmOperacionesTipo1 extends JDialog{
    private JPanel pnlPrincipal;
    private JButton btnChequesPropios;
    private JButton btnChequesTerceros;
    private JButton btnPagare;

    public FrmOperacionesTipo1(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnChequesPropios.setPreferredSize(new Dimension(230,40));
        btnChequesTerceros.setPreferredSize(new Dimension(230,40));
        btnPagare.setPreferredSize(new Dimension(230,40));
        //asociarEventos();
    }
}
