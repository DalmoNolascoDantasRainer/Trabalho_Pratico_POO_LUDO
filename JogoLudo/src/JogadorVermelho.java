public class JogadorVermelho extends Jogador {
    private Tabuleiro tabuleiro;
    
    public JogadorVermelho(Tabuleiro tabuleiro) {
        super("Jogador Vermelho", Cor.VERMELHO);
        this.tabuleiro = tabuleiro;
    }

    @Override
    public void jogar(int dado, int peaoEscolhido) {
        int referenciaSaida = 91;  
        int[] caminho = tabuleiro.getCaminho();
        int[] trilhaFinalVermelho = {106, 107, 108, 109, 110, 111};
    
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
                if ((peao.getPosicaoAtual() == 105) && !peao.isEstaNaTrilhaFinal()) {
                    peao.setPosicaoAtual(106); 
                    peao.setEstaNaTrilhaFinal(true);
                    System.out.println("Peão entrou na trilha final na posição: 0");
                } else if (peao.isEstaNaTrilhaFinal()) {
                    System.out.println("Peão esta na trilha final");
                    for (int j = 0; j < trilhaFinalVermelho.length; j++) {
                        if (trilhaFinalVermelho[j] == peao.getPosicaoAtual()) {
                            peao.setPosicaoAtual(trilhaFinalVermelho[(j + 1)]);
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
            for(int i = 0; i < tabuleiro.getTrilhaFinalVermelho().size(); i++){
                if(tabuleiro.getTrilhaFinalVermelho().get(i).getPosicao() == peao.getPosicaoAtual()){
                    if(tabuleiro.getTrilhaFinalVermelho().get(i).podeAndar(dado, trilhaFinalVermelho)){
                        peao.setPosicaoAtual(tabuleiro.getTrilhaFinalVermelho().get(i + dado).getPosicao());
                        break;
                    }
                }
            }
        }

        for (Casa casa : tabuleiro.getListaCasas()) {
            if (casa.getPosicao() == peao.getPosicaoAtual()){
                casa.adicionarPeca(peao);
                
            }
            else if (casa.getPosicao() == posicaoAnterior){
                casa.removerPeca(peao);
            }
        }
        for (Casa casa : tabuleiro.getTrilhaFinalVermelho()){
            if (casa.getPosicao() == peao.getPosicaoAtual()){
                
                casa.adicionarPeca(peao);
            }
            else if (casa.getPosicao() == posicaoAnterior){
                casa.removerPeca(peao);
            }
        }
        
    
        tabuleiro.atualizarPosicaoPeao(peao, posicaoAnterior);
        System.out.println("Posição final do peão: " + peao.getPosicaoAtual());
        tabuleiro.exibirEstadoCasas();
    }
}