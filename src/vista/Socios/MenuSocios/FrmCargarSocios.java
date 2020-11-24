package vista.Socios.MenuSocios;

import modelo.Classes.Accion;
import modelo.Classes.Accionista;
import modelo.Classes.Socios;
import modelo.Enum.EstadoSocio;
import modelo.Enum.TipoAccion;
import modelo.Enum.TipoEmpresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static vista.FrmPrincipal.*;

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
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar fecha = Calendar.getInstance();
    private String formatedDate;

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

        tbsocioID.setText(String.valueOf(IDSocio));
        formatedDate = fecha.get(Calendar.DATE) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
        tbFecha.setText(formatedDate);
    }

    private void asociarEventos()
    {
        btnEnviarSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                boolean validacion = false;
                boolean validacionAccionista = false;
                Accion accion = null;

                for(Socios item : socios){
                    if(item.getCuit().equals(Long.parseLong(tbCUIT.getText()))){
                        validacion = true;
                    }
                    else{
                        for(Accionista item2 : accionistas){
                            if(cbEstadoSocio.getSelectedItem().equals(String.valueOf(EstadoSocio.POSTULANTE_A_SOCIO_PROTECTOR))) {
                                if (item2.getCuitAccionista().toString().equals(tbCUIT.getText()) && item.getEstado().equals(EstadoSocio.SOCIO_PLENO_PARTICIPE))
                                    validacionAccionista = true;
                            }
                        }
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

                if(!validacion && !validacionAccionista) {

                    socios.add(new Socios(
                            Integer.parseInt(tbsocioID.getText()),
                            EstadoSocio.valueOf(cbEstadoSocio.getSelectedItem().toString()),
                            Long.parseLong(tbCUIT.getText()),
                            tbRazonSocial.getText(),
                            tbFecha.getText(),
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

                    JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el socio");

                    IDSocio = IDSocio + 1111;

                    tbsocioID.setText(IDSocio.toString());
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
                else if (validacion == true && !validacionAccionista){
                    JOptionPane.showMessageDialog(null, "El IDSocio/CUIT ya fue ingresado anteriormente");

                    tbCUIT.setText("");
                }
                else if(!validacion && validacionAccionista){
                    JOptionPane.showMessageDialog(null, "El Socio ingresado es accionista de una empresa socia participe");

                    tbsocioID.setText(IDSocio.toString());
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
            }
        });
    }
}
