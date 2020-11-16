package modelo;

public class Accion {

    public Accion(Integer accionID, TipoAccion AccionTipo, float valorUnitario, Integer cantidad) {
        this.accionID = accionID;
        this.AccionTipo = AccionTipo;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
    }

    private Integer accionID;
    private TipoAccion AccionTipo;
    private float valorUnitario;
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

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}