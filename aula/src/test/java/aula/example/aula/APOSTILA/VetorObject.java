package aula.example.aula.APOSTILA;

public class VetorObject {
    private Object[] objetos = new Object[10];
    private int totalDeObjetos = 0;

    public void adicionaObjeto(Object objeto) {
        this.garanteEspaco();
        this.objetos[totalDeObjetos] = objeto;
        this.totalDeObjetos++;
    }

    public void adiciona (int posicao, Object objeto) {
        this.garanteEspaco();
        if (!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posiçao Invalida");
        }
         for (int i = this.totalDeObjetos - 1; i >= posicao; i--) {
             this.objetos[i + 1] = this.objetos[i];
         }
         this.objetos[posicao] = objeto;
         this.totalDeObjetos++;
    }

    public Object pega(int posicao) {
        if (!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posiçao Invalida");
        }
        return this.objetos[posicao];
    }

    public void remove (int posicao) {
        if (!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posiçao Invalida");
        }
        for (int i = posicao; i < this.totalDeObjetos - 1; i++) {
            this.objetos[i] = this.objetos[i + 1];
        }
        this.totalDeObjetos--;
    }

    public boolean contem (Aluno aluno) {
        for (int i = 0;i < this.totalDeObjetos;i++) {
          if (aluno.equals(this.objetos[i])) {
              return true;
          }
        }
       return false;
    }
    public int tamanho (){
        return this.totalDeObjetos;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeObjetos;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.totalDeObjetos;
    }

    private void garanteEspaco() {
        if(this.totalDeObjetos == this.objetos.length) {
            Object[] novaArray = new Object[this.objetos.length * 2];
            for (int i = 0;i < this.totalDeObjetos;i++) {
                novaArray[i] = this.objetos[i];
            }
            this.objetos = novaArray;
        }
    }
}
