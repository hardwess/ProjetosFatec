package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {

	public static String IP(String Resultado) {
		String NomeEndereco[] = new String[2];
		Process exec;
		int marcador = 0;
		if (Resultado.startsWith("W")) {
			try {
				exec = Runtime.getRuntime().exec("ipconfig");
				if (exec.waitFor() == 0) {
					String linha = "";
					BufferedReader buf = new BufferedReader(new InputStreamReader(exec.getInputStream()));
					while ((linha = buf.readLine()) != null) {
						if (linha.contains("Ethernet")) {
							NomeEndereco[0] = String.valueOf(linha);
							marcador =  1;
						}
						if (linha.contains("IPv4")) {
							NomeEndereco[1] = String.valueOf(linha);
							marcador = marcador + 1;
						}
						if (marcador == 2) {
							marcador = 0;
							JOptionPane.showMessageDialog(null, NomeEndereco[0] + "\n" + NomeEndereco[1]);
						}
					}
				} else
					System.out.println("ERRO");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return Resultado;
	}

	public double ping() {
		double i = 0.0;
		int Contador = 0;
		try {
			Process proc = Runtime.getRuntime().exec("PING -t10 WWW.GOOGLE.COM.BR ");
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (Contador < 12) {
				System.out.println(linha);
				linha = buffer.readLine();
				Contador++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}

}
