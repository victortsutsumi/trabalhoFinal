package trabalhopoo2;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class AtaqueAleatorio implements AtaqueStrategy{

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
    public void executarAtaque(Tabuleiro tabuleiro) {

        System.out.println("Executando ataque aleatorio: posição  torpedo disparado!");

        Random random = new Random();
        int tamanhoTabuleiroX = 5;
        int tamanhoTabuleiroY = 5;
        int linha = random.nextInt(tamanhoTabuleiroX);
        int coluna = random.nextInt(tamanhoTabuleiroY);
        boolean acertou;

        acertou = tabuleiro.verificarChute(tabuleiro, linha, coluna);
        notificarObservadores(acertou);
        tabuleiro.atualizarTabuleiro(linha, coluna, acertou, tabuleiro);
    }

    private void notificarObservadores(boolean acertou) {
        for (Observador observador : observadores) {
            observador.notificarAcerto(acertou);
        }
    }


}
