package vista.ConsultasGenerales.OperacionesAvaladas;

import controlador.SociosController;
import modelo.Operacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FrmInternalConsulta2 extends JInternalFrame{

    private SociosController sociosControlador;
    private JPanel pnlPrincipal;
    private JTextField tbCUIT;
    private JTextField tbFechaHasta;
    private JTextField tbFechaDesde;
    private JButton btnConsulta;
    private JTable tOperacionesAvaladas;
    private DefaultTableModel tableModel;

    public FrmInternalConsulta2(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        this.tableModel = new DefaultTableModel(0, 2) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false; //Con esto conseguimos que la tabla no se pueda editar
            }
        };

        this.tableModel.addColumn("Operacion");
        this.tableModel.addColumn("Fecha operacion");

        tOperacionesAvaladas.setModel(tableModel);
    }

    private void asociarEventos(){

        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
