package aula.example.aula.APOSTILA;

import com.fasterxml.jackson.core.JsonPointer;

public class Aluno extends JsonPointer {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return nome;
    }

    public boolean equals(Object o){
        Aluno outro = (Aluno)o;
        return this.nome.equals(outro.nome);
    }

    public void append(String s) {
    }
}

