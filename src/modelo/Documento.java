package modelo;
import java.util.*;

/**
 * 
 */
public class Documento {

    /**
     * Default constructor
     */
    public Documento(Integer documentoID, String tipoDocumento, Date fchRecepcion, EstadoDocumento estado, String usuario) {

        this.documentoID = documentoID;
        this.tipoDocumento = tipoDocumento;
        this.fchRecepcion = fchRecepcion;
        this.estado = estado;
        this.usuario = usuario;
    }

    private Integer documentoID;
    private String tipoDocumento;
    private Date fchRecepcion;
    private EstadoDocumento estado;
    private String usuario;

    public int getDocumentoID() {
        return documentoID;
    }

    public void setDocumentoID(int documentoID) {
        this.documentoID = documentoID;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFchRecepcion() {
        return fchRecepcion;
    }

    public void setFchRecepcion(Date fchRecepcion) {
        this.fchRecepcion = fchRecepcion;
    }

    public EstadoDocumento getEstado() {
        return estado;
    }

    public void setEstado(EstadoDocumento estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}