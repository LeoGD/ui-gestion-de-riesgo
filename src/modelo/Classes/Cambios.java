package modelo.Classes;
import java.util.*;

public class Cambios {

    public Cambios(Integer cambioID, Date fchCambio, String estadoAnt, String estadoSig, String tipo, String usuario) {

        this.cambioID = cambioID;
        this.fchCambio = fchCambio;
        this.estadoAnt = estadoAnt;
        this.estadoSig = estadoSig;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    private Integer cambioID;
    private Date fchCambio;
    private String estadoAnt;
    private String estadoSig;
    private String tipo;
    private String usuario;

    public Integer getCambioID() {
        return cambioID;
    }

    public void setCambioID(Integer cambioID) {
        this.cambioID = cambioID;
    }

    public Date getFchCambio() {
        return fchCambio;
    }

    public void setFchCambio(Date fchCambio) {
        this.fchCambio = fchCambio;
    }

    public String getEstadoAnt() {
        return estadoAnt;
    }

    public void setEstadoAnt(String estadoAnt) {
        this.estadoAnt = estadoAnt;
    }

    public String getEstadoSig() {
        return estadoSig;
    }

    public void setEstadoSig(String estadoSig) {
        this.estadoSig = estadoSig;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}