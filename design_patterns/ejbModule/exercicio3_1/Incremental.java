package exercicio3_1;

public class Incremental {
	private static int count = 0;
	private int numero;

	private static Incremental instancia = null;

	static Incremental getInstanceOff() {
		if (instancia == null) instancia = new Incremental();

		return instancia;
	}

	public void incrementa() {
		numero = ++count;
	}

	public String toString() {
		return "Incremental " + numero;
	}
}
