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
    public static final List<Documento> documentos = new ArrayList<>();

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

                /*CUANDO SE DEFINAN LOS MODELOS, SE TIENE QUE MODIFICAR LA LOGICA PARA QUE RECORRA TODOS
                //LOS SOCIOS CARGADOS Y QUE VAYA COMPARANDO CADA UNO CON EL INGRESADO, EN CASO DE NO ENCONTRARLO,
                ANULAR EL INGRESO AL MENU OPERACIONES*/
                if(cadena.equals("1111111"))
                {
                    FrmOperacionesTipo1 frame = new FrmOperacionesTipo1(self, "Sistema de Gestion de Riesgo");
                    frame.setVisible(true);
                }
                else if(cadena.equals("2222222"))
                {
                    FrmOperacionesTipo2 frame = new FrmOperacionesTipo2(self, "Sistema de Gestion de Riesgo");
                    frame.setVisible(true);
                }
                else if(cadena.equals("3333333"))
                {
                    FrmOperacionesTipo3 frame = new FrmOperacionesTipo3(self, "Sistema de Gestion de Riesgo");
                    frame.setVisible(true);
                }
                else if(cadena.equals("12345678"))
                {
                    FrmOperacionesProtectores frame = new FrmOperacionesProtectores(self, "Sistema de Gestion de Riesgo");
                    frame.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"No se encontró el socio ingresado");
                }

                /*for(Socios item : socios){
                    if(cadena != null && cadena.equals(item.getCuit())){
                        if(item.getEstado().equals("POSTULANTE_A_SOCIO_PARTICIPE")  || item.getEstado().equals("POSTULANTE_A_SOCIO_PROTECTOR")){
                            JOptionPane.showMessageDialog(null, "El socio ingresado no es un socio pleno. Necesita realizar los tramites correspondientes a las acciones para poder operar");
                        }
                        if(item.getEstado().equals("SOCIO_PLENO_PARTICIPE")){
                            //RELLENAR CON CODIGO
                        }
                        if(item.getEstado().equals("SOCIO_PLENO_PROTECTORES")){
                            FrmOperacionesProtectores frame = new FrmOperacionesProtectores(self, "Sistema de Gestion de Riesgo");
                            frame.setVisible(true);
                        }

                    }
                }*/
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

        operaciones.add(new Operacion(0001, TipoOperacion.UNO, NombreOperacion.CHEQUES_PROPIOS, EstadoOperacion.INGRESADO,
                0.15f, EstadoComision.Calculada, new Certificados(0001), 0, 0, 0, 0.05f));
        operaciones.add(new Operacion(0002, TipoOperacion.UNO, NombreOperacion.CHEQUES_DE_TERCEROS, EstadoOperacion.INGRESADO,
                0.13f, EstadoComision.Calculada, new Certificados(0002), 0, 0, 0, 0.1f));
        operaciones.add(new Operacion(0003, TipoOperacion.UNO, NombreOperacion.PAGARÉ_BURSATIL, EstadoOperacion.INGRESADO,
                0.2f, EstadoComision.Calculada, new Certificados(0003), 0, 0, 0, 0.05f));
        operaciones.add(new Operacion(0004, TipoOperacion.DOS, NombreOperacion.CUENTAS_CORRIENTES_COMERCIALES, EstadoOperacion.INGRESADO,
                0.05f, EstadoComision.Calculada, new Certificados(0003), 0, 0, 0, 0.05f));
        operaciones.add(new Operacion(0005, TipoOperacion.DOS, NombreOperacion.TARJETA_DE_CREDITO, EstadoOperacion.INGRESADO,
                0.07f, EstadoComision.Calculada, new Certificados(0003), 0, 0, 0, 0.05f));
        operaciones.add(new Operacion(0006, TipoOperacion.TRES, NombreOperacion.PRÉSTAMOS, EstadoOperacion.INGRESADO,
                0.09f, EstadoComision.Calculada, new Certificados(0003), 0, 0, 0, 0.05f));

        socios.add(new Socios());

        lineas1.add(new LineaDeCredito(0001, 20000, "16/08/2021",
                "Aprobada", operaciones.get(0), 0));
        lineas1.add(new LineaDeCredito(0002, 42000, "16/08/2021",
                "Aprobada", operaciones.get(1), 0));
        lineas1.add(new LineaDeCredito(0003, 37000, "16/08/2021",
                "Aprobada", operaciones.get(2), 0));

        lineas2.add(new LineaDeCredito(0001, 60000, "16/08/2021",
                "Aprobada", operaciones.get(3), 0));
        lineas2.add(new LineaDeCredito(0002, 85000, "16/08/2021",
                "Aprobada", operaciones.get(4), 0));

        lineas3.add(new LineaDeCredito(0001, 40000, "16/08/2021",
                "Aprobada", operaciones.get(5), 0));

        frame.setVisible(true);
    }
}

