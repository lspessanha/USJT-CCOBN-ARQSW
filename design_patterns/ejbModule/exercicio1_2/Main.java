package exercicio1_2;

public class Main {

	public static void main(String[] args) {
		AbstractPizzaria fabrica = new Pizzaria();
		AbstractCalzonaria fabrica_calzone = new Calzonaria();
		
		Pizza pizza = fabrica.getFactory(DiaSemana.SEGUNDA);
		System.out.println(pizza.fazer());
		
		pizza = fabrica.getFactory(DiaSemana.TERCA);
		System.out.println(pizza.fazer());
		
		pizza = fabrica.getFactory(DiaSemana.DOMINGO);
		
		Calzone calzone = fabrica_calzone.getFactory(DiaSemana.QUARTA);
		System.out.println(calzone.fazer());
		
		calzone = fabrica_calzone.getFactory(DiaSemana.QUINTA);
		System.out.println(calzone.fazer());
		
		calzone = fabrica_calzone.getFactory(DiaSemana.DOMINGO);

	}

}
