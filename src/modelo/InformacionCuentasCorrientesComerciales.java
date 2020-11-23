package modelo;
import java.util.*;


public class InformacionCuentasCorrientesComerciales {


    public InformacionCuentasCorrientesComerciales(Integer informacionCCCID, String empresaCuentaCorriente,
                                                   Integer importeTotal, Date fechaOperacion, Date fechaVencimiento,
                                                   EstadoOperacion estadoOperacion, Certificados certificado) {

        this.informacionCCCID = informacionCCCID;
        this.empresaCuentaCorriente = empresaCuentaCorriente;
        this.importeTotal = importeTotal;
        this.fechaVencimiento = fechaOperacion;
        this.fechaVencimiento = fechaVencimiento;
        this.estadoOperacion = estadoOperacion;
        this.certificado = certificado;
    }

    private Integer informacionCCCID;
    private String empresaCuentaCorriente;
    private Integer importeTotal;
    private Date fechaOperacion;
    private Date fechaVencimiento;
    private EstadoOperacion estadoOperacion;
    private Certificados certificado;

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

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Date getFechaOperacion() { return fechaOperacion; }

    public void setFechaOperacion(Date fechaOperacion) { this.fechaOperacion = fechaOperacion; }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public EstadoOperacion getEstadoOperacion() { return estadoOperacion; }

    public void setEstadoOperacion(EstadoOperacion estadoOperacion) { this.estadoOperacion = estadoOperacion; }

    public Certificados getCertificado() { return certificado; }

    public void setCertificado(Certificados certificado) { this.certificado = certificado; }
}