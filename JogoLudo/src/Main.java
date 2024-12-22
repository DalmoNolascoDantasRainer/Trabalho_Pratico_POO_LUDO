public class Main {
    public static void main(String[] args) {
        // Instancia um objeto da classe Dado
        Dado dado = new Dado();

        // Rola o dado algumas vezes para teste
        System.out.println("Rolando o dado...");
        for (int i = 1; i <= 8; i++) {
            dado.rolarDado();
        }
    }
}
