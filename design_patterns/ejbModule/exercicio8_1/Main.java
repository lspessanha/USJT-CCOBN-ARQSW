package exercicio8_1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		NoticiaAssina noticiario = new NoticiaAssina(new ArrayList<ConsomeNoticia>());
		
		Consumidor con1 = new Consumidor(noticiario, "Carlos");
		Consumidor con2 = new Consumidor(noticiario, "Everaldo");
		Consumidor con3 = new Consumidor(noticiario, "Jubileu");
		
		System.out.println("");
		
		con1.assinar();
		con2.assinar();
		con3.assinar();
		
		System.out.println("");

		Noticia noticia1 = new Noticia();
		noticia1.setTextoNoticia("Lançamento de livro");
		noticia1.setDia(04);
		noticia1.setMes(11);
		noticia1.setTopico("Cultura");
		noticiario.setNoticia(noticia1);

		System.out.println("");

		con1.cancelar();
		con3.cancelar();

		System.out.println("");
		
		Noticia noticia2 = new Noticia();
		noticia2.setTextoNoticia("Greve dos Correios");
		noticia2.setDia(11);
		noticia2.setMes(11);
		noticia2.setTopico("Cotidiano");
		noticiario.setNoticia(noticia2);

		System.out.println("");

		con3.assinar();
		
		System.out.println("");
		
		Noticia noticia3 = new Noticia();
		noticia3.setTextoNoticia("Inovação tecnológica");
		noticia3.setDia(18);
		noticia3.setMes(11);
		noticia3.setTopico("Tecnologia");
		noticiario.setNoticia(noticia3);

	}

}
