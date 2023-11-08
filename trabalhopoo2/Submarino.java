
package trabalhopoo2;
import java.util.Random;

public class Submarino implements Navio{
    static int i = 0;
    private AtaqueStrategy ataqueStrategy;

    public static Navio constroiNavio(String modelo){
        if(modelo.equals("submarino")){
            System.out.println("Submarino criado");
            return new Submarino();
        }
        return null;
    }

    public void posicionaNavio(Tabuleiro tabuleiro){
        if(i > 4)
            i = 0;
        Random random = new Random();
        int tamanhoTabuleiro = 5;
        int linha = random.nextInt(tamanhoTabuleiro);
        int coluna = i; // Inicializa a posição da coluna

        tabuleiro.getTabuleiro()[linha][coluna] = 3;
        i += 2;
    }

    public void setAtaqueStrategy(AtaqueStrategy ataqueStrategy) {
        this.ataqueStrategy = ataqueStrategy;
    }

    public void executarAtaque(Tabuleiro tabuleiro) {
        if (ataqueStrategy != null) {
            ataqueStrategy.executarAtaque(tabuleiro);
        } else {
            System.out.println("Nenhuma estratégia de ataque definida.");
        }
    }

}
