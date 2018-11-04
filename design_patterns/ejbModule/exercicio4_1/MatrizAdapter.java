package exercicio4_1;

import java.util.HashMap;

public class MatrizAdapter extends HashMap<Integer, Integer> {

	private static final long serialVersionUID = 1L;

	public MatrizAdapter(int[][] matriz) {
		for (int i = 0; i < matriz[1].length; i++) {
			put(matriz[0][i], matriz[1][i]);
		}
	}

}
