public class TicTacToe {
  public static void main(String[] args) {
    Board tictactoe = new Board();
    Player player1 = new AI("X", 3, tictactoe);
    Player player2 = new Easy("O", 10, tictactoe);
    while(tictactoe.isFull()>2&&!tictactoe.isWon()) {
      player1.move(player2.getVal());
      System.out.println(tictactoe);
      if(!tictactoe.isWon()) {
        player2.move(player1.getVal());
        System.out.println(tictactoe);
      }
    }
    if(tictactoe.isFull()>0&&!tictactoe.isWon()) {
      player1.move(player2.getVal());
      System.out.println(tictactoe);
    }

    switch(tictactoe.getWinner()) {
      case 0:
        System.out.println("Draw!");
        break;
      case 3:
        System.out.println("Player 1 Wins!");
        break;
      case 10:
        System.out.println("Player 2 Wins!");
        break;
      default:
        System.out.println("Error!");
        break;
    }
  }
}
