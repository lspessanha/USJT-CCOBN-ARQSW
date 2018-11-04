package exercicio8_1;

import java.util.List;

public class NoticiaAssina extends Noticiario {

	private Noticia noticia;
	private final List<ConsomeNoticia> consumidores;

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
		notificaNoticia(noticia.getTextoNoticia(), noticia.getDia(), noticia.getMes(), noticia.getTopico());
	}

	public NoticiaAssina (List<ConsomeNoticia> consumidores) {
		this.consumidores = consumidores;
	}

	@Override
	public void notificaNoticia(String textoNoticia, int dia, int mes, String topico) {
		for (ConsomeNoticia consumidor: consumidores) {
			System.out.println("Assinante: " + consumidor.getAssinante());
			consumidor.consomeNoticia(textoNoticia, dia, mes, topico + "\n");
		}
	}

	@Override
	public void inscreverConsumidor(ConsomeNoticia consumidor) {
		consumidores.add(consumidor);
		System.out.println(consumidor.getAssinante() + " assinou.");
	}

	@Override
	public void removerConsumidor(ConsomeNoticia consumidor) {
		int index = consumidores.indexOf(consumidor);
		consumidores.remove(index);
		System.out.println(consumidor.getAssinante() + " cancelou a assinatura.");
	}

}
