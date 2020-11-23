package controlador;

import modelo.*;

import java.util.*;

import static vista.FrmPrincipal.*;


public class SociosController {


    public SociosController() {
    }


    public void abm() {
        // TODO implement here
    }

    public List<Operacion> operacionesAvaladas(Long CUIT, Date fchDesde, Date fchHasta) {
        // TODO implement here
        List<Operacion> operacionesAvaladas = new ArrayList<Operacion>();

        for(Socios item : socios) {
            if (CUIT.equals(item.getCuit())) {
                for (LineaDeCredito item2 : item.getLinea()) {
                    if(item2.getTipoOperaciones().getEstadoOperacion().equals(EstadoOperacion.MONETIZADO)){
                        operacionesAvaladas.add(item2.getTipoOperaciones());
                    }
                }
                break;
            }
        }

        return operacionesAvaladas;
    }

    public LineaDeCredito consultaRiesgoVivoyTotal(Long CUIT) {

        LineaDeCredito consulta = new LineaDeCredito();
        Integer acumuladoTotalUtilizado = 0;

        for(Socios item : socios){
            if(item.getLinea().equals(CUIT)){
                for(LineaDeCredito item2 : item.getLinea()){
                    acumuladoTotalUtilizado += item2.getUtilizadoDeLinea();
                }
            }
        }
        return consulta;
    }

    public DatosConsulta calcularPromedioDescuentoYTotal(Date fchDesde, Date fchHasta, TipoEmpresa tipo) {

        DatosConsulta consulta = new DatosConsulta();
        Integer cantidadTasa = 0;
        float totalTasa = 0;
        float promedioTasa = 0;
        Integer cantidadCheques = 0;

        for(Socios item : socios){
            if(item.getTipoEmpresa().equals(tipo)){
                for(LineaDeCredito item2 : item.getLinea()){

                    if(item2.getTipoOperaciones().getTipoOperacion().equals(TipoOperacion.UNO)){
                        cantidadCheques++;
                    }

                    totalTasa += item2.getTipoOperaciones().getTasaDescuento();
                    cantidadTasa++;
                }
                promedioTasa = totalTasa/cantidadTasa;
                break;
            }
        }

        consulta.setPromedioTasa(promedioTasa);
        consulta.setTotalOperado(cantidadCheques);

        return consulta;
    }
}