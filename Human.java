import java.util.Scanner;
public class Human implements Player {
  private String icon;
  private int val;
  Board board;
  public Human(String symbol, int value, Board b) {
    val = value;
    icon = symbol;
    board = b;
  }
  public void move(int opp) {
    Scanner scan = new Scanner(System.in);
    int x;
    int y;
    System.out.println("Your turn: ");
    System.out.print("Row: ");
    x=scan.nextInt();
    System.out.print("Col: ");
    y=scan.nextInt();
    while(x>3||x<0||y>3||y<0||board.getPos(x-1,y-1)!=0){
      System.out.print("Row: ");
      x=scan.nextInt();
      System.out.print("Col: ");
      y=scan.nextInt();
    }

    board.setPos(x-1,y-1, val, icon);
  }

  public int getVal() {
    return val;
  }
}
