import java.util.ArrayList;

import Casas.Casa;
import Casas.CasaFinal;
public class Tabuleiro{
    private ArrayList<CasaFinal> listaTrilhaFinal;
    private ArrayList<Casa> listaCasas;

    public Tabuleiro(){
        listaCasas = new ArrayList<>();
        listaTrilhaFinal = new ArrayList<>();
        inicializaTabuleiro();
    }

    public ArrayList<Casa> getListaCasas() {
        return listaCasas;
    }

    public ArrayList<CasaFinal> getListaTrilhaFinal() {
        return listaTrilhaFinal;
    }

    public void inicializaTabuleiro(){
        // iniciando as casas
        for (int i = 0; i < 52; i++) { // COLOCAR QTD DE CASAS
            listaCasas.add(new Casa(i));
        }

        // Trilha Final Amarelo
        ArrayList<CasaFinal> trilhaFinalAmarelo = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                trilhaFinalAmarelo.add(new CasaFinal());
            }
        
        // Trilha Final Azul
        ArrayList<CasaFinal> trilhaFinalAzul = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                trilhaFinalAzul.add(new CasaFinal());
            }

        // Trilha Final Verde
        ArrayList<CasaFinal> trilhaFinalVerde = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                trilhaFinalVerde.add(new CasaFinal());
            }
        
        // Trilha Final Vermelho
        ArrayList<CasaFinal> trilhaFinalVermelho = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                trilhaFinalVermelho.add(new CasaFinal());
            }

        /*// Inicializa a trilha final para cada jogador (6 casas para cada cor)
        for (Jogador jogador : jogadores) {
            ArrayList<CasaFinal> trilhaFinal = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                trilhaFinal.add(new CasaFinal());
            }
            jogador.setTrilhaFinal(trilhaFinal);
        } */
    }
}



/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabuleiro {

    private JFrame frame; // Janela principal do jogo
private JButton[] casas; // Vetor que representa as casas do tabuleiro
private int totalCasas; // Número total de casas no tabuleiro

public Tabuleiro() {
    // Construtor que inicializa o tabuleiro Ludo
    this.totalCasas = 52 + 4 * 4 + 6 * 4; // 52 casas do percurso, 16 das bases e 24 do "caminho seguro"
    this.casas = new JButton[totalCasas];
    inicializarInterface(); // Configura a interface gráfica
}

private void inicializarInterface() {
    // Configura a janela principal
    frame = new JFrame("Tabuleiro Ludo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 800);

    // Cria o painel principal com layout para simular o tabuleiro Ludo
    JPanel painelTabuleiro = new JPanel();
    painelTabuleiro.setLayout(new GridLayout(15, 15)); // Tabuleiro 15x15

    for (int i = 0; i < 15 * 15; i++) {
        JButton botao = new JButton();
        botao.setFont(new Font("Arial", Font.BOLD, 10));
        botao.setBackground(Color.LIGHT_GRAY);

        // Define as cores e funcionalidade conforme a posição no tabuleiro Ludo
        int linha = i / 15;
        int coluna = i % 15;

        if ((linha < 6 && coluna < 6) || (linha > 8 && coluna < 6) || (linha < 6 && coluna > 8) || (linha > 8 && coluna > 8)) {
            // Áreas das bases coloridas
            if (linha < 6 && coluna < 6) botao.setBackground(Color.RED);
            else if (linha < 6 && coluna > 8) botao.setBackground(Color.GREEN);
            else if (linha > 8 && coluna < 6) botao.setBackground(Color.YELLOW);
            else if (linha > 8 && coluna > 8) botao.setBackground(Color.BLUE);
        } else if ((linha == 7 && coluna >= 1 && coluna <= 5) || (linha == 7 && coluna >= 9 && coluna <= 13) ||
                   (coluna == 7 && linha >= 1 && linha <= 5) || (coluna == 7 && linha >= 9 && linha <= 13)) {
            // Caminhos seguros (centralizados)
            botao.setBackground(Color.WHITE);
        } else if (linha == 7 || coluna == 7) {
            // Caminhos principais
            botao.setBackground(Color.GRAY);
        }

        final int indice = i; // Índice para ação do botão
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aoClicarNaCasa(indice);
            }
        });

        painelTabuleiro.add(botao); // Adiciona o botão ao painel
    }

    frame.add(painelTabuleiro); // Adiciona o painel à janela principal
    frame.setVisible(true); // Torna a janela visível
}

private void aoClicarNaCasa(int indice) {
    // Define o comportamento ao clicar em uma casa do tabuleiro
    System.out.println("Casa clicada: " + indice);
}
}*/ 