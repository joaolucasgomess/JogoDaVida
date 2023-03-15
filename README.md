# JogoDaVida
Olá! Esse é nosso primeiro projeto na matéria de Estrutura de Dados no curso de Análise e Desenvolvimento de Sistemas.

Se trata da implementação de um algoritmo aplicado a matrizes quadradas, que vamos chamar de tabuleiro. Este que possui células (elementos da matriz). Células estas que podem possuir o valor de 1, que representará que ela está viva, e o valor 0, representando que ela se encontra morta. Sendo assim, o Jogo da Vida irá seguir as seguintes regras:
```
1. Qualquer célula viva com menos de dois vizinhos vivos morre de solidão.
2. Qualquer célula viva com mais de três vizinhos vivos morre de superpopulação.
3. Qualquer célula morta com exatamente três vizinhos vivos se torna uma célula
viva.
4. Qualquer célula viva com dois ou três vizinhos vivos continua no mesmo estado
para a próxima geração.
```
O primeiro tabuleiro será gerado com um valor de células vivas e mortas e a partir daí as regras serão aplicadas.
Se divirta!

# Para jogar
A partir de qualquer compilador de Java é possível executar o game.
