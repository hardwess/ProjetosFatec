package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int idCarro;
	private Semaphore semaforo;
	private static int posicaoChegada;
	private static int posicaoSaida;

	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroParado();
			carroSaindo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void carroAndando() {
		int distanciaFinal = (int) ((Math.random() * 2001) + 1000);
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
				+ "o.");
	}

	private void carroParado() {
		System.out.println("O carro #" + idCarro + " estacionou");
		int tempo = (int) ((Math.random() * 2501) + 500);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroSaindo() {
		posicaoSaida++;
		System.out.println("O carro #" + idCarro + " foi o " + posicaoSaida
				+ "o. a sair");
	}

}
