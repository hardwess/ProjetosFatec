package controller;

import java.util.concurrent.Semaphore;

public class Control extends Thread {

	private int idCarro;
	private Semaphore semaforo;
	private static int posicaoChegada;
	private static int Passagem;

	public Control(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroPassando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void carroAndando() {
		int distanciaFinal = (int) (Math.random() * 100);
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 6) + 10);
		int tempo = 30;
		while (distanciaPercorrida < distanciaFinal) {
			distanciaPercorrida += deslocamento;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Carro #" + idCarro + " andou "
					+ distanciaPercorrida + " metros");
		}
		posicaoChegada++;
		System.out.println("Carro #" + idCarro + " foi o " + posicaoChegada
				+ "o. a chegar");
	}

	

	private void carroPassando() {
		int tempo = 0;
		Passagem++;
		switch (idCarro) {
		case 0:
			System.out.println("O carro #" + idCarro + " foi o " + Passagem
					+ "o. a cruzar de Oeste para Leste");
			break;
		case 1:
			System.out.println("O carro #" + idCarro + " foi o " + Passagem
					+ "o. a cruzar de Norte para Sul");
			break;
		case 2:
			System.out.println("O carro #" + idCarro + " foi o " + Passagem
					+ "o. a cruzar de Leste para Oeste");
			break;
		case 3:
			System.out.println("O carro #" + idCarro + " foi o " + Passagem
					+ "o. a cruzar de Sul para Norte");
			break;
		}
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
