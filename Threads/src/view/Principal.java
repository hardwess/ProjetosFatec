package view;

import controller.ThreadCalc;

public class Principal {

	public static void main(String args[]) {

		int a = 10;
		int b = 2;
		
		for (int op = 0; op < 4; op++) {
			ThreadCalc t = new ThreadCalc(a, b, op);
			t.start();
		}
	}

}
