package vista.Operaciones;

import vista.Operaciones.OperacionesProtectores.FrmAporte;
import vista.Operaciones.OperacionesProtectores.FrmRetirar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vista.FrmPrincipal.aportes;

public class FrmOperacionesProtectores extends JDialog{
    private JPanel pnlPrincipal;
    private JButton btnAporte;
    private JButton btnRetirar;
    private FrmOperacionesProtectores self;
    private Long cuit;

    public FrmOperacionesProtectores(Window owner, String titulo, Long cuitSocio)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAporte.setPreferredSize(new Dimension(230,40));
        asociarEventos();

        this.self = this;
        this.cuit = cuitSocio;
    }

    private void asociarEventos(){
        btnAporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAporte frame = new FrmAporte(self, "Sistema de Gestion de Riesgo", cuit);
                frame.setVisible(true);
            }
        });

        btnRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmRetirar frame = new FrmRetirar(self, "Sistema de Gestion de Riesgo", cuit);

                if(aportes != null) {
                    frame.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No hay aportes realizados por este socio");
                }
            }
        });
    }
}
