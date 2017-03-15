package controller;

import javax.swing.JOptionPane;

import view.Main;

public class Control extends Thread {

	Main m = new Main();

	private Integer Matriz[] = new Integer[5];
	private Integer linha1;

	public Control(Integer Matriz2[], Integer linha) {

		for (int i = 0; i != 5; i++) {
			this.Matriz[i] = Matriz2[i];
			this.linha1 = linha;
		}
	}

	@Override
	public void run() {
		Show();
	}

	private void Show() {
		int Soma = 0;
		for (int j = 0; j != 5; j++) {
			Soma = Soma + Matriz[j];
		}
		System.out.println("\n linha " + (linha1+1) + ": " + Matriz[0] + " + " + Matriz[1] + " + " + Matriz[2] + " + "
				+ Matriz[3] + " + " + Matriz[4] + " = " + Soma);
	}

}
