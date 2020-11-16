package vista;

import modelo.EstadoSocio;
import modelo.LineaDeCredito;
import modelo.Socios;
import modelo.TipoOperacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vista.FrmPrincipal.lineas1;
import static vista.FrmPrincipal.lineas2;
import static vista.FrmPrincipal.lineas3;
import static vista.FrmPrincipal.socios;

public class FrmLineas extends  JDialog{

    private JPanel pnlPrincipal;
    private JButton btnAsignarSocio;
    private JButton btnAprobar;

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
                    if(cadenaLineas.equals(item.getCuit().toString())){
                        if(item.getEstado() == EstadoSocio.SOCIO_PLENO_PARTICIPE){

                            String tipolinea = JOptionPane.showInputDialog(null, "Seleccione el tipo de linea a asignarse (UNO,DOS,TRES): ");

                            if(tipolinea.equals(TipoOperacion.UNO.toString())){
                                item.setLinea(lineas1);

                                socios.add(item);
                            }
                            else if(tipolinea.equals(TipoOperacion.DOS.toString())){
                                item.setLinea(lineas2);

                                socios.add(item);
                            }
                            else if(tipolinea.equals(TipoOperacion.TRES.toString())){
                                item.setLinea(lineas3);

                                socios.add(item);
                            }
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
                    if(cadenaAprobacion.equals(item.getCuit().toString())){

                        for(LineaDeCredito item2 : item.getLinea()){
                            item2.setEstado("Aprobada");
                        }
                    }
                }
            }
        });
    }
}
