package modelo.Classes;

import modelo.Enum.EstadoComision;
import modelo.Enum.EstadoOperacion;

public class InformacionCheques {

    public InformacionCheques(Integer numDelCheque, String bancoDelCheque, String fchOperacion,
                              String fchVencimiento, Integer cuitDelFirmante, EstadoOperacion estadoOperacion,
                              Certificados certificado, MercadoArgentinoValores presentado, float comision,
                              Integer montoCheque, EstadoComision estadocomision, Factura factura) {

        this.numDelCheque = numDelCheque;
        this.bancoDelCheque = bancoDelCheque;
        this.montoCheque = montoCheque;
        this.fchOperacion = fchOperacion;
        this.fchVencimiento = fchVencimiento;
        this.cuitDelFirmante = cuitDelFirmante;
        this.estadoOperacion = estadoOperacion;
        this.certificado = certificado;
        this.presentado = presentado;
        this.comision = comision;
        this.estadocomision = estadocomision;
        this.factura = factura;
    }

    private Integer numDelCheque;
    private String bancoDelCheque;
    private Integer montoCheque;
    private String fchOperacion;
    private String fchVencimiento;
    private Integer cuitDelFirmante;
    private EstadoOperacion estadoOperacion;
    private Certificados certificado;
    private MercadoArgentinoValores presentado;
    private float comision;
    private EstadoComision estadocomision;
    private Factura factura;

    public Integer getNumDelCheque() {
        return numDelCheque;
    }

    public void setNumDelCheque(Integer numDelCheque) {
        this.numDelCheque = numDelCheque;
    }

    public String getBancoDelCheque() {
        return bancoDelCheque;
    }

    public void setBancoDelCheque(String bancoDelCheque) {
        this.bancoDelCheque = bancoDelCheque;
    }

    public String getFchVencimiento() {
        return fchVencimiento;
    }

    public void setFchVencimiento(String fchVencimiento) {
        this.fchVencimiento = fchVencimiento;
    }

    public Integer getCuitDelFirmante() {
        return cuitDelFirmante;
    }

    public void setCuitDelFirmante(Integer cuitDelFirmante) {
        this.cuitDelFirmante = cuitDelFirmante;
    }

    public String getFchOperacion() { return fchOperacion; }

    public void setFchOperacion(String fchOperacion) { this.fchOperacion = fchOperacion; }

    public EstadoOperacion getEstadoOperacion() { return estadoOperacion; }

    public void setEstadoOperacion(EstadoOperacion estadoOperacion) { this.estadoOperacion = estadoOperacion; }

    public Certificados getCertificado() { return certificado; }

    public void setCertificado(Certificados certificado) { this.certificado = certificado; }

    public MercadoArgentinoValores getPresentado() { return presentado; }

    public void setPresentado(MercadoArgentinoValores presentado) { this.presentado = presentado; }

    public float getComision() { return comision; }

    public void setComision(float comision) { this.comision = comision; }

    public EstadoComision getEstadocomision() { return estadocomision; }

    public void setEstadocomision(EstadoComision estadocomision) { this.estadocomision = estadocomision; }

    public Factura getFactura() { return factura; }

    public void setFactura(Factura factura) { this.factura = factura; }

    public Integer getMontoCheque() { return montoCheque; }

    public void setMontoCheque(Integer montoCheque) { this.montoCheque = montoCheque; }
}