import javax.swing.*;
import java.awt.*;
//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Tabuleiro {
    private JPanel painelTabuleiro;
    private ArrayList<Casa> listaCasas;
    private ArrayList<CasaFinal> trilhaFinalAmarelo;
    private ArrayList<CasaFinal> trilhaFinalAzul;
    private ArrayList<CasaFinal> trilhaFinalVerde;
    private ArrayList<CasaFinal> trilhaFinalVermelho;
    private int[] caminho;


    public Tabuleiro() {
        listaCasas = new ArrayList<>();
        trilhaFinalAmarelo = new ArrayList<>();
        trilhaFinalAzul = new ArrayList<>();
        trilhaFinalVerde = new ArrayList<>();
        trilhaFinalVermelho = new ArrayList<>();
        inicializarInterface();
        inicializaTabuleiro();
        InicializaTrilhasFinais();
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
            91, 92, 93, 94, 95, 96, 81, 66, 51, 36, 21, 6, 7, 8, 23, 38, 53, 68, 83, 98, 99, 100, 101, 102, 103, 104, 119, 134, 133, 132, 131, 130, 129, 128, 143, 158, 173, 188, 203, 218, 217, 216, 201, 186, 171, 156, 141, 126, 125, 124, 123, 122, 121, 120, 105, 90};


        // Inicializa as casas no caminho cinza
        for (int i = 0; i < caminho.length; i++) {
            int posicao = caminho[i];
            listaCasas.add(new Casa(posicao));  // Adiciona a casa à lista
        }
        
    }

    public void InicializaTrilhasFinais(){
        int[] trilhaFinalVermelho = {106, 107, 108, 109, 110, 111};
        int[] trilhaFinalAmarelo = {202, 187, 172, 157, 142, 127};
        int[] trilhaFinalAzul = {118, 117, 116, 115, 114, 113};
        int[] trilhaFinalVerde = {22, 37, 52, 67, 82, 97};

        adicionarTrilhaFinal(trilhaFinalVermelho, this.trilhaFinalVermelho);
        adicionarTrilhaFinal(trilhaFinalAmarelo, this.trilhaFinalAmarelo);
        adicionarTrilhaFinal(trilhaFinalAzul, this.trilhaFinalAzul);
        adicionarTrilhaFinal(trilhaFinalVerde, this.trilhaFinalVerde);
    }

    public void adicionarTrilhaFinal(int[] trilhaFinal, ArrayList<CasaFinal> listaTrilhasFinais) {
        for (int i = 0; i < trilhaFinal.length; i++) {
            int posicao = trilhaFinal[i];
            if (i == trilhaFinal.length - 1) {
                listaTrilhasFinais.add(new CasaFinal(posicao, true));  // Adiciona a casa na lista
            } else {
            listaTrilhasFinais.add(new CasaFinal(posicao));  // Adiciona a casa na lista
            }
        }
    }

    public int[] getCaminho() {
        return caminho;
    }
    //modificando
    public void limparTabuleiro() {
        for (Component component : painelTabuleiro.getComponents()) {
            JButton botao = (JButton) component;
            botao.setText("");
        }
    }

    public void posicionarPeao(Peao peao, int indice) {

        int posicaoAtual = peao.getPosicaoAtual();
        if (posicaoAtual >= 0 && posicaoAtual < 15 * 15) {
            JButton botao = (JButton) painelTabuleiro.getComponent(posicaoAtual);
            botao.setText(""+peao.getIndice()); // Exibe a inicial da cor do peão
    
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

    public ArrayList<CasaFinal> getTrilhaFinalAmarelo() {
        return trilhaFinalAmarelo;
    }

    public ArrayList<CasaFinal> getTrilhaFinalAzul() {
        return trilhaFinalAzul;
    }

    public ArrayList<CasaFinal> getTrilhaFinalVerde() {
        return trilhaFinalVerde;
    }

    public ArrayList<CasaFinal> getTrilhaFinalVermelho() {
        return trilhaFinalVermelho;
    }   
    

    public void atualizarPosicaoPeao(Peao peao, int antigaPosicao) {
        // Limpa a posição antiga do peão e come os peoes na casade destino
        int novaPosicao = peao.getPosicaoAtual();
        
        System.out.println("Atualizando posição do peão. Antiga posição: " + antigaPosicao + ", Nova posição: " + novaPosicao);
        if (antigaPosicao >= 0 && antigaPosicao < 15 * 15) {
            for (int j = 0; j < caminho.length; j++){
                if (caminho[j] == novaPosicao){
                    // Use um iterador para evitar ConcurrentModificationException
                    Iterator<Peao> iterator = listaCasas.get(j).getListaPeoes().iterator();
                    while (iterator.hasNext()) {
                        Peao peaoAdversario = iterator.next();
                        if (peaoAdversario.getCorPeao() != peao.getCorPeao()) {
                            peaoAdversario.retornarBase();
                            iterator.remove(); // Remove o peão adversário da lista
                            System.out.println("Peão adversário retornado para a base");
                        }
                    }
                }
            }
            boolean eraTrilhaFinal = false;
            for (int i = 0; i < trilhaFinalAmarelo.size(); i++) {
                if (trilhaFinalAmarelo.get(i).getPosicao() == antigaPosicao || trilhaFinalAzul.get(i).getPosicao() == antigaPosicao || trilhaFinalVerde.get(i).getPosicao() == antigaPosicao || trilhaFinalVermelho.get(i).getPosicao() == antigaPosicao) {
                    eraTrilhaFinal = true;
                    break;
                }
            }

            if(antigaPosicao == 7 || antigaPosicao == 119 || antigaPosicao == 217 || antigaPosicao == 105){
                JButton botaoAtual = (JButton) painelTabuleiro.getComponent(antigaPosicao);
                botaoAtual.setBackground(Color.GRAY);
            } 
           
            else if(eraTrilhaFinal){
                JButton botaoAtual = (JButton) painelTabuleiro.getComponent(antigaPosicao);
                botaoAtual.setBackground(Color.WHITE);
            }
            else {
                JButton botaoAtual = (JButton) painelTabuleiro.getComponent(antigaPosicao);
                botaoAtual.setText("");
                botaoAtual.setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    public void exibirEstadoCasas() {
        for (int i = 0; i < listaCasas.size(); i++) {
            Casa casa = listaCasas.get(i);
            System.out.print("Casas " + i + ": ");
            for (Peao peao : casa.getListaPeoes()) {
                System.out.print(peao.getCorPeao().name().substring(0, 1) + " ");
            }
            System.out.println();
        }
    }
}
