package vista.Operaciones.OperacionesProtectores;

import modelo.Aporte;

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
    private JButton btnEnviar;
    private JComboBox cbAporte;
    private JPanel pnlCargaRetiro;
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private Long cuit;

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
    }

    private void asociarEventos(){
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                for(Aporte item : aportes){

                    Long cuitSocioAporte = item.getSocio().getCuit();

                    if(cuitSocioAporte.equals(cuit)){
                        if(cbAporte.getSelectedItem().toString().equals(item.getAporteID())) {

                            item.getFDR().setMonto(item.getFDR().getMonto() - Integer.parseInt(tbMontoRetiro.getText()));
                            try {
                                item.setFchRetirar(formato.parse(tbFechaRetiro.getText()));
                            } catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                        }
                    }
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
