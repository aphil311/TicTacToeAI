public class AI implements Player{
  private String icon;
  private int val;
  Board board;
  public AI(String symbol, int value, Board b) {
    val = value;
    icon = symbol;
    board = b;
  }
  public int getVal() {
    return val;
  }
  public void move(int z) {
    int x=0;
    int y=0;
    if(findWin(val)!=null) {
      x=findWin(val)[0];
      y=findWin(val)[1];
    }
    board.setPos(x,y, val, icon);
  }
  private int[] findWin(int a) {
    for(int i=0; i<3; i++) {
      if(board.addRow(i)==a*2) {
        int[] points = {i, findOpenCol(i)};
        return points;
      }
      if(board.addCol(i)==2*val) {
        int[] points = {findOpenRow(i), i};
        return points;
      }
    }
    if(board.addDiag(0)==2*val) {
      for(int i=0; i<3; i++) {
        if(board.getPos(i,i)==0) {
          int[] points = {i, i};
          return points;
        }
      }
    }
    if(board.addDiag(1)==2*val) {
      for(int i=2; i>=0; i--) {
        if(board.getPos(i,2-i)==0){
          int[] points = {i, 2-i};
          return points;
        }
      }
    }
    return null;
  }
  private int findOpenCol(int r) {
    for(int i = 0; i<3; i++) {
      if(board.getPos(r,i)==0)
        return i;
    }
    return -1;
  }
  private int findOpenRow(int c) {
    for(int i = 0; i<3; i++) {
      if(board.getPos(i,c)==0)
        return i;
    }
    return -1;
  }
}
