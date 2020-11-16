package vista;

import modelo.InformacionCuentasCorrientesComerciales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static vista.FrmPrincipal.CCC;

public class FrmCargaCCC extends JDialog{
    private JTextField tbFechaVencimiento;
    private JTextField tbImporteTotal;
    private JTextField tbCCCID;
    private JTextField tbEmpresaCC;
    private JButton btnEnviar;
    private JPanel pnlCargaCCC;

    public FrmCargaCCC(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaCCC);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();
    }

    private void asociarEventos(){
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    CCC.add(new InformacionCuentasCorrientesComerciales(
                            Integer.parseInt(tbCCCID.getText()),
                            tbEmpresaCC.getText(),
                            Integer.parseInt(tbImporteTotal.getText()),
                            formato.parse(tbFechaVencimiento.getText())
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
