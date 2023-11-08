package trabalhopoo2;

public class Memento {
    private final int[][] estadoDoTabuleiro;

    public Memento(int[][] estadoDoTabuleiro) {
        this.estadoDoTabuleiro = estadoDoTabuleiro;
    }

    public int[][] getEstadoDoTabuleiro() {
        return estadoDoTabuleiro;
    }
}