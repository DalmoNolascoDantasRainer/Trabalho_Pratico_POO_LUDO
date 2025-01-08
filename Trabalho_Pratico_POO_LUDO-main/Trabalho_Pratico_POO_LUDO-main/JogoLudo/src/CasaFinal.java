

import java.util.ArrayList;
public class CasaFinal extends Casa {

    boolean chegouFinal = false;
    int posicaoFinal;

    public CasaFinal(int posicao, ArrayList<Peao> listaPeoes) {
        super(posicao, listaPeoes);

    }

    public CasaFinal() {
        super(0, new ArrayList<Peao>());
        
    }

    public boolean isChegouFinal() {
        return chegouFinal;
    }
//Provalvemente irá mudar a lógica do método
//Considere que está na trilha final
//Tratar o caso de estar na posição antes da primeira posição da trilha final, de modo que se tirar 6 ganha
//Se tiver em uma posição do tabuleiro e que jogando o dado entre na trilha final, o que fazer?
    int verificaNumeroDado(int numeroDado, int posicaoAtual){
        ; // Talvez seja necessário mudar o valor
        int casasRestantes = 6 - (posicaoAtual + 1) ; //Talvez seja necessário mudar o valor
        if (numeroDado == casasRestantes) {
            chegouFinal = true;
            return 5; // Retorna a posição final
        } else if (numeroDado < casasRestantes) {
            posicaoAtual = posicaoAtual + numeroDado;
            return posicaoAtual;// Retorna a nova posição
        } else {
            return posicaoAtual; // Não se move se o valor do dado for maior que o necessário
        }
        
    }
    
}
