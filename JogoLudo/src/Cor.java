import java.awt.Color;

public enum Cor {
    AMARELO(Color.YELLOW),
    AZUL(Color.BLUE),
    VERDE(Color.GREEN),
    VERMELHO(Color.RED);

    private final Color cor;

    Cor(Color cor) {
        this.cor = cor;
    }

    public Color getCorOriginal() {
        return this.cor;
    }
}