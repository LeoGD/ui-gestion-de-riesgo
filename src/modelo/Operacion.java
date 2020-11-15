package modelo;

import java.util.*;

/**
 * 
 */
public class Operacion {

    /**
     * Default constructor
     */
    public Operacion(Integer operacionID, TipoOperacion tipoOperacion, NombreOperacion nombreOperacion,
                     EstadoOperacion estadoOperacion, float porcentajeComision, EstadoComision estadoComision,
                     Certificados certificadoGarantia, Integer importeTotal1, Integer importeUtilizado2,
                     Integer cuotasImpagas3, float TasaDescuento) {

        this.operacionID = operacionID;
        this.tipoOperacion = tipoOperacion;
        this.nombreOperacion = nombreOperacion;
        this.estadoOperacion = estadoOperacion;
        this.porcentajeComision = porcentajeComision;
        this.estadoComision = estadoComision;
        this.certificadoGarantia = certificadoGarantia;
        this.importeTotal1 = importeTotal1;
        this.importeUtilizado2 = importeUtilizado2;
        this.cuotasImpagas3 = cuotasImpagas3;
        this.TasaDescuento = TasaDescuento;
    }

    /**
     * 
     */
    private Integer operacionID;
    private TipoOperacion tipoOperacion;
    private NombreOperacion nombreOperacion;
    private EstadoOperacion estadoOperacion;
    private float porcentajeComision;
    private EstadoComision estadoComision;
    private Certificados certificadoGarantia;
    //List<String> operaciones;
    private Integer importeTotal1;
    private Integer importeUtilizado2;
    private Integer cuotasImpagas3;
    private float TasaDescuento;





    /**
     * 
     */
    public Socios TipoB;















    /**
     * 
     */
    public void getoperacionID() {
        // TODO implement here
    }

    /**
     * 
     */
    public void gettipoOperacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getporcentajeComision() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getestadoOperacion() {
        // TODO implement here
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
    public void getNombreOperacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getImporteTotal() {
        // TODO implement here
    }

}