package modelo;

public class DatosConsulta {

    public DatosConsulta(){

    }

    private float PromedioTasa;
    private Integer TotalOperado;

    public Integer getTotalOperado() {
        return TotalOperado;
    }

    public void setTotalOperado(Integer totalOperado) {
        TotalOperado = totalOperado;
    }

    public float getPromedioTasa() {
        return PromedioTasa;
    }

    public void setPromedioTasa(float promedioTasa) {
        PromedioTasa = promedioTasa;
    }
}
