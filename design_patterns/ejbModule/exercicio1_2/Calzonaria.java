package exercicio1_2;

public class Calzonaria implements AbstractCalzonaria {

	@Override
	public Calzone getFactory(DiaSemana dia) {
		switch (dia) {
		case SEGUNDA: case QUARTA: case SEXTA:
			return new CalzoneCalabresa();
		case TERCA: case QUINTA: case SABADO:
			return new CalzonePresunto();
		default:
			System.out.println("Pizzaria Fechada, não pode ser feito calzones.");
			return null;
		}
	}


}
