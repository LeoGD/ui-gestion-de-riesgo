package vista;

import javax.swing.*;
import java.awt.*;

public class FrmAsignarLinea extends JDialog{
    private JPanel pnlAsignarLinea;
    private JButton btnTipo1;
    private JButton btnTipo3;
    private JButton btnTipo2;

    public FrmAsignarLinea(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlAsignarLinea);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        //this.self = this;
    }

    private void asociarEventos(){

    }
}
