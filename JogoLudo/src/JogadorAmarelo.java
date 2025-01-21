public class JogadorAmarelo extends Jogador {
    private Tabuleiro tabuleiro;
    
    public JogadorAmarelo(Tabuleiro tabuleiro) {
        super("Jogador Amarelo", Cor.AMARELO);
        this.tabuleiro = tabuleiro; }

    @Override
    public void jogar(int dado, int peaoEscolhido) {
        int referenciaSaida = 201;  
        int[] caminho = tabuleiro.getCaminho();
        int[] trilhaFinalAmarelo = {202, 187, 172, 157, 142, 127};
    
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
                if ((peao.getPosicaoAtual() == 217) && !peao.isEstaNaTrilhaFinal()) {
                    peao.setPosicaoAtual(202); 
                    peao.setEstaNaTrilhaFinal(true);
                    System.out.println("Peão entrou na trilha final na posição: 0");
                } else if (peao.isEstaNaTrilhaFinal()) {
                    System.out.println("Peão esta na trilha final");
                    for (int j = 0; j < trilhaFinalAmarelo.length; j++) {
                        if (trilhaFinalAmarelo[j] == peao.getPosicaoAtual()) {
                            peao.setPosicaoAtual(trilhaFinalAmarelo[(j + 1)]);
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
            for(int i = 0; i < tabuleiro.getTrilhaFinalAmarelo().size(); i++){
                if(tabuleiro.getTrilhaFinalAmarelo().get(i).getPosicao() == peao.getPosicaoAtual()){
                    if(tabuleiro.getTrilhaFinalAmarelo().get(i).podeAndar(dado, trilhaFinalAmarelo)){
                        peao.setPosicaoAtual(tabuleiro.getTrilhaFinalAmarelo().get(i + dado).getPosicao());
                        break;
                    }
                    else{
                        //Realizar o tratamento de exceção
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
        for (Casa casa : tabuleiro.getTrilhaFinalAmarelo()){
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

