import java.util.ArrayList;

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

    // Método para adicionar um peão ao jogador
    public void adicionarPeao(Peao peao) { //****************************************************************************** */
        listaPeoes.add(peao);
    }
    
    public void jogar(){
        // Implementado nas subclasses
    }

    // IMPLEMENTAR FUNÇÃO JOGAR

    /*
     * a lista de peoes não é alterada, apenas os valores
     * Função que realiza a jogada do jogador
     * recebe o dado ja rolado
     * verifica se o jogador pode retirar um peão da base
     * pergunta ao jogador qual peão ele deseja mover
     * valor padrão de erro do peãoescolhido é -1
     */
    public void jogar(int dado, int peaoEscolhido) {
        int podeRetirar = 0;
        int referenciaSaida = 2;    
        if (dado == 6) {
            podeRetirar = 1;
        }

        if (listaPeoes.get(peaoEscolhido).isEstaNaBase() && podeRetirar == 1) {
            listaPeoes.get(peaoEscolhido).setPosicaoAtual(0);
            listaPeoes.get(peaoEscolhido).setEstaNaBase(false);
        } else {
            for (int i = 0; i < dado; i++){ // anda o dado de casas
                if (((listaPeoes.get(peaoEscolhido).getPosicaoAtual()) == referenciaSaida-2) && listaPeoes.get(peaoEscolhido).isEstaNaTrilhaFinal() == false){
                    listaPeoes.get(peaoEscolhido).setPosicaoAtual(0); 
                    listaPeoes.get(peaoEscolhido).setEstaNaTrilhaFinal(true);                  
                }
                else if(listaPeoes.get(peaoEscolhido).isEstaNaTrilhaFinal() == true){
                        listaPeoes.get(peaoEscolhido).setPosicaoAtual((listaPeoes.get(peaoEscolhido).getPosicaoAtual() + 1) % 6);
                    }
                else{
                    listaPeoes.get(peaoEscolhido).setPosicaoAtual((listaPeoes.get(peaoEscolhido).getPosicaoAtual() + 1) % 52);
                }
                
            }

        }

    }

}



