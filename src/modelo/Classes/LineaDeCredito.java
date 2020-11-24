package modelo.Classes;

public class LineaDeCredito {

    public LineaDeCredito(){}

    public LineaDeCredito(Integer lineaCreditoID, Integer monto, String fechaVigencia, String estado, Operacion tipoOperaciones,
                          Integer utilizadoDeLinea, RiesgoVivo riesgoVivo) {
        this.lineaCreditoID = lineaCreditoID;
        this.monto = monto;
        this.fechaVigencia = fechaVigencia;
        this.estado = estado;
        this.tipoOperaciones = tipoOperaciones;
        this.utilizadoDeLinea = utilizadoDeLinea;
        this.riesgoVivo = riesgoVivo;
    }

    private Integer lineaCreditoID;
    private Integer monto;
    private String fechaVigencia;
    private String estado;
    private Operacion tipoOperaciones;
    private Integer utilizadoDeLinea;
    private RiesgoVivo riesgoVivo;

    public Integer getLineaCreditoID() {
        return lineaCreditoID;
    }

    public void setLineaCreditoID(Integer lineaCreditoID) {
        this.lineaCreditoID = lineaCreditoID;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Operacion getTipoOperaciones() {
        return tipoOperaciones;
    }

    public void setTipoOperaciones(Operacion tipoOperaciones) {
        this.tipoOperaciones = tipoOperaciones;
    }

    public Integer getUtilizadoDeLinea() {
        return utilizadoDeLinea;
    }

    public void setUtilizadoDeLinea(Integer utilizadoDeLinea) {
        this.utilizadoDeLinea = utilizadoDeLinea;
    }

    public RiesgoVivo getRiesgoVivo() { return riesgoVivo; }

    public void setRiesgoVivo(RiesgoVivo riesgoVivo) { this.riesgoVivo = riesgoVivo; }
}