
public enum Cor {
    VERMELHO("Vermelho"), 
    AMARELO("Amarelo"), 
    VERDE("Verde"), 
    AZUL("Azul");

    private String cor;

    Cor(String cor){
        this.cor = cor;
    }

    public String getCor(){
        return this.cor;
    }

}