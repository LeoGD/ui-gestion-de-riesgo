package vista.LineaDeCredito;

import modelo.Classes.Cambios;
import modelo.Classes.LineaDeCredito;
import modelo.Classes.Socios;
import modelo.Enum.EstadoSocio;
import modelo.Enum.NombreOperacion;
import modelo.Enum.TipoOperacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static vista.FrmPrincipal.*;

public class FrmLineas extends  JDialog{

    private JPanel pnlPrincipal;
    private JButton btnAsignarSocio;
    private JButton btnAprobar;
    private Calendar fecha = Calendar.getInstance();

    public FrmLineas(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlPrincipal);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAsignarSocio.setPreferredSize(new Dimension(230,40));
        btnAprobar.setPreferredSize(new Dimension(230,40));
        asociarEventos();
    }

    private void asociarEventos(){
        btnAsignarSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadenaLineas = JOptionPane.showInputDialog(null, "Ingrese el CUIT del socio: ");

                for(Socios item : socios){
                    if(Long.parseLong(cadenaLineas) == item.getCuit()){
                        if(item.getEstado() == EstadoSocio.SOCIO_PLENO_PARTICIPE){

                            String tipolinea = JOptionPane.showInputDialog(null, "Seleccione el tipo de linea a asignarse (UNO,DOS,TRES): ");

                            if(tipolinea.equals(TipoOperacion.UNO.toString())){
                                item.setLinea(lineas1);

                                JOptionPane.showMessageDialog(null, "Se asigno con exito el tipo de linea.\nLas operaciones asignadas son las siguientes:\n- " + NombreOperacion.CHEQUES_PROPIOS + "\n- " + NombreOperacion.CHEQUES_DE_TERCEROS + "\n- " + NombreOperacion.PAGARÉ_BURSATIL);
                            }
                            else if(tipolinea.equals(TipoOperacion.DOS.toString())){
                                item.setLinea(lineas2);

                                JOptionPane.showMessageDialog(null, "Se asigno con exito el tipo de linea.\nLas operaciones asignadas son las siguientes:\n- " + NombreOperacion.CUENTAS_CORRIENTES_COMERCIALES + "\n- " + NombreOperacion.TARJETA_DE_CREDITO);
                            }
                            else if(tipolinea.equals(TipoOperacion.TRES.toString())){
                                item.setLinea(lineas3);

                                socios.add(item);

                                JOptionPane.showMessageDialog(null, "Se asigno con exito el tipo de linea.\nLas operaciones asignadas son las siguientes:\n- " + NombreOperacion.PRÉSTAMOS);
                            }
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No es posible asignarle una linea de credito a este socio ya que el socio no es un socio pleno participe");
                        }
                    }
                }
            }
        });

        btnAprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadenaAprobacion = JOptionPane.showInputDialog(null, "Ingrese el CUIT del socio: ");

                for(Socios item : socios){
                    if(item.getCuit().toString().equals(cadenaAprobacion)){

                        for(LineaDeCredito item2 : item.getLinea()){
                            item2.setEstado("Aprobada");

                            Cambios cambioEstadoOperacion = new Cambios(
                                    contadorCambio++,
                                    fecha.getTime(),
                                    "Vigente",
                                    item2.getEstado(),
                                    "En Linea de Credito",
                                    ""
                            );
                        }
                    }
                }

                JOptionPane.showMessageDialog(null, "Se aprobo con exito la linea de credito");
            }
        });
    }
}
