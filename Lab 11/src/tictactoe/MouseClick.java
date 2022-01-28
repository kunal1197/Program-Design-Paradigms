package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Class that handles mouse clicks on the board.
 */
public class MouseClick extends MouseAdapter {
  private final TicTacToeController listener;
  private int flag = 1;

  /**
   * Constructor for the MouseClick class.
   *
   * @param listener the controller that handles the mouse clicks.
   */
  public MouseClick(TicTacToeController listener) {
    this.listener = listener;
  }

  /**
   * Handles the mouse click event.
   *
   * @param e the mouse event.
   */
  public void mouseClicked(MouseEvent e) {
    if (flag == 1) {
      super.mouseClicked(e);
      // arithmetic to convert panel coords to grid coords
      //e.getX(), e.getY()
      List<Integer> coords = parseRowCol(e.getX(), e.getY());
      int row = coords.get(0);
      int col = coords.get(1);
      if (row == -1 || col == -1) {
        dialogBox("Invalid move, Click Again");
      } else {
        try {
          listener.handleCellClick(row, col);
        } catch (IllegalStateException ex) {
          dialogBox("Game Over");
          flag = 0;
        } catch (IllegalArgumentException ex) {
          dialogBox("The position is already occupied, Click Again");
        }
      }
    } else {
      dialogBox("Game is Already Over");
    }
  }

  private List<Integer> parseRowCol(int x, int y) {
    int row = -1;
    int col = -1;
    if (x >= 0 && x <= 200) {
      col = 0;
    } else if (x >= 201 && x <= 400) {
      col = 1;
    } else if (x >= 401 && x <= 600) {
      col = 2;
    }
    if (y >= 0 && y <= 200) {
      row = 0;
    } else if (y >= 201 && y <= 400) {
      row = 1;
    } else if (y >= 401 && y <= 600) {
      row = 2;
    }

    return List.of(row, col);
  }

  private void dialogBox(String message) {
    JOptionPane.showMessageDialog(null, message);
  }

}
