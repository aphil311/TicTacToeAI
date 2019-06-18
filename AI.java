import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class AI extends Player{
  public AI(String s, int v, Board b, int c) {
    super(s, v, b, c);
  }
  public void move() {
    if(winExists()[0]>=0) {
      System.out.println("Found a winning move!");
      board.setPos(winExists()[0], winExists()[1], val, icon);
    }
    else {
      defaultMove();
    }
  }

  private int[] winExists() {
    int[] points = {-1, -1};
    for(int i=0; i<3; i++) {
      if(board.addRow(i)==val*2) {
        points[0]=i;
        for(int j = 0; j<3; j++) {
          if(board.getPos(i,j)==0) {
            points[1]=j;
            return points;
          }
        }
      }
      if(board.addCol(i)==val*2) {
        points[1]=i;
        for(int j = 0; j<3; j++) {
          if(board.getPos(j,i)==0) {
            points[0]=j;
            return points;
          }
        }
      }
      if(board.addRow(i)==opp*2) {
        points[0]=i;
        for(int j = 0; j<3; j++) {
          if(board.getPos(i,j)==0) {
            points[1]=j;
            return points;
          }
        }
      }
      if(board.addCol(i)==opp*2) {
        points[1]=i;
        for(int j = 0; j<3; j++) {
          if(board.getPos(j,i)==0) {
            points[0]=j;
            return points;
          }
        }
      }
    }
    if(board.addDiag(0)==6||board.addDiag(0)==20)
      playDiag(0);
    if(board.addDiag(1)==6||board.addDiag(1)==20)
      playDiag(1);

    return points;
  }

  private void defaultMove() {
    if(board.getPos(1, 1)==0) {
      System.out.println("Playing center!");
      board.setPos(1, 1, val, icon);
    }
    else {
      attemptCorner();
    }
  }

  private void attemptCorner() {
    if (board.getPos(0,0) == opp) {
      if(board.getPos(2, 2)==0) {
        board.setPos(2, 2, val, icon);
        return;
      }
    }
    if(board.getPos(2, 2)==opp) {
      if(board.getPos(0, 0)==0) {
        board.setPos(0, 0, val, icon);
        return;
      }
    }
    if(board.getPos(2, 0)==opp) {
      if(board.getPos(0, 2)==0) {
        board.setPos(0, 2, val, icon);
        return;
      }
    }
    if(board.getPos(0, 2)==opp) {
      if(board.getPos(2, 0)==0) {
        board.setPos(2, 0, val, icon);
        return;
      }
    }
    playRandomCorner();
  }

  private void playRandomCorner() {
    Random generator = new Random();
    List<Integer> points = new ArrayList();
    if (board.getPos(0,0) == 0) {
      points.add(0);
      points.add(0);
    }
    if(board.getPos(2, 2)==0) {
      points.add(2);
      points.add(2);
    }
    if(board.getPos(2, 0)==0) {
      points.add(2);
      points.add(0);
    }
    if(board.getPos(0, 2)==0) {
      points.add(0);
      points.add(2);
    }
    if(points.size()==0)
      playSide();
    else {
      int num = generator.nextInt(points.size()/2)*2;
      System.out.println(num);
      board.setPos(points.get(num), points.get(num+1), val, icon);
    }
  }

  private void playSide() {
    if (board.getPos(0, 1)==0) {
      board.setPos(0, 1, val, icon);
      return;
    }
    else if (board.getPos(1, 2)==0) {
      board.setPos(1, 2, val, icon);
      return;
    }
    else if (board.getPos(2, 1)==0) {
      board.setPos(2, 1, val, icon);
      return;
    }
    else if (board.getPos(1, 0)==0) {
      board.setPos(1, 0, val, icon);
      return;
    }
  }

  private void playDiag(int a) {
    if(a==0) {
      for(int i=0; i<3; i++) {
        if (board.getPos(i, i)==0){
          board.setPos(i, i, val, icon);
          return;
        }
      }
    }
    else if(a==1) {
      for(int i=0; i<3; i++) {
        for (int j=2; j>=0; j--) {
          if(board.getPos(i, j)==0)
            board.setPos(i, j, val, icon);
        }
      }
    }
    else {
      System.out.println("Error");
      defaultMove();
    }
  }
}
