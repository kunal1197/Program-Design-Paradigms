package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is the implementation of the Player interface, which is used create Player details.
 */
public class PlayerImpl implements Player {

  private final String playerName;
  private final List<Integer> playerPath;
  private final Map<Treasure, Integer> treasureList;

  /**
   * This is the constructor of the PlayerImpl class.
   *
   * @param playerName   player name.
   * @param playerPath   player path.
   * @param treasureList treasure list.
   */
  public PlayerImpl(String playerName, List<Integer> playerPath, Map<Treasure,
          Integer> treasureList) {
    nullChecks(playerName, playerPath);
    this.playerName = playerName;
    this.playerPath = playerPath;
    this.treasureList = treasureList;
  }

  private void nullChecks(String playerName, List<Integer> playerPath) {
    if (playerName == null || playerName.equals("")) {
      throw new IllegalArgumentException("Player Name cannot be empty");
    }
    if (playerPath == null) {
      throw new IllegalArgumentException("Player path cannot be empty");
    }
  }

  /**
   * This method is used to get the treasure list.
   *
   * @return treasure list.
   */
  @Override
  public Map<Treasure, Integer> playerTreasureList() {
    return treasureList;
  }

  /**
   * This method is used to get the player name.
   *
   * @return player name.
   */
  @Override
  public String getPlayerName() {
    return playerName;
  }

  /**
   * This method is used to get the player path.
   *
   * @return player path.
   */
  @Override
  public List<Integer> getPlayerPath() {
    return playerPath;
  }

  /**
   * This method is used to get the possible move list.
   *
   * @return list of possible move.
   */
  @Override
  public List<Integer> getMoveList() {
    List<Integer> moveList = new ArrayList<>();
    return moveList;
  }


  /**
   * Used to get the String representation of Player Object.
   *
   * @return Player object String.
   */
  public String toString() {
    return String.format("Player Details: \nPlayer Name->%s\n Current Location->%s"
                    + " TreasureList->%s",
            this.getPlayerName(),
            this.getPlayerPath(),
            this.playerTreasureList());
  }
}
