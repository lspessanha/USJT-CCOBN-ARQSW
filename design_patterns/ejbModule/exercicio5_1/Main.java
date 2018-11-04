package exercicio5_1;

public class Main {
	
	public static void main(String[] args) {
		
		IOFacade iof = new IOFacade();
		
		iof.init();
		
		// I/O Arquivos Textos
		String[] texto = {
				"Escreva uma classe Java chamada IOFacade que simplifique o uso dos recursos de I/O do Java",
				"Com métodos para abrir arquivos texto, arquivos binários e objetos"
			};
		iof.gravarArquivoTexto("ArquivoTexto.txt", texto);
		iof.lerArquivoTexto("ArquivoTexto.txt");
		
		// I/O Arquivos Binários
		byte[] byteArray = {10, 20, 30, 40, 50, 60, 70, 80};
		iof.gravarArquivoBinario("ArquivoBinario", byteArray);
		iof.lerArquivoBinario("ArquivoBinario");
		
		// I/O Objetos
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Carlos Everaldo");
		
		iof.gravarObjeto("ObjetoPessoa", pessoa);
		iof.lerObjeto("ObjetoPessoa");
		
		iof.shutdown();
	}
}
