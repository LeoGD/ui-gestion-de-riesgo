package modelo.Classes;

import modelo.Enum.TipoAccion;

public class Accion {

    public Accion(){}

    public Accion(Integer accionID, TipoAccion AccionTipo, Integer valorUnitario, Integer cantidad) {
        this.accionID = accionID;
        this.AccionTipo = AccionTipo;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
    }

    private Integer accionID;
    private TipoAccion AccionTipo;
    private Integer valorUnitario;
    private Integer cantidad;

    public Integer getAccionID() {
        return accionID;
    }

    public void setAccionID(Integer accionID) {
        this.accionID = accionID;
    }

    public TipoAccion getAccionTipo() {
        return AccionTipo;
    }

    public void setAccionTipo(TipoAccion accionTipo) {
        AccionTipo = accionTipo;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}