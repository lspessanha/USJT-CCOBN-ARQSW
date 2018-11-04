package exercicio7_1;

import java.util.Scanner;

public abstract class TransformacaoTemplate {
	
	public String string;
	
	public String getString() {
		return string;
	}

	public void setString(String s) {
		this.string = s;
	}

	public final void processo() {
		if(getString() == null) {
			setString(lerString());
		}
		String st = transforma(getString());
		printa(st);
	}
	
	abstract String transforma(String s);
	
	final String lerString() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite alguma string: ");
		setString(scanner.next());
		return getString();
	}
	
	final void printa(String st) {
		System.out.print(st + "\n");
	}

	@Override
	public String toString() {
		return string;
	}

}
