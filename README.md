# Trabalho_Pratico_POO_UNO
Nesse repositório iremos criar um projeto para a disciplina de Programação Orientada a Objetos com o intuito de criar um jogo de UNO.

## Introdução:
Neste projeto, cada grupo deverá propor e desenvolver um sistema de seu interesse usando orientação a objetos e a linguagem Java.
Ao final do projeto, espera-se que os alunos:
 1) tenham alcançado um domínio maior da orientação a objetos e da tecnologia Java
 2) sejam capazes de organizar um sistema em módulos bem definidos, reduzindo o acoplamento e aumentando a coesão.
 3) tenham amadurecido a experiência de se trabalhar em equipe.
 4) tenham aprendido a usar de forma apropriada uma ferramenta de controle de versão.

## Desenvolvimento:
Para o desenvolvimento desse projeto utilizaremos a ferramenta Visual Studio Code, que é um editor de código aberto desenvolvido pela Microsoft.
Além disso, haverá um versionamento do nosso código feito em Java pela ferramenta Git/Github.

Sobre o projeto: Decidimos em consenso que iremos implementar um jogo de cartas comumente conhecido como UNO;

O que é o jogo UNO:
 1) Cartas Numéricas: As cartas numéricas são as mais comuns no baralho de Uno. Existem quatro cores principais: vermelho, azul, verde e amarelo. Cada cor contém 19 cartas numéricas, que vão de 0 a 9.
    * Vermelho: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 (2 de cada número, exceto o 0, que tem 1)
    * Azul: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 (2 de cada número, exceto o 0, que tem 1)
    * Verde: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 (2 de cada número, exceto o 0, que tem 1)
    * Amarelo: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 (2 de cada número, exceto o 0, que tem 1)
 
 2) Cartas Especiais: Além das cartas numéricas, o baralho de Uno também contém cartas especiais que podem alterar o fluxo do jogo. Essas cartas são importantes para criar reviravoltas emocionantes e imprevisíveis.
    * Coringas Troca de cor: Existem 4 cartas Coringas, que permitem ao jogador escolher a cor que deseja jogar. Essa carta é extremamente poderosa, pois pode ser usada em qualquer momento do jogo, independentemente da cor ou número da carta anterior.
    * Coringas +4: Também existem 4 cartas Coringas +4. Quando um jogador coloca essa carta, o próximo jogador deve comprar quatro cartas e perde a vez. O jogador que usar essa carta também escolhe a nova cor que se começará a jogar. Essa carta só pode ser jogada        se o jogador não tiver cartas na cor que está em jogo.
    * Inverter: As 2 cartas de Inverter permitem que a direção do jogo mude. Se o jogo estava indo no sentido horário, passa a ir no sentido anti-horário e vice-versa. Essa carta pode criar estratégias interessantes, especialmente em grupos maiores.
    * Pular: Existem 2 cartas de Pular, que fazem com que o próximo jogador perca a sua vez. Essa carta é muito útil para impedir que um adversário jogue e continue avançando em sua estratégia.
    * Comprar Duas: Existem 2 cartas de Comprar Duas. Quando um jogador usa essa carta, o próximo deve comprar duas cartas e perde a vez. É uma forma eficiente de aumentar a competição e dificultar as jogadas dos oponentes.
  
  3) O vencedor é aquele que, após ter ficado com uma carta na mão e ter dito em voz alta UNO, conseguir descartar essa carta na pilha antes de todos os outros jogadores.

Porque essa escolha: Por ser um jogo muito conhecido e divertido de se jogar, optamos por replicá-lo de maneira que possa ser jogado em nossos computadores sem que precise de uma baralho ou instalar um app, que, em alguns casos, é pago.
