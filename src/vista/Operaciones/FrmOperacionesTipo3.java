package vista.Operaciones;

import vista.Operaciones.OperacionesTipo3.FrmCargaPrestamos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmOperacionesTipo3 extends JDialog{
    private JPanel pnlPrincipal;
    private JButton btnPrestamos;
    private FrmOperacionesTipo3 self;

    public FrmOperacionesTipo3(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnPrestamos.setPreferredSize(new Dimension(230,40));
        asociarEventos();

        this.self = this;
    }

    private void asociarEventos(){
        btnPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargaPrestamos frame = new FrmCargaPrestamos(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });
    }
}
