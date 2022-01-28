package tictactoe;

/**
 * Represents a player in the game of tic-tac-toe.
 */
public enum Player {
  X("X"), O("O");

  private final String disp;

  private Player(String disp) {
    this.disp = disp;
  }

  /**
   * Returns the display name of the player.
   *
   * @return the display name of the player
   */
  @Override
  public String toString() {
    return disp;
  }
}
