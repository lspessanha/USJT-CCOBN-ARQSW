package exercicio6_1;

public class Main {

	public static void main(String[] args) {
		Semana domingo = new Semana(new Domingo());
		domingo.mostraDiaDaSemana();
		
		Semana segunda = new Semana(new Segunda());
		segunda.mostraDiaDaSemana();
		
		Semana terca = new Semana(new Terca());
		terca.mostraDiaDaSemana();

		Semana quarta = new Semana(new Quarta());
		quarta.mostraDiaDaSemana();
		
		Semana quinta = new Semana(new Quinta());
		quinta.mostraDiaDaSemana();
		
		Semana sexta = new Semana(new Sexta());
		sexta.mostraDiaDaSemana();
		
		Semana sabado = new Semana(new Sabado());
		sabado.mostraDiaDaSemana();
	}

}
