package controlador;

import modelo.InformacionCheques;
import modelo.Operacion;
import modelo.Socios;
import modelo.TipoEmpresa;
import java.util.*;

import static vista.FrmPrincipal.*;


public class SociosController {


    public SociosController() {
    }


    public void abm() {
        // TODO implement here
    }

    public Integer totalComisionesDiarias(Date fechaIngresada){

        /*for(Operacion item : operaciones){
            if(fechaIngresada.equals(item.))
        }*/
        return 0;
    }

    public void operacionesAvaladas(Long CUIT, Date fchDesde, Date fchHasta) {
        // TODO implement here
    }

    public void consultaRiesgoVivoyTotal(Integer socioID) {
        // TODO implement here
    }

    public void calcularPromedioDescuentoYTotal(Date fchDesde, Date fchHasta, TipoEmpresa tipo) {
        // TODO implement here
    }

    public void realizarOperacion(Integer socioID, Integer operacionID) {
        // TODO implement here
    }

    public void calcularOperacionChequeFirmante() {
        // TODO implement here
    }

    public void calcularOperacionesPorFactura(Integer socioID) {
        // TODO implement here
    }

    public void verificarSocio(Integer socioID) {
        // TODO implement here
    }

    public void verificarEmpresasCompartidas() {
        // TODO implement here
    }

}