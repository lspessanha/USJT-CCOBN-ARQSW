package exercicio2_1;

public class Main {
	
	public static void main(String[] args) {
		
		FactoryNome factNS = new FactoryNomeSobrenome();
		FactoryNome factSN = new FactorySobrenomeNome();
		
		String scott = "McNealy, Scott";
		String james = "James Gosling";
		String patrick = "Naughton, Patrick";
		
		factSN.getNome(scott);
		factNS.getNome(james);
		factSN.getNome(patrick);
		
		factNS.listarNomes();
		factSN.listarNomes();
		
	}
}
