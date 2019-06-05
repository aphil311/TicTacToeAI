abstract class Player {
  protected String icon;
  protected int val;
  Board board;
  public Player(String symbol, int value, Board b) {
    val = value;
    icon = symbol;
    board = b;
  }
  abstract void move();
  abstract int getVal();
}
