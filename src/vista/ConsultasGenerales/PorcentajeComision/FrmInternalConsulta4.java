package vista.ConsultasGenerales.PorcentajeComision;

import controlador.OperacionController;
import modelo.TipoEmpresa;
import modelo.TipoOperacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmInternalConsulta4 extends JInternalFrame{

    private OperacionController operacionControlador;
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

                valor = operacionControlador.calcularComision(TipoOperacion.valueOf(cbTipoOperacion.getSelectedItem().toString()));

                tbPorcentajeComision.setText(String.valueOf(valor));
            }
        });
    }
}
