package vista.ConsultasGenerales.OperacionesAvaladas;

import controlador.SociosController;
import modelo.Classes.Operacion;
import modelo.Classes.Socios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static vista.FrmPrincipal.socios;

public class FrmInternalConsulta2 extends JInternalFrame{

    private SociosController sociosControlador = new SociosController();
    private JPanel pnlPrincipal;
    private JTextField tbFechaHasta;
    private JTextField tbFechaDesde;
    private JButton btnConsulta;
    private JTable tOperacionesAvaladas;
    private JComboBox cbCUIT;
    private DefaultTableModel tableModel = new DefaultTableModel();
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private String[] nombresColumnas = {"Operacion", "Fecha Operacion"};

    public FrmInternalConsulta2(String titulo)
    {
        super(titulo);
        setContentPane(pnlPrincipal);
        asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        cbCUIT.setModel(model);

        for (Socios item : socios) {
            model.addElement(item.getCuit());
        }

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

                List<Operacion> consulta = null;

                consulta = sociosControlador.operacionesAvaladas(Long.parseLong(cbCUIT.getSelectedItem().toString()), tbFechaDesde.getText(), tbFechaHasta.getText());

                Object[][] data = {{"Kathy", "Smith"},{"John", "Doe"}};
                tOperacionesAvaladas = new JTable(data, nombresColumnas);
                tOperacionesAvaladas.setFillsViewportHeight(true);
            }
        });
    }
}
