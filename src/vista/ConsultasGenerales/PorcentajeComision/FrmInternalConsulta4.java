package vista.ConsultasGenerales.PorcentajeComision;

import controlador.OperacionController;
import modelo.Enum.TipoOperacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmInternalConsulta4 extends JInternalFrame{

    private OperacionController operacionControlador = new OperacionController();
    private JPanel pnlPrincipal;
    private JComboBox cbTipoOperacion;
    private JTextField tbPorcentajeComision;
    private JButton btnConsulta;

    public FrmInternalConsulta4(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

    private void asociarEventos(){
        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float valor = 0;

                valor = operacionControlador.calcularComision(TipoOperacion.valueOf(String.valueOf(cbTipoOperacion.getSelectedItem())));

                tbPorcentajeComision.setText(String.valueOf(valor));
            }
        });
    }
}
