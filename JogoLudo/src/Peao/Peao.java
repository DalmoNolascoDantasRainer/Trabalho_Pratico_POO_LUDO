package Peao;
/*
valor da posição quando esta na base = -1
*/

public class Peao {
    private int posicaoAtual;
    private boolean estaNaBase;
    private boolean estaNaTrilhaFinal;
    
    public Peao() {
        this.posicaoAtual = -1;
        this.estaNaBase = true;
        this.estaNaTrilhaFinal = false;

    }

    public Peao(int posicaoAtual, boolean estaNaBase, boolean estaNaTrilhaFinal) {
        this.posicaoAtual = posicaoAtual;
        this.estaNaBase = estaNaBase;
        this.estaNaTrilhaFinal = estaNaTrilhaFinal;
    }
    //getters e setters dos atributos
    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(int posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public boolean isEstaNaBase() {
        return estaNaBase;
    }

    public void setEstaNaBase(boolean estaNaBase) {
        this.estaNaBase = estaNaBase;
    }

    public boolean isEstaNaTrilhaFinal() {
        return estaNaTrilhaFinal;
    }

    public void setEstaNaTrilhaFinal(boolean estaNaTrilhaFinal) {
        this.estaNaTrilhaFinal = estaNaTrilhaFinal;
    }


    //funçoes da classe
    public void moverPeao(int posicao) {//recebe a posicao que o peao deve ir
        this.posicaoAtual = posicao;
    }

    public void retornarBase() {
        this.posicaoAtual = 0;
        this.estaNaBase = true;
        this.estaNaTrilhaFinal = false;
    }

}
