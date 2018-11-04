package exercicio6_1;

public class Semana {

	private final DiaDaSemana dia;
	
	public Semana(DiaDaSemana dia) {
		this.dia = dia;
	}
	
	public void mostraDiaDaSemana() {
		switch (dia.dia()) {
		case "Domingo":
			System.out.println(dia.dia() + " � �ltimo dia do final de semana");
			break;
		case "Segunda-Feira":
			System.out.println(dia.dia() + " � o primeiro dia da semana");
			break;
		case "Ter�a-Feira":
			System.out.println(dia.dia() + " � o segundo dia da semana");
			break;
		case "Quarta-Feira":
			System.out.println(dia.dia() + " � o terceiro dia da semana");
			break;
		case "Quinta-Feira":
			System.out.println(dia.dia() + " � o quarto dia da semana");
			break;
		case "Sexta-Feira":
			System.out.println(dia.dia() + " � o quinto dia da semana");
			break;
		case "S�bado":
			System.out.println(dia.dia() + " � o primeiro dia do final de semana");
			break;
		default:
			System.out.println("Informe um dia da semana");
			break;
		}
	}
	
}
