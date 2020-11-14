package modelo;
import java.util.*;

/**
 * 
 */
public class LineaDeCredito {

    /**
     * Default constructor
     */
    public LineaDeCredito() {
    }

    private Integer lineaCreditoID;
    private float monto;
    private Date fechaVigencia;
    private String estado;
    private List <Operacion> tipoOperaciones;
    private float utilizadoDeLinea;

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