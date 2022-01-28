package dungeontest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import dungeon.Dungeon;
import dungeon.MockDungeonImpl;
import dungeon.Player;
import dungeon.PlayerImpl;
import dungeon.Treasure;

import static org.junit.Assert.assertEquals;

/**
 * Tests the DungeonImpl class.
 */
public class DungeonImplTest {

  Dungeon dungeon;
  Player player;

  /**
   * Setup test for PlayerImpl.
   */
  @Before
  public void setup() {
    dungeon = new MockDungeonImpl(4, 4, 2, true, 50);
    player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
  }

  /**
   * Test to check the Dungeon Generated.
   */
  @Test
  public void testDungeonObj() {
    assertEquals("  0T--    1T      2C      3C    \n" +
            "              |       |            \n" +
            "--4T--    5C--    6C--    7T    \n" +
            "             |          \n" +
            "  8C--    9T--    10C     11C   \n" +
            "              |      |      \n" +
            "--12T     13C--   14C--   15C   \n" +
            "        |              |      \n\n", dungeon.toString());
  }

  /**
   * Test to check if the player has reached the end Point.
   */
  @Test
  public void gameFinishCondition() {
    int size = player.getPlayerPath().size();
    assertEquals(String.valueOf(dungeon.getEndPoint()),
            Integer.toString(player.getPlayerPath().get(size - 1)));
  }

  /**
   * Test if error is thrown if the Interconnectivity is valid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInterconnectivity() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 20, true,
            50);
  }

  /**
   * Test if error is thrown if the Interconnectivity is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeInterconnectivity() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, -2, true,
            50);
  }

  /**
   * Test the valid Distance between two points.
   */
  @Test
  public void testDistance() {
    assertEquals(5, dungeon.getShortestDistance());
  }

  /**
   * Test to check if the player path formed is correct or not.
   */
  @Test
  public void testPlayerPath() {
    assertEquals("[15, 14, 10, 6, 7, 3]", String.valueOf(player.getPlayerPath()));
  }

  /**
   * Test if error is thrown if the maze size is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMazeSize() {
    Dungeon dungeon = new MockDungeonImpl(2, 2, 20, true,
            50);
  }

  /**
   * Test if error is thrown if the maze size is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNegativeMazeSize() {
    Dungeon dungeon = new MockDungeonImpl(-3, -3, 20, true,
            50);
  }

  /**
   * Test if error is thrown if the maze length is invalid.
   */
  @Test
  public void testGetSizeLenth() {
    assertEquals(4, dungeon.getSizeLength());
  }

  /**
   * Test if error is thrown if the maze width is invalid.
   */
  @Test
  public void testGetSizeBreadth() {
    assertEquals(4, dungeon.getSizeLength());
  }

  /**
   * Test to see if the verices are assigned correctly.
   */
  @Test
  public void getVertices() {
    assertEquals(16, dungeon.getVertices());
  }

  /**
   * Test to see if the degree of interconnectivity is correct.
   */
  @Test
  public void testGetInterconnectivity() {
    assertEquals(2, dungeon.getInterconnectivity());
  }

  /**
   * Test to see if the wrapping value is correct.
   */
  @Test
  public void testGetWrappingValue() {
    assertEquals(true, dungeon.getWrappingValue());
  }

  /**
   * Test to see if the treasure value is correct.
   */
  @Test
  public void testGetTreasurePercent() {
    assertEquals(50, dungeon.getTreasurePercent());
  }

  /**
   * Test to see if the treasure is correctly populated or not in the maze.
   */
  @Test
  public void testPopulateTreasure() {
    assertEquals("{0=[RUBY], 1=[SAPPHIRE], 2=[], 3=[], 4=[SAPPHIRE, RUBY]," +
                    " 5=[], 6=[], 7=[], 8=[], 9=[], 10=[], 11=[], 12=[], 13=[], 14=[], 15=[]}",
            dungeon.getTreasureList().toString());
  }

  /**
   * Test to see if the maze is correctly wrapping or not.
   */
  @Test
  public void testIsWrapping() {
    List<Integer> list = dungeon.edgeAdjacencyList().get(0);
    boolean test = list.contains(12);
    assertEquals(true, test);
  }

  /**
   * Test to see if the maze is correctly non-wrapping or not.
   */
  @Test
  public void testIsNonWrapping() {
    for (int i = 0 ; i  < dungeon.getSizeLength(); i++) {
      List<Integer> list = dungeon.edgeAdjacencyList().get(i);
      boolean test = list.contains(i + (dungeon.getSizeBreadth() * dungeon.getSizeLength()));
      assertEquals(false, test);
    }
  }

  /**
   * Test to see if cave is assigned correctly to the node.
   */
  @Test
  public void testCaveAssigned() {
    assertEquals("Cave", dungeon.assignCaveOrTunnel(7));
  }

  /**
   * Test to see if tunnel is assigned correctly to the node.
   */
  @Test
  public void testTunnelAssigned() {
    assertEquals("Tunnel", dungeon.assignCaveOrTunnel(9));
  }

  /**
   * Test to see if the player can move west.
   */
  @Test
  public void playerMovesWest() {
    List<Integer> locations = dungeon.getNeighbour(1, 3);
    List<Integer> playerPath = player.getPlayerPath();

    assertEquals(true, locations.contains(playerPath.get(1)));
  }

  /**
   * Test to see if the player can move south.
   */
  @Test
  public void playerMovesSouth() {
    List<Integer> locations = dungeon.getNeighbour(3, 3);
    List<Integer> playerPath = player.getPlayerPath();

    assertEquals(true, locations.contains(playerPath.get(5)));
  }

  /**
   * Test to see if the player can move north.
   */
  @Test
  public void playerMovesNorth() {
    List<Integer> locations = dungeon.getNeighbour(1, 2);
    List<Integer> playerPath = player.getPlayerPath();

    assertEquals(true, locations.contains(playerPath.get(2)));
  }

  /**
   * Test to see if the player can move east.
   */
  @Test
  public void playerMovesEast() {
    List<Integer> locations = dungeon.getNeighbour(0, 2);
    List<Integer> playerPath = player.getPlayerPath();

    assertEquals(true, locations.contains(playerPath.get(3)));
  }

  /**
   * Test to see the interconnectivity is applied in the maze or not.
   */
  @Test
  public void testValidateInterConnectivity() {
    int size = dungeon.interconnectivityList().size();
    int validate = size - dungeon.getVertices() - 1;
    assertEquals(dungeon.getInterconnectivity(), validate);
  }

  /**
   * Test to see if the Cave Node can hold multiple treasures.
   */
  @Test
  public void testCaveMultipleTreasures() {
    Map<Integer, List<Treasure>> treasure = dungeon.getTreasureList();
    assertEquals("[SAPPHIRE, DIAMOND]", treasure.get(1).toString());
  }

  /**
   * Test to see if the Cave Node can hold zero treasures.
   */
  @Test
  public void testCaveZeroTreasures() {
    Map<Integer, List<Treasure>> treasure = dungeon.getTreasureList();
    assertEquals("[]", treasure.get(2).toString());
  }

  /**
   * Test to see if the Cave Node can hold treasures of same type multiple times.
   */
  @Test
  public void testCaveOneTreasures() {
    Map<Integer, List<Treasure>> treasure = dungeon.getTreasureList();
    assertEquals("[DIAMOND, RUBY, DIAMOND]", treasure.get(4).toString());
  }

  /**
   * Check is any Tunnel does not hold any treasures.
   */
  @Test
  public void testTunnelTreasure() {
    Map<Integer, List<Treasure>> treasure = dungeon.getTreasureList();
    Map<Integer, List<Treasure>> tunnelTreasure = new HashMap<>();

    for (Integer i : treasure.keySet()) {
      if (treasure.get(i).isEmpty()) {
        tunnelTreasure.put(i, treasure.get(i));
      }
    }

    List<List<Integer>> edgeAdjacencyList = dungeon.edgeAdjacencyList();
    List<Integer> tunnelList = new ArrayList<>();
    int k = 0;
    for (List<Integer> i : edgeAdjacencyList) {
      k++;
      if (i.size() == 2) {
        tunnelList.add(k);
      }
    }

    assertEquals(tunnelList.size(), dungeon.getVertices() - tunnelTreasure.size() + 1);
  }

  /**
   * Test to see if the correct number of cave node are allocated the treasure according the
   * given treasure percentage.
   */
  @Test
  public void testTreasurePercentAllocation() {
    Map<Integer, List<Treasure>> treasure = dungeon.getTreasureList();
    int caves = 0;
    int treasureCaves = 0;

    for (int i = 0; i < dungeon.getVertices(); i++) {
      if (Objects.equals(dungeon.assignCaveOrTunnel(i), "Tunnel")) {
        caves++;
      }
    }
    for (Integer i : treasure.keySet()) {
      if (!treasure.get(i).isEmpty()) {
        treasureCaves++;
      }
    }

    double treasureCells = (double) (treasureCaves * 100) / caves;
    assertEquals((int) treasureCells, dungeon.getTreasurePercent());
  }

  /**
   * Test to see if error is thrown if the distance is less than 5.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testErrorDistance() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50);
    dungeon.getStartPoint();
    dungeon.getEndPoint();
  }

  /**
   * Test to see if the player can visit all the nodes in the graph.
   */
  @Test
  public void testPlayerGraphTraversal() {
    List<List<Integer>> edges = dungeon.interconnectivityList();
    List<Integer> flatten = new ArrayList<>();
    List<Integer> frequency = new ArrayList<>();
    edges.forEach(flatten::addAll);
    for (int i = 0; i < dungeon.getVertices(); i++) {
      frequency.add(Collections.frequency(flatten, i));
    }

    assertEquals(true, Collections.min(frequency) > 0);
  }
}
