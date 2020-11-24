package modelo.Classes;

import java.util.*;

public class RiesgoVivo {

    public RiesgoVivo(){

    }

    public RiesgoVivo(Integer riesgoVivoID, List<String> tipoOperacion, Integer monto) {

        this.riesgoVivoID = riesgoVivoID;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }

    private Integer riesgoVivoID;
    private List<String> tipoOperacion;
    private Integer monto = 0;

    public Integer getRiesgoVivoID() {
        return riesgoVivoID;
    }

    public void setRiesgoVivoID(Integer riesgoVivoID) {
        this.riesgoVivoID = riesgoVivoID;
    }

    public List<String> getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(List<String> tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
}