package vista.Socios.MenuSocios;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static vista.FrmPrincipal.acciones;
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
                boolean validacion = false;
                Accion accion = null;

                for(Socios item : socios){
                    if(item.getCuit().equals(Long.parseLong(tbCUIT.getText())) || item.getCuit().equals(Long.parseLong(tbCUIT.getText()))){
                        validacion = true;
                    }
                }

                for(Accion item2 : acciones){
                    if(cbEstadoSocio.getSelectedItem().toString().equals(EstadoSocio.POSTULANTE_A_SOCIO_PARTICIPE.toString()) && item2.getAccionTipo().equals(TipoAccion.A)){
                        accion = item2;
                    }
                    else if(cbEstadoSocio.getSelectedItem().toString().equals(EstadoSocio.POSTULANTE_A_SOCIO_PROTECTOR.toString()) && item2.getAccionTipo().equals(TipoAccion.B)){
                        accion = item2;
                    }
                }

                if(!validacion) {

                    try {
                        socios.add(new Socios(
                                Integer.parseInt(tbsocioID.getText()),
                                EstadoSocio.valueOf(cbEstadoSocio.getSelectedItem().toString()),
                                Long.parseLong(tbCUIT.getText()),
                                tbRazonSocial.getText(),
                                formato.parse(tbFecha.getText()),
                                TipoEmpresa.valueOf(cbTipoEmpresa.getSelectedItem().toString()),
                                tbActividad.getText(),
                                tbDireccion.getText(),
                                Long.parseLong(tbTelefono.getText()),
                                tbCorreo.getText(),
                                null,
                                null,
                                null,
                                accion,
                                null,
                                null,
                                null,
                                null
                        ));
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el socio");

                    tbsocioID.setText("");
                    tbCUIT.setText("");
                    tbRazonSocial.setText("");
                    cbTipoEmpresa.setSelectedIndex(-1);
                    tbActividad.setText("");
                    tbDireccion.setText("");
                    tbTelefono.setText("");
                    tbCorreo.setText("");
                    tbFecha.setText("");
                    cbEstadoSocio.setSelectedIndex(-1);

                }
                else {
                    JOptionPane.showMessageDialog(null, "El IDSocio/CUIT ya fue ingresado anteriormente");

                    tbsocioID.setText("");
                    tbCUIT.setText("");
                }
            }
        });
    }
}
