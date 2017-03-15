
import javax.swing.JOptionPane;

public class ListaDeInteiros {

    private int dados[];
    private int tamanho;
    static int Backup;
    Menu n;

    public ListaDeInteiros(int c) {
        dados = new int[c];
        tamanho = 0;
    }

    public boolean cheia() {
        return tamanho == dados.length;
    }

    public boolean vazia() {
        return tamanho == (dados.length - dados.length);
    }

    public void adicionaInicio(int e) {
        if (cheia()) {
            JOptionPane.showMessageDialog(null, "Lista Cheia!", "Alerta", JOptionPane.ERROR_MESSAGE);
        } else {
            int i = tamanho;
            while (i > 0) {
                dados[i] = dados[i - 1];
                i--;
            }
            e = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o valor à ser escrito na lista"));
            dados[0] = e;
            tamanho++;
        }
        //teste
        for (int z = 0; z < 4; z++) {
            System.out.print("[" + dados[z] + "] ");
        }
        System.out.println("");
        //teste
    }

    public void adicionaFinal(int e) {
        if (!cheia()) {
            e = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o valor à ser escrito na lista"));
            dados[tamanho] = e;
            tamanho++;
            //teste
            for (int z = 0; z < 4; z++) {
                System.out.print("[" + dados[z] + "] ");
            }
            System.out.println("");
            //teste
        } else {
            JOptionPane.showMessageDialog(null, "Lista Cheia!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void adicionaPosicao(int e) {
        int Posicao;
        Posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição à inserir o valor: "));
        Posicao = Posicao - 1;
        if (Posicao <= tamanho) {
            for (int i = tamanho - 1; i > Posicao; i--) {
                dados[i] = dados[i - 1];
            }
            dados[Posicao] = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor à ser inserido: "));
            tamanho++;
        } else {
            JOptionPane.showMessageDialog(null, "Excede o tamanho da lista\nA lista contém: " + tamanho + " elemento(s)");
        }
        //teste
        for (int z = 0; z < 4; z++) {
            System.out.print("[" + dados[z] + "] ");
        }
        System.out.println("");
        //teste
    }

    public int RemoveInicio(int e) {
        if (tamanho == 1) {
            Backup = dados[dados.length - dados.length];
            dados[0] = 0;
            tamanho--;
            //teste
            for (int z = 0; z < 4; z++) {
                System.out.print("[" + dados[z] + "] ");
            }
            System.out.println("");
            //teste
        } else if (vazia()) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!", "Alerta", JOptionPane.ERROR_MESSAGE);
        } else {
            Backup = dados[dados.length - dados.length];
            int i = 0;
            while (i < (tamanho - 1)) {
                dados[i] = dados[i + 1];
                dados[i + 1] = 0;
                i++;
            }
            tamanho--;
            //teste
            for (int z = 0; z < 4; z++) {
                System.out.print("[" + dados[z] + "] ");
            }
            System.out.println("");
            //teste
        }
        return Backup;
    }

    public int RemoveFinal(int e) {
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!", "Alerta", JOptionPane.ERROR_MESSAGE);
        } else {
            Backup = dados[tamanho - 1];
            dados[tamanho - 1] = 0;
            tamanho--;
            //teste
            for (int z = 0; z < 4; z++) {
                System.out.print("[" + dados[z] + "] ");
            }
            System.out.println("");
            //teste
        }
        return Backup;
    }

    public int RemovePosicao(int e) {
        int Posicao = 0;
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!", "Alerta", JOptionPane.ERROR_MESSAGE);
        } else {
            Posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição à ser excluída: "));
            while (Posicao > tamanho) {
                JOptionPane.showMessageDialog(null, "Excede o tamanho da lista\nA lista contém: " + tamanho + " elemento(s)");
                Posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição à ser excluída: "));
            }
            Posicao = Posicao - 1;
            Backup = dados[Posicao];
            for (int i = Posicao; i < tamanho - 1; i++) {
                dados[i] = dados[i + 1];
            }
            tamanho--;
            dados[tamanho] = 0;
        }
        //teste
        for (int z = 0; z < 4; z++) {
            System.out.print("[" + dados[z] + "] ");
        }
        System.out.println("");
        //teste
        return Backup;
    }
}