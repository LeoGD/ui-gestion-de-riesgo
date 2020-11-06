package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton btnSocios;
    private JButton btnConsultas;
    private JButton btnOperaciones;
    private JButton btnLineas;
    private JPanel pnlTop;

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

        frame.setVisible(true);
    }
}
