package vista;

import javax.swing.*;

public class FrmInternalConsulta2 extends JInternalFrame{

    private JPanel pnlPrincipal;
    private JTextField tbCUIT;
    private JTextField tbFechaHasta;
    private JTextField tbFechaDesde;
    private JButton btnConsulta;
    private JTable tOperacionesAvaladas;

    public FrmInternalConsulta2(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        //asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }
}
