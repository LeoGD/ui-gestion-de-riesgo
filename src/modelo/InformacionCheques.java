package modelo;

import java.util.*;

/**
 * 
 */
public class InformacionCheques {

    /**
     * Default constructor
     */
    public InformacionCheques(Integer numDelCheque, String bancoDelCheque,
                              Date fchVencimiento, Integer cuitDelFirmante) {

        this.numDelCheque = numDelCheque;
        this.bancoDelCheque = bancoDelCheque;
        this.fchVencimiento = fchVencimiento;
        this.cuitDelFirmante = cuitDelFirmante;
    }

    private Integer numDelCheque;
    private String bancoDelCheque;
    private Date fchVencimiento;
    private Integer cuitDelFirmante;

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
}