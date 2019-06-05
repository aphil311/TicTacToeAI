//=============================================================================
// ~File Name: Board.java
//
// ~Author: Aphillips
//
// ~Purpose: Represents a Tic Tac Toe board.
//=============================================================================

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
   * Sets the 
   *
   */
  public void setPos(int x, int y, int a, String b) {
    iBoard[x][y] = a;
    sBoard[x][y] = b;
  }

  public int getPos(int x, int y) {
    return iBoard[x][y];
  }

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

  public int getWinner() {
    return winner;
  }

  public int addRow(int row) {
    int count = 0;
    for(int i = 0; i<3; i++) {
      count+=iBoard[row][i];
    }
    return count;
  }

  public int addCol(int col) {
    int count = 0;
    for(int j = 0; j<3; j++) {
      count+=iBoard[j][col];
    }
    return count;
  }

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

  public String toString() {
    String row1 = sBoard[0][0] + "|" + sBoard[0][1] + "|" + sBoard[0][2];
    String row2 = sBoard[1][0] + "|" + sBoard[1][1] + "|" + sBoard[1][2];
    String row3 = sBoard[2][0] + "|" + sBoard[2][1] + "|" + sBoard[2][2];
    String row = "-+-+-";
    return row1+"\n"+row+"\n"+row2+"\n"+row+"\n"+row3+"\n";
  }
}
