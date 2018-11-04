package exercicio7_2;

import java.util.Comparator;

public class PontoFlutuanteComparator implements Comparator<Double> {

	@Override
	public int compare(Double d1, Double d2) {
		String x = d1.toString();
		String y = d2.toString();

		String[] splitX = x.split("\\.");
		String[] splitY = y.split("\\.");

		return splitX[1].compareTo(splitY[1]);
	}

}
