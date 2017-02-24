
import java.io.*;
import javax.swing.*;

public class Estatística2015 {

    String fileName = "Estatistica.txt";
    int qtdLinhas = 4;
    final int TAMANHO = 15;
    Estatistica estatistica[] = new Estatistica[TAMANHO];

    public void FCADASTRAESTATISTICA() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < qtdLinhas; i++) {
            estatistica[i].CodCidade = Integer.parseInt(JOptionPane.showInputDialog("Insira o Código da cidade:"));
            writer.write(Integer.toString(estatistica[i].CodCidade));
            writer.write(" - ");
            estatistica[i].NomeCidade = JOptionPane.showInputDialog("Insira o nome da cidade:");
            writer.write(estatistica[i].NomeCidade);
            writer.write(" - ");
            estatistica[i].QTDAcidentes = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantia de acidentes:"));
            writer.write(Integer.toString(estatistica[i].QTDAcidentes));
            writer.write(" - ");
            estatistica[i].TipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog("Insira o tipo do veículo:"));
            writer.write(Integer.toString(estatistica[i].TipoVeiculo));
            writer.newLine();
        }
        JOptionPane.showMessageDialog(null, "gravação efetuada ", "confirmado", JOptionPane.INFORMATION_MESSAGE);
        writer.close();
    }

    public void FTIPO() throws IOException {
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        Estatistica temp[] = new Estatistica[TAMANHO];
        String texto = "";
        for (int i = 0; i < TAMANHO; i++) {
            temp[i] = new Estatistica();
        }

        for (int i = 0; i < TAMANHO; i++) {
            ler.readLine().split(" - ");
            estatistica[i].CodCidade = Integer.parseInt(texto);
            System.out.print(estatistica[i].CodCidade + " ");
            estatistica[i].NomeCidade = texto;
            System.out.print(estatistica[i].NomeCidade + " ");
            estatistica[i].QTDAcidentes = Integer.parseInt(texto);
            System.out.print(estatistica[i].QTDAcidentes + " ");
            estatistica[i].TipoVeiculo = Integer.parseInt(texto);
            System.out.print(estatistica[i].TipoVeiculo + "\n");
        }
        ler.close();
    }

    public void PQTACIDENTES() throws IOException {
    }

    public void PCONSULTAACIDENTES() throws IOException {
    }

    public void CONSULTAR() throws IOException {
    }
}
