package view;

import java.util.concurrent.Semaphore;

import controller.Control;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int i = 0; i < 4; i++) {
			Control t = new Control(i, semaforo);
			t.start();
		}

	}

}
