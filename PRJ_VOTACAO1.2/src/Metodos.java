
import java.io.*;
import javax.swing.*;

public class Metodos {

    String fileName = "Votação2016.txt";
    final int QTD = 100;
    int i, j;
    //Váriavel que marca se o array já foi carregado para efetuar a organização do mesmo ou notificar que precisa ser registrado
    int piao;
    Integer temp[][] = new Integer[QTD][2];
    Integer temp3[] = new Integer[11];
    Integer temp4[] = new Integer[100];

    public Abstrata[] cadastra(Abstrata[] abstrata) {
        for (i = 0; i < QTD; i++) {
            temp[i][0] = (int) Math.floor((Math.random() * 11));
            temp[i][1] = (int) Math.floor((Math.random() * 300));
        }
        JOptionPane.showMessageDialog(null, "Registros carregados");
        piao = 1;
        return abstrata;
    }

    public Abstrata[] ClassificaSecao(Abstrata[] abstrata) {
        int j = 0;

        if (piao > 0) {
            for (i = 0; i < (QTD - 1); i++) {
                for (int k = (i + 1); k < QTD; k++) {
                    if (temp[i][0] > temp[k][0]) {
                        int aux = temp[i][0];
                        temp[i][0] = temp[k][0];
                        temp[k][0] = aux;
                        aux = temp[i][1];
                        temp[i][1] = temp[k][1];
                        temp[k][1] = aux;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Dados classificados");
        } else {
            JOptionPane.showMessageDialog(null, "             Votos não registrados\n  "
                    + "(Retorne ao menu anterior e registre)", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return abstrata;
    }

    public Abstrata[] GravaRegistro(Abstrata[] abstrata) throws IOException {
        if (piao > 0) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (i = 0; i < QTD; i++) {
                abstrata[i] = new Abstrata();
            }
            for (i = 0; i < QTD; i++) {
                abstrata[i].NumeroSecao = temp[i][0];
                writer.write(String.valueOf(abstrata[i].NumeroSecao));
                writer.write(" - ");
                abstrata[i].NumeroCandidato = temp[i][1];
                writer.write(String.valueOf(abstrata[i].NumeroCandidato));
                writer.newLine();
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Arquivo gerado");
        } else {
            JOptionPane.showMessageDialog(null, "             Votos não registrados\n  "
                    + "(Retorne ao menu anterior e registre)", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return abstrata;
    }

    public Abstrata[] MostraIndicadores(Abstrata[] abstrata) {
        int opcao = 0;
        if (piao < 1) {
            JOptionPane.showMessageDialog(null, "             Votos não registrados\n  "
                    + "(Retorne ao menu anterior e registre)", "Alerta", JOptionPane.ERROR_MESSAGE);
        } else {
            while (opcao != 9) {
                String option = JOptionPane.showInputDialog("\n"
                        + "       ESTATÍSTICAS DE VOTAÇÃO EM 2016                     \n"
                        + "\n"
                        + "1 – Quantidade de eleitores por Seção\n"
                        + "2 – Seção com Maior e Menor número de Eleitores\n"
                        + "3 – Quantidade de votos por candidato\n"
                        + "4 – 10 primeiros colocadas (Nº do cand. e qtd de votos)\n"
                        + "\n"
                        + "9 – Finaliza consulta\n"
                        + "\n");
                //Try - Catch evita que o menu dê erro e o programa se feche ao não digitar nada na caixa de opção
                try {
                    opcao = Integer.parseInt(option);
                } catch (NumberFormatException e) {
                    if (option == null) {
                        break;
                    }
                    opcao = 0;
                }
                switch (opcao) {
                    case 1:
                        QuantiaEleitoresSecao();
                        break;
                    case 2:
                        MaiorMenorNumeroEleitores();
                        break;
                    case 3:
                        VotosPorCandidato();
                        break;
                    case 4:
                        PrimeirosColocados();
                        break;
                    case 9:
                        return abstrata;
                    default:
                        JOptionPane.showMessageDialog(null, " Opção Inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
        return abstrata;
    }

    public void QuantiaEleitoresSecao() {
        Integer temp2[][] = new Integer[QTD][2];
        temp2 = temp;
        //BubbleSort para organizar o array temporário para comparação da quantia de seções registradas
        for (i = 0; i < (QTD - 1); i++) {
            for (int k = (i + 1); k < QTD; k++) {
                if (temp2[i][0] > temp2[k][0]) {
                    int aux = temp2[i][0];
                    temp2[i][0] = temp2[k][0];
                    temp2[k][0] = aux;
                    aux = temp2[i][1];
                    temp2[i][1] = temp2[k][1];
                    temp2[k][1] = aux;
                }
            }
        }
        Inicializa();
        //compara quantos votos a seção teve na matriz organizada anteriormente e registra no vetor 
        for (i = 0; i < QTD; i++) {
            for (j = 0; j < 11; j++) {
                if (temp2[i][0] == j) {
                    temp3[j] = (temp3[j] + 1);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Seção: 0 - " + temp3[0] + " votos\n"
                + "Seção: 1 - " + temp3[1] + " votos\n"
                + "Seção: 2 - " + temp3[2] + " votos\n"
                + "Seção: 3 - " + temp3[3] + " votos\n"
                + "Seção: 4 - " + temp3[4] + " votos\n"
                + "Seção: 5 - " + temp3[5] + " votos\n"
                + "Seção: 6 - " + temp3[6] + " votos\n"
                + "Seção: 7 - " + temp3[7] + " votos\n"
                + "Seção: 8 - " + temp3[8] + " votos\n"
                + "Seção: 9 - " + temp3[9] + " votos\n"
                + "Seção: 10 - " + temp3[10] + " votos");
    }

    public void MaiorMenorNumeroEleitores() {
        int Maior = 0, Menor = 100, AuxMaior = 0, AuxMenor = 0;
        Integer temp2[][] = new Integer[QTD][2];
        temp2 = temp;
        //BubbleSort para organizar o array temporário para comparação da quantia de seções registradas
        for (i = 0; i < (QTD - 1); i++) {
            for (int k = (i + 1); k < QTD; k++) {
                if (temp2[i][0] > temp2[k][0]) {
                    int aux = temp2[i][0];
                    temp2[i][0] = temp2[k][0];
                    temp2[k][0] = aux;
                    aux = temp2[i][1];
                    temp2[i][1] = temp2[k][1];
                    temp2[k][1] = aux;
                }
            }
        }
        Inicializa();
        //compara quantos votos a seção teve na matriz organizada anteriormente e registra no vetor 
        for (i = 0; i < QTD; i++) {
            for (j = 0; j < 11; j++) {
                if (temp2[i][0] == j) {
                    temp3[j] = (temp3[j] + 1);
                }
            }
        }
        for (i = 0; i < 11; i++) {
            if (Maior < temp3[i]) {
                Maior = temp3[i];
                AuxMaior = i;
            }
            if (Menor > temp3[i]) {
                Menor = temp3[i];
                AuxMenor = i;
            }
        }
        JOptionPane.showMessageDialog(null, "Maior quantia de eleitores  | seção: " + AuxMaior + " com " + Maior + " Eleitores\n"
                + "Menor quantia de eleitores | seção: " + AuxMenor + " com " + Menor + " Eleitores");

    }

    public void VotosPorCandidato() {
        Integer temp2[][] = new Integer[QTD][2];
        temp2 = temp;
        int Candidato = 0;
        int Quantia = 0;
        Candidato = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do candidato:"));
        for (i = 0; i < QTD - 1; i++) {
            if (Candidato == temp2[i][1]) {
                Quantia = Quantia + 1;
            }
        }
        JOptionPane.showMessageDialog(null, "Candidato: " + Candidato + "\n Quantia de votos: " + Quantia);
    }

    public void PrimeirosColocados() {
        Integer temp2[][] = new Integer[QTD][2];
        Integer temp3[] = new Integer[301];
        Integer temp4[][] = new Integer[10][2];
        temp2 = temp;
        //Inicializa
        for (i = 0; i < 10; i++) {
            temp4[i][0] = 0;
            temp4[i][1] = 0;
        }
        //BubbleSort para organizar o array temporário em ordem crescente o número de candidato
        for (i = 0; i < (QTD - 1); i++) {
            for (int k = (i + 1); k < QTD; k++) {
                if (temp2[i][1] > temp2[k][1]) {
                    int aux = temp2[i][1];
                    temp2[i][1] = temp2[k][1];
                    temp2[k][1] = aux;
                    aux = temp2[i][0];
                    temp2[i][0] = temp2[k][0];
                    temp2[k][0] = aux;
                }
            }
        }
        //Inicializa
        for (i = 0; i < 301; i++) {
            temp3[i] = 0;
        }
        //Localiza no vetor a quantia de votos pelo númnero do candidato (número do candidato = endereço do vetor)
        for (i = 0; i < QTD; i++) {
            temp3[temp2[i][1]] = temp3[temp2[i][1]] + 1;
        }
        //Classifica no array de 10 ocorrências a maior quantia de votos e o número do candidato votado
        for (i = 0; i < (QTD - 1); i++) {
            for (int k = (i + 1); k < 301; k++) {
                if (temp3[i] > temp4[k][1]) {
                    int aux = temp3[i];
                    temp3[i] = temp4[k][1];
                    temp4[k][1] = aux;
                    temp4[k][0] = i;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Ranking - 10 mais votados\n"
                + "Candidato:          Votos:\n"
                + temp4[0][0] + " - " + temp4[0][1] + "\n"
                + temp4[1][0] + " - " + temp4[1][1] + "\n"
                + temp4[2][0] + " - " + temp4[2][1] + "\n"
                + temp4[3][0] + " - " + temp4[3][1] + "\n"
                + temp4[4][0] + " - " + temp4[4][1] + "\n"
                + temp4[5][0] + " - " + temp4[5][1] + "\n"
                + temp4[6][0] + " - " + temp4[6][1] + "\n"
                + temp4[7][0] + " - " + temp4[7][1] + "\n"
                + temp4[8][0] + " - " + temp4[8][1] + "\n"
                + temp4[9][0] + " - " + temp4[9][1] + "\n");
    }

    public void Inicializa() {
        //inicializa o vetor temporário para receber a quantia de votos referente á sua seção
        for (j = 0; j < 11; j++) {
            temp3[j] = 0;
        }
    }
}
