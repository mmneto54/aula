package aula.example.aula.APOSTILA;

public class TesteAdicionaNoFim {
    public static void main(String[] args) {


        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        Aluno a4 = new Aluno();

        a1.setNome("Boothill");
        a2.setNome("Jade");
        a2.setNome("Robin");
        a3.setNome("Welt");

        Vetor lista = new Vetor();

        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.adiciona(a3);

        System.out.println(lista);
    }
}
