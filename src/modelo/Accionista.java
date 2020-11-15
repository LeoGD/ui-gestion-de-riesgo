package modelo;
import java.util.*;

/**
 * 
 */
public class Accionista {

    /**
     * Default constructor
     */
    public Accionista() {
    }

    private Integer accionistaID;
    private Integer cuitAccionista;
    private String razonSocialAccionista;
    private float porcentajeParticipacion;

    public float getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    public void setPorcentajeParticipacion(float porcentajeParticipacion) {
        this.porcentajeParticipacion = porcentajeParticipacion;
    }

    public Integer getAccionistaID() {
        return accionistaID;
    }

    public void setAccionistaID(Integer accionistaID) {
        this.accionistaID = accionistaID;
    }

    public Integer getCuitAccionista() {
        return cuitAccionista;
    }

    public void setCuitAccionista(Integer cuitAccionista) {
        this.cuitAccionista = cuitAccionista;
    }

    public String getRazonSocialAccionista() {
        return razonSocialAccionista;
    }

    public void setRazonSocialAccionista(String razonSocialAccionista) {
        this.razonSocialAccionista = razonSocialAccionista;
    }
}