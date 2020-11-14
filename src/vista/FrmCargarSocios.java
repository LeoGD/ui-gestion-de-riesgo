package vista;

import modelo.EstadoSocio;
import modelo.Socios;
import modelo.TipoEmpresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static vista.FrmPrincipal.socios;

public class FrmCargarSocios extends JDialog{
    private JPanel pnlCargaSocios;
    private JTextField tbsocioID;
    private JTextField tbCUIT;
    private JTextField tbRazonSocial;
    private JComboBox cbTipoEmpresa;
    private JTextField tbActividad;
    private JButton btnEnviarSocio;
    private JTextField tbDireccion;
    private JTextField tbTelefono;
    private JTextField tbCorreo;
    private JTextField tbFecha;
    private JComboBox cbEstadoSocio;

    public FrmCargarSocios(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaSocios);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        //this.self = this;


    }

    private void asociarEventos()
    {
        btnEnviarSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                for(Socios item : socios) {

                    item.setSocioID(Integer.parseInt(tbsocioID.getText()));
                    item.setCuit(Integer.parseInt(tbCUIT.getText()));
                    item.setRazonSocial(tbRazonSocial.getText());
                    item.setEstado(EstadoSocio.valueOf(cbEstadoSocio.getSelectedItem().toString()));
                    item.setTipoEmpresa(TipoEmpresa.valueOf(cbTipoEmpresa.getSelectedItem().toString()));
                    try {
                        item.setFchInicioActividades(formato.parse(tbFecha.getText()));
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    item.setActividadPrincipal(tbActividad.getText());
                    item.setDireccion(tbDireccion.getText());
                    item.setTelefono(Integer.parseInt(tbTelefono.getText()));
                    item.setMail(tbCorreo.getText());

                    socios.add(item);
                }

                JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el socio");
            }
        });
    }
}
