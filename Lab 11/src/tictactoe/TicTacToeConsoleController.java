package tictactoe;

/**
 * TicTacToeConsoleController is the implementation of the TicTacToeController.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final TicTacToeView v;
  private final TicTacToe m;

  TicTacToeConsoleController(TicTacToe m, TicTacToeView v) {
    this.m = m;
    this.v = v;
  }

  /**
   * Execute a single game of TicTacToe given a TicTacToe Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a non-null TicTacToe Model
   */
  @Override
  public void playGame(TicTacToe m) {
    while (m.getWinner() == null || !m.isGameOver()) {
      v.refresh();
    }
  }

  /**
   * Handle an action in a single cell of the board, such as to make a move.
   *
   * @param row the row of the clicked cell
   * @param col the column of the clicked cell
   */
  @Override
  public void handleCellClick(int row, int col) {
    m.move(row, col);
    System.out.println("You clicked on row: " + row + " and col: " + col);
  }
}
