package vista.Operaciones.OperacionesProtectores;

import modelo.Classes.Aporte;
import modelo.Classes.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static vista.FrmPrincipal.*;

public class FrmAporte extends JDialog{
    private JPanel pnlAporte;
    private JTextField tbFechaAporte;
    private JTextField tbAporteID;
    private JTextField tbMonto;
    private JButton btnEnviar;
    private Long cuit;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar fecha = Calendar.getInstance();
    private String formatedDate;

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

        tbAporteID.setText(IDApo.toString());
        formatedDate = fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
        tbFechaAporte.setText(formatedDate);
    }

    private void asociarEventos(){
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Socios socioAporte = null;
                boolean validacionFDR = false;

                if (Integer.parseInt(tbMonto.getText()) > fondo.getMonto() * 0.05) {
                    validacionFDR = true;
                }

                for (Socios item : socios) {
                    if (item.getCuit().equals(cuit)) {
                        socioAporte = item;
                    }
                }

                fondo.setMonto(fondo.getMonto() + Integer.parseInt(tbMonto.getText()));

                if (!validacionFDR) {
                    aportes.add(new Aporte(
                            Integer.parseInt(tbAporteID.getText()),
                            socioAporte,
                            Integer.parseInt(tbMonto.getText()),
                            formatedDate,
                            null,
                            fondo
                    ));

                    if (socioAporte.getCuit().equals(cuit)) {
                        for (Aporte item2 : aportes) {

                            Integer valor = Integer.parseInt(tbAporteID.getText());

                            if (valor.equals(item2.getAporteID())) {

                                socioAporte.setAportes(aportes);

                                break;
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");

                    IDApo = IDApo + 1111;

                    tbAporteID.setText(IDApo.toString());
                    tbMonto.setText("");
                    tbFechaAporte.setText(formatedDate);
                }
                else if(validacionFDR){
                    JOptionPane.showMessageDialog(null, "No es posible operar con montos mayores al 5% del fondo de riesgo");

                    tbMonto.setText("");
                }
            }
        });
    }
}
