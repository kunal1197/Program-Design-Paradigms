package dungeon;

import java.util.List;
import java.util.Map;

/**
 * This interface represents a player in the game, with its name, current path, and the treasures
 * it has collected.
 */
public interface Player {

  /**
   * The method returns the treasures the player has collected.
   *
   * @return the name of the player
   */
  Map<Treasure, Integer> playerTreasureList();

  /**
   * The method returns the name of the player.
   *
   * @return the name of the player.
   */
  String getPlayerName();

  /**
   * The method returns the current path of the player.
   *
   * @return the current path of the player.
   */
  List<Integer> getPlayerPath();

  /**
   * The method returns move list possible.
   *
   * @return possible move list.
   */
  List<Integer> getMoveList();
}
