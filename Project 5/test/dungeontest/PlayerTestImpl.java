package dungeontest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import dungeon.Dungeon;
import dungeon.MockDungeonImpl;
import dungeon.Player;
import dungeon.PlayerImpl;

import static org.junit.Assert.assertEquals;

/**
 * Tests the PlayerImpl class.
 */
public class PlayerTestImpl {

  Dungeon dungeon;
  Player player;

  /**
   * Sets up the test for PlayerImpl.
   */
  @Before
  public void setup() {
    dungeon = new MockDungeonImpl(4, 4, 2, true, 50,
            5);
    player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
  }

  /**
   * Test id the player contains the correct list of treasures.
   */
  @Test
  public void testPlayerTreasure() {
    assertEquals("{DIAMOND=1, SAPPHIRE=1, RUBY=1}",
            dungeon.getFinalPlayerTreasureList().toString());
  }

  /**
   * Test if error is thrown when player path is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyPlayerPath() {
    List<Integer> playerPath = null;
    Player test = new PlayerImpl("adam", playerPath, dungeon.getPlayerTreasureList());
  }

  /**
   * Test id error is thrown when player name is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyPlayerName() {
    Player test = new PlayerImpl("", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
  }

  /**
   * Test if error is thrown when player treasure name is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullPlayerName() {
    Player test = new PlayerImpl("", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
  }

  /**
   * Test to see if the player can pick up the treasure from a node or not.
   */
  @Test
  public void playerPickTreasures() {
    assertEquals("{DIAMOND=0, SAPPHIRE=1, RUBY=3}",
            dungeon.getFinalPlayerTreasureList().toString());
  }
}
