package trabalhopoo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AtaquePlanejado implements AtaqueStrategy{

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
        System.out.println("Executando ataque planejado: torpedo disparado!");

        Random random = new Random();
        int tamanhoTabuleiroX = 5;
        int tamanhoTabuleiroY = 3;
        int linha = random.nextInt(tamanhoTabuleiroX);
        int aleatorioColuna = random.nextInt(tamanhoTabuleiroY);
        int coluna = aleatorioColuna * 2;
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
