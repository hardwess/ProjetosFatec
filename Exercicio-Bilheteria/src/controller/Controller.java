package controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {

	private int idCliente;
	private Semaphore semaforo;
	private static int Ingressos = 100;

	public Controller(int idCliente, Semaphore semaforo) {
		this.idCliente = idCliente;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		Login();
	}

	private void Login() {
		
		System.out.println("Cliente: " + idCliente + " - Está logando.");
		int tempo = (int) (Math.random() * 1951) + 50;
		
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempo < 1000) {
			System.out.println("Cliente: " + idCliente + " - Logou. (" + tempo / 1000d + " S)");
			try {
				semaforo.acquire();
				Compra();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		} else {
			System.out.println("Cliente: " + idCliente + " - Tempo de login expirado. (" + tempo / 1000d + " S)");
		}
	}

	private void Compra() {
		
		System.out.println("Cliente: " + idCliente + " - está comprando.");
		int tempo = (int) (Math.random() * 2000) + 1000;

		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tempo < 2500 && Ingressos > 0) {
			int compra = (int) ((Math.random() * 4) + 1);
			Ingressos -= compra;
			System.out.println(
					"Ciente: " + idCliente + " - comprou " + compra + " Ingressos, Restam " + Ingressos + " Ingressos");
		} else if (tempo > 2500) {
			System.out.println("Cliente: " + idCliente + " - Tempo de compra expirado. (" + tempo / 1000d + " S)");
		} else {
			System.out.println("Cliente: " + idCliente + " - Não pode comprar, Não há mais ingressos.");
		}
	}
}
