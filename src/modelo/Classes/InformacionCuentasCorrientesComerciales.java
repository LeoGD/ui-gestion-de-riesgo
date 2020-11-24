package modelo.Classes;
import modelo.Enum.EstadoComision;
import modelo.Enum.EstadoOperacion;


public class InformacionCuentasCorrientesComerciales {


    public InformacionCuentasCorrientesComerciales(Integer informacionCCCID, String empresaCuentaCorriente,
                                                   Integer importeTotal, String fechaOperacion, String fechaVencimiento,
                                                   EstadoOperacion estadoOperacion, Certificados certificado,
                                                   float comision, EstadoComision estadocomision, Factura factura) {

        this.informacionCCCID = informacionCCCID;
        this.empresaCuentaCorriente = empresaCuentaCorriente;
        this.importeTotal = importeTotal;
        this.fechaVencimiento = fechaOperacion;
        this.fechaVencimiento = fechaVencimiento;
        this.estadoOperacion = estadoOperacion;
        this.certificado = certificado;
        this.comision = comision;
        this.estadocomision = estadocomision;
        this.factura = factura;
    }

    private Integer informacionCCCID;
    private String empresaCuentaCorriente;
    private Integer importeTotal;
    private String fechaOperacion;
    private String fechaVencimiento;
    private EstadoOperacion estadoOperacion;
    private Certificados certificado;
    private float comision;
    private EstadoComision estadocomision;
    private Factura factura;

    public Integer getInformacionCCCID() {
        return informacionCCCID;
    }

    public void setInformacionCCCID(Integer informacionCCCID) {
        this.informacionCCCID = informacionCCCID;
    }

    public String getEmpresaCuentaCorriente() {
        return empresaCuentaCorriente;
    }

    public void setEmpresaCuentaCorriente(String empresaCuentaCorriente) { this.empresaCuentaCorriente = empresaCuentaCorriente; }

    public Integer getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Integer importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getFechaOperacion() { return fechaOperacion; }

    public void setFechaOperacion(String fechaOperacion) { this.fechaOperacion = fechaOperacion; }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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