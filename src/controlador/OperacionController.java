package controlador;

import modelo.EstadoOperacion;
import modelo.InformacionCheques;
import modelo.Operacion;
import modelo.TipoOperacion;
import java.util.*;

import static vista.FrmPrincipal.cheques;
import static vista.FrmPrincipal.operaciones;


public class OperacionController {


    public OperacionController() {
    }


    public void abm() {
        // TODO implement here
    }

    public Integer totalComisionesDiarias(Date fechaIngresada) {
        for(Operacion item : operaciones){
            if(item.getEstadoOperacion().equals(EstadoOperacion.MONETIZADO)){
                for(InformacionCheques item2 : cheques){
                    // TODO if(fechaIngresada.equals(item2.)){
                    // TODO implement here
                    // TODO }
                }
            }
        }
        // TODO implement here
        return 0;
    }

    public float calcularComision(TipoOperacion tipo) {
        for(Operacion item : operaciones){
            if(item.getTipoOperacion().equals(tipo)){
                return item.getPorcentajeComision();
            }
        }
        return 0;
    }

}