import java.util.Random;

public class Easy extends Player {
  public Easy(String s, int v, Board b) {
    super(s, v, b);
  }
  public void move() {
    Random generator=new Random();
    int x=generator.nextInt(3);
    int y=generator.nextInt(3);
    while(board.getPos(x,y)!=0){
      x=generator.nextInt(3);
      y=generator.nextInt(3);
    }
    board.setPos(x,y, val, icon);
  }
}
