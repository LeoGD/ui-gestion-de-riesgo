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

public class FrmAporte extends JDialog{
    private JPanel pnlAporte;
    private JTextField tbFechaAporte;
    private JTextField tbAporteID;
    private JTextField tbMonto;
    private JButton btnEnviar;
    private Integer cuit;

    public FrmAporte(Window owner, String titulo, Integer cuitSocio)
    {
        super(owner, titulo);

        setContentPane(pnlAporte);
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

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Socios socioAporte = null;

                for(Socios item : socios){
                    if(item.getCuit() == cuit){
                        socioAporte = item;
                    }
                }

                try {
                    aportes.add(new Aporte(
                            Integer.parseInt(tbAporteID.getText()),
                            socioAporte,
                            Integer.parseInt(tbMonto.getText()),
                            formato.parse(tbFechaAporte.getText()),
                            null,
                            new FondoDeRiesgo(Integer.parseInt(tbMonto.getText()) + fondo.getMonto())
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
