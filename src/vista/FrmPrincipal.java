package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FrmPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton btnSocios;
    private JButton btnConsultas;
    private JButton btnOperaciones;
    private JButton btnLineas;
    private JPanel pnlTop;
    public static final List<Socios> socios = new ArrayList<Socios>();
    public static final List<LineaDeCredito> lineas1 = new ArrayList<LineaDeCredito>();
    public static final List<LineaDeCredito> lineas2 = new ArrayList<LineaDeCredito>();
    public static final List<LineaDeCredito> lineas3 = new ArrayList<LineaDeCredito>();
    public static final List<Operacion> operaciones = new ArrayList<Operacion>();
    public static final List<Accionista> accionistas = new ArrayList<Accionista>();
    public static final List<Documento> documentos = new ArrayList<Documento>();
    public static final List<InformacionCheques> cheques = new ArrayList<InformacionCheques>();
    public static final List<InformacionCuentasCorrientesComerciales> CCC = new ArrayList<InformacionCuentasCorrientesComerciales>();
    public static final List<InformacionPrestamos> prestamos = new ArrayList<InformacionPrestamos>();
    public static final List<Aporte> aportes = new ArrayList<Aporte>();
    public static final FondoDeRiesgo fondo = null;

    private FrmPrincipal self;

    public FrmPrincipal(String titulo)
    {
        super(titulo);

        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setContentPane(pnlPrincipal);
        setSize(500,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        btnSocios.setPreferredSize(new Dimension(230,40));
        btnConsultas.setPreferredSize(new Dimension(230,40));
        btnLineas.setPreferredSize(new Dimension(230,40));
        btnOperaciones.setPreferredSize(new Dimension(230,40));

        asociarEventos();

        this.self = this;
    }

    private void asociarEventos()
    {
        btnSocios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmSocios frame = new FrmSocios(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });

        btnLineas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmLineas frame = new FrmLineas(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });

        btnOperaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String cadena = JOptionPane.showInputDialog("Ingrese el CUIT del socio:");

                for(Socios item : socios){

                    if(!cadena.equals("") && cadena.equals(item.getCuit().toString())){

                        if(item.getEstado().equals(EstadoSocio.POSTULANTE_A_SOCIO_PARTICIPE)  || item.getEstado().equals(EstadoSocio.POSTULANTE_A_SOCIO_PROTECTOR)){
                            JOptionPane.showMessageDialog(null, "El socio ingresado no es un socio pleno. Necesita realizar los tramites correspondientes a las acciones para poder operar");
                        }
                        if(item.getEstado().equals(EstadoSocio.POSTULANTE_A_SOCIO_PARTICIPE)){
                            if(item.getLinea().equals(lineas1)){
                                FrmOperacionesTipo1 frame = new FrmOperacionesTipo1(self, "Sistema de Gestion de Riesgo");
                                frame.setVisible(true);
                            }
                            else if(item.getLinea().equals(lineas2)){
                                FrmOperacionesTipo2 frame = new FrmOperacionesTipo2(self, "Sistema de Gestion de Riesgo");
                                frame.setVisible(true);
                            }
                            else if(item.getLinea().equals(lineas3)){
                                FrmOperacionesTipo3 frame = new FrmOperacionesTipo3(self, "Sistema de Gestion de Riesgo");
                                frame.setVisible(true);
                            }
                        }
                        if(item.getEstado().equals(EstadoSocio.SOCIO_PLENO_PROTECTOR)){
                            FrmOperacionesProtectores frame = new FrmOperacionesProtectores(self, "Sistema de Gestion de Riesgo", item.getCuit());
                            frame.setVisible(true);
                        }

                    }
                }
            }
        });

        btnConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmConsultas frame = new FrmConsultas(self, "Sistema de Gestion de Riesgo");
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        FrmPrincipal frame = new FrmPrincipal("Sistema de Gestion de Riesgo");

        operaciones.add(new Operacion(1111, TipoOperacion.UNO, NombreOperacion.CHEQUES_PROPIOS, EstadoOperacion.INGRESADO,
                0.15f, EstadoComision.Calculada, null, 0, 0, 0, 0.05f));
        operaciones.add(new Operacion(2222, TipoOperacion.UNO, NombreOperacion.CHEQUES_DE_TERCEROS, EstadoOperacion.INGRESADO,
                0.13f, EstadoComision.Calculada, null, 0, 0, 0, 0.1f));
        operaciones.add(new Operacion(3333, TipoOperacion.UNO, NombreOperacion.PAGARÉ_BURSATIL, EstadoOperacion.INGRESADO,
                0.2f, EstadoComision.Calculada, null, 0, 0, 0, 0.05f));
        operaciones.add(new Operacion(4444, TipoOperacion.DOS, NombreOperacion.CUENTAS_CORRIENTES_COMERCIALES, EstadoOperacion.INGRESADO,
                0.05f, EstadoComision.Calculada, null, 0, 0, 0, 0.05f));
        operaciones.add(new Operacion(5555, TipoOperacion.DOS, NombreOperacion.TARJETA_DE_CREDITO, EstadoOperacion.INGRESADO,
                0.07f, EstadoComision.Calculada, null, 0, 0, 0, 0.05f));
        operaciones.add(new Operacion(6666, TipoOperacion.TRES, NombreOperacion.PRÉSTAMOS, EstadoOperacion.INGRESADO,
                0.09f, EstadoComision.Calculada, null, 0, 0, 0, 0.05f));

        lineas1.add(new LineaDeCredito(1111, 20000, "16/08/2021",
                "Vigente", operaciones.get(0), 0));
        lineas1.add(new LineaDeCredito(2222, 42000, "16/08/2021",
                "Vigente", operaciones.get(1), 0));
        lineas1.add(new LineaDeCredito(3333, 37000, "16/08/2021",
                "Vigente", operaciones.get(2), 0));

        lineas2.add(new LineaDeCredito(1111, 60000, "16/08/2021",
                "Vigente", operaciones.get(3), 0));
        lineas2.add(new LineaDeCredito(2222, 85000, "16/08/2021",
                "Vigente", operaciones.get(4), 0));

        lineas3.add(new LineaDeCredito(1111, 40000, "16/08/2021",
                "Vigente", operaciones.get(5), 0));

        frame.setVisible(true);
    }
}

