package vista;

import javax.swing.*;
import java.awt.*;

public class FrmCargarSocios extends JDialog{
    private JPanel pnlCargaSocios;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox cbTipoEmpresa;
    private JTextField textField4;
    private JButton enviarButton;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;

    public FrmCargarSocios(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaSocios);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //asociarEventos();

        //this.self = this;
    }
}
