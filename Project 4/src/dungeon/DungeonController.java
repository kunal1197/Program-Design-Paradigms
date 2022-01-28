package dungeon;

/**
 * The DungeonController Interface is the main controller for the dungeon.
 */
public interface DungeonController {

  /**
   * Execute a single game of maze Dungeon given a Dungoen Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a dungeon model.
   */
  void playGame(Dungeon d, Player p, Monster m);

}
