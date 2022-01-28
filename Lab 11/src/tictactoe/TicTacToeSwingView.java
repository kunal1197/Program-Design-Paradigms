package tictactoe;

import java.awt.event.MouseAdapter;

import javax.swing.*;


/**
 * The implementation of the view for the tic-tac-toe game.
 */
public class TicTacToeSwingView extends JFrame implements TicTacToeView {

  private final BoardPanel boardPanel;

  /**
   * Constructor for the TicTacToeSwingView.
   *
   * @param model the model for the game.
   */
  public TicTacToeSwingView(ReadonlyTttModel model) {
    super("The Tic-Tac-Toe Game");
    this.setSize(600, 800);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setResizable(false);

    boardPanel = new BoardPanel(model);
    add(boardPanel);
  }

  /**
   * Set up the controller to handle click events in this view.
   *
   * @param listener the controller
   */
  @Override
  public void addClickListener(TicTacToeController listener) {
    // create the MouseAdapter to handle mouse clicks
    MouseAdapter clickAdapter = new MouseClick(listener);
    boardPanel.addMouseListener(clickAdapter);
  }


  /**
   * Refresh the view to reflect any changes in the game state.
   */
  @Override
  public void refresh() {
    repaint();
  }

  /**
   * Make the view visible to start the game session.
   */
  @Override
  public void makeVisible() {
    setVisible(true);
  }
}
