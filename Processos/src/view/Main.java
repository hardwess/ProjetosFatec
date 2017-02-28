package view;

import controller.RedesController;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.plaf.FontUIResource;

public class Main {

	public static void main(String[] args) {

		RedesController m = new RedesController();
		int opcao = 0;
		String So = "";
		String Resultado;

		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe ui", Font.PLAIN, 12)));
		UIManager.put("OptionPane.messageForeground", Color.black);
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Segoe ui", Font.PLAIN, 12)));
		UIManager.put("OptionPane.background", new Color(112, 219, 219));
		UIManager.put("Panel.background", new Color(112, 219, 219));
		UIManager.put("Button.background1", new Color(112, 219, 219));
		UIManager.put("Button.border", new Color(112, 219, 219));
		
		So = System.getProperty("os.name");
		
		while (opcao != 9) {
			String option = (JOptionPane.showInputDialog("             Menu\n\n1 - IP\n2 - PING\n\n9 - Sair"));
			try {
				opcao = Integer.parseInt(option);
			} catch (NumberFormatException e) {
				if (option == null) {
					System.exit(0);
				}
				opcao = 0;
			}
			switch (opcao) {
			case 1:
				Resultado = RedesController.IP(So);
				break;
			case 2:
				m.ping();
				break;
			case 9:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}

	}

}
