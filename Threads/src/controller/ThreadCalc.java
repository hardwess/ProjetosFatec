package controller;

public class ThreadCalc extends Thread {

	private int a, b, operacao;

	public ThreadCalc(int a, int b, int op) {
		this.a = a;
		this.b = b;
		this.operacao = op;
	}

	@Override
	public void run() {
		calc();
	}

	private void calc() {
		int tempo = 1000 * operacao;
		try{
		Thread.sleep(tempo);}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		String op = "";
		int res = 0;
		switch (operacao) {
		case 0:
			res = a + b;
			op = "+";
			break;
		case 1:
			res = a - b;
			op = "-";
			break;
		case 2:
			res = a / b;
			op = "/";
			break;
		case 3:
			res = a * b;
			op = "*";
			break;
		}
		System.out.println(a + " " + op + " " + b + " = " + res + operacao);
	}

}
