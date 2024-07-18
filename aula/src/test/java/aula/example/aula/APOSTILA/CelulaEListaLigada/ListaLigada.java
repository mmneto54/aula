package aula.example.aula.APOSTILA.CelulaEListaLigada;

public class ListaLigada {

    private Celula pegaCelula(int i) {
        //TODO MAYBE MAKE SOMETHING
        return null;
    }

    private Celula primeiro;
    private Celula ultimo;
    private int totalDeElementos;

    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionarNoComeco(elemento);
        } else {
            Celula nova= new Celula(elemento);
            this.ultimo.setProximo(nova);
            this.ultimo = nova;
                    this.totalDeElementos++;
        }
    }
    public void adiciona(int posicao, Object elemento) {
        if(posicao == 0){
            this.adicionarNoComeco(elemento);
        } else if(posicao == this.totalDeElementos){
            this.adiciona(elemento);
        }else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula nova = new Celula(anterior.getProximo(), elemento);
            anterior.setProximo(nova);
            this.totalDeElementos++;
        }

    }
    public Object pega(int posicao) {return null;}
    public void remover(int posicao) {}
    public int tamanho() {return 0;}
    public boolean estaVazia() {return false;}

    public void adicionarNoComeco(Object elemento) {
        Celula nova = new Celula(this.primeiro, elemento);
        this.primeiro = nova;

        if(this.totalDeElementos == 0){
            this.ultimo = nova;
            this.ultimo = this.primeiro;
        }
        this.totalDeElementos++;
    }
    public void removeDoComeco(){}
    public void removerNoFim(){}
}
