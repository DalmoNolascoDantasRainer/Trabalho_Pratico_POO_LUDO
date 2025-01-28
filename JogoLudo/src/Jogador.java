import java.util.ArrayList;

public abstract class Jogador {
    private String nome;
    private Cor cor;
    private int peoesChegada;
    private ArrayList<Peao> listaPeoes;

    public Jogador(String nome, Cor cor) {
        this.nome = nome;
        this.cor = cor;
        this.listaPeoes = new ArrayList<>();
        this.peoesChegada = 0;
    }

    // getters
    public String getNome() {
        return nome;
    }

    public Cor getCor() {
        return cor;
    }

    public ArrayList<Peao> getListaPeoes() {
        return listaPeoes;
    }

    public int getPecasChegada() {
        return peoesChegada;
    }

    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public void setPeoesChegada(int peoesChegada) {
        this.peoesChegada = peoesChegada;
    }

    // Método para adicionar um peão ao jogador
    public void adicionarPeao(Peao peao) {
        listaPeoes.add(peao);
    }
    
    public abstract void jogar(int dado, int peaoEscolhido);
}