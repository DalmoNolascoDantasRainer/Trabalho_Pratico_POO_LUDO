import java.util.Random;

public class Dado {

    private Random random;

    public Dado() {
        random = new Random();
    }

    // Método para rolar o dado
    public int rolarDado() {
        int resultado = random.nextInt(6) + 1; // Gera um número entre 1 e 6
        System.out.println("Dado rolado: " + resultado);
        return resultado;
    }
}