package main;

import controller.Fatorial;
import javax.swing.JOptionPane;

public class View {

	public static void main(String[] args) {

		Fatorial f = new Fatorial();
		int n = 0;

		n = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número para calcular seu fatorial: "));

		int r = f.fatorialRecursivo(n);

		JOptionPane.showMessageDialog(null, "O Fatorial de " + n + " é igual à " + r);

	}

}
