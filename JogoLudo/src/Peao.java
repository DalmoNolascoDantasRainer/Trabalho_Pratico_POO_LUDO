

/*
valor da posição quando esta na base = -1
*/

public class Peao {
    private int posicaoAtual;
    private boolean estaNaBase;
    private boolean estaNaTrilhaFinal;
    private Cor corPeao;
    
    public Peao() {
        this.posicaoAtual = -1;
        this.estaNaBase = true;
        this.estaNaTrilhaFinal = false;

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
        this.posicaoAtual = 0;
        this.estaNaBase = true;
        this.estaNaTrilhaFinal = false;
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
