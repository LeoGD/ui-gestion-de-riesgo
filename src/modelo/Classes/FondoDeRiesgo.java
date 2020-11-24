package modelo.Classes;

public class FondoDeRiesgo {

    public FondoDeRiesgo(){}

    public FondoDeRiesgo(Integer monto) {

        this.monto = monto;
    }


    private Integer monto = 0;

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public void get5porcMonto() {
        // TODO implement here
    }

}