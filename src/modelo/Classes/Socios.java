package modelo.Classes;
import modelo.Enum.EstadoSocio;
import modelo.Enum.TipoEmpresa;

import java.util.*;

public class Socios {

    public Socios(List<Accionista> accionistas){
        this.accionistas = accionistas;
    }

    public Socios(Integer socioID, EstadoSocio estado, Long cuit, String razonSocial, String fchInicioActividades,
                  TipoEmpresa tipoEmpresa, String actividadPrincipal, String direccion, Long telefono, String mail, List<LineaDeCredito> linea,
                  List<Accionista> accionistas, Documento documentos, Accion acciones, List<Aporte> aportes, InformacionCheques tramitecheque,
                  InformacionCuentasCorrientesComerciales tramiteCCC, InformacionPrestamos tramiteprestamo){

        this.socioID = socioID;
        this.estado = estado;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fchInicioActividades = fchInicioActividades;
        this.tipoEmpresa = tipoEmpresa;
        this.actividadPrincipal = actividadPrincipal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.linea = linea;
        this.accionistas = accionistas;
        this.documentos = documentos;
        this.acciones = acciones;
        this.aportes = aportes;
        this.tramitecheque = tramitecheque;
        this.tramiteCCC = tramiteCCC;
        this.tramiteprestamo = tramiteprestamo;
    }

    private Integer socioID;
    private EstadoSocio estado;
    private Long cuit;
    private String razonSocial;
    private String fchInicioActividades;
    private TipoEmpresa tipoEmpresa;
    private String actividadPrincipal;
    private String direccion;
    private Long telefono;
    private String mail;
    private List<LineaDeCredito> linea;
    private List<Accionista> accionistas;
    private Documento documentos;
    private Accion acciones;
    private List<Aporte> aportes;
    private InformacionCheques tramitecheque;
    private InformacionCuentasCorrientesComerciales tramiteCCC;
    private InformacionPrestamos tramiteprestamo;

    public Accion getAcciones() { return acciones; }

    public void setAcciones(Accion acciones) { this.acciones = acciones; }

    public List<LineaDeCredito> getLinea() {
        return linea;
    }

    public void setLinea(List<LineaDeCredito> linea) {
        this.linea = linea;
    }

    public List<Accionista> getAccionistas() { return accionistas; }

    public void setAccionistas(List<Accionista> accionistas) { this.accionistas = accionistas; }

    public Documento getDocumentos() { return documentos; }

    public void setDocumentos(Documento documentos) { this.documentos = documentos; }

    public Integer getSocioID() {
        return socioID;
    }

    public void setSocioID(Integer socioID) { this.socioID = socioID; }

    public EstadoSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoSocio estado) {
        this.estado = estado;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getFchInicioActividades() {
        return fchInicioActividades;
    }

    public void setFchInicioActividades(String fchInicioActividades) { this.fchInicioActividades = fchInicioActividades; }

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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Aporte> getAportes() { return aportes; }

    public void setAportes(List<Aporte> aportes) { this.aportes = aportes; }

    public InformacionCheques getTramitecheque() { return tramitecheque; }

    public void setTramitecheque(InformacionCheques tramitecheque) { this.tramitecheque = tramitecheque; }

    public InformacionCuentasCorrientesComerciales getTramiteCCC() { return tramiteCCC; }

    public void setTramiteCCC(InformacionCuentasCorrientesComerciales tramiteCCC) { this.tramiteCCC = tramiteCCC; }

    public InformacionPrestamos getTramiteprestamo() { return tramiteprestamo; }

    public void setTramiteprestamo(InformacionPrestamos tramiteprestamo) { this.tramiteprestamo = tramiteprestamo; }
}