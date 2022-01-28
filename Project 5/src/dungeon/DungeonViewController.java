package dungeon;

/**
 * Represents a Controller for Dungeon Game: handle user moves by executing them using the model;
 * convey move outcomes to the user in form of view.
 */
public interface DungeonViewController {

  /**
   * Execute a single game of maze Dungeon given a Dungoen Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a dungeon model.
   */
  void playGame(Dungeon d, Player p, Monster m);

  /**
   * This is used to move the player in the dungeon.
   *
   * @param i input is the direction of the player.
   */
  void movePlayer(int i);

  /**
   * This is used to find the possible move directions of the player.
   *
   * @param direction is the direction of the player.
   * @return player location.
   */
  int possibleDirections(String direction);

  /**
   * This is used to update the view when the player moves.
   *
   * @param view is the view of the game.
   */
  void updateView(DungeonView view);

  /**
   * This is used to pick up the treasure.
   *
   * @return the treasure.
   */
  String pickTreasure();

  /**
   * This is used to pick up the Arrows.
   *
   * @return the arrows.
   */
  String pickArrow();

  /**
   * This is used to pich the Treasure and the Arrow together.
   *
   * @return the treasure and the arrow.
   */
  String pickBoth();

  /**
   * This is used to shoot the arrows.
   *
   * @param distance  is the distance of the arrow.
   * @param direction is the direction of the arrow.
   * @return the message.
   */
  String shootArrow(int distance, String direction);

  /**
   * This is used to handle the player's movement through the maze via mouse clicks.
   *
   * @param x is the x coordinate of the mouse click.
   * @param y is the y coordinate of the mouse click.
   */
  void handleMouseClick(int x, int y);

  /**
   * This is used to start a new game with edited new parameters.
   *
   * @param dungeonLength     is the length of the dungeon.
   * @param dungeonBreadth    is the breadth of the dungeon.
   * @param interConnectivity is the interconnectivity of the dungeon.
   * @param wrapping          Value is the wrapping value of the dungeon.
   * @param treasure          Percent is the percentage of treasure in the dungeon.
   * @param monsterNo         is the number of monsters in the dungeon.
   */
  void editConfig(int dungeonLength, int dungeonBreadth, int interConnectivity, boolean wrapping,
                  int treasure, int monsterNo);

  /**
   * This is used to restart the game.
   */
  void restartGame();
}

