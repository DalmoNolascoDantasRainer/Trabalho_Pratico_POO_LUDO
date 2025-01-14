public class JogadorVerde extends Jogador {
    private Tabuleiro tabuleiro;
    
    public JogadorVerde(Tabuleiro tabuleiro) {
        super("Jogador Verde", Cor.VERDE);
        this.tabuleiro = tabuleiro;}

    @Override
    public void jogar(int dado, int peaoEscolhido) {
        int referenciaSaida = 23;  
        int[] caminho = tabuleiro.getCaminho();
        int[] trilhaFinalVerde = {22, 37, 52, 67, 82, 97};
    
        Peao peao = getListaPeoes().get(peaoEscolhido);
    
        System.out.println("Peão escolhido: " + peaoEscolhido);
        System.out.println("Posição inicial do peão: " + peao.getPosicaoAtual());
        System.out.println("Dado: " + dado);
        int posicaoAnterior = peao.getPosicaoAtual();
        
    
        if (peao.isEstaNaBase() && dado == 6) {
            peao.setPosicaoAtual(referenciaSaida);
            peao.setEstaNaBase(false);
            System.out.println("Peão saiu da base para a posição: " + referenciaSaida);
        } 
        else if (!peao.isEstaNaBase() && !peao.isEstaNaTrilhaFinal()) {
            for (int i = 0; i < dado; i++) { 
                if ((peao.getPosicaoAtual() == 7) && !peao.isEstaNaTrilhaFinal()) {
                    peao.setPosicaoAtual(22); 
                    peao.setEstaNaTrilhaFinal(true);
                    System.out.println("Peão entrou na trilha final na posição: 0");
                } else if (peao.isEstaNaTrilhaFinal()) {
                    System.out.println("Peão esta na trilha final");
                    for (int j = 0; j < trilhaFinalVerde.length; j++) {
                        if (trilhaFinalVerde[j] == peao.getPosicaoAtual()) {
                            peao.setPosicaoAtual(trilhaFinalVerde[(j + 1)]);
                            break;
                        }
                    }
                    System.out.println("Peão avançou na trilha final para a posição: " + peao.getPosicaoAtual());
                } else {

                    for (int j = 0; j < caminho.length; j++) {
                        if (caminho[j] == peao.getPosicaoAtual()) {
                            System.out.println("Peão avançou para a posição: " + peao.getPosicaoAtual());
                            int novaPosicao = (j + 1) % caminho.length;
                            peao.setPosicaoAtual(caminho[novaPosicao % caminho.length]);
                            System.out.println("Peão avançou para a posição: " + peao.getPosicaoAtual());
                            break;
                        }
                    }
                }
            }
        }
        else{//Realizar o tratamento de exceção
            for(int i = 0; i < tabuleiro.getTrilhaFinalVerde().size(); i++){
                if(tabuleiro.getTrilhaFinalVerde().get(i).getPosicao() == peao.getPosicaoAtual()){
                    if(tabuleiro.getTrilhaFinalVerde().get(i).podeAndar(dado, trilhaFinalVerde)){
                        peao.setPosicaoAtual(tabuleiro.getTrilhaFinalVerde().get(i + dado).getPosicao());
                        break;
                    }
                    else{
                        //Realizar o tratamento de exceção
                    }
                }
            }
        }
        
    
        tabuleiro.atualizarPosicaoPeao(peao, posicaoAnterior);
        System.out.println("Posição final do peão: " + peao.getPosicaoAtual());
        tabuleiro.exibirEstadoCasas();
    }
}