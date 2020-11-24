package vista.Socios.MenuSocios;

import modelo.Classes.Accionista;
import modelo.Classes.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static vista.FrmPrincipal.*;
import static vista.Socios.FrmSocios.cadenaAccionista;

public class FrmCargarAccionistas extends JDialog{
    private JPanel pnlCargaAccionistas;
    private JTextField tbCUITAccionista;
    private JTextField tbParticipacion;
    private JTextField tbRazonSocial;
    private JTextField tbAccionistaID;
    private JButton btnEnviarAccionista;

    public FrmCargarAccionistas(Window owner, String titulo)
    {
        super(owner, titulo);

        setContentPane(pnlCargaAccionistas);
        setSize(500,600);
        this.setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        asociarEventos();

        tbAccionistaID.setText(IDAccionista.toString());
    }

    private void asociarEventos()
    {
        btnEnviarAccionista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accionistas.clear();

                boolean validacion = false;

                for(Accionista item : accionistas){
                    if(item.getAccionistaID().toString().equals(tbAccionistaID.getText()) || item.getCuitAccionista().equals(Long.parseLong(tbCUITAccionista.getText()))){
                        validacion = true;
                    }
                }

                if(!validacion) {
                    accionistas.add(new Accionista(
                            Integer.parseInt(tbAccionistaID.getText()),
                            Long.parseLong(tbCUITAccionista.getText()),
                            tbRazonSocial.getText(),
                            Float.parseFloat(tbParticipacion.getText())
                    ));

                    for (Socios item : socios) {
                        if (cadenaAccionista.equals(item.getCuit().toString())) {
                            for (Accionista item2 : accionistas) {

                                Integer valor = Integer.parseInt(tbAccionistaID.getText());

                                if (valor.equals(item2.getAccionistaID())) {

                                    item.setAccionistas(accionistas);

                                    break;
                                }
                            }
                        }
                        break;
                    }
                }

                JOptionPane.showMessageDialog(null, "Se dio de alta exitosamente el accionista");

                IDAccionista = IDAccionista + 1111;

                tbAccionistaID.setText(IDAccionista.toString());
                tbCUITAccionista.setText("");
                tbParticipacion.setText("");
                tbRazonSocial.setText("");
            }
        });
    }
}
