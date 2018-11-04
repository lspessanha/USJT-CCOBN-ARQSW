package exercicio6_2;

public class Main {

	public static void main(String[] args) {

		Sort metodo = new BubbleSort();
		int[] v = vectorUnsorted();
		metodo.sort(v);
		System.out.println("Bubble Sort");
		imprimirVetor(v);

		metodo = new InsertSort();
		v = vectorUnsorted();
		metodo.sort(v);
		System.out.println("Insertion Sort");
		imprimirVetor(v);

		metodo = new SelectionSort();
		v = vectorUnsorted();
		metodo.sort(v);
		System.out.println("Selection Sort");
		imprimirVetor(v);
		
		metodo = new QuickSort();
		v = vectorUnsorted();
		metodo.sort(v);

		System.out.println("Quick Sort");
		imprimirVetor(v);

	}
	
	private static int[] vectorUnsorted() {
		int[] v = { 30, 3, 27, 4, 11, 28, 5, 26, 9, 20, 6, 12, 21, 7, 23, 14, 1, 16, 2, 17, 8, 10, 15, 13, 25, 19, 18, 29, 22 };
		return v;
	}
	
	private static void imprimirVetor(int[] v) {
		for (int i = 0; i < v.length; i++) {
			if (i < v.length - 1)
				System.out.print(v[i] + " ");
			else
				System.out.println(v[i]);

		}
	}

}
