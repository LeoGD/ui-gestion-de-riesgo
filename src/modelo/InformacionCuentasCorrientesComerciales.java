package modelo;
import java.util.*;


public class InformacionCuentasCorrientesComerciales {


    public InformacionCuentasCorrientesComerciales(Integer informacionCCCID, String empresaCuentaCorriente,
                                                   Integer importeTotal, Date fechaVencimiento) {

        this.informacionCCCID = informacionCCCID;
        this.empresaCuentaCorriente = empresaCuentaCorriente;
        this.importeTotal = importeTotal;
        this.fechaVencimiento = fechaVencimiento;
    }

    private Integer informacionCCCID;
    private String empresaCuentaCorriente;
    private Integer importeTotal;
    private Date fechaVencimiento;

    public Integer getInformacionCCCID() {
        return informacionCCCID;
    }

    public void setInformacionCCCID(Integer informacionCCCID) {
        this.informacionCCCID = informacionCCCID;
    }

    public String getEmpresaCuentaCorriente() {
        return empresaCuentaCorriente;
    }

    public void setEmpresaCuentaCorriente(String empresaCuentaCorriente) {
        this.empresaCuentaCorriente = empresaCuentaCorriente;
    }

    public Integer getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Integer importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}