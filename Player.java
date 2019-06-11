abstract class Player {
  protected String icon;
  protected int val;
  protected int opp;
  Board board;
  public Player(String symbol, int value, Board b, int c) {
    val = value;
    icon = symbol;
    board = b;
    opp = c;
  }
  abstract void move();

  /**
   * Accessor method for the val variable
   * @return The value of the variable val
   */
  int getVal() {
    return val;
  }
}
