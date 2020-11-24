package modelo.Classes;

public class MercadoArgentinoValores {

    public MercadoArgentinoValores(boolean presentado) {

        this.presentado = presentado;
    }

    private boolean presentado;

    public boolean isPresentado() { return presentado; }

    public void setPresentado(boolean presentado) { this.presentado = presentado; }
}