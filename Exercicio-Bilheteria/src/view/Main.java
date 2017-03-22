package view;

import java.util.concurrent.Semaphore;

import controller.Controller;

public class Main {

	public static void main(String[] args) {

		int permissoes = 1;

		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int i = 1; i < 301; i++) {
			Controller t = new Controller(i, semaforo);
			t.start();
		}

	}

}
