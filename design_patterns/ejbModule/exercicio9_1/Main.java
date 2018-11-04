package exercicio9_1;

public class Main {
	
	public static void main(String[] args) {
		
		SlotChain chain1cent = new Slot1Cent();
		SlotChain chain5cent = new Slot5Cent();
		SlotChain chain10cent = new Slot10Cent();
		SlotChain chain15cent = new Slot15Cent();
		
		chain1cent.setNextChain(chain5cent);
		chain5cent.setNextChain(chain10cent);
		chain10cent.setNextChain(chain15cent);
		
		Produto refrigerante = new Produto("Refrigerante", 1.00);
		Produto salgadinho = new Produto("Salgadinho", 2.50);
		Produto balinha = new Produto("Balinha", .05);
		
		Moeda m1c = new Moeda(0.01);
		Moeda m5c = new Moeda(0.05);
		Moeda m10c = new Moeda(0.10);
		Moeda m15c = new Moeda(0.15);
		
		System.out.println("Refrigerante:");
		chain1cent.calcula(m5c, refrigerante);
		chain1cent.calcula(m10c, refrigerante);
		chain1cent.calcula(m15c, refrigerante);
		chain1cent.calcula(m15c, refrigerante);
		chain1cent.calcula(m15c, refrigerante);
		chain1cent.calcula(m15c, refrigerante);
		chain1cent.calcula(m15c, refrigerante);
		chain1cent.calcula(m15c, refrigerante);

		System.out.println("\nSalgadinho:");
		chain1cent.calcula(m1c, salgadinho);
		chain1cent.calcula(m1c, salgadinho);
		chain1cent.calcula(m1c, salgadinho);
		chain1cent.calcula(m1c, salgadinho);
		chain1cent.calcula(m1c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m10c, salgadinho);
		chain1cent.calcula(m15c, salgadinho);
		
		System.out.println("\nBalinha:");
		chain1cent.calcula(m10c, balinha);
	
	}

}
