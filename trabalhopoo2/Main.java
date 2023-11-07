package trabalhopoo2;
import java.util.Scanner;

public class Main {
	
	public static void main (String [] args) {

		Tabuleiro tabuleiroSingleton = Tabuleiro.getInstance();
		tabuleiroSingleton.imprimirTabuleiro();

		Navio submarino = Submarino.constroiNavio("submarino");

		Navio submarino1 = Submarino.constroiNavio("submarino");
		submarino1.posicionaNavio(tabuleiroSingleton);

		Navio submarino2 = Submarino.constroiNavio("submarino");
		submarino2.posicionaNavio(tabuleiroSingleton);

		Navio submarino3 = Submarino.constroiNavio("submarino");
		submarino3.posicionaNavio(tabuleiroSingleton);

		tabuleiroSingleton.imprimirTabuleiro();


		Scanner scanner = new Scanner(System.in);

		System.out.println("Bem vindo a Batalha Naval!");
		System.out.println("Você tem 5 chances de afundar os 3 submarinos espalhados no oceano!");
		int chances = 5;
		int submarinos = 3;
		boolean verdade;

		while(chances > 0){

			if(tabuleiroSingleton.notificaVitoria() == 1){
				System.out.println("Parabéns, você afundou todos os submarinos!");
				break;
			}


			System.out.println("Escolha sua estratégia:");
			System.out.println("1 - Digitar posição");
			System.out.println("2 - Máquina calcula posição aleatória de ataque");
			System.out.println("3 - Máquina calcula e planeja o ataque");
			System.out.println("0 - Encerrar o jogo previamente");
			int opcao = scanner.nextInt();

			switch(opcao){
				case 1:
					AtaqueStrategy ataqueJogador = new AtaqueJogador();
					ataqueJogador.registrarObservador(tabuleiroSingleton);
					submarino.setAtaqueStrategy(ataqueJogador);
					submarino.executarAtaque(tabuleiroSingleton);
					break;
				case 2:
					AtaqueStrategy ataqueAleatorio = new AtaqueAleatorio();
					ataqueAleatorio.registrarObservador(tabuleiroSingleton);
					submarino.setAtaqueStrategy(ataqueAleatorio);
					submarino.executarAtaque(tabuleiroSingleton);
					break;
				case 3:
					AtaqueStrategy ataquePlanejado = new AtaquePlanejado();
					ataquePlanejado.registrarObservador(tabuleiroSingleton);
					submarino.setAtaqueStrategy(ataquePlanejado);
					submarino.executarAtaque(tabuleiroSingleton);
					break;
				case 0:
					chances = 1;
					break;
			}

			chances--;
			System.out.println("Total de torpedos: " + chances);
			tabuleiroSingleton.imprimirTabuleiro();
		}














	}
}
