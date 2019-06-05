/**
 * Represents a Tic Tac Toe board.
 * @author aphil311
 * @version
 */

public class Board {
  // Instance Data
  private int[][] iBoard = {{0,0,0},            // This is the two dimensional
                            {0,0,0},            // array that represents the
                            {0,0,0}};           // board with numbers

  private String[][] sBoard = {{" "," "," "},   // This is the two dimensional
                               {" "," "," "},   // array that represents the
                               {" "," "," "}};  // board as symbols.

  private int winner = 0;      // Stores the value of the winning player

  //------------------------------------------
  // Constructor - Does not initialize anything
  //------------------------------------------
  public Board() {}

  /**
   * Sets a position on the board to a symbol and an integer
   * @param x The row that the client wishes to change
   * @param y The column that the client wishes to change
   * @param a The integer that represents the client
   * @param b The symbol that represents the client
   */
  public void setPos(int x, int y, int a, String b) {
    iBoard[x][y] = a;
    sBoard[x][y] = b;
  }

  /**
   * Returns the integer at the position that the client wishes to access
   * @param x The row that the client wishes to access
   * @param y The column that the client wishes to access
   * @return The integer value present at (x,y) on the board
   */
  public int getPos(int x, int y) {
    return iBoard[x][y];
  }

  /**
   * Returns the number of spaces still available on the board
   * @return The ammount of free spaces left on the board as an integer
   */
  public int isFull() {
    int count=0;
    for(int x = 0; x<3; x++) {
      for(int y = 0; y<3; y++) {
        if(iBoard[x][y]==0)
          count++;
      }
    }
    return count;
  }

  /**
   * Determines whether or not a player has won the game
   * @return True if the game has been won, false otherwise
   */
  public boolean isWon(){
    for(int i=0; i<3; i++) {
      if(addRow(i)==9||addCol(i)==9) {
        winner = 3;
        return true;
      }
      if(addRow(i)==30||addCol(i)==30) {
        winner = 10;
        return true;
      }
    }
    if(addDiag(0)==9||addDiag(1)==9) {
      winner = 3;
      return true;
    }
    if(addDiag(0)==30||addDiag(1)==30) {
      winner = 10;
      return true;
    }

    return false;
  }

  /**
   * Allows the client to see which player has won the game
   * @return The integer representative of the player who has won the game
   */
  public int getWinner() {
    return winner;
  }


  // TODO: Combine these functions
  /**
   * Finds the sum of all the integers present in a row
   * @param row The index of the row to be added up
   * @return The sum of all numbers in the row
   */
  public int addRow(int row) {
    int count = 0;
    for(int i = 0; i<3; i++) {
      count+=iBoard[row][i];
    }
    return count;
  }

  /**
   * Finds the sum of all the integers present in a row
   * @param col The index of the column to be added up
   * @return The sum of all numbers in the column
   */
  public int addCol(int col) {
    int count = 0;
    for(int j = 0; j<3; j++) {
      count+=iBoard[j][col];
    }
    return count;
  }

  // TODO: Simplify this function
  public int addDiag(int a) {
    if(a==0) {
      int count = 0;
      for(int i=0; i<3; i++) {
        count+=iBoard[i][i];
      }
      return count;
    }
    else if(a==1) {
      int count = 0;
      for(int i=0; i<3; i++) {
        count+=iBoard[i][2-i];
      }
      return count;
    }
    else
      return -1;
  }

  @Override
  public String toString() {
    // TODO: Fill this more efficiently with a loop
    String row1 = sBoard[0][0] + "|" + sBoard[0][1] + "|" + sBoard[0][2];
    String row2 = sBoard[1][0] + "|" + sBoard[1][1] + "|" + sBoard[1][2];
    String row3 = sBoard[2][0] + "|" + sBoard[2][1] + "|" + sBoard[2][2];
    String row = "-+-+-";
    return row1+"\n"+row+"\n"+row2+"\n"+row+"\n"+row3+"\n";
  }
}
