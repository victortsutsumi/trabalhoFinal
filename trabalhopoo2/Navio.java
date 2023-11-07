package trabalhopoo2;

public interface Navio {

    void setAtaqueStrategy(AtaqueStrategy ataqueStrategy);
    void executarAtaque(Tabuleiro tabuleiro);
    void posicionaNavio(Tabuleiro tabuleiro);

}
