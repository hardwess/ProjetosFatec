package controller;

public class Fatorial {

	public int fatorialRecursivo(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * fatorialRecursivo(n - 1);
		}
	}
}
