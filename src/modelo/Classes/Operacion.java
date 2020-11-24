package modelo.Classes;

import modelo.Enum.EstadoComision;
import modelo.Enum.EstadoOperacion;
import modelo.Enum.NombreOperacion;
import modelo.Enum.TipoOperacion;

public class Operacion {

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

    public Integer getOperacionID() {
        return operacionID;
    }

    public void setOperacionID(Integer operacionID) {
        this.operacionID = operacionID;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public NombreOperacion getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(NombreOperacion nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public EstadoOperacion getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(EstadoOperacion estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public EstadoComision getEstadoComision() {
        return estadoComision;
    }

    public void setEstadoComision(EstadoComision estadoComision) {
        this.estadoComision = estadoComision;
    }

    public Certificados getCertificadoGarantia() {
        return certificadoGarantia;
    }

    public void setCertificadoGarantia(Certificados certificadoGarantia) { this.certificadoGarantia = certificadoGarantia; }

    public Integer getImporteTotal1() {
        return importeTotal1;
    }

    public void setImporteTotal1(Integer importeTotal1) {
        this.importeTotal1 = importeTotal1;
    }

    public Integer getImporteUtilizado2() {
        return importeUtilizado2;
    }

    public void setImporteUtilizado2(Integer importeUtilizado2) {
        this.importeUtilizado2 = importeUtilizado2;
    }

    public Integer getCuotasImpagas3() {
        return cuotasImpagas3;
    }

    public void setCuotasImpagas3(Integer cuotasImpagas3) {
        this.cuotasImpagas3 = cuotasImpagas3;
    }

    public float getTasaDescuento() {
        return TasaDescuento;
    }

    public void setTasaDescuento(float tasaDescuento) {
        TasaDescuento = tasaDescuento;
    }
}