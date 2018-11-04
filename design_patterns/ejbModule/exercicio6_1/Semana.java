package exercicio6_1;

public class Semana {

	private final DiaDaSemana dia;
	
	public Semana(DiaDaSemana dia) {
		this.dia = dia;
	}
	
	public void mostraDiaDaSemana() {
		switch (dia.dia()) {
		case "Domingo":
			System.out.println(dia.dia() + " é último dia do final de semana");
			break;
		case "Segunda-Feira":
			System.out.println(dia.dia() + " é o primeiro dia da semana");
			break;
		case "Terça-Feira":
			System.out.println(dia.dia() + " é o segundo dia da semana");
			break;
		case "Quarta-Feira":
			System.out.println(dia.dia() + " é o terceiro dia da semana");
			break;
		case "Quinta-Feira":
			System.out.println(dia.dia() + " é o quarto dia da semana");
			break;
		case "Sexta-Feira":
			System.out.println(dia.dia() + " é o quinto dia da semana");
			break;
		case "Sábado":
			System.out.println(dia.dia() + " é o primeiro dia do final de semana");
			break;
		default:
			System.out.println("Informe um dia da semana");
			break;
		}
	}
	
}
