package vista.ConsultasGenerales;

import vista.ConsultasGenerales.ComisionesDiarias.FrmInternalConsulta1;
import vista.ConsultasGenerales.ConsultaSocio.FrmInternalConsulta5;
import vista.ConsultasGenerales.OperacionesAvaladas.FrmInternalConsulta2;
import vista.ConsultasGenerales.PorcentajeComision.FrmInternalConsulta4;
import vista.ConsultasGenerales.Promedio.FrmInternalConsulta3;

import javax.swing.*;
import java.awt.*;

public class FrmConsultas extends JDialog{

    private JPanel pnlPrincipal;
    private JTabbedPane tpConsultas;
    private JDesktopPane dpConsulta1;
    private JDesktopPane dpConsulta2;
    private JDesktopPane dpConsulta3;
    private JDesktopPane dpConsulta4;
    private JDesktopPane dpConsulta5;

    public FrmConsultas(Window owner, String titulo)
    {
        super(owner, titulo);

        this.setContentPane(pnlPrincipal);
        this.setSize(800,600);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //asociarEventos();

        FrmInternalConsulta1 frameConsulta1 = new FrmInternalConsulta1("Total comisiones diarias");
        frameConsulta1.setVisible(true);
        dpConsulta1.add(frameConsulta1);

        FrmInternalConsulta2 frameConsulta2 = new FrmInternalConsulta2("Total comisiones diarias");
        frameConsulta2.setVisible(true);
        dpConsulta2.add(frameConsulta2);

        FrmInternalConsulta3 frameConsulta3 = new FrmInternalConsulta3("Total comisiones diarias");
        frameConsulta3.setVisible(true);
        dpConsulta3.add(frameConsulta3);

        FrmInternalConsulta4 frameConsulta4 = new FrmInternalConsulta4("Total comisiones diarias");
        frameConsulta4.setVisible(true);
        dpConsulta4.add(frameConsulta4);

        FrmInternalConsulta5 frameConsulta5 = new FrmInternalConsulta5("Total comisiones diarias");
        frameConsulta5.setVisible(true);
        dpConsulta5.add(frameConsulta5);
    }
}
