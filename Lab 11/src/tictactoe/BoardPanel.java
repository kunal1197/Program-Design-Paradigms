package tictactoe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;


/**
 * The BoardPanel class is responsible for drawing the board and the player moves on it.
 */
class BoardPanel extends JPanel {

  private final ReadonlyTttModel model;

  /**
   * Constructor for the BoardPanel class.
   *
   * @param model the model of the game.
   */
  public BoardPanel(ReadonlyTttModel model) {
    this.model = model;
  }

  /**
   * Paints the board.
   *
   * @param g the graphics object.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g.setColor(Color.YELLOW);
    g.fillRect(0, 0, 600, 800);
    g.setColor(Color.BLACK);

    // draw grid lines
    g2d.drawLine(200, 0, 200, 600);
    g2d.drawLine(400, 0, 400, 600);
    g2d.drawLine(0, 200, 600, 200);
    g2d.drawLine(0, 400, 600, 400);
    g2d.drawLine(0, 600, 600, 600);

    g2d.setColor(Color.BLUE);
    g2d.setFont(new Font("Times New Roman", Font.BOLD, 50));

    String turn = "";
    if (!model.isGameOver()) {
      turn = turn + "Turn: " + model.getTurn();
      g2d.drawString(turn, 200, 700);
    } else if (model.isGameOver() && model.getWinner() == null) {
      turn = turn + "Draw";
      g2d.drawString(turn, 200, 700);
    } else if (model.isGameOver() && model.getWinner() != null) {
      turn = turn + "Winner: " + model.getWinner();
      g2d.drawString(turn, 200, 700);
    }

    g2d.setFont(new Font("Times New Roman", Font.BOLD, 75));

    Player[][] board = model.getBoard();
    // te over board, draw X and O accordingly
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == Player.X) {
          g2d.setColor(Color.RED);
          g2d.drawString("X", ((j + 1) * 150) - (g2d.getFont().getSize() / 2),
                  (i + 1) * 200);
        } else if (board[i][j] == Player.O) {
          g2d.setColor(Color.DARK_GRAY);
          g2d.drawString("O", ((j + 1) * 150) - (g2d.getFont().getSize() / 2),
                  (i + 1) * 200);
        }
      }
    }
  }
}
