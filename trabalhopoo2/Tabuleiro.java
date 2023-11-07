package trabalhopoo2;

public class Tabuleiro implements Observador{
	public static int subs = 3;
	private static Tabuleiro instance;
    private int[][] tabuleiro = new int[5][5];

    public Tabuleiro() {
		for(int i=0; i < tabuleiro.length; i++) {
			for(int j=0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = 0;
			}
		}
        System.out.println("Tabuleiro criado");
    }

	public static Tabuleiro getInstance() {
		if (instance == null) {
			instance = new Tabuleiro();
		}
		return instance;
	}

	public int[][] getTabuleiro(){
		return tabuleiro;
	}

	 public void imprimirTabuleiro(){
		System.out.println("A B C D E");
		 for(int i=0; i < tabuleiro.length; i++) {
			 for(int j=0; j < tabuleiro.length; j++) {
				 switch (tabuleiro[i][j]){
					 case 0:
						 System.out.print("- "); //Oceano
						 break;
					 case 1:
						 System.out.print("X "); //Acertou
						 break;
					 case 2:
						 System.out.print("* "); //Errou
						 break;
					 case 3:
						 System.out.print("N "); //Navio
						 break;
				 }
			 }
			 System.out.println();
		 }
	}

	public boolean posicaoValida(Tabuleiro tabuleiro, int linha, int coluna){
		if(linha > 4 || coluna > 4 || linha < 0 || coluna < 0){
			System.out.println("Posição inválida. Insira uma nova posição!");
			return false;
		}
		return true;
	}

	public boolean verificarChute(Tabuleiro tabuleiro, int linha, int coluna){
		if(tabuleiro.getTabuleiro()[linha][coluna] == 3){
			tabuleiro.atualizaVitoria(tabuleiro);
			return true;
		}
		tabuleiro.exibirTotalSubs();
		return false;
	}

	public void exibirTotalSubs(){
		System.out.println("Submarinos restantes: " + subs);
	}

	public void atualizaVitoria(Tabuleiro tabuleiro){
		subs--;
		tabuleiro.exibirTotalSubs();
		tabuleiro.notificaVitoria();
	}

	public int notificaVitoria(){
		if(subs == 0){
			return 1;
		}
		return 0;
	}

	public void notificarAcerto(boolean acertou) {
		if(acertou){
			System.out.println("Você atingiu um submarino!");
		}
		else {
			System.out.println("Você errou o disparo! Menos 1 torpedo!");
		}
	}


	public void atualizarTabuleiro(int linha, int coluna, boolean acertou, Tabuleiro tabuleiro) {
		if (acertou)
			tabuleiro.getTabuleiro()[linha][coluna] = 1;
		else
			tabuleiro.getTabuleiro()[linha][coluna] = 2;
	}

}
