package dungeontest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import dungeon.Dungeon;
import dungeon.DungeonView;
import dungeon.DungeonViewConsoleController;
import dungeon.DungeonViewController;
import dungeon.MockDungeonImpl;
import dungeon.MockDungeonSwingView;
import dungeon.Monster;
import dungeon.MonsterImpl;
import dungeon.Player;
import dungeon.PlayerImpl;
import dungeon.Treasure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test the DungeonViewController class.
 */
public class ControllerViewTest {

  Dungeon dungeon;
  Player player;
  Monster monster;
  DungeonView view;
  DungeonViewController controller;

  /**
   * Setup the test.
   */
  @Before
  public void setUp() {
    dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);

    List<Integer> path = dungeon.getShortestPath();
    Map<Treasure, Integer> playerBag = dungeon.getFinalPlayerTreasureList();

    player = new PlayerImpl("Kunal", path, playerBag);
    monster = new MonsterImpl(5, dungeon.populateOtyughs());

    // GUI Based Controller Game
    view = new MockDungeonSwingView(dungeon);
    controller = new DungeonViewConsoleController(dungeon, view);
  }

  /**
   * Test the North move method.
   */
  @Test
  public void moveNorthTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    controller.movePlayer(11);
    assertEquals(11, dungeon.getPlayerLocation());
  }

  /**
   * Test the South move method.
   */
  @Test
  public void moveSouthTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    controller.movePlayer(3);
    assertEquals(3, dungeon.getPlayerLocation());
  }

  /**
   * Test the West move method.
   */
  @Test
  public void moveWestTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    controller.movePlayer(14);
    assertEquals(14, dungeon.getPlayerLocation());
  }

  /**
   * Test the East move method.
   */
  @Test
  public void moveEastTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    controller.movePlayer(11);
    controller.movePlayer(7);
    controller.movePlayer(4);
    assertEquals(4, dungeon.getPlayerLocation());
  }

  /**
   * Test the Shoot method.
   */
  @Test
  public void shootTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    assertTrue(controller.shootArrow(1, "W").contains("Arrow shot in the dark"));
  }

  /**
   * Test the Monster can be hit or not.
   */
  @Test
  public void monsterHitTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    assertTrue(controller.shootArrow(1, "W").contains("Otyugh Hit by Arrow"));
  }

  /**
   * Test the Monster can die or not.
   */
  @Test
  public void monsterDieTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    controller.shootArrow(1, "W");
    assertTrue(controller.shootArrow(1, "W").contains("Otyugh is Dead"));
  }

  /**
   * Test arrow miss Otyugh.
   */
  @Test
  public void arrowMissTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    assertTrue(controller.shootArrow(1, "E").contains("Arrow Shot and it hit the wall"));
  }

  /**
   * Test the treasure can be picked up or not.
   */
  @Test
  public void treasurePickUpTest() {
    dungeon.updatePlayerLocation(3);
    assertEquals(3, dungeon.getPlayerLocation());
    assertTrue(controller.pickTreasure().contains("Picked up treasure"));
  }

  /**
   * Test the Arrow can be picked up or not.
   */
  @Test
  public void arrowPickUpTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    assertTrue(controller.pickArrow().contains("Picked up arrow"));
  }

  /**
   * Test the Treasure and Arrow can be picked up together or not.
   */

  @Test
  public void treasureAndArrowPickUpTest() {
    dungeon.updatePlayerLocation(4);
    assertEquals(4, dungeon.getPlayerLocation());
    assertTrue(controller.pickBoth().contains("Picked up treasure Picked up arrows"));
  }

  /**
   * Test if player can die or not.
   */
  @Test
  public void playerDieTest() {
    assertEquals(15, dungeon.getPlayerLocation());
    controller.movePlayer(14);
    controller.movePlayer(15);
    assertEquals(14, dungeon.getPlayerLocation());
  }


  /**
   * Test to see if the player can win the game or not.
   */
  @Test
  public void playerWinGame() {
    assertEquals(15, dungeon.getPlayerLocation());
    controller.pickArrow();
    controller.movePlayer(11);
    assertEquals(11, dungeon.getPlayerLocation());
    controller.movePlayer(7);
    assertEquals(7, dungeon.getPlayerLocation());
    controller.shootArrow(1, "E");
    assertTrue(controller.shootArrow(1, "E").contains("Otyugh is Dead"));
    controller.movePlayer(4);
    assertEquals(4, dungeon.getPlayerLocation());
    controller.movePlayer(8);
    assertEquals(8, dungeon.getPlayerLocation());
    controller.movePlayer(9);
    assertEquals(9, dungeon.getPlayerLocation());
    controller.movePlayer(13);
    assertEquals(13, dungeon.getPlayerLocation());
    controller.shootArrow(1, "W");
    assertTrue(controller.shootArrow(1, "W").contains("Otyugh is Dead"));
    controller.movePlayer(12);
    assertEquals(12, dungeon.getPlayerLocation());
    assertEquals(12, dungeon.getEndPoint());
  }


}
