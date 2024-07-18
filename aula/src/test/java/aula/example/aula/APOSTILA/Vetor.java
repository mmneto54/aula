package aula.example.aula.APOSTILA;

import lombok.Getter;
import lombok.Setter;

public class Vetor {

    @Setter
    @Getter
    private Aluno[] alunos = new Aluno[10];
    private int totalDeAlunos = 0;

    private void garanteEspaco(){
        if (this.totalDeAlunos == this.alunos.length){
            Aluno[] novaArray = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++){
                novaArray[i] = this.alunos[i];
            }
            this.alunos = novaArray;
        }
    }

    public void adiciona(Aluno aluno) {
     this.garanteEspaco();
     this.alunos[this.totalDeAlunos] = aluno;
     this.totalDeAlunos++;
    }

    public void adiciona(int posicao, Aluno aluno) {
        this.garanteEspaco();
        if(this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posicao invalida");
        }
        for (int i = this.totalDeAlunos - 1; i >= posicao; i-=1){
            this.alunos[i +1] = this.alunos[i];
        }
        this.alunos[posicao] = aluno;
        this.totalDeAlunos++;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.totalDeAlunos;
    }

    public Aluno getAluno(int posicao) {
        return alunos[posicao];
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeAlunos;

    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.alunos.length; i++) {
            if (aluno == this.alunos[i]) {
                return true;
            }
        }
        return false;
    }
    public int tamanho(){
        return 0;
    }
    public String toString(){
        if(this.totalDeAlunos == 0){
        }
        return "lista de alunos: " + this.totalDeAlunos;
    }
}