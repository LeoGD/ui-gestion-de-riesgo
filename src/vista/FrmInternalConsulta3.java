package vista;

import javax.swing.*;

public class FrmInternalConsulta3 extends JInternalFrame{

    private JPanel pnlPrincipal;
    private JTextField tbFechaDesde;
    private JTextField tbFechaHasta;
    private JComboBox cbTipoEmpresa;
    private JButton consultarButton;
    private JTextField tbPromedioTO;
    private JTextField tbPromedioTD;

    public FrmInternalConsulta3(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        //asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }
}
