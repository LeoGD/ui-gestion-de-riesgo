package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmOperacionesTipo1 extends JDialog{
    private JPanel pnlPrincipal;
    private JButton btnChequesPropios;
    private JButton btnChequesTerceros;
    private JButton btnPagare;
    private FrmOperacionesTipo1 self;

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
        asociarEventos();

        this.self = this;
    }

    private void asociarEventos(){
        btnChequesPropios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargaChequesPagare frame = new FrmCargaChequesPagare(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });

        btnChequesTerceros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargaChequesPagare frame = new FrmCargaChequesPagare(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });

        btnPagare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargaChequesPagare frame = new FrmCargaChequesPagare(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });
    }
}
