# Batalha Naval

## Autores
- Victor Amaro Gonçalves Tsutsumi

## Índice

- [Introdução](#introdução)
- [Padrões de projeto](#padrões-de-projeto-utilizados)
    - [Factory](#factory-method)
    - [Singleton](#singleton)
    - [Stategy](#strategy)
    - [Observer](#observer)
    - [Memento](#memento)
    - [Injeção de dependências](#injeção-de-dependências)
- [Princípios de projeto](#princípios-de-projeto)
    - [Princípio de responsabilidade única](#princípio-de-responsabilidade-única)
    - [Segregação de interfaces](#segregação-de-interfaces)
    - [Princípio de Demeter](#princípio-de-demeter)
- [Frameworks](#frameworks)
- [Conclusão](#conclusão)

## Introdução

Sistema básico baseado no jogo de batalha naval, onde o computador posiciona os submarinos no oceano, e cabe ao usuário, tentar adivinhar a posição ou usar a inteligência do computador para tentar abater todos os 3 submarinos.

Este projeto tem como objetivo aprende e implementar padrões e princípios de projeto estudados na disciplina de Programação Orientada a Objetos 2. A escolha do sistema de batalha naval se dá pela familiaridade com jogo e a facilidade de implementação.

## Padrões de projeto utilizados

### Factory Method

O padrão factory foi utilizado para criar instâncias de Submarinos que serão posicionados no oceano e que serão abatido durante o jogo. A ideia é deixar aberto para que se possa fazer factory de outros tipos de navio, num jogo mais complexo.

```java
public Submarino constroiNavio(String modelo) {
    if (modelo.equals("submarino")) {
        return new Submarino();
    }
    return null;
}
```

### Singleton

O padrão singleton foi utilizado para instanciar o Tabuleiro, ja que ele é único e será utilizado essa mesma instância durante toda execução do software.

```java
public static Tabuleiro getInstance() {
    if (instance == null) {
        instance = new Tabuleiro();
    }
    return instance;
}
```

### Strategy

O padrão Strategy foi implementado para escolher qual tipo de ataque o usuário deseja utilizar, sendo as opções:
- `ataqueJogador` onde o usuário insere a posição do palpite
- `ataqueAleatorio` onde uma posição aleatória é selecionada como palpite
- `ataquePlanejado` onde o ataque é feito em uma das colunas onde se encontra algum dos submarinos

```java
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
```


### Observer

O padrão observer foi utilizado para observar e notificar o tabuleiro toda vez que um ataque for realizado.

```java
private void notificarObservadores(boolean acertou) {
    for (Observador observador : observadores) {
        observador.notificarAcerto(acertou);
    }
}
```


### Memento

O padrão memento foi utilizado para salvar o estado inicial de criação de tabuleiro e funcionar como uma função `reiniciarJogo`. Ele salva o estado de criação do oceano, antes de posicionar os navios, para que se usuário queria reiniciar, ele possa resgatar a instância inicial do Tabuleiro e gere um "novo jogo".

```java
public Memento criarMemento() {
    int[][] copiaEstado = new int[tabuleiro.length][tabuleiro[0].length];
    for (int i = 0; i < tabuleiro.length; i++) {
        copiaEstado[i] = Arrays.copyOf(tabuleiro[i], tabuleiro[i].length);
    }
    return new Memento(copiaEstado);
}
```

### Injeção de Dependências

Esse padrão está sendo implementado atráves do padrão Memento, que só pode ser instanciado caso exista um Tabuleiro previamente.

```java
Tabuleiro tabuleiroSingleton = Tabuleiro.getInstance();
Memento mementoInicial = tabuleiroSingleton.criarMemento();
```


## Princípios de projeto
	
### Princípio de responsabilidade única

Esse princípio foi utilizado em diversos métodos para deixar mais claro e objetivo cada um dos métodos. Dessa forma, fica mais fácil de separar as responsabilidades e consequentemente chamar os métodos para cada situação necessária.

```java
public void imprimirTabuleiro()
public boolean posicaoValida(Tabuleiro tabuleiro, int linha, int coluna)
public boolean verificarChute(Tabuleiro tabuleiro, int linha, int coluna)
public void exibirTotalSubs()
public void atualizaVitoria(Tabuleiro tabuleiro)
public void notificarAcerto(boolean acertou)
public int notificaVitoria()
```

### Segregação de interfaces

Esse princípio é utilizado no própria utilização do padrão factory. Cria-se uma interface Navio com os métodos básicos para todo navio e daí pode se criar classe específicas que direvem da interface Navio, como submarinos, encouraçados, porta-aviões, entre outros.

```java
public interface Navio {
    void setAtaqueStrategy(AtaqueStrategy ataqueStrategy);
    void executarAtaque(Tabuleiro tabuleiro);
    void posicionaNavio(Tabuleiro tabuleiro);
}
```

### Princípio de Demeter

Esse princípio se dá para evitar cadeias de métodos. Dessa forma, na implementação de `executarAtaque`, ao invés de encadear métodos, separou-se em outros pequenos métodos mais simples (principio de responsabilidade única) para evitar essas cadeias.

```java
public void executarAtaque(Tabuleiro tabuleiro) {
    
    ...

    acertou = tabuleiro.verificarChute(tabuleiro, linha, coluna);
    notificarObservadores(acertou);
    tabuleiro.atualizarTabuleiro(linha, coluna, acertou, tabuleiro);
}
```

## Frameworks

Nenhum framework foi implementado.


## Conclusão

A realização desse projeto trouxe muitos desafios, tanto na modelagem do sistema quanto na implementação. A parte mais complexa foi pensar em quais padrões de projeto seriam possíveis de implementar dado minha idéia de projeto. A implementação também foi desafiadora, já que estou pouco habituado com Java. No entanto, foi um projeto muito divertido de fazer porque ao longo do desenvolvimento, é interessante perceber como o código fica mais limpo, menos redundante, mais légivel, mais coeso, melhor estruturado por seguir os padrões e aplicando os princípios. O entendimento do sistema, em caso de alguma manutenção, fica mais simples, algo essencial para o trabalho em grupo em projetos que envolvem muitos desenvolvedores.

A lição que fica é de estar atento as utilizações de padrões e princípios para estar constantemente escrevendo código melhores.
	