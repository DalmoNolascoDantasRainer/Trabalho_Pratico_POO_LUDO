public class JogadorAzul extends Jogador {
    private Tabuleiro tabuleiro;
    
    public JogadorAzul(Tabuleiro tabuleiro) {
        super("Jogador Azul", Cor.AZUL);
        this.tabuleiro = tabuleiro;}

    @Override
    public void jogar(int dado, int peaoEscolhido) {
        int referenciaSaida = 133;  
        int[] caminho = tabuleiro.getCaminho();
        int[] trilhaFinalAzul = {118, 117, 116, 115, 114, 113};
    
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
                if ((peao.getPosicaoAtual() == 119) && !peao.isEstaNaTrilhaFinal()) {
                    peao.setPosicaoAtual(118); 
                    peao.setEstaNaTrilhaFinal(true);
                    System.out.println("Peão entrou na trilha final na posição: 0");
                } else if (peao.isEstaNaTrilhaFinal()) {
                    System.out.println("Peão esta na trilha final");
                    for (int j = 0; j < trilhaFinalAzul.length; j++) {
                        if (trilhaFinalAzul[j] == peao.getPosicaoAtual()) {
                            peao.setPosicaoAtual(trilhaFinalAzul[(j + 1)]);
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
            for(int i = 0; i < tabuleiro.getTrilhaFinalAzul().size(); i++){
                if(tabuleiro.getTrilhaFinalAzul().get(i).getPosicao() == peao.getPosicaoAtual()){
                    if(tabuleiro.getTrilhaFinalAzul().get(i).podeAndar(dado, trilhaFinalAzul)){
                        peao.setPosicaoAtual(tabuleiro.getTrilhaFinalAzul().get(i + dado).getPosicao());
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
        for (Casa casa : tabuleiro.getTrilhaFinalAzul()){
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