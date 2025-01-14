import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    private static Jogador jogadorAtual;
    private static JLabel dadoLabel;
    private static JLabel jogadorAtualLabel;
    private static JComboBox<Integer> peaoComboBox;
    private static int resultadoDado;
    private static int turno;

    public static void main(String[] args) {
        // Instancia um objeto da classe Dado
        Dado dado = new Dado();
        

        // Cria jogadores e inicializa peões
        Tabuleiro tabuleiro = new Tabuleiro();
        JogadorVermelho jogadorVermelho = new JogadorVermelho(tabuleiro);
        JogadorAmarelo jogadorAmarelo = new JogadorAmarelo(tabuleiro);
        JogadorAzul jogadorAzul = new JogadorAzul(tabuleiro);
        JogadorVerde jogadorVerde = new JogadorVerde(tabuleiro);

        inicializarPeoes(jogadorAmarelo, tabuleiro);
        inicializarPeoes(jogadorAzul, tabuleiro);
        inicializarPeoes(jogadorVerde, tabuleiro);
        inicializarPeoes(jogadorVermelho, tabuleiro);

        // Cria a janela principal
        JFrame frame = new JFrame("Jogo Ludo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLayout(new BorderLayout());

        // Adiciona o tabuleiro ao centro da janela
        frame.add(tabuleiro.getPanel(), BorderLayout.CENTER);

        // Cria um painel para os botões dos jogadores e adiciona à lateral da janela
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        placeComponents(panel, jogadorAmarelo, jogadorAzul, jogadorVerde, jogadorVermelho, tabuleiro, dado);
        frame.add(panel, BorderLayout.EAST);

        frame.setVisible(true);
        
        tabuleiro.exibirEstadoCasas();
    }

    private static void placeComponents(JPanel panel, Jogador jogadorAmarelo, Jogador jogadorAzul, Jogador jogadorVerde, JogadorVermelho jogadorVermelho, Tabuleiro tabuleiro, Dado dado) {
        

        
        jogadorAtualLabel = new JLabel("Jogador Atual: ");
        panel.add(jogadorAtualLabel);

        // Adiciona o botão para rolar o dado
        JButton rollDiceButton = new JButton("Rolar Dado");
        panel.add(rollDiceButton);
        rollDiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultadoDado = dado.rolarDado();
                dadoLabel.setText("Resultado do dado: " + resultadoDado);
                System.out.println("Resultado do dado: " + resultadoDado); // Depuração
                switch (turno) {
                    case 0:
                        jogadorAtual = jogadorAmarelo;
                        break;
                    case 1:
                        jogadorAtual = jogadorVermelho;
                        break;
                    case 2:
                        jogadorAtual = jogadorVerde;
                        break;
                    case 3:
                        jogadorAtual = jogadorAzul;
                        break;
                    default:
                        jogadorAtual = jogadorAmarelo;
                        break;
                }
                jogadorAtualLabel.setText("Jogador Atual: " + jogadorAtual.getNome());
                turno = (turno + 1) % 4;
            }
        });

        // Adiciona o label para exibir o resultado do dado
        dadoLabel = new JLabel("Resultado do dado: ");
        panel.add(dadoLabel);
        // Adiciona o combo box para selecionar o peão
        peaoComboBox = new JComboBox<>(new Integer[]{0, 1, 2, 3});
        peaoComboBox.setPreferredSize(new Dimension(150, 25)); // Define o tamanho preferido
        peaoComboBox.setMaximumSize(new Dimension(150, 25)); // Define o tamanho máximo
        panel.add(peaoComboBox);

        // Adiciona o botão para efetivar a ação
        JButton efetivarAcaoButton = new JButton("Efetivar Ação");
        panel.add(efetivarAcaoButton);
        efetivarAcaoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                
                int peaoEscolhido = (int) peaoComboBox.getSelectedItem();
                Peao peaoAtual = jogadorAtual.getListaPeoes().get(peaoEscolhido);
                int posicaoAnterior = peaoAtual.getPosicaoAtual();

                System.out.println("Peão escolhido: " + peaoEscolhido); // Depuração
                System.out.println("Chamando jogadorAtual.jogar"); // Depuração
                System.out.println("Tipo de jogadorAtual: " + jogadorAtual.getClass().getName()); // Depuração
                jogadorAtual.jogar(resultadoDado, peaoEscolhido);
                switch (jogadorAtual.getClass().getName()) {
                    case "JogadorAmarelo":
                        if(peaoAtual.getPosicaoAtual() == 127 && posicaoAnterior != 127){
                            jogadorAtual.setPeoesChegada(jogadorAtual.getPecasChegada() + 1);
                        }
                        break;
                    case "JogadorAzul":
                        if(peaoAtual.getPosicaoAtual() == 113 && posicaoAnterior != 113){
                            jogadorAtual.setPeoesChegada(jogadorAtual.getPecasChegada() + 1);
                        }
                        break;
                    case "JogadorVerde":
                        if(peaoAtual.getPosicaoAtual() == 97 && posicaoAnterior != 97){
                            jogadorAtual.setPeoesChegada(jogadorAtual.getPecasChegada() + 1);
                        }
                        break;
                    case "JogadorVermelho":
                        if(peaoAtual.getPosicaoAtual() == 111 && posicaoAnterior != 111){
                            jogadorAtual.setPeoesChegada(jogadorAtual.getPecasChegada() + 1);
                        }
                        break;
                    default:
                        break;
                }
                resultadoDado = 0;
                atualizarTabuleiro(tabuleiro, jogadorAmarelo, jogadorAzul, jogadorVerde, jogadorVermelho);
                if(jogadorAtual.getPecasChegada() == 4){
                    JOptionPane.showMessageDialog(null, "O jogador " + jogadorAtual.getNome() + " venceu!");
                }
                
                
            }
            
        });
    }

    private static void inicializarPeoes(Jogador jogador, Tabuleiro tabuleiro) {
        for (int i = 0; i < 4; i++) {
            Peao peao = new Peao();
        
            peao.setCorPeao(jogador.getCor()); // Define a cor do peão
            peao.setIndice(i); // Define o índice do peão
            jogador.adicionarPeao(peao);
            // Defina a posição inicial do peão na base
            peao.setPosicaoInicial(jogador.getCor(), i);
            // Posiciona o peão no tabuleiro
            tabuleiro.posicionarPeao(peao, i);
        }
    }

    private static void atualizarTabuleiro(Tabuleiro tabuleiro, Jogador... jogadores) {
        tabuleiro.limparTabuleiro(); // Limpa o tabuleiro antes de reposicionar os peões
        for (Jogador jogador : jogadores) {
            for (Peao peao : jogador.getListaPeoes()) {
                tabuleiro.posicionarPeao(peao, 1);
            }
        }
        
    }
}