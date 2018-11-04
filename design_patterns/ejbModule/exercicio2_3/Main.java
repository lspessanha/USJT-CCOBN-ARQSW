package exercicio2_3;

public class Main {
	
	public static void main(String[] args) {

		int[] numeros = new int[10];
		for (int i = 0; i < 10; i++) {
			numeros[i] = i + 1;
		}
		
		LogFactory logfact = new LogFactory();
		
		Log log = logfact.getLog("arquivo");
		log.efetuar(numeros);
		
		log = logfact.getLog("console");
		log.efetuar(numeros);
		
	}

}
