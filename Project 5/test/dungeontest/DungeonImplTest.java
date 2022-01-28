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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
  }

  /**
   * Test to check the Dungeon Generated.
   */
  @Test
  public void testDungeonObj() {
    assertEquals("  0T--    1T      2C      3C    \n"
            + "              |       |            \n"
            + "--4T--    5C--    6C--    7T    \n"
            + "             |          \n"
            + "  8C--    9T--    10C     11C   \n"
            + "              |      |      \n"
            + "--12T     13C--   14C--   15C   \n"
            + "        |              |      \n\n", dungeon.toString());
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
            50, 5);
  }

  /**
   * Test if error is thrown if the Interconnectivity is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeInterconnectivity() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, -2, true,
            50, 5);
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
    assertEquals("[5, 1, 2, 14, 13, 12, 15]", String.valueOf(player.getPlayerPath()));
  }

  /**
   * Test if error is thrown if the maze size is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMazeSize() {
    Dungeon dungeon = new MockDungeonImpl(2, 2, 20, true,
            50, 5);
  }

  /**
   * Test if error is thrown if the maze size is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNegativeMazeSize() {
    Dungeon dungeon = new MockDungeonImpl(-3, -3, 20, true,
            50, 5);
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
    assertEquals("{0=[], 1=[SAPPHIRE, DIAMOND, RUBY], 2=[], 3=[DIAMOND, RUBY, DIAMOND],"
                    + " 4=[SAPPHIRE], 5=[], 6=[], 7=[], 8=[], 9=[], 10=[], 11=[], 12=[],"
                    + " 13=[], 14=[], 15=[]}",
            dungeon.getFinalPlayerTreasureList().toString());
  }

  /**
   * Test to see if the maze is correctly wrapping or not.
   */
  @Test
  public void testIsWrapping() {
    List<Integer> list = dungeon.edgeAdjacencyList().get(3);
    boolean test = list.contains(15);
    assertEquals(true, test);
  }

  /**
   * Test to see if the maze is correctly non-wrapping or not.
   */
  @Test
  public void testIsNonWrapping() {
    for (int i = 0; i < dungeon.getSizeLength(); i++) {
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
    assertEquals("[SAPPHIRE, DIAMOND, RUBY]", treasure.get(1).toString());
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
            50, 5);
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

  // Project 4 Tests

  /**
   * Test to see if the Arrows are populated in the dungeon.
   */
  @Test
  public void testArrowsPopulatedInDungeon() {
    assertEquals("[0, 0, 2, 0, 3, 0, 2, 3, 1, 1, 0, 3, 0, 0, 0, 3]",
            String.valueOf(dungeon.getArrowLocations()));
  }

  /**
   * Test to see if the Otyughs are populated in the dungeon and in which nodes.
   */
  @Test
  public void testOyughsPopulatedInDungeon() {
    assertEquals("[0, 4, 1, 13, 12]",
            String.valueOf(dungeon.populateOtyughs()));
  }

  /**
   * Test to see if the Otyughs numbers are equal to the provided number.
   */
  @Test
  public void testNumberOfOtyugh() {
    assertEquals("5",
            String.valueOf(dungeon.populateOtyughs().size()));
  }

  /**
   * Test to see if error is thrown if otyugh number is greater than the number of vertices.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testOtyughNumbers() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 52);
  }

  /**
   * Test to see if error is thrown if otyugh number is negative or 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeOtyughNumbers() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, -2);
  }

  /**
   * Test to see if there is always a monster present in the dungeon at the end point.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEndPointOtyugh() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    assertTrue(dungeon.populateOtyughs().contains(dungeon.getEndPoint()));
  }

  /**
   * Test to see if there is no Otyugh in the dungeon at the start point.
   */
  @Test
  public void testStartPointOtyugh() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    assertFalse(dungeon.populateOtyughs().contains(dungeon.getStartPoint()));
  }

  /**
   * Test to see if there is Otyugh can only occupy caves, not tunnels.
   */
  @Test
  public void testOtyughCavePresence() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    List<Integer> otyughs = dungeon.populateOtyughs();
    for (int i = 0; i < otyughs.size() - 1; i++) {
      assertEquals("Cave", dungeon.assignCaveOrTunnel(otyughs.get(i)));
    }
  }

  /**
   * Test if the caves can contain Treasure with Arrows or not.
   */
  @Test
  public void testArrowAndTreasure() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Map<Integer, List<Treasure>> list = dungeon.getTreasureList();
    List<Integer> arrow = dungeon.getArrowLocations();
    String temp = "";
    for (int i = 0; i < arrow.size(); i++) {
      if (arrow.get(i) > 0 && list.get(i) != null) {
        temp = "Arrow - " + arrow.get(i) + ", Treasure - " + list.get(i);
        break;
      }
    }
    assertEquals("Arrow - 2, Treasure - [RUBY, SAPPHIRE]", temp);
  }

  /**
   * Test if the arrows are not always present with the treasure.
   */
  @Test
  public void testArrowAndTreasureNotTogether() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Map<Integer, List<Treasure>> list = dungeon.getTreasureList();
    List<Integer> arrow = dungeon.getArrowLocations();
    String temp = "";
    for (int i = 0; i < arrow.size(); i++) {
      if (arrow.get(i) == 0 && list.get(i) != null) {
        temp = "Arrow - " + arrow.get(i) + ", Treasure - " + list.get(i);
        break;
      }
    }
    assertEquals("Arrow - 0, Treasure - [DIAMOND]", temp);
  }

  /**
   * Test if the arrows are found in both cave and tunnels.
   */
  @Test
  public void testArrowsCaveTunnel() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Map<Integer, List<Treasure>> list = dungeon.getTreasureList();
    List<Integer> arrow = dungeon.getArrowLocations();
    String temp = "";
    String temp1 = "";
    for (int i = 0; i < arrow.size(); i++) {
      if (arrow.get(i) > 0 && (dungeon.assignCaveOrTunnel(i).equals("Cave"))) {
        temp = "Arrow - " + arrow.get(i) + ", Node Type - " + dungeon.assignCaveOrTunnel(i);
        break;
      }
    }
    for (int i = 0; i < arrow.size(); i++) {
      if (arrow.get(i) > 0 && (dungeon.assignCaveOrTunnel(i).equals("Tunnel"))) {
        temp1 = "Arrow - " + arrow.get(i) + ", Node Type - " + dungeon.assignCaveOrTunnel(i);
        break;
      }
    }
    assertEquals("Arrow - 2, Node Type - Cave", temp);
    assertEquals("Arrow - 3, Node Type - Tunnel", temp1);
  }

  /**
   * Test if the arrows and Treasure are present in the same Quantity.
   */
  @Test
  public void testArrowAndTreasureQuantity() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Map<Integer, List<Treasure>> list = dungeon.getTreasureList();
    List<Integer> arrow = dungeon.getArrowLocations();
    int count = 0;
    int count1 = 0;
    for (int i = 0; i < arrow.size(); i++) {
      if (arrow.get(i) > 0) {
        count++;
      }
    }
    int percent = (int) ((double) (count * 100) / dungeon.getVertices());
    assertEquals(dungeon.getTreasurePercent(), percent);
  }

  /**
   * Test to see if there is no presence of smell, when no Otyughs are present.
   */
  @Test
  public void testNoSmell() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    assertEquals("No smell nearby",
            dungeon.getOtyughSmell(10));
  }

  /**
   * Test to see if there is a presence of strong smell with single monster, when Otyughs are
   * present.
   */
  @Test
  public void testStrongSmellOneMonster() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    assertEquals("You can smell something more Pungent nearby",
            dungeon.getOtyughSmell(7));
  }

  /**
   * Test to see if there is a presence of strong smell with multiple monsters, when Otyughs are
   * present.
   */
  @Test
  public void testStrongSmellMultipleMonster() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    assertEquals("You can smell multiple smells more Pungent nearby",
            dungeon.getOtyughSmell(5));
  }

  /**
   * Test to see if there is a presence of weak smell, when Otyughs are present.
   */
  @Test
  public void testWeakSmell() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    assertEquals("You can smell something less Pungent nearby",
            dungeon.getOtyughSmell(13));
  }

  /**
   * Test to see if player can die when Monster is present in the same node.
   */
  @Test
  public void testPlayerKill() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    assertEquals("You have been killed by the Otyugh\n",
            dungeon.checkPlayerAvoidanceAbility(dungeon.getEndPoint()).get(1));
  }

  /**
   * Test to see if player has a chance to escape when injured Monster is present in the same node.
   */
  @Test
  public void testPlayerKillChances() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    dungeon.updatePlayerLocation(5);
    dungeon.shootArrow(1, "E");
    dungeon.updatePlayerLocation(6);

    assertEquals("You have been killed by the Otyugh\n",
            dungeon.checkPlayerAvoidanceAbility(dungeon.getEndPoint()).get(1));
  }

  /**
   * Test to see if player has 3 arrows in the beginning of the game.
   */
  @Test
  public void testPlayerArrowInitail() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    assertEquals("3",
            String.valueOf(dungeon.getPlayerArrowlist()));
  }

  /**
   * Test to see if the arrow can only travel in straight line in cave.
   */
  @Test
  public void testArrowInCave() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    dungeon.updatePlayerLocation(5);
    assertEquals("Arrow Shot and it hit the wall\n", dungeon.shootArrow(1, "N"));
  }

  /**
   * Test to see if the number of arrow caves in the dungeon is equal to percentage of the treasure.
   */
  @Test
  public void testArrowPopulatePercent() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    int c = 0;
    for (int i = 0; i < dungeon.getArrowLocations().size(); i++) {
      if (dungeon.getArrowLocations().get(i) > 0) {
        c++;
      }
    }
    int percent = (int) ((double) (dungeon.getTreasurePercent() * dungeon.getVertices()) / 100);
    assertEquals(percent, c);
  }

  /**
   * Test to see if the player has the ability to shoot an arrow.
   */
  @Test
  public void testShootArrow() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());


    assertEquals("Arrow shot in the dark\n", dungeon.shootArrow(1, "E"));
  }

  /**
   * Test to see if the arrow has travelled all the distance and not hit the monster.
   */
  @Test
  public void testFullArrowDistance() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());


    assertEquals("Arrow did not hit the monster\n", dungeon.shootArrow(2, "E"));
  }

  /**
   * Test to see if the arrow has travelled all the distance and not hit the monster.
   */
  @Test
  public void testArrowHitWall() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    dungeon.updatePlayerLocation(5);
    assertEquals("Arrow Shot and it hit the wall\n", dungeon.shootArrow(1, "N"));
  }

  /**
   * Test to see if the arrow can travel through the curved tunnel.
   */
  @Test
  public void testCrookedArrows() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    assertEquals("10", String.valueOf(dungeon.getPlayerLocation()));
    assertEquals("6", String.valueOf(dungeon.getEndPoint()));
    assertEquals("Arrow did not hit the monster\n", dungeon.shootArrow(2, "E"));
  }

  /**
   * Test to see if the Otyugh takes 2 hits to be killed or not.
   */
  @Test
  public void testOtyughTwoHit() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    dungeon.updatePlayerLocation(5);
    dungeon.shootArrow(1, "E");
    dungeon.shootArrow(1, "E");
    assertEquals("Arrow shot in the dark\n", dungeon.shootArrow(1, "E"));
  }

  /**
   * Test to see if the Otyugh can only be killed if the exact distance is given to shoot and not
   * if it comes in the path.
   */
  @Test
  public void testExactOtyughDistanceKill() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    dungeon.updatePlayerLocation(5);
    assertEquals("Arrow did not hit the monster\n", dungeon.shootArrow(2, "E"));
  }

  /**
   * Test player pick up weapon and the count is updated.
   */
  @Test
  public void testPlayerPickWeapon() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    assertEquals(3, dungeon.getPlayerArrowlist());
    dungeon.pickArrows(1, dungeon.getPlayerLocation());
    assertEquals(4, dungeon.getPlayerArrowlist());
  }

  /**
   * Test player pick up weapon and the count is updated.
   */
  @Test
  public void testPlayerPickTreasure() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    assertEquals("{RUBY=0, SAPPHIRE=0, DIAMOND=0}",
            String.valueOf(dungeon.getPlayerTreasureList()));
    dungeon.pickUpTreasure(Treasure.DIAMOND, dungeon.getPlayerLocation());
    dungeon.pickUpTreasure(Treasure.SAPPHIRE, dungeon.getPlayerLocation());
    dungeon.pickUpTreasure(Treasure.RUBY, dungeon.getPlayerLocation());
    assertEquals("{RUBY=1, SAPPHIRE=1, DIAMOND=1}",
            String.valueOf(dungeon.getPlayerTreasureList()));
  }

  /**
   * Test player arrow count is updated when he shoots an arrow.
   */
  @Test
  public void testArrowCountUpdatedOnShooting() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    assertEquals(3, dungeon.getPlayerArrowlist());
    dungeon.shootArrow(1, "W");
    assertEquals(2, dungeon.getPlayerArrowlist());
  }

  /**
   * Test player arrows are exhausted when he shoots all arrows.
   */
  @Test
  public void testPlayerArrowFinish() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());

    assertEquals(3, dungeon.getPlayerArrowlist());
    dungeon.shootArrow(1, "W");
    dungeon.shootArrow(1, "W");
    dungeon.shootArrow(1, "W");
    dungeon.shootArrow(1, "W");
    assertEquals(0, dungeon.getPlayerArrowlist());
  }

  /**
   * Test that the number of Otyughs cannot be greater than the number of Otyughs in the dungeon.
   */
  @Test
  public void testNumberOfOtyughGreaterThanCaves() {
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kk", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    int count = 0;
    for (int i = 0; i < dungeon.getVertices(); i++) {
      if (dungeon.assignCaveOrTunnel(i).equals("Cave")) {
        count++;
      }
    }
    assertTrue(count > dungeon.populateOtyughs().size());
  }


}

