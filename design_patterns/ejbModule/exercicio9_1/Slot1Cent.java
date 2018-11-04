package exercicio9_1;

public class Slot1Cent implements SlotChain {

	private SlotChain nextChain;

	@Override
	public void setNextChain(SlotChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calcula(Moeda moeda, Produto produto) {

		if (moeda.getValor() == 0.01) {
			if (produto.getValorFaltante() - 0.01 > 0) {
				produto.setValorFaltante(produto.getValorFaltante() - 0.01);
				System.out.println("Moeda de R$ " + String.format("%.2f", moeda.getValor()) + " foi inserida." + "\nAinda faltam R$ " + String.format("%.2f", produto.getValorFaltante()) + " para efetuar a compra do(a): " + produto.getNome());
			} else {
				produto.setValorFaltante(produto.getValorFaltante() - 0.01);
				System.out.println("\n" + produto.getNome() + " foi entregue!\nSeu troco é de R$ " + String.format("%.2f", produto.getValorFaltante() * -1));
			}
			
			
		} else {
			nextChain.calcula(moeda, produto);
		}

	}

}
