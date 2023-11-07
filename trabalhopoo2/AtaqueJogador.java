package trabalhopoo2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtaqueJogador implements AtaqueStrategy{
    private List<Observador> observadores = new ArrayList<>();

    @Override
    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public boolean executarAtaque(Tabuleiro tabuleiro) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a posição da linha de ataque (1-5): ");
        int linha = scanner.nextInt() - 1;
        System.out.println("Digite a posição da coluna de ataque (1-5): ");
        int coluna = scanner.nextInt() - 1;

        while(!tabuleiro.posicaoValida(tabuleiro, linha, coluna)){
            System.out.println("Digite a posição da linha de ataque (1-5): ");
            linha = scanner.nextInt() - 1;
            System.out.println("Digite a posição da coluna de ataque (1-5): ");
            coluna = scanner.nextInt() - 1;
        }

        boolean acertou;

        acertou = tabuleiro.verificarChute(tabuleiro, linha, coluna);
        System.out.println("VerificarChute: " + acertou);
        notificarObservadores(acertou);
        tabuleiro.atualizarTabuleiro(linha, coluna, acertou, tabuleiro);

        return acertou;
    }

    private void notificarObservadores(boolean acertou
    ) {
        for (Observador observador : observadores) {
            observador.notificarAcerto(acertou);
        }
    }

}
