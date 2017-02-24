public class Cronometro {

	
	public static void main(String[] args) {
		String palavra = "";
		double TempoInicial = System.nanoTime(), TempoFinal;
		
		for (int i=0;i<32483;i++){
		palavra = palavra + "a";	
		}
	
		TempoFinal = TempoInicial - (System.nanoTime()*Math.pow(10, 9));
		System.out.print("Tempo de execução = "+TempoFinal);
	}
}
