package modelo;
import java.util.*;

/**
 * 
 */
public class Aporte {

    public Aporte(Integer aporteID, Socios socio, Integer monto, Date fchAporte, Date fchRetirar, FondoDeRiesgo FDR) {

        this.aporteID = aporteID;
        this.socio = socio;
        this.monto = monto;
        this.fchAporte = fchAporte;
        this.fchRetirar = fchRetirar;
        this.FDR = FDR;
    }

    private Integer aporteID;
    private Socios socio;
    private Integer monto;
    private Date fchAporte;
    private Date  fchRetirar;
    private FondoDeRiesgo FDR;

    public Integer getAporteID() {
        return aporteID;
    }

    public void setAporteID(Integer aporteID) {
        this.aporteID = aporteID;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Date getFchAporte() {
        return fchAporte;
    }

    public void setFchAporte(Date fchAporte) {
        this.fchAporte = fchAporte;
    }

    public Date getFchRetirar() {
        return fchRetirar;
    }

    public void setFchRetirar(Date fchRetirar) {
        this.fchRetirar = fchRetirar;
    }

    public FondoDeRiesgo getFDR() {
        return FDR;
    }

    public void setFDR(FondoDeRiesgo FDR) {
        this.FDR = FDR;
    }
}