package modelo;

import java.util.*;

public class InformacionCheques {

    public InformacionCheques(Integer numDelCheque, String bancoDelCheque, Date fchOperacion,
                              Date fchVencimiento, Integer cuitDelFirmante, EstadoOperacion estadoOperacion,
                              Certificados certificado, MercadoArgentinoValores presentado) {

        this.numDelCheque = numDelCheque;
        this.bancoDelCheque = bancoDelCheque;
        this.fchOperacion = fchOperacion;
        this.fchVencimiento = fchVencimiento;
        this.cuitDelFirmante = cuitDelFirmante;
        this.estadoOperacion = estadoOperacion;
        this.certificado = certificado;
        this.presentado = presentado;
    }

    private Integer numDelCheque;
    private String bancoDelCheque;
    private Date fchOperacion;
    private Date fchVencimiento;
    private Integer cuitDelFirmante;
    private EstadoOperacion estadoOperacion;
    private Certificados certificado;
    private MercadoArgentinoValores presentado;

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

    public Date getFchVencimiento() {
        return fchVencimiento;
    }

    public void setFchVencimiento(Date fchVencimiento) {
        this.fchVencimiento = fchVencimiento;
    }

    public Integer getCuitDelFirmante() {
        return cuitDelFirmante;
    }

    public void setCuitDelFirmante(Integer cuitDelFirmante) {
        this.cuitDelFirmante = cuitDelFirmante;
    }

    public Date getFchOperacion() { return fchOperacion; }

    public void setFchOperacion(Date fchOperacion) { this.fchOperacion = fchOperacion; }

    public EstadoOperacion getEstadoOperacion() { return estadoOperacion; }

    public void setEstadoOperacion(EstadoOperacion estadoOperacion) { this.estadoOperacion = estadoOperacion; }

    public Certificados getCertificado() { return certificado; }

    public void setCertificado(Certificados certificado) { this.certificado = certificado; }

    public MercadoArgentinoValores getPresentado() { return presentado; }

    public void setPresentado(MercadoArgentinoValores presentado) { this.presentado = presentado; }
}