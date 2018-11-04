package exercicio2_2;

public class Main {
	
	public static void main(String[] args) {
		
		FactoryProvedor provFact = new FactoryProvedor();

		Provedor provedor = provFact.getProvedor("design patterns");
		provedor.exibir();
		
		Provedor provedor2 = provFact.getProvedor("desaini paterni");
		provedor2.exibir();
		
		Provedor provedor3 = provFact.getProvedor();
		provedor3.exibir();
		
	}

}
