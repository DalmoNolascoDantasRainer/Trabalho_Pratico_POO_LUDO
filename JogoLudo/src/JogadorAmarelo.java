public class JogadorAmarelo extends Jogador {
    private Tabuleiro tabuleiro;
    
    public JogadorAmarelo(Tabuleiro tabuleiro) {
        super("Jogador Amarelo", Cor.AMARELO);
        this.tabuleiro = tabuleiro; }

    @Override
    public void jogar(int dado, int peaoEscolhido) {
        int podeRetirar = 0;
        int referenciaSaida = 201;  
        
        podeRetirar = 1;
    
        Peao peao = getListaPeoes().get(peaoEscolhido);
    
        System.out.println("Peão escolhido: " + peaoEscolhido);
        System.out.println("Posição inicial do peão: " + peao.getPosicaoAtual());
        System.out.println("Dado: " + dado);
        int posicaoAnterior = peao.getPosicaoAtual();
    
        if (peao.isEstaNaBase() && podeRetirar == 1) {
            peao.setPosicaoAtual(referenciaSaida);
            peao.setEstaNaBase(false);
            System.out.println("Peão saiu da base para a posição: " + referenciaSaida);
        } else {
            for (int i = 0; i < dado; i++) { 
                if ((peao.getPosicaoAtual() == 202) && !peao.isEstaNaTrilhaFinal()) {
                    peao.setPosicaoAtual(87); 
                    peao.setEstaNaTrilhaFinal(true);
                    System.out.println("Peão entrou na trilha final na posição: 0");
                } else if (peao.isEstaNaTrilhaFinal()) {
                    peao.setPosicaoAtual((peao.getPosicaoAtual() + 1) % 6);
                    System.out.println("Peão avançou na trilha final para a posição: " + peao.getPosicaoAtual());
                } else {

                    int[] caminho = tabuleiro.getCaminho();
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
    
        if(posicaoAnterior != -1){
            tabuleiro.atualizarPosicaoPeao(peao, posicaoAnterior);
        }
        System.out.println("Posição final do peão: " + peao.getPosicaoAtual());
        tabuleiro.exibirEstadoCasas();
    }
}

