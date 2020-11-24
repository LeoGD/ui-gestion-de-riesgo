package vista.Socios;

import modelo.Classes.Cambios;
import modelo.Enum.EstadoSocio;
import modelo.Classes.Socios;
import vista.Socios.MenuSocios.FrmCargarAccionistas;
import vista.Socios.MenuSocios.FrmCargarDocumentos;
import vista.Socios.MenuSocios.FrmCargarSocios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static vista.FrmPrincipal.contadorCambio;
import static vista.FrmPrincipal.socios;

public class FrmSocios extends JDialog{

    private JPanel pnlPrincipal;
    private JButton btnAltaSocio;
    private JButton btnSubAcc;
    private JButton btnAltaDoc;
    private JButton btnCargarAcc;
    public static String cadenaAccionista;
    public static String cadenaDocumento;
    public static String cadenaSuscripcion;
    private Calendar fecha = Calendar.getInstance();


    private FrmSocios self;

    public FrmSocios(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAltaDoc.setPreferredSize(new Dimension(230,40));
        btnCargarAcc.setPreferredSize(new Dimension(230,40));
        btnAltaSocio.setPreferredSize(new Dimension(230,40));
        btnSubAcc.setPreferredSize(new Dimension(230,40));
        asociarEventos();

        this.self = this;
    }

    private void asociarEventos()
    {
        btnAltaSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCargarSocios frame = new FrmCargarSocios(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });

        btnCargarAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadenaAccionista = JOptionPane.showInputDialog("Ingrese el CUIT del socio:");

                for(Socios item : socios){
                    if(Long.parseLong(cadenaAccionista) == item.getCuit() && item.getAccionistas() == null)
                    {
                        FrmCargarAccionistas frame = new FrmCargarAccionistas(self, "Sistema de Gestion de Riesgo");
                        frame.setVisible(true);
                        break;
                    }
                    else if (item.getAccionistas() != null) {
                        JOptionPane.showMessageDialog(null, "Ya se cargaron los accionistas al socio");
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se encontro el socio ingresado");
                        break;
                    }
                }
            }
        });

        btnAltaDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadenaDocumento = JOptionPane.showInputDialog("Ingrese el CUIT del socio:");

                for(Socios item : socios){
                    if(Long.parseLong(cadenaAccionista) == item.getCuit() && item.getDocumentos() == null)
                    {
                        FrmCargarDocumentos frame = new FrmCargarDocumentos(self, "Sistema de Gestion de Riesgo");
                        frame.setVisible(true);
                        break;
                    }
                    else if (item.getDocumentos() != null){
                        JOptionPane.showMessageDialog(null, "Ya se cargo la documentación al socio");
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se encontro el socio ingresado");
                        break;
                    }
                }
            }
        });

        btnSubAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cadenaSuscripcion = JOptionPane.showInputDialog("Ingrese el CUIT del socio:");

                for(Socios item : socios){

                    if (Long.parseLong(cadenaAccionista) == item.getCuit() && item.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO_PARTICIPE) {

                        if (item.getAccionistas() == null || item.getDocumentos() == null) {

                            String cadenaAcciones = JOptionPane.showInputDialog("Cuantas acciones tipo A desea vender? ");
                            Integer cantidadAccionesTipoA = Integer.parseInt(cadenaAcciones);

                            if (cantidadAccionesTipoA != null) {


                                item.getAcciones().setCantidad(item.getAcciones().getCantidad() - cantidadAccionesTipoA);

                                item.setEstado(EstadoSocio.SOCIO_PLENO_PARTICIPE);

                                Cambios cambioEstadoOperacion = new Cambios(
                                        contadorCambio++,
                                        fecha.getTime(),
                                        String.valueOf(EstadoSocio.POSTULANTE_A_SOCIO_PARTICIPE),
                                        item.getEstado().toString(),
                                        "En Socios",
                                        ""
                                );

                                JOptionPane.showMessageDialog(null, "Se vendieron exitosamente las acciones. El socio se convirtio en " + item.getEstado());
                            } else {
                                if (item.getAcciones().getCantidad() < cantidadAccionesTipoA) {
                                    JOptionPane.showMessageDialog(null, "No es posible realizar la suscripcion ya que no hay suficientes acciones para vender");
                                }
                            }
                            break;
                        }
                    } else if (Long.parseLong(cadenaAccionista) == item.getCuit() && item.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO_PROTECTOR) {
                        String cadenaAcciones = JOptionPane.showInputDialog("Cuantas acciones tipo B desea vender? ");
                        Integer cantidadAccionesTipoB = Integer.parseInt(cadenaAcciones);

                        if (cantidadAccionesTipoB != null) {

                            item.getAcciones().setCantidad(item.getAcciones().getCantidad() - cantidadAccionesTipoB);

                            item.setEstado(EstadoSocio.SOCIO_PLENO_PROTECTOR);

                            Cambios cambioEstadoOperacion = new Cambios(
                                    contadorCambio++,
                                    fecha.getTime(),
                                    String.valueOf(EstadoSocio.POSTULANTE_A_SOCIO_PROTECTOR),
                                    item.getEstado().toString(),
                                    "En Socios",
                                    ""
                            );

                            JOptionPane.showMessageDialog(null, "Se vendieron exitosamente las acciones. El socio se convirtio en " + item.getEstado());
                        } else {
                            if (item.getAcciones().getCantidad() < cantidadAccionesTipoB) {
                                JOptionPane.showMessageDialog(null, "No es posible realizar la suscripcion ya que no hay suficientes acciones para vender");
                            }
                        }
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el socio ingresado");
                        break;
                    }
                }
            }
        });
    }
}
