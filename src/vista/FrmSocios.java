package vista;

import modelo.Accion;
import modelo.EstadoSocio;
import modelo.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vista.FrmPrincipal.socios;

public class FrmSocios extends JDialog{

    private JPanel pnlPrincipal;
    private JButton btnAltaSocio;
    private JButton btnSubAcc;
    private JButton btnAltaDoc;
    private JButton btnCargarAcc;
    public static String cadenaAccionista = new String();
    public static String cadenaDocumento = new String();
    public static String cadenaSuscripcion = new String();


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
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ya se cargaron los accionistas al socio");
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
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ya se la documentación al socio");
                    }
                }
            }
        });

        btnSubAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cadenaSuscripcion = JOptionPane.showInputDialog("Ingrese el CUIT del socio:");

                for(Socios item : socios){
                    if(Long.parseLong(cadenaAccionista) == item.getCuit() && item.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO_PARTICIPE)
                    {
                        String cadenaAcciones = JOptionPane.showInputDialog("Cuantas acciones tipo A desea vender? ");
                        Integer cantidadAccionesTipoA = Integer.parseInt(cadenaAcciones);

                        Accion accionModificada = item.getAcciones();
                        accionModificada.setCantidad(item.getAcciones().getCantidad() - cantidadAccionesTipoA);

                        item.setEstado(EstadoSocio.SOCIO_PLENO_PARTICIPE);

                        JOptionPane.showMessageDialog(null,"Se vendieron exitosamente las acciones. El socio se convirtio en " + item.getEstado());
                    }
                    else if(Long.parseLong(cadenaAccionista) == item.getCuit() && item.getEstado() == EstadoSocio.POSTULANTE_A_SOCIO_PROTECTOR)
                    {
                        String cadenaAcciones = JOptionPane.showInputDialog("Cuantas acciones tipo B desea vender? ");
                        Integer cantidadAccionesTipoB = Integer.parseInt(cadenaAcciones);

                        Accion accionModificada = item.getAcciones();
                        accionModificada.setCantidad(item.getAcciones().getCantidad() - cantidadAccionesTipoB);

                        item.setEstado(EstadoSocio.SOCIO_PLENO_PROTECTOR);

                        JOptionPane.showMessageDialog(null,"Se vendieron exitosamente las acciones. El socio se convirtio en " + item.getEstado());
                    }
                }
            }
        });
    }
}
