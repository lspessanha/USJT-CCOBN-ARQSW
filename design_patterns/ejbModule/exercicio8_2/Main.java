package exercicio8_2;

public class Main {
	
	public static void main(String[] args) {
		
		NoticiarioAssina nAssina = new NoticiarioAssina();
		ConsomeNoticia cnPublicador = new Publicador();
		Agregador aTopico = new AgregadorTopico("Cultura");
		Agregador aMes = new AgregadorMes();
		
		nAssina.adicionaConsumidor(cnPublicador);
		nAssina.adicionaConsumidor(aTopico);
		nAssina.adicionaConsumidor(aMes);
		
		aTopico.adicionaConsumidor(cnPublicador);
		aMes.adicionaConsumidor(cnPublicador);
		
		nAssina.notificaNoticia("Lorem ipsum dolor sit amet, consectetur adipisicing elit.", 2, 9, "Cultura");
		nAssina.notificaNoticia("Fuga expedita veritatis asperiores maiores, repudiandae, natus ea magni.", 3, 9, "Cultura");
		nAssina.notificaNoticia("Error tenetur quasi est aspernatur sed voluptatum molestias earum fugiat voluptate soluta amet beatae debitis", 4, 9, "Tecnologia");
		nAssina.notificaNoticia("Unde eveniet illo numquam provident reiciendis molestias error et, commodi explicabo cumque sed", 5, 9, "Cotidiano");
		nAssina.notificaNoticia("In, provident quam quos praesentium eius, aspernatur eligendi, dolorum suscipit reprehenderit doloremque repellat.", 6, 9, "Cultura");
		nAssina.notificaNoticia("Eos nemo quis ipsa odio laborum, rem, excepturi quisquam nihil.", 7, 9, "Cultura");
		nAssina.notificaNoticia("Lançamento de livro", 4, 11, "Cultura");
		nAssina.notificaNoticia("Greve dos Correios", 11, 11, "Cotidiano");
		nAssina.notificaNoticia("Inovação tecnológica", 18, 11, "Tecnologia");
	
	}

}
