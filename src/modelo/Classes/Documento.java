package modelo.Classes;
import modelo.Enum.EstadoDocumento;

/**
 * 
 */
public class Documento {

    /**
     * Default constructor
     */
    public Documento(Long documentoID, String tipoDocumento, String fchRecepcion, EstadoDocumento estado, String usuario) {

        this.documentoID = documentoID;
        this.tipoDocumento = tipoDocumento;
        this.fchRecepcion = fchRecepcion;
        this.estado = estado;
        this.usuario = usuario;
    }

    private Long documentoID;
    private String tipoDocumento;
    private String fchRecepcion;
    private EstadoDocumento estado;
    private String usuario;

    public Long getDocumentoID() {
        return documentoID;
    }

    public void setDocumentoID(Long documentoID) {
        this.documentoID = documentoID;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getFchRecepcion() {
        return fchRecepcion;
    }

    public void setFchRecepcion(String fchRecepcion) {
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