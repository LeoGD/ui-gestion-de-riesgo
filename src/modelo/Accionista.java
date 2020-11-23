package modelo;
import java.util.*;

/**
 * 
 */
public class Accionista {

    public Accionista(Integer accionistaID, Long cuitAccionista, String razonSocialAccionista, float porcentajeParticipacion) {

        this.accionistaID = accionistaID;
        this.cuitAccionista = cuitAccionista;
        this.razonSocialAccionista = razonSocialAccionista;
        this.porcentajeParticipacion = porcentajeParticipacion;
    }

    private Integer accionistaID;
    private Long cuitAccionista;
    private String razonSocialAccionista;
    private float porcentajeParticipacion;

    public float getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    public void setPorcentajeParticipacion(float porcentajeParticipacion) { this.porcentajeParticipacion = porcentajeParticipacion; }

    public Integer getAccionistaID() {
        return accionistaID;
    }

    public void setAccionistaID(Integer accionistaID) {
        this.accionistaID = accionistaID;
    }

    public Long getCuitAccionista() {
        return cuitAccionista;
    }

    public void setCuitAccionista(Long cuitAccionista) {
        this.cuitAccionista = cuitAccionista;
    }

    public String getRazonSocialAccionista() {
        return razonSocialAccionista;
    }

    public void setRazonSocialAccionista(String razonSocialAccionista) { this.razonSocialAccionista = razonSocialAccionista; }
}