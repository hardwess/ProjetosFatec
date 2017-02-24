
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.plaf.FontUIResource;

public class Menu {

    public static void main(String arg[]) throws IOException {
        int i;
        Estatística2015 m;
        m = new Estatística2015();
        int opcao = 0;

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe ui", Font.PLAIN, 12)));
        UIManager.put("OptionPane.messageForeground", Color.black);
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Segoe ui", Font.PLAIN, 12)));
        UIManager.put("OptionPane.background", new Color(112, 219, 219));
        UIManager.put("Panel.background", new Color(112, 219, 219));
        UIManager.put("Button.background", new Color(112, 219, 219));
        UIManager.put("Button.border", new Color(112, 219, 219));

        while (opcao != 9) {
            String option = (JOptionPane.showInputDialog("             Estatística Trânsito 2015\n\n1 - Cadastrar Estatística\n2 - Consultar por tipo de veículo\n3 - Consultar por quantia de acidentes\n4 - Consultar por Código/Nome/Quantia de acidentes\n5 - Consultar maior e menor número de acidentes\n\n9 - Sair"));
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
                    m.FCADASTRAESTATISTICA();
                    break;
                case 2:
                    m.FTIPO();
                   break;
                case 3:
                    m.PQTACIDENTES();
                    break;
                case 4:
                    m.PCONSULTAACIDENTES();
                    break;
                case 5:
                    m.CONSULTAR();
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
