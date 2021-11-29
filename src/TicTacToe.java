public class TicTacToe {
    public static void main(String[] args) {
        Board tictactoe = new Board();
        Player player1 = new AI("X", 3, tictactoe, 10);
        Player player2 = new Easy("O", 10, tictactoe, 3);
        while (tictactoe.isFull() > 2 && !tictactoe.isWon()) {
            player1.move();
            System.out.println(tictactoe);
            if (!tictactoe.isWon()) {
                player2.move();
                System.out.println(tictactoe);
            }
        }
        if (tictactoe.isFull() > 0 && !tictactoe.isWon()) {
            player1.move();
            System.out.println(tictactoe);
        }

        // TODO: Fix bug where last move is a draw
        switch (tictactoe.getWinner()) {
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
