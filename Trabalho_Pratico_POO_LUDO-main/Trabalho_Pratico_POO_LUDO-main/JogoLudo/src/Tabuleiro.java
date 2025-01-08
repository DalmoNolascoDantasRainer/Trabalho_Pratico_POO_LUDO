import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tabuleiro {
    private JPanel painelTabuleiro;
    private ArrayList<Casa> listaCasas;
    private ArrayList<CasaFinal> listaTrilhaFinal;
    private int[] caminho;

    public Tabuleiro() {
        listaCasas = new ArrayList<>();
        listaTrilhaFinal = new ArrayList<>();
        inicializarInterface();
        inicializaTabuleiro();
    }

    public JPanel getPanel() {
        return painelTabuleiro;
    }

    private void inicializarInterface() {
        // Configura a janela principal
        painelTabuleiro = new JPanel();
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

            painelTabuleiro.add(botao); // Adiciona o botão ao painel
        }
    }

    public void inicializaTabuleiro() {
        // Define as posições das casas no caminho cinza (índices lineares)
        caminho = new int[] {
            91, 92, 93, 94, 95, 96, 81, 66, 51, 36, 21, 6, 7, 8, 23, 38, 53, 68, 83, 98, 99, 100, 101, 102, 103, 104, 119, 134, 133, 132, 131, 130, 129, 128, 143, 158, 173, 188, 203, 202, 201, 186, 171, 156, 141, 126, 125, 124, 123, 122, 121, 120, 105, 90};

        // Inicializa as casas no caminho cinza
        for (int i = 0; i < caminho.length; i++) {
            int posicao = caminho[i];
            listaCasas.add(new Casa(posicao));  // Adiciona a casa à lista
        }
    }

    public int[] getCaminho() {
        return caminho;
    }

    public void limparTabuleiro() {
        for (Component component : painelTabuleiro.getComponents()) {
            JButton botao = (JButton) component;
            botao.setText("");
        }
    }

    public void posicionarPeao(Peao peao) {
        int posicaoAtual = peao.getPosicaoAtual();
        if (posicaoAtual >= 0 && posicaoAtual < 15 * 15) {
            JButton botao = (JButton) painelTabuleiro.getComponent(posicaoAtual);
            botao.setText(peao.getCorPeao().name().substring(0, 1)); // Exibe a inicial da cor do peão
    
            // Define a cor do botão com base na cor do peão
            switch (peao.getCorPeao()) {
                case AMARELO:
                    botao.setBackground(Color.YELLOW);
                    break;
                case AZUL:
                    botao.setBackground(Color.BLUE);
                    break;
                case VERDE:
                    botao.setBackground(Color.GREEN);
                    break;
                case VERMELHO:
                    botao.setBackground(Color.RED);
                    break;
            }
        }
    }

    public ArrayList<Casa> getListaCasas() {
        return listaCasas;
    }

    public ArrayList<CasaFinal> getListaTrilhaFinal() {
        return listaTrilhaFinal;
    }

    public void atualizarPosicaoPeao(Peao peao, int novaPosicao) {
        // Limpa a posição atual do peão
        int posicaoAtual = peao.getPosicaoAtual();
        if (posicaoAtual >= 0 && posicaoAtual < 15 * 15) {
            JButton botaoAtual = (JButton) painelTabuleiro.getComponent(posicaoAtual);
            botaoAtual.setText("");
            botaoAtual.setBackground(Color.LIGHT_GRAY);
        }

        // Atualiza a posição do peão
        peao.setPosicaoAtual(novaPosicao);

        // Adiciona o peão na nova posição
        posicionarPeao(peao);
    }

    public void exibirEstadoCasas() {
        for (int i = 0; i < listaCasas.size(); i++) {
            Casa casa = listaCasas.get(i);
            System.out.print("Casa " + i + ": ");
            for (Peao peao : casa.getListaPeoes()) {
                System.out.print(peao.getCorPeao().name().substring(0, 1) + " ");
            }
            System.out.println();
        }
    }
}
/*import java.util.ArrayList;
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

         Inicializa a trilha final para cada jogador (6 casas para cada cor)
        for (Jogador jogador : jogadores) {
            ArrayList<CasaFinal> trilhaFinal = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                trilhaFinal.add(new CasaFinal());
            }
            jogador.setTrilhaFinal(trilhaFinal);
        } 
    }
}
*/

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