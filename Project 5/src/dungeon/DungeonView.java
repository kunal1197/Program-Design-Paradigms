package dungeon;

/**
 * A view for Dungeon Game: display the game board and provide visual interface
 * for users.
 */
public interface DungeonView {

  /**
   * This is used to add a mouse listener to the board panel.
   *
   * @param listener the mouse listener.
   */
  void addClickListener(DungeonViewController listener);

  /**
   * This is used to add a key listener to the board panel.
   *
   * @param listener the key listener.
   */
  void addKeyListener(DungeonViewController listener);

  /**
   * This is used to repaint the board panel.
   */
  void refresh();

  /**
   * This is used to make board panel visible.
   */
  void makeVisible();

  /**
   * This is used to restart a new game.
   *
   * @param listener button listener.
   */
  void startNewGame(DungeonViewController listener);

  /**
   * This is used to update the model of the dungeon.
   *
   * @param model the model of the dungeon.
   */
  void updateDungeon(Dungeon model);
}

