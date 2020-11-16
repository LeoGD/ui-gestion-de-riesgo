package modelo;
import java.util.*;

public class InformacionPrestamos {

    public InformacionPrestamos(Integer informacionPrestamoID, String bancoSolicitaPrestamo, Integer importeTotal,
                                float tasa, Date fchAcreditacion, Integer cantCuotas, SistemaPrestamos sistema) {

        this.informacionPrestamoID = informacionPrestamoID;
        this.bancoSolicitaPrestamo = bancoSolicitaPrestamo;
        this.importeTotal = importeTotal;
        this.tasa = tasa;
        this.fchAcreditacion = fchAcreditacion;
        this.cantCuotas = cantCuotas;
        this.sistema = sistema;
    }

    private Integer informacionPrestamoID;
    private String bancoSolicitaPrestamo;
    private Integer importeTotal;
    private float tasa;
    private Date fchAcreditacion;
    private Integer cantCuotas;
    private SistemaPrestamos sistema;

    public Integer getInformacionPrestamoID() {
        return informacionPrestamoID;
    }

    public void setInformacionPrestamoID(Integer informacionPrestamoID) {
        this.informacionPrestamoID = informacionPrestamoID;
    }

    public String getBancoSolicitaPrestamo() {
        return bancoSolicitaPrestamo;
    }

    public void setBancoSolicitaPrestamo(String bancoSolicitaPrestamo) {
        this.bancoSolicitaPrestamo = bancoSolicitaPrestamo;
    }

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

    public Date getFchAcreditacion() {
        return fchAcreditacion;
    }

    public void setFchAcreditacion(Date fchAcreditacion) {
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
}