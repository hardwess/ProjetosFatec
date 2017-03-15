package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int i = 0; i < 10; i++) {
			Thread t = new ThreadCarro(i, semaforo);
			t.start();
		}
	}

}
