package exercicio7_1;

public class Main {
	
	public static void main(String[] args) {
		
		TransformacaoTemplate transf = new Maiusculo();
		transf.processo();
		String stringDigitada = transf.getString();
		
		transf = new Minusculo();
		transf.setString(stringDigitada);
		transf.processo();
		
		transf = new Duplicado();
		transf.setString(stringDigitada);
		transf.processo();
		
		transf = new Invertido();
		transf.setString(stringDigitada);
		transf.processo();

	}

}
