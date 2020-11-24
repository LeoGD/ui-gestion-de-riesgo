package vista.Operaciones.OperacionesProtectores;

import modelo.Classes.Aporte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static vista.FrmPrincipal.*;

public class FrmRetirar extends JDialog{
    private JTextField tbFechaRetiro;
    private JTextField tbMontoRetiro;
    private JButton btnEnviar;
    private JComboBox cbAporte;
    private JPanel pnlCargaRetiro;
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private Long cuit;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Calendar fecha = Calendar.getInstance();
    private String formatedDate;

    public FrmRetirar(Window owner, String titulo, Long cuitSocio)
    {
        super(owner, titulo);

        setContentPane(pnlCargaRetiro);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        this.cuit = cuitSocio;

        cbAporte.setModel(model);

        for(Aporte item : aportes){
            model.addElement(item.getAporteID());
        }

        formatedDate = fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
        tbFechaRetiro.setText(formatedDate);
    }

    private void asociarEventos(){

        cbAporte.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                for(Aporte item : aportes){
                    if((cbAporte.getSelectedItem()).toString().equals(item.getAporteID().toString()) && item.getMonto() > 0) {
                        tbMontoRetiro.setText(item.getMonto().toString());
                    }
                }
            }
        });

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    fecha.setTime(formato.parse(tbFechaRetiro.getText()));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                for(Aporte item : aportes){

                    Long cuitSocioAporte = item.getSocio().getCuit();

                    if(cuitSocioAporte.equals(cuit)){
                        if(cbAporte.getSelectedItem().toString().equals(item.getAporteID().toString())) {

                            item.getFDR().setMonto(item.getFDR().getMonto() - Integer.parseInt(tbMontoRetiro.getText()));

                            item.setFchRetirar(formatedDate);

                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");

                cbAporte.setSelectedIndex(-1);
                tbFechaRetiro.setText(formatedDate);
            }
        });
    }
}
