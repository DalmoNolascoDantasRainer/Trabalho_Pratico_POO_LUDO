

import java.util.ArrayList;


public class Casa {

    int posicao;
    ArrayList<Peao> listaPeoes;

    public Casa(int posicao, ArrayList<Peao> listaPeoes) {
        this.posicao = posicao;
        this.listaPeoes = listaPeoes;
    } 

    public Casa(int posicao) {
        this.posicao = posicao;
        this.listaPeoes = new ArrayList<>();
    }

    public int getPosicao() {
        return posicao;
    }

    public ArrayList<Peao> getListaPeoes() {
        return listaPeoes;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void setListaPeoes(ArrayList<Peao> listaPeoes) {
        this.listaPeoes = listaPeoes;
    }

    
    boolean estaOcupada(){
        if(listaPeoes.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    void adicionarPeca(Peao peao){   //Passar posicao ou nao?
        listaPeoes.add(peao);    
    }

    void removerPeca(Peao peao){
        listaPeoes.remove(peao);
        
    }
}



