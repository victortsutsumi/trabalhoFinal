package trabalhopoo2;

public interface Navio {

    void setAtaqueStrategy(AtaqueStrategy ataqueStrategy);
    boolean executarAtaque(Tabuleiro tabuleiro);
    void posicionaNavio(Tabuleiro tabuleiro);

}
