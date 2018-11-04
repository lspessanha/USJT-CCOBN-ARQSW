package exercicio4_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args) {
		
		int[][] matriz = 
			{
				{
					1, 3, 5
				},
				{
					2, 4, 6
				}
			};
		
		HashMap<Integer, Integer> map = new MatrizAdapter(matriz);
		
		StringBuilder sb = new StringBuilder();
	    Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
	    while (iter.hasNext()) {
	        Entry<Integer, Integer> entry = iter.next();
	        sb.append("Linha: ").append(entry.getKey());
	        sb.append(" => ");
	        sb.append("Coluna: ").append(entry.getValue());
	        if (iter.hasNext())
	            sb.append('\n');
	    }
	    System.out.println(sb.toString());
		
	}
}
