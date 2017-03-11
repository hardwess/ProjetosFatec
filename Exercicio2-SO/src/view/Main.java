package view;

import controller.Control;

public class Main {

	public static void main(String[] args) {
		
		Integer Matriz[][] = new Integer[3][5];

		for (int i = 0; i != 3; i++) {
			for (int f = 0; f != 5; f++) {
				Matriz[i][f] = ((int) (Math.random() * 10));
			}
		}

		for (int k = 0; k != 3; k++) {
			Control c = new Control(Matriz[k], k);
			c.start();
		}

	}

}
