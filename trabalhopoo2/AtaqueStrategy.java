package trabalhopoo2;

public interface AtaqueStrategy {
    void registrarObservador(Observador observador);
    void removerObservador(Observador observador);
    void executarAtaque(Tabuleiro tabuleiro);
}
