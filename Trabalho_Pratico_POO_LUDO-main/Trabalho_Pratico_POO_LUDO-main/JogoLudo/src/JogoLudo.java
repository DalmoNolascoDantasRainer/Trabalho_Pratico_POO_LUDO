import java.util.ArrayList;

public class JogoLudo {
    private Tabuleiro tabuleiro;
    private ArrayList<Jogador> jogadores;
    private Dado dados;
    private int rodadaAtual;

    public JogoLudo() {
        this.tabuleiro = new Tabuleiro();
        this.jogadores = new ArrayList<>();
        this.dados = new Dado();
        this.rodadaAtual = 0;
    }

    public void iniciarRodada() {
        Cor[] cores = Cor.values();
        for (int i = 0; i < 4; i++) {
            jogadores.add(new Jogador("Jogador " + (i + 1), cores[i]));
        }
    }

    public String verificaVencedor() {
        for (Jogador jogador : jogadores) {
            if (jogador.getPecasChegada() == 4) {
                return jogador.getNome();
            }
        }
        return null;
    }
 }
