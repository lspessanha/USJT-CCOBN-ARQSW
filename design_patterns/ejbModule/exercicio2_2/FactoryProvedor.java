package exercicio2_2;

public class FactoryProvedor {
	
	public Provedor getProvedor(String senha) {
		if (senha.equals("design patterns")) {
			return new ProvedorConfidencial();
		}
		return new ProvedorPublico();
	}
	
	public Provedor getProvedor() {
		return new ProvedorPublico();
	}

}
