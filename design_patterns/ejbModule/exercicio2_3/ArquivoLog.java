package exercicio2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ArquivoLog extends Log {

	@Override
	void efetuar(int[] numeros) {
		File file = new File("log.txt");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file, "UTF-8");
			for (int i : numeros) {
				writer.println(i);
			}
			writer.close();
			System.out.println("gerou o arquivo de log");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
