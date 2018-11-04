package exercicio7_2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) {
		
		Double[] vetor = { 9.98, 7.77, 0.31, 3.15, 1.43, 4.27, 7.99 };
		
		Comparator<Double> comparator = new PontoFlutuanteComparator();
		Arrays.sort(vetor, comparator);
		
		System.out.println(Arrays.toString(vetor));
	}

}
