import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.plaf.FontUIResource;

public class Menu {

    public static void UltimaRemocao() {
        ListaDeInteiros m;
        m = new ListaDeInteiros(4);
        JOptionPane.showMessageDialog(null, "Última remoção: " + m.Backup);
    }

    public static void main(String arg[]) {
        ListaDeInteiros m;
        m = new ListaDeInteiros(4);
        int opcao = 0;

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe ui", Font.PLAIN, 12)));
        UIManager.put("OptionPane.messageForeground", Color.black);
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Segoe ui", Font.PLAIN, 12)));
        UIManager.put("OptionPane.background", new Color(112, 219, 219));
        UIManager.put("Panel.background", new Color(112, 219, 219));
        UIManager.put("Button.background", new Color(112, 219, 219));
        UIManager.put("Button.border", new Color(112, 219, 219));

        while (opcao != 9) {
            String option = (JOptionPane.showInputDialog(null, "                                    Lista\n\n"
                    +"         Adições:\n"
                    + "1 - Adiciona Início \n"
                    + "2 - Adiciona Final \n"
                    + "3 - Adiciona Posição \n\n"
                    + "        Remoções:\n"
                    + "4 - Remove Início \n"
                    + "5 - Remove Final \n"
                    + "6 - Remove Posição \n\n\n"
                    + "9 - Sair", "", -1));
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
                    m.adicionaInicio(opcao);
                    break;
                case 2:
                    m.adicionaFinal(opcao);
                    break;
                case 3:
                    m.adicionaPosicao(opcao);
                    break;
                case 4:
                    m.RemoveInicio(opcao);
                    UltimaRemocao();
                    break;
                case 5:
                    m.RemoveFinal(opcao);
                    UltimaRemocao();
                    break;
                case 6:
                    m.RemovePosicao(opcao);
                    UltimaRemocao();
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