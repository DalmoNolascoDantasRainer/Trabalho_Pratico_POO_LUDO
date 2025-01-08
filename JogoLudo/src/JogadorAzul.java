public class JogadorAzul  extends Jogador {
    public JogadorAzul(String nome) {
        super(nome, Cor.AZUL);
    }

    @Override
    public void jogar(int dado, int peaoEscolhido) {
        int podeRetirar = 0;
        int referenciaSaida = 2;    
        if (dado == 6) {
            podeRetirar = 1;
        }

        if (getListaPeoes().get(peaoEscolhido).isEstaNaBase() && podeRetirar == 1) {
            getListaPeoes().get(peaoEscolhido).setPosicaoAtual(referenciaSaida);
            getListaPeoes().get(peaoEscolhido).setEstaNaBase(false);
        } else {
            for (int i = 0; i < dado; i++){ 
                if (((getListaPeoes().get(peaoEscolhido).getPosicaoAtual()) == referenciaSaida-2) && getListaPeoes().get(peaoEscolhido).isEstaNaTrilhaFinal() == false){
                    getListaPeoes().get(peaoEscolhido).setPosicaoAtual(0); 
                    getListaPeoes().get(peaoEscolhido).setEstaNaTrilhaFinal(true);                  
                }
                else if(getListaPeoes().get(peaoEscolhido).isEstaNaTrilhaFinal() == true){
                        getListaPeoes().get(peaoEscolhido).setPosicaoAtual((getListaPeoes().get(peaoEscolhido).getPosicaoAtual() + 1) % 6);
                    }
                else{
                    getListaPeoes().get(peaoEscolhido).setPosicaoAtual((getListaPeoes().get(peaoEscolhido).getPosicaoAtual() + 1) % 52);
                }
                
            }

        }

    }
    
    
}
