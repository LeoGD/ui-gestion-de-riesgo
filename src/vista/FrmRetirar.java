package vista;

import modelo.Aporte;
import modelo.FondoDeRiesgo;
import modelo.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static vista.FrmPrincipal.*;

public class FrmRetirar extends JDialog{
    private JTextField tbFechaRetiro;
    private JTextField tbMontoRetiro;
    private JPanel pnlCargaRetiro;
    private JButton btnEnviar;
    private Integer cuit;

    public FrmRetirar(Window owner, String titulo, Integer cuitSocio)
    {
        super(owner, titulo);

        setContentPane(pnlCargaRetiro);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        this.cuit = cuitSocio;
    }

    private void asociarEventos(){
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Socios socioAporte = null;

                for(Socios item : socios){
                    if(item.getCuit() == cuit){
                        socioAporte = item;
                    }
                }

                for(Aporte item2 : aportes){
                    if()
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");*/
            }
        });
    }
}