import java.util.Random;
public class Easy implements Player {
  Random generator=new Random();
  private String icon;
  private int val;
  Board board;
  public Easy(String symbol, int value, Board b) {
    val = value;
    icon = symbol;
    board = b;
  }
  public void move(int opp) {
    Random generator=new Random();
    int x=generator.nextInt(3);
    int y=generator.nextInt(3);
    while(board.getPos(x,y)!=0){
      x=generator.nextInt(3);
      y=generator.nextInt(3);
    }
    board.setPos(x,y, val, icon);
  }
  public int getVal() {
    return val;
  }
}
