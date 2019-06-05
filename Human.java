import java.util.Scanner;

public class Human extends Player {
  public Human(String s, int v, Board b) {
    super(s, v, b);
  }

  /**
   * Allows the user to play on their move. Checks if play is legal.
   */
  public void move() {
    int x = getInput("Row: ");
    int y = getInput("Col: ");

    if(board.getPos(x-1, y-1)==0)
      board.setPos(x-1,y-1, val, icon);
    else
      move();
  }

  /**
   * Asks a question and returns the response
   * @param s The question to be asked
   * @return The response as an integer
   */
  private int getInput(String s) {
    Scanner scan = new Scanner(System.in);
    int response;
    System.out.print(s);
    response = scan.nextInt();
    while(response>3||response<1) {
      System.out.print("Not valid, try again: ");
      response = scan.nextInt();
    }
    return response;
  }
}
