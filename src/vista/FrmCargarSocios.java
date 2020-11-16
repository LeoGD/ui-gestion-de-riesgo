package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

                try {
                    socios.add(new Socios(
                            Integer.parseInt(tbsocioID.getText()),
                            EstadoSocio.valueOf(cbEstadoSocio.getSelectedItem().toString()),
                            Integer.parseInt(tbCUIT.getText()),
                            tbRazonSocial.getText(),
                            formato.parse(tbFecha.getText()),
                            TipoEmpresa.valueOf(cbTipoEmpresa.getSelectedItem().toString()),
                            tbActividad.getText(),
                            tbDireccion.getText(),
                            Integer.parseInt(tbTelefono.getText()),
                            tbCorreo.getText(),
                            null,
                            null,
                            null,
                            null
                    ));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el socio");
            }
        });
    }
}
