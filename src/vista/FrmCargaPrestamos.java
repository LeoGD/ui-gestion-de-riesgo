package vista;

import modelo.InformacionCheques;
import modelo.InformacionPrestamos;
import modelo.SistemaPrestamos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static vista.FrmPrincipal.cheques;
import static vista.FrmPrincipal.prestamos;

public class FrmCargaPrestamos extends JDialog{
    private JTextField tbPrestamoID;
    private JTextField tbBancoPrestamista;
    private JTextField tbCantidadCuotas;
    private JTextField tbFechaAcreditacion;
    private JTextField tbTasa;
    private JTextField tbImporteTotal;
    private JButton btnEnviar;
    private JComboBox cbSistema;
    private JPanel pnlCargaPrestamos;

    public FrmCargaPrestamos(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaPrestamos);
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
                    prestamos.add(new InformacionPrestamos(
                            Integer.parseInt(tbPrestamoID.getText()),
                            tbBancoPrestamista.getText(),
                            Integer.parseInt(tbImporteTotal.getText()),
                            Float.parseFloat(tbTasa.getText()),
                            formato.parse(tbFechaAcreditacion.getText()),
                            Integer.parseInt(tbCantidadCuotas.getText()),
                            SistemaPrestamos.valueOf(cbSistema.getSelectedItem().toString())
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Se realizó con exito la operacion");
            }
        });
    }
}
