package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * This starter files is for students to implement a console controller for the
 * TicTacToe MVC assignment.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   *
   * @param in  the source to read from
   * @param out the target to print to
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  /**
   * Execute a single game of tic tac toe given a tic tac toe Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a non-null tic tac toe Model
   */
  @Override
  public void playGame(TicTacToe m) {

    int rowInt = 0;
    int colInt = 0;
    String row = "";
    String col = "";
    if (m == null) {
      throw new IllegalArgumentException("Model should not be null");
    }
    try {
      out.append(m.toString()).append("\n");
      out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
      while (!m.isGameOver()) {
        try {

          do {
            row = scan.next();
            if (row.equalsIgnoreCase("q")) {
              out.append("Game quit! Ending game state:\n").append(m.toString()).append("\n");
              return;
            } else {
              try {
                rowInt = Integer.parseInt(row);
                break;
              } catch (NumberFormatException e) {
                out.append("Not a valid number: ").append(row).append("\n");
              }
            }
          }
          while (row != null);

          do {
            col = scan.next();
            if (col.equalsIgnoreCase("q")) {
              out.append("Game quit! Ending game state:\n").append(m.toString()).append("\n");
              return;
            } else {
              try {
                colInt = Integer.parseInt(col);
                break;
              } catch (NumberFormatException e) {
                out.append("Not a valid number: ").append(col).append("\n");
              }
            }
          }
          while (col != null);

          try {
            m.move(rowInt - 1, colInt - 1);
            if (!m.isGameOver()) {
              this.out.append(m.toString()).append("\n");
              out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
            }
          } catch (IllegalArgumentException e) {
            out.append("Not a valid move: ").append(row).append(", ").append(col).append("\n");
          }

        } catch (IOException ioe) {
          throw new IllegalStateException("Append failed", ioe);
        }
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    }


    try {
      this.out.append(m.toString()).append("\n");
      Player winner = m.getWinner();
      if (m.isGameOver() && winner != null) {
        if (winner.toString().equals("X")) {
          out.append("Game is over! X wins.\n");
        } else {
          out.append("Game is over! O wins.\n");
        }
      } else if (m.isGameOver() && winner == null) {
        out.append("Game is over! Tie game.\n");
      }

    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    }
  }
}

