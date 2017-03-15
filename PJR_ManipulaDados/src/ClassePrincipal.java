
import java.io.IOException;
import javax.swing.JOptionPane;

public class ClassePrincipal {

    public static void main(String arg[]) throws IOException {
        Aluno[] aluno = new Aluno[3];
        ClasseMetodos m = new ClasseMetodos();
        int opcao = 0;

        opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Grava Aluno\n2 - Ler Aluno\n9 - Sair"));
        while (opcao != 9) {
            switch (opcao) {
                case 0:
                    opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Grava Aluno\n2 - Ler Aluno\n9 - Sair"));
                case 1:
                    while (opcao == 1) {
                        m.GravaAluno(aluno);
                        opcao = 0;
                    }
                    break;
                case 2:
                    while (opcao == 2) {
                        m.LerAluno(aluno);
                        opcao = 0;
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Grava Aluno\n2 - Ler Aluno\n9 - Sair"));
            }
        }
    }
}
