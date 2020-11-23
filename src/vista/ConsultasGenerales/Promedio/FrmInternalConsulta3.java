package vista.ConsultasGenerales.Promedio;

import controlador.SociosController;
import modelo.DatosConsulta;
import modelo.TipoEmpresa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FrmInternalConsulta3 extends JInternalFrame{

    private SociosController socioControlador;
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
        asociarEventos();

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

    private void asociarEventos(){
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DatosConsulta resultados = new DatosConsulta();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    resultados = socioControlador.calcularPromedioDescuentoYTotal(formato.parse(tbFechaDesde.getText()), formato.parse(tbFechaHasta.getText()), TipoEmpresa.valueOf(cbTipoEmpresa.getSelectedItem().toString()));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                tbPromedioTO.setText(String.valueOf(resultados.getTotalOperado()));
                tbPromedioTD.setText(String.valueOf(resultados.getPromedioTasa()));
            }
        });
    }
}
