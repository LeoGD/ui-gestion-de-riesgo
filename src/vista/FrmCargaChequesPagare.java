package vista;

import modelo.InformacionCheques;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static vista.FrmPrincipal.*;
import static vista.FrmSocios.cadenaAccionista;

public class FrmCargaChequesPagare extends  JDialog{
    private JTextField tbCuitFirmante;
    private JTextField tbFechaVencimiento;
    private JTextField tbBanco;
    private JTextField tbNumero;
    private JButton btnEnviar;
    private JPanel pnlCargaChequesPagare;

    public FrmCargaChequesPagare(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaChequesPagare);
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
                    cheques.add(new InformacionCheques(
                            Integer.parseInt(tbNumero.getText()),
                            tbBanco.getText(),
                            formato.parse(tbFechaVencimiento.getText()),
                            Integer.parseInt(tbCuitFirmante.getText())
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
