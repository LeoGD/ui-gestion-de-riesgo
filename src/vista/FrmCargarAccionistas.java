package vista;

import modelo.Socios;
import modelo.TipoEmpresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FrmCargarAccionistas extends JDialog{
    private JPanel pnlCargaAccionistas;
    private JTextField tbCUITAccionista;
    private JTextField tbParticipacion;
    private JTextField tbRazonSocial;
    private JTextField tbAccionistaID;
    private JButton btnEnviarAccionista;

    public FrmCargarAccionistas(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaAccionistas);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        //this.self = this;

    }

    private void asociarEventos()
    {
        btnEnviarAccionista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el socio");
            }
        });
    }
}
