

/*
valor da posição quando esta na base = -1
*/

import java.util.ArrayList;
import java.util.List;

public class Peao {
    private int posicaoAtual;
    private boolean estaNaBase;
    private boolean estaNaTrilhaFinal;
    private Cor corPeao;
    private int[] posicaoInicial;

    
    public Peao() {
        this.posicaoAtual = -1;
        this.estaNaBase = true;
        this.estaNaTrilhaFinal = false;
        this.posicaoInicial = new int[2];

    }

    public Peao(int posicaoAtual, boolean estaNaBase, boolean estaNaTrilhaFinal, Cor corPeao) {
        this.posicaoAtual = posicaoAtual;
        this.estaNaBase = estaNaBase;
        this.estaNaTrilhaFinal = estaNaTrilhaFinal;
        this.corPeao = corPeao;
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

    public Cor getCorPeao() {
        return corPeao;
    }

    public void setCorPeao(Cor corPeao) {
        this.corPeao = corPeao;
    }

    //funçoes da classe
    public void moverPeao(int posicao) {//recebe a posicao que o peao deve ir
        this.posicaoAtual = posicao;
    }

    public void retornarBase() {
        this.posicaoAtual = -1;
        this.estaNaBase = true;
        this.estaNaTrilhaFinal = false;
    }

    public int[] getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(Cor cor, int indice) {
        // Defina a posição inicial com base na cor do jogador e no índice do peão
        switch (cor) {
            case AMARELO:
                if (indice == 0) this.posicaoInicial = new int[]{13, 0};
                else if (indice == 1) this.posicaoInicial = new int[]{13, 1};
                else if (indice == 2) this.posicaoInicial = new int[]{14, 0};
                else if (indice == 3) this.posicaoInicial = new int[]{14, 1};
                break;
            case AZUL:
                if (indice == 0) this.posicaoInicial = new int[]{13, 13};
                else if (indice == 1) this.posicaoInicial = new int[]{13, 14};
                else if (indice == 2) this.posicaoInicial = new int[]{14, 13};
                else if (indice == 3) this.posicaoInicial = new int[]{14, 14};
                break;
            case VERDE:
                if (indice == 0) this.posicaoInicial = new int[]{0, 13};
                else if (indice == 1) this.posicaoInicial = new int[]{0, 14};
                else if (indice == 2) this.posicaoInicial = new int[]{1, 13};
                else if (indice == 3) this.posicaoInicial = new int[]{1, 14};
                break;
            case VERMELHO:
                // Defina as posições iniciais para os peões verdes
                if (indice == 0) this.posicaoInicial = new int[]{0, 0};
                else if (indice == 1) this.posicaoInicial = new int[]{0, 1};
                else if (indice == 2) this.posicaoInicial = new int[]{1, 0};
                else if (indice == 3) this.posicaoInicial = new int[]{1, 1};
                break;
        }
    }


class MainPeao {
    public static void main(String[] args) {
        // Instanciando um Peao com o construtor padrão
        Peao peao1 = new Peao();
        System.out.println("Peão criado com o construtor padrão:");
        System.out.println("Posição atual: " + peao1.getPosicaoAtual());
        System.out.println("Está na base: " + peao1.isEstaNaBase());
        System.out.println("Está na trilha final: " + peao1.isEstaNaTrilhaFinal());
        System.out.println();

        // Modificando o peão
        
        peao1.setCorPeao(Cor.VERMELHO);
        peao1.moverPeao(10); // Move o peão para a posição 10
        peao1.setEstaNaBase(false);
        System.out.println("Peão após mover para a posição 10:");
        System.out.println("Posição atual: " + peao1.getPosicaoAtual());
        System.out.println("Está na base: " + peao1.isEstaNaBase());
        System.out.println("Cor do peão: " + peao1.getCorPeao());
        System.out.println();

        // Retornando o peão à base
        peao1.retornarBase();
        System.out.println("Peão após retornar à base:");
        System.out.println("Posição atual: " + peao1.getPosicaoAtual());
        System.out.println("Está na base: " + peao1.isEstaNaBase());
        System.out.println("Está na trilha final: " + peao1.isEstaNaTrilhaFinal());
        System.out.println();

        // Instanciando outro Peão com o construtor parametrizado
        Peao peao2 = new Peao(-1, true, false, Cor.AZUL);
        System.out.println("Peão criado com o construtor parametrizado:");
        System.out.println("Posição atual: " + peao2.getPosicaoAtual());
        System.out.println("Está na base: " + peao2.isEstaNaBase());
        System.out.println("Cor do peão: " + peao2.getCorPeao());
    }
}
}
