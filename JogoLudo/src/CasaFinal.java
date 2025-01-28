

import java.util.ArrayList;
public class CasaFinal extends Casa {

    boolean chegouFinal = false;
    int posicaoFinal;

    public CasaFinal(int posicao, ArrayList<Peao> listaPeoes) {
        super(posicao, listaPeoes);

    }

    public CasaFinal(int posicao) {
        super(posicao, new ArrayList<Peao>());
        
    }
    public CasaFinal(int posicao, boolean chegouFinal) {
        super(posicao, new ArrayList<Peao>());
        this.chegouFinal = chegouFinal;
    }

    public boolean isChegouFinal() {
        return chegouFinal;
    }

    boolean podeAndar(int numeroDado, int[] posicoesTrilhaFinal){
        for(int i = 0; i < posicoesTrilhaFinal.length; i++){
            if(posicoesTrilhaFinal[i] == this.posicao){
                if(i + numeroDado < posicoesTrilhaFinal.length){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    
}
