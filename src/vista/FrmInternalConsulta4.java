package vista;

import javax.swing.*;

public class FrmInternalConsulta4 extends JInternalFrame{

    private JPanel pnlPrincipal;
    private JComboBox cbTipoOperacion;
    private JTextField tbPorcentajeComision;
    private JButton btnConsulta;

    public FrmInternalConsulta4(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        //asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }
}
