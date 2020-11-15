package modelo;
import java.util.*;

/**
 * 
 */
public class Socios {

    /**
     * Default constructor
     */
    public Socios() {
    }

    private Integer socioID;
    private EstadoSocio estado;
    private Integer cuit;
    private String razonSocial;
    private Date fchInicioActividades;
    private TipoEmpresa tipoEmpresa;
    private String actividadPrincipal;
    private String direccion;
    private Integer telefono;
    private String mail;
    private LineaDeCredito linea;
    private Accionista accionistas;
    private Documento documentos;

    public LineaDeCredito getLinea() {
        return linea;
    }

    public void setLinea(LineaDeCredito linea) {
        this.linea = linea;
    }

    public Accionista getAccionistas() { return accionistas; }

    public void setAccionistas(Accionista accionistas) { this.accionistas = accionistas; }

    public Documento getDocumentos() { return documentos; }

    public void setDocumentos(Documento documentos) { this.documentos = documentos; }

    public Integer getSocioID() {
        return socioID;
    }

    public void setSocioID(Integer socioID) {
        this.socioID = socioID;
    }

    public EstadoSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoSocio estado) {
        this.estado = estado;
    }

    public Integer getCuit() {
        return cuit;
    }

    public void setCuit(Integer cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFchInicioActividades() {
        return fchInicioActividades;
    }

    public void setFchInicioActividades(Date fchInicioActividades) {
        this.fchInicioActividades = fchInicioActividades;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
/**En duda*/
    /**public Aporte Aportan;*/


































    /**
     * 
     */
    public void getIdSocio() {
        // TODO implement here
    }

    /**
     * 
     */
    public void gettipoEmpresa() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getTasaDescuento() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getTipoOperacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getNombreOperacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getMonto() {
        // TODO implement here
    }

    /**
     * 
     */

    public void getEstadoSocio() {
        // TODO implement here
    }

}