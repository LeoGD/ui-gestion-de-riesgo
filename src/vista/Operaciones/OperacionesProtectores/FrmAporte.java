package vista.Operaciones.OperacionesProtectores;

import modelo.*;

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
    private Long cuit;

    public FrmAporte(Window owner, String titulo, Long cuitSocio)
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
                    if(item.getCuit().equals(cuit)){
                        socioAporte = item;
                    }
                }

                fondo.setMonto(fondo.getMonto() + Integer.parseInt(tbMonto.getText()));

                try {
                    aportes.add(new Aporte(
                            Integer.parseInt(tbAporteID.getText()),
                            socioAporte,
                            Integer.parseInt(tbMonto.getText()),
                            formato.parse(tbFechaAporte.getText()),
                            null,
                            fondo
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                if(socioAporte.getCuit().equals(cuit)) {
                    for (Aporte item2 : aportes) {

                        Integer valor = Integer.parseInt(tbAporteID.getText());

                        if(valor.equals(item2.getAporteID())){

                            socioAporte.setAportes(aportes);

                            break;
                        }
                    }
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
