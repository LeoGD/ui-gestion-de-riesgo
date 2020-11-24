package controlador;

import modelo.Classes.DatosConsulta;
import modelo.Classes.LineaDeCredito;
import modelo.Classes.Operacion;
import modelo.Classes.Socios;
import modelo.Enum.TipoEmpresa;
import modelo.Enum.TipoOperacion;

import java.util.*;

import static vista.FrmPrincipal.*;


public class SociosController {


    public SociosController() {
    }

    public List<Operacion> operacionesAvaladas(Long CUIT, String fchDesde, String fchHasta) {

        List<Operacion> operacionesAvaladas = new ArrayList<Operacion>();
        Integer contador = 0;

        for(Socios item : socios) {
            if (CUIT.equals(item.getCuit())) {

                if(item.getLinea().get(contador).getTipoOperaciones().getTipoOperacion().equals(TipoOperacion.UNO)){
                    operacionesAvaladas.add(item.getLinea().get(contador).getTipoOperaciones());
                }
                else if(item.getLinea().get(contador).getTipoOperaciones().getTipoOperacion().equals(TipoOperacion.DOS)){
                    operacionesAvaladas.add(item.getLinea().get(contador).getTipoOperaciones());
                }
                else if(item.getLinea().get(contador).getTipoOperaciones().getTipoOperacion().equals(TipoOperacion.TRES)){
                    operacionesAvaladas.add(item.getLinea().get(contador).getTipoOperaciones());
                }
                contador++;
            }
        }

        return operacionesAvaladas;
    }

    public LineaDeCredito consultaRiesgoVivoyTotal(Long CUIT) {

        LineaDeCredito consulta = null;
        Integer acumuladoTotalUtilizado = 0;
        Integer RiesgoVivoSocio = 0;

        for(Socios item : socios){
            for(LineaDeCredito item2 : item.getLinea()){
                if(item.getCuit().equals(CUIT)) {
                    consulta = item2;
                    acumuladoTotalUtilizado = acumuladoTotalUtilizado + item2.getUtilizadoDeLinea();
                    RiesgoVivoSocio = RiesgoVivoSocio + item2.getRiesgoVivo().getMonto();
                }
            }
        }

        consulta.getRiesgoVivo().setMonto(RiesgoVivoSocio);
        consulta.setUtilizadoDeLinea(acumuladoTotalUtilizado);

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