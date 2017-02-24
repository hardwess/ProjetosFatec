
import java.io.IOException;
import javax.swing.*;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.plaf.FontUIResource;

public class MENU {

    public static void main(String arg[]) throws IOException {
        int i;
        int opcao = 0;
        Metodos m;
        m = new Metodos();
        Abstrata Registro[] = new Abstrata[m.QTD];

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe ui", Font.PLAIN, 12)));
        UIManager.put("OptionPane.messageForeground", Color.black);
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Segoe ui", Font.PLAIN, 12)));
        UIManager.put("OptionPane.background", new Color(112, 219, 219));
        UIManager.put("Panel.background", new Color(112, 219, 219));
        UIManager.put("Button.background", new Color(112, 219, 219));
        UIManager.put("Button.border", new Color(112, 219, 219));

        while (opcao != 9) {
            String option = JOptionPane.showInputDialog("\n"
                    + "           SISTEMA DE VOTAÇÃO                   \n       "
                    + "\n"
                    + " 1 – Carregar Seção/Número Candidato\n"
                    + " 2 – Classificar por Seção\n"
                    + " 3 – Gravar Registros\n"
                    + " 4 – Mostrar Indicadores\n"
                    + "\n"
                    + " 9 – Finalizar\n"
                    + "\n");
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
                    Registro = m.cadastra(Registro);
                    break;
                case 2:
                    Registro = m.ClassificaSecao(Registro);
                    break;
                case 3:
                    Registro = m.GravaRegistro(Registro);
                    break;
                case 4:
                    Registro = m.MostraIndicadores(Registro);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " Opção Inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
                    break;

            }
        }
    }
}
