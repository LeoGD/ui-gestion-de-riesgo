package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmOperacionesTipo2 extends JDialog{
    private JPanel pnlPrincipal;
    private JButton btnCCC;
    private JButton btnTarjeta;
    private FrmOperacionesTipo2 self;

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
        asociarEventos();

        this.self = this;
    }

    private void asociarEventos(){
        btnCCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargaCCC frame = new FrmCargaCCC(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });

        btnTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DUDA A CONSULTAR
            }
        });
    }
}
