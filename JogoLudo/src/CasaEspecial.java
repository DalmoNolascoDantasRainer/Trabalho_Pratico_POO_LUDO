

import java.util.ArrayList;
public class CasaEspecial extends Casa {

    int tipoCasa;

    public CasaEspecial(int posicao, ArrayList<Peao> listaPeoes, int tipoCasa) {
        super(posicao, listaPeoes);
        this.tipoCasa = tipoCasa;
    }


    public int getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(int tipoCasa) {
        this.tipoCasa = tipoCasa;
    }

    boolean podeComer(int tipoCasa){
        //Posicao da estrelinha, não pode comer
        if(tipoCasa == 1){
            return false;
        }
        //Posicao da casa de saída, pode comer
        else if (tipoCasa == 2){
            return true;
        } else {
            return false;
        }
    }        

    }





