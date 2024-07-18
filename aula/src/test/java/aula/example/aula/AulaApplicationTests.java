package aula.example.aula;



class AulaApplicationTests {

	public static void main(String[] args) {

       String[] animais = {"tigre","elefante","macaco"};
	   String nomeProduto = "Maquiana de lavar";

		//System.out.println("saida do console metodo antigo de laco " + animais[0]);
		//System.out.println("saida do console metodo antigo de laco " + animais[1] );
		//System.out.println("saida do console metodo antigo de laco " + animais[2] );

	for(String animaisNome: animais) {
		  System.out.println("saida do console " + animaisNome);
	  }

	 for (int i = 0; i < animais.length; i++) {
		  System.out.println("saida do console metodo antigo de laco " + animais[i]);
	  }

	}

}
