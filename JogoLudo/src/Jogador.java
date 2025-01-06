import java.util.ArrayList;
import java.util.Scanner;
import Peao.Peao;

public class Jogador {
    private String nome;
    private Cor cor;
    private int peoesChegada;
    private ArrayList<Peao> listaPeoes;

    public Jogador(String nome, Cor cor) {
        this.nome = nome;
        this.cor = cor;
        this.listaPeoes = new ArrayList<>();
        this.peoesChegada = 0;
    }

    // getters
    public String getNome() {
        return nome;
    }

    public Cor getCor() {
        return cor;
    }

    public ArrayList<Peao> getListaPeoes() {
        return listaPeoes;
    }

    public int getPecasChegada() {
        return peoesChegada;
    }

    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public void setPeoesChegada(int peoesChegada) {
        this.peoesChegada = peoesChegada;
    }

    // IMPLEMENTAR FUNÇÃO JOGAR

    /**
     * a lista de peoes não é alterada, apenas os valores
     * Função que realiza a jogada do jogador
     * recebe o dado ja rolado
     * verifica se o jogador pode retirar um peão da base
     * pergunta ao jogador qual peão ele deseja mover
     */
    public void jogar(int dado) {
        Scanner scanner = new Scanner(System.in);
        int podeRetirar = 0;
        int peaoEscolhido = -1;
        int referenciaSaida = 2;    
        if (dado == 6) {
            podeRetirar = 1;
        }
        System.out.print("Digite o peao(0 a 3): ");
        peaoEscolhido = scanner.nextInt();

        if (listaPeoes.get(peaoEscolhido).isEstaNaBase() && podeRetirar == 1) {
            listaPeoes.get(peaoEscolhido).setPosicaoAtual(0);
        } else {
            for (int i = 0; i < dado; i++){
                if ((listaPeoes.get(peaoEscolhido).getPosicaoAtual()) == referenciaSaida-2){
                    
                }
                else{
                    listaPeoes.get(peaoEscolhido).setPosicaoAtual((listaPeoes.get(peaoEscolhido).getPosicaoAtual() + 1) % 52);

                }
                
        }

        }

    }





}



