package modelo;
import java.util.*;

/**
 * 
 */
public class Documento {

    /**
     * Default constructor
     */
    public Documento() {
    }

    /**
     * 
     */
    private int documentoID;
    private String tipoDocumento;
    private Date fchRecepcion;
    private EstadoDocumento estado;
    private Usuario usuario;
}