package modelo;
import java.util.*;

/**
 * 
 */
public class LineaDeCredito {

    /**
     * Default constructor
     */
    public LineaDeCredito(Integer lineaCreditoID, Integer monto, String fechaVigencia, String estado, Operacion tipoOperaciones,
                          Integer utilizadoDeLinea) {
        this.lineaCreditoID = lineaCreditoID;
        this.monto = monto;
        this.fechaVigencia = fechaVigencia;
        this.estado = estado;
        this.tipoOperaciones = tipoOperaciones;
        this.utilizadoDeLinea = utilizadoDeLinea;
    }

    private Integer lineaCreditoID;
    private Integer monto;
    private String fechaVigencia;
    private String estado;
    private Operacion tipoOperaciones;
    private Integer utilizadoDeLinea;

    public Integer getLineaCreditoID() {
        return lineaCreditoID;
    }

    public void setLineaCreditoID(Integer lineaCreditoID) {
        this.lineaCreditoID = lineaCreditoID;
    }

    /**
     * 
     */
    public void getTasaDescuento() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getTipoOperacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getNombreOperacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getEstadoOperacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getOperacionID() {
        // TODO implement here
    }

    /**
     * 
     */
    public void get10porcMonto() {
        // TODO implement here
    }

}