package vista;

import modelo.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSocios extends JDialog{

    private JPanel pnlPrincipal;
    private JButton btnAltaSocio;
    private JButton btnSubAcc;
    private JButton btnAltaDoc;
    private JButton btnCargarAcc;

    private FrmSocios self;

    public FrmSocios(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAltaDoc.setPreferredSize(new Dimension(230,40));
        btnCargarAcc.setPreferredSize(new Dimension(230,40));
        btnAltaSocio.setPreferredSize(new Dimension(230,40));
        btnSubAcc.setPreferredSize(new Dimension(230,40));
        asociarEventos();

        this.self = this;

    }

    private void asociarEventos()
    {
        btnAltaSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargarSocios frame = new FrmCargarSocios(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });

        btnCargarAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Socios socio = new Socios();

                JOptionPane.showMessageDialog(null,socio.getRazonSocial());

            }
        });
    }
}
