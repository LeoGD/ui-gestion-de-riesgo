package controlador;

import modelo.Enum.EstadoOperacion;
import modelo.Classes.InformacionCheques;
import modelo.Classes.Operacion;
import modelo.Enum.TipoOperacion;

import static vista.FrmPrincipal.cheques;
import static vista.FrmPrincipal.operaciones;


public class OperacionController {


    public OperacionController() {
    }

    public Integer totalComisionesDiarias(String fechaIngresada) {

        Integer cantidad = 0;

        for(InformacionCheques item : cheques){
            if(item.getEstadoOperacion().equals(EstadoOperacion.MONETIZADO) && item.getFchOperacion().equals(fechaIngresada)){
                cantidad++;
            }
        }

        return cantidad;
    }

    public float calcularComision(TipoOperacion tipo) {

        float valor = 0;

        for(Operacion item : operaciones){
            if(item.getTipoOperacion().equals(tipo)){
                valor = item.getPorcentajeComision();
            }
        }

        return valor;
    }

}