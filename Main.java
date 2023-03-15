public class Main {
  public static void main(String[] args) {
    JogoDaVida jogoDaVida = new JogoDaVida();
    
    jogoDaVida.gerarTabuleiro();
    System.out.println("Tabuleiro gerado aleatoriamente: ");
    jogoDaVida.imprimirTabuleiro(jogoDaVida.getTabuleiro());
    while(true){
      jogoDaVida.continuarGeracao();
      System.out.println("Tabuleiro atualizado: ");
      jogoDaVida.imprimirTabuleiro(jogoDaVida.getTabuleiro());
    }
  }
}