package com.mycompany.mavenproject2;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Mavenproject2 {

    public static void main(String[] args) {
        int tmVetor = Integer.parseInt(JOptionPane.showInputDialog("Qual será o tamanho do vetor:  "));
        int vetor[] = new int[tmVetor];
        int vetorOrdenado[] = new int [tmVetor];

        
        for (int i = 0; i < tmVetor; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição: " + i));
            vetorOrdenado[i] = vetor[i];
        }

        
        String[] opcao = {"Inserção", "Seleção", "Bolha"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha o método de ordenação:", "Método de Ordenação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

        switch (escolha) {
            case 0: 
                ordenacaoInsercao(vetorOrdenado);
                break;
            case 1: 
                ordenacaoSelecao(vetorOrdenado);
                break;
            case 2: 
                ordenacaoBolha(vetorOrdenado);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha inválida!");
                return;
        }

       
        String mensagemOrg = "Vetor original: ";
        for (int i = 0; i < vetor.length; i++) {
            mensagemOrg += vetor[i];
            if (i < vetor.length - 1) {
                mensagemOrg += " - ";
            }
        }

        String mensagemOrdenado = "Vetor ordenado: ";
        for (int i = 0; i < vetorOrdenado.length; i++) {
            mensagemOrdenado += vetorOrdenado[i];
            if (i < vetorOrdenado.length - 1) {
                mensagemOrdenado += " - ";
            }
        }

        JOptionPane.showMessageDialog(null, mensagemOrg + "\n" + mensagemOrdenado);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////    
    public static void ordenacaoInsercao(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            int chave = vetor[i];
            int j;

            for (j = i - 1; j >= 0 && vetor[j] > chave; j--) {
                vetor[j + 1] = vetor[j];
            }
            vetor[j + 1] = chave;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////    
    public static void ordenacaoSelecao(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }

            if (menor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[menor];
                vetor[menor] = temp;
            }
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void ordenacaoBolha(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
}

/*O metedo de desenvolvimente deste trabalho, foi por meio de pesquisas nos repositórios do GITHUB do professor
Paulinho. Algumas das implementações vi necessidade de pesquisas em sites, para entender como estrutura-las no código.
Por primeiro, criei todos os métodos, assim como feito em aula, depois fui implementando os detalhes solicitados pelo
Professor (vetor original e ordenado, escolha de método e etc*/