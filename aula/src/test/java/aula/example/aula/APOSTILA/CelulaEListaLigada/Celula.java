package aula.example.aula.APOSTILA.CelulaEListaLigada;

public class Celula {
    private Celula proximo;
    private Object elemento;

    public Celula(Celula proximo, Object elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Celula (Object elemento) {
        this.elemento = elemento;
    }

    public void setProximo (Celula proximo) {
        this.proximo = proximo;
    }

    public Celula getProximo (){
        return proximo;
    }

    public Object getElemento (){
        return elemento;
    }
}
