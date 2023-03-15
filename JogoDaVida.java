import java.util.*;

public class JogoDaVida{
   private int[][] tabuleiro;
   private int[][] tabuleiroTransicao;
   private int tamanhoDoTabuleiro = 0;
   
   public int[][] getTabuleiro(){
      return tabuleiro;
   }
   
   public int[][] getTabuleiroTransicao(){
      return tabuleiroTransicao;
   }
   
   // LE ENTRADA DO USUAIO PARA DEFINIR TAMANHO DO TABULEIRO
   public int lerTamanhoDoTabuleiro(){
      if(this.tamanhoDoTabuleiro == 0){
         Scanner leia = new Scanner(System.in);
         System.out.println("Para iniciarmos o Jogo da Vida, digite a seguir o tamanho do tabuleiro desejado(Somente um numero): ");
         this.tamanhoDoTabuleiro = leia.nextInt();
         return this.tamanhoDoTabuleiro;
      }else{
         return this.tamanhoDoTabuleiro;
      }
   }

   // GERAR A ALEATORIEDADE DAS CELULAS 
   public int aleatoriedade(){
      Random aleatorio = new Random();
      int numero = aleatorio.nextInt(2);
      return numero;
   }
   
   // GERA UM TABULEIRO COM VALORES DE CELULAS ALEATORIAS A PARTIR DO TAMNHO DIGITAL PELO USUARIO
   public void gerarTabuleiro(){
      int tamanhoDoTabuleiro = lerTamanhoDoTabuleiro();
      this.tabuleiro = new int[tamanhoDoTabuleiro][tamanhoDoTabuleiro];
      this.tabuleiroTransicao = new int[tamanhoDoTabuleiro][tamanhoDoTabuleiro];
      
      for(int linha = 0; linha < tamanhoDoTabuleiro; linha++){
         for(int celula = 0; celula < tamanhoDoTabuleiro; celula++){
            tabuleiro[linha][celula] = aleatoriedade();
         }
      }
   }

   // IMPRIME O TABULEIRO
   public void imprimirTabuleiro(int[][] tabuleiro){
      for(int[] linha : tabuleiro) {
         for(int celula : linha){
            System.out.print(celula + " ");
         }
         System.out.println();
      }
      System.out.println();
   }

   // VERIFICA SE AS CELULAS VIZINHAS ESTÃO VIVAS OU MORTAS, CONSIDERANDO QUE A posicaoOndeCelulaAponta = 0 IRÁ APONTAR PARA A DIREITA E A CADA NOVO VALOR É APONTADA A PRÓXIMA DIREÇÃO EM SENTIDO HORÁRIO
   public int testarCelulas(int linhaAtual, int celulaAtual){
      int ultimaPosicao = tamanhoDoTabuleiro - 1;
      int qtdVizinhosVivos = 0;
      boolean[] condicaoPrimeiroIf = {celulaAtual < ultimaPosicao, linhaAtual < ultimaPosicao, celulaAtual > 0, linhaAtual > 0};
      int[][] condicaoSegundoIf = {{linhaAtual, linhaAtual + 1, linhaAtual, linhaAtual - 1}, { celulaAtual + 1, celulaAtual, celulaAtual - 1, celulaAtual }};
      int[][] condicaoTerceiroIf = {{linhaAtual, linhaAtual - ultimaPosicao, linhaAtual, linhaAtual + ultimaPosicao}, {celulaAtual - ultimaPosicao, celulaAtual, celulaAtual + ultimaPosicao, celulaAtual}};
      
      for(int posicaoOndeCelulaAponta = 0; posicaoOndeCelulaAponta < 4; posicaoOndeCelulaAponta++){
         if(condicaoPrimeiroIf[posicaoOndeCelulaAponta]){
            if(tabuleiro[condicaoSegundoIf[0][posicaoOndeCelulaAponta]][condicaoSegundoIf[1][posicaoOndeCelulaAponta]] == 1){
               qtdVizinhosVivos++;
            }
         }else if(tabuleiro[condicaoTerceiroIf[0][posicaoOndeCelulaAponta]][condicaoTerceiroIf[1][posicaoOndeCelulaAponta]] == 1){
            qtdVizinhosVivos++;
         }  
      }
      return qtdVizinhosVivos;
   }

   //  GERA O TABULEIRO ATUALIZADO APÓS A VERIFICAÇÃO DO TABULEIRO INCIAL
   public void gerarTabuleiroAtualizado(int celulaAtual, int linhaAtual){
      int qtdVizinhosVivos = testarCelulas(linhaAtual, celulaAtual); 
      
      if(tabuleiro[linhaAtual][celulaAtual] == 1){
         if(qtdVizinhosVivos < 2 || qtdVizinhosVivos > 3){
            tabuleiroTransicao[linhaAtual][celulaAtual] = 0;
         }else if (qtdVizinhosVivos == 2 || qtdVizinhosVivos == 3){
            tabuleiroTransicao[linhaAtual][celulaAtual] = tabuleiro[linhaAtual][celulaAtual];
         }
      }else if(qtdVizinhosVivos == 3){
         tabuleiroTransicao[linhaAtual][celulaAtual] = 1;
      }
   }

   public void continuarGeracao(){
      System.out.println("Digite '1' para ir para a proxima geracao ou 2 para encerrar");
      Scanner leia = new Scanner(System.in);
      int opcaoGeracao = leia.nextInt();
      switch(opcaoGeracao){
         case 1:
            executarAtualizacaoDoTabuleiro();
            break;
         case 2:
            System.out.println("Volte sempre!");
            System.exit(0);
            break;
      }
   }
   
   // EXECUTA A ATUALIZAÇÃO DO TABULEIRO
   public void executarAtualizacaoDoTabuleiro(){
      for(int linhaAtual = 0; linhaAtual < tabuleiro.length; linhaAtual++){
         for(int celulaAtual = 0; celulaAtual < tabuleiro[linhaAtual].length; celulaAtual++){
            gerarTabuleiroAtualizado(celulaAtual, linhaAtual);
         }
      }this.tabuleiro = tabuleiroTransicao;
   }
}