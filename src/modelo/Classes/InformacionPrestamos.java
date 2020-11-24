package modelo.Classes;
import modelo.Enum.EstadoComision;
import modelo.Enum.EstadoOperacion;
import modelo.Enum.SistemaPrestamos;

public class InformacionPrestamos {

    public InformacionPrestamos(Integer informacionPrestamoID, String bancoSolicitaPrestamo, Integer importeTotal,
                                float tasa, String fchOperacion, String fchAcreditacion, Integer cantCuotas, SistemaPrestamos sistema,
                                EstadoOperacion estadoOperacion, Certificados certificado, float comision, EstadoComision estadocomision,
                                Factura factura) {

        this.informacionPrestamoID = informacionPrestamoID;
        this.bancoSolicitaPrestamo = bancoSolicitaPrestamo;
        this.importeTotal = importeTotal;
        this.tasa = tasa;
        this.fchOperacion = fchOperacion;
        this.fchAcreditacion = fchAcreditacion;
        this.cantCuotas = cantCuotas;
        this.sistema = sistema;
        this.estadoOperacion = estadoOperacion;
        this.certificado = certificado;
        this.comision = comision;
        this.estadocomision = estadocomision;
        this.factura = factura;
    }

    private Integer informacionPrestamoID;
    private String bancoSolicitaPrestamo;
    private Integer importeTotal;
    private float tasa;
    private String fchOperacion;
    private String fchAcreditacion;
    private Integer cantCuotas;
    private SistemaPrestamos sistema;
    private EstadoOperacion estadoOperacion;
    private Certificados certificado;
    private float comision;
    private EstadoComision estadocomision;
    private Factura factura;

    public Integer getInformacionPrestamoID() {
        return informacionPrestamoID;
    }

    public void setInformacionPrestamoID(Integer informacionPrestamoID) { this.informacionPrestamoID = informacionPrestamoID; }

    public String getBancoSolicitaPrestamo() {
        return bancoSolicitaPrestamo;
    }

    public void setBancoSolicitaPrestamo(String bancoSolicitaPrestamo) { this.bancoSolicitaPrestamo = bancoSolicitaPrestamo; }

    public Integer getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Integer importeTotal) {
        this.importeTotal = importeTotal;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public String getFchOperacion() { return fchOperacion; }

    public void setFchOperacion(String fchOperacion) { this.fchOperacion = fchOperacion; }

    public String getFchAcreditacion() {
        return fchAcreditacion;
    }

    public void setFchAcreditacion(String fchAcreditacion) {
        this.fchAcreditacion = fchAcreditacion;
    }

    public Integer getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(Integer cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public SistemaPrestamos getSistema() {
        return sistema;
    }

    public void setSistema(SistemaPrestamos sistema) {
        this.sistema = sistema;
    }

    public EstadoOperacion getEstadoOperacion() { return estadoOperacion; }

    public void setEstadoOperacion(EstadoOperacion estadoOperacion) { this.estadoOperacion = estadoOperacion; }

    public Certificados getCertificado() { return certificado; }

    public void setCertificado(Certificados certificado) { this.certificado = certificado; }

    public float getComision() { return comision; }

    public void setComision(float comision) { this.comision = comision; }

    public EstadoComision getEstadocomision() { return estadocomision; }

    public void setEstadocomision(EstadoComision estadocomision) { this.estadocomision = estadocomision; }

    public Factura getFactura() { return factura; }

    public void setFactura(Factura factura) { this.factura = factura; }
}