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

			if(submarinos == 0){
				System.out.println("Parabéns, você afundou todos os submarinos!");
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
					verdade = submarino.executarAtaque(tabuleiroSingleton);
					System.out.println("verdade: " + verdade);
					if(!verdade)
						submarinos--;
					break;
				case 2:
					AtaqueStrategy ataqueAleatorio = new AtaqueAleatorio();
					ataqueAleatorio.registrarObservador(tabuleiroSingleton);
					submarino.setAtaqueStrategy(ataqueAleatorio);
					submarino.executarAtaque(tabuleiroSingleton);
					verdade = submarino.executarAtaque(tabuleiroSingleton);

					if(!verdade)
						submarinos--;
					break;
				case 3:
					AtaqueStrategy ataquePlanejado = new AtaquePlanejado();
					ataquePlanejado.registrarObservador(tabuleiroSingleton);
					submarino.setAtaqueStrategy(ataquePlanejado);
					submarino.executarAtaque(tabuleiroSingleton);
					verdade = submarino.executarAtaque(tabuleiroSingleton);
					if(!verdade) {
						submarinos--;
					}
					break;
				case 0:
					chances = 0;
					break;
			}
			chances--;
			System.out.println("Total de torpedos: " + chances);
			System.out.println("Total de submarinos: " + submarinos);
			tabuleiroSingleton.imprimirTabuleiro();
		}












//		encouracado.executarAtaque(); // Executa a estratégia de ataque aleatório
//
//		AtaqueStrategy ataquePlanejado = new AtaquePlanejado();
//		encouracado.setAtaqueStrategy(ataquePlanejado);
//
//		encouracado.executarAtaque();





//		FactoryNavio factoryNavio = new MinhaFactoryNavio();// Substitua 'SuaFactoryNavio' pelo nome da sua implementação concreta.
//
//		ProxyEncouracado proxyEncouracado = new ProxyEncouracado(factoryNavio);
//
//		// Agora você pode usar o proxyEncouracado para atirar, mover, configurar estratégias de ataque, etc.
//		proxyEncouracado.atirar();
//		proxyEncouracado.mover();
//
//		AtaqueStrategy ataqueAleatorio1 = new AtaqueAleatorio();
//		proxyEncouracado.setAtaqueStrategy(ataqueAleatorio);
//
//		proxyEncouracado.executarAtaque();
//
//
//
//		Encouracado encouracado2 = new Encouracado(); // Certifique-se de criar sua instância de Encouracado conforme necessário.
//		Observador relatorioDanos = new RelatorioDanos();
//
//		// Registre o Observador no Sujeito Observado (Encouracado).
//		encouracado.registrarObservador(relatorioDanos);
//
//		// Simule um evento (navio atingido).
//		encouracado.notificarNavioAtingido();



	}
}
