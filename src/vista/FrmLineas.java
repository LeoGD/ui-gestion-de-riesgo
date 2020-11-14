package vista;

import modelo.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vista.FrmPrincipal.socios;

public class FrmLineas extends  JDialog{

    private JPanel pnlPrincipal;
    private JButton btnAsignarSocio;
    private JButton btnAprobar;

    public FrmLineas(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAsignarSocio.setPreferredSize(new Dimension(230,40));
        btnAprobar.setPreferredSize(new Dimension(230,40));
        asociarEventos();
    }

    private void asociarEventos(){
        btnAsignarSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena = JOptionPane.showInputDialog(null, "Ingrese el CUIT del socio: ");

                for(Socios item : socios){
                    if(cadena.equals(item.getCuit())){

                    }
                }
            }
        });
    }
}
