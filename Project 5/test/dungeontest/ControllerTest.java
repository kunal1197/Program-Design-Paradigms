package dungeontest;

import org.junit.Test;

import java.io.StringReader;
import java.util.NoSuchElementException;

import dungeon.Dungeon;
import dungeon.DungeonConsoleController;
import dungeon.DungeonController;
import dungeon.MockDungeonImpl;
import dungeon.Monster;
import dungeon.MonsterImpl;
import dungeon.Player;
import dungeon.PlayerImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the DungeonConsoleController class.
 */
public class ControllerTest {

  /**
   * Test to see if the Controller can handle Illegal Inputs.
   */
  @Test
  public void testInvalidInput() {
    Readable input = new StringReader("P 2 yu S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);
    assertTrue(output.toString().contains("\nInvalid Input\nPlease enter a valid value\n"));
  }

  /**
   * Check if the player can finish the dungeon game by reaching the end point.
   */
  @Test
  public void playerFinishGameByReachingEnd() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("The player has reached end point\n"
            + "Game Over!!"));
  }

  /**
   * Check if the player is able to move successfully through one node to another in the dungeon.
   */
  @Test
  public void playerMoveBetweenNodes() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("The Player's Location is 15 Node"));
    assertTrue(output.toString().contains("The Player's Location is 14 Node"));
  }

  /**
   * Test if the Player has the ability to shoot arrow the Dungeon.
   */
  @Test
  public void playerCanShoot() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("Arrow shot in the dark"));
    assertTrue(output.toString().contains("Enter the Distance you want to shoot"));
  }

  /**
   * Test if the Player can pick Treasure from Dungeon.
   */
  @Test
  public void playerCanPickTreasure() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("What do you want to pick?"));
    assertTrue(output.toString().contains("Press 1 for treasure"));
    assertTrue(output.toString().contains("You have picked up all the treasures"));
  }

  /**
   * Test if the Player can pick Arrows from Dungeon.
   */
  @Test
  public void playerCanPickArrow() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("What do you want to pick?"));
    assertTrue(output.toString().contains("Press 2 for arrow"));
    assertTrue(output.toString().contains("You have picked up all the arrows"));
  }

  /**
   * Check the ability of arrow to hit monster.
   */
  @Test
  public void arrowCanHitOtyugh() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("Arrow shot in the dark"));
    assertTrue(output.toString().contains("Otyugh Hit by Arrow"));
  }

  /**
   * Test when the Player Hits an Arrow, the Otyugh can take damage.
   */
  @Test
  public void otyughTakesDamage() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("Arrow shot in the dark"));
    assertTrue(output.toString().contains("Otyugh Hit by Arrow"));
    assertTrue(output.toString().contains("Otyugh Health is 50"));
  }

  /**
   * Test when a damaged Otyugh when hit by Arrow, check if it is dying or not.
   */
  @Test
  public void otyughCanBeKilled() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("Arrow shot in the dark"));
    assertTrue(output.toString().contains("Otyugh Hit by Arrow"));
    assertTrue(output.toString().contains("Otyugh is Dead"));
  }

  /**
   * Check if there can be weak smell detected when monster is at 2 nodes away.
   */
  @Test
  public void otyughWeakSmellDetected() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);
    assertTrue(output.toString().contains("You can smell something less Pungent nearby"));
  }

  /**
   * Check if there can be Strong smell detected when monster is at 1 node away.
   */
  @Test
  public void otyughStrongSmellOneMonster() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);
    assertTrue(output.toString().contains("You can smell something more Pungent nearby"));
  }

  /**
   * Check if there can be Strong smell detected when multiple monsters are 2 nodes away.
   */
  @Test
  public void otyughStrongSmellMultipleMonster() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);
    assertTrue(output.toString().contains("You can smell multiple smells more Pungent nearby"));
  }

  /**
   * Check if player can be killed by monster when inside same node with it.
   */
  @Test
  public void checkPlayerCanBeKilledByMonster() {
    Readable input = new StringReader("P 2 M 14");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("Player is in a Cave with Otyugh"));
    assertTrue(output.toString().contains("You have been killed by the Otyugh"));
  }

  /**
   * Check player avoidance ability when the monster is damaged and player is in the same node with
   * it.
   */
  @Test
  public void checkPlayerAvoidanceAbility() {
    Readable input = new StringReader("P 2 S 1 W M 14");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertTrue(output.toString().contains("Player is in a Cave with Otyugh"));
    assertTrue(output.toString().contains("The Otyugh health is at 50%, there is a chance you might"
            + " die."));
    assertTrue(output.toString().contains("You have been killed by the Otyugh"));
  }

  /**
   * Check if Otyugh is Present at the last ending node of the cave.
   */
  @Test
  public void testOtyughPresentAtEndPoint() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertEquals("12", String.valueOf(dungeon.getEndPoint()));
    assertTrue(output.toString().contains("The Player's Location is 13 Node\n"
            + "You find all these gems here\n"
            + "Cave - []\n"
            + "The number of arrows you find here\n"
            + "0\n"
            + "The number of arrows the player has\n"
            + "3\n"
            + "The number of Gems the player has\n"
            + "{DIAMOND=1, SAPPHIRE=1, RUBY=1}\n"
            + "Doors Lead to\n"
            + "[N, W, S]\n"
            + "Move, Pickup, or Shoot (M-P-S)?\n"
            + "\n"
            + "Where do you want to go? \n"
            + "9 will lead to N\n"
            + "12 will lead to W\n"
            + "1 will lead to S\n"
            + "Enter Cell Number you want to go next\n"
            + "\n"
            + "Player is in a Cave with Otyugh\n"
            + "The Otyugh health is at 50%, there is a chance you might die.\n"
            + "You have been killed by the Otyugh\n"
            + "Game Over!!"));
  }


  /**
   * Check if player has 3 crooked arrows at the beginning of the game.
   */
  @Test
  public void testPlayerHasArrowsSet() {
    Readable input = new StringReader("P 2 S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);

    assertEquals("15", String.valueOf(dungeon.getStartPoint()));
    assertTrue(output.toString().contains("The Player's Location is 15 Node\n"
            + "You find all these gems here\n"
            + "Cave - []\n"
            + "The number of arrows you find here\n"
            + "3\n"
            + "The number of arrows the player has\n"
            + "3\n"));
  }

  /**
   * Check if the id missing input in controller can handle NoSuchElementException or not.
   */
  @Test(expected = NoSuchElementException.class)
  public void testMissingOutput() {
    Readable input = new StringReader("P 2");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);
  }

  /**
   * Test to see if it throws error for failing appendable/ null model.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFailingAppendable() {
    Readable input = new StringReader("P 2");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(null, null, null);
  }

  /**
   * Test to see if the Controller can handle Illegal Inputs for Shooting.
   */
  @Test
  public void InputValidityTestShooting() {
    Readable input = new StringReader("P 2 yu S 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);
    assertTrue(output.toString().contains("\nInvalid Input\nPlease enter a valid value\n"));
  }

  /**
   * Test to see if the Controller can handle Illegal Inputs for Shoot Distance.
   */
  @Test
  public void InputValidityTestShootDistance() {
    Readable input = new StringReader("P 2 S hu 1 W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);
    assertTrue(output.toString().contains("\nIncomplete Inputs"));
  }

  /**
   * Test to see if the Controller can handle Illegal Inputs for Shoot Direction.
   */
  @Test
  public void InputValidityTestShootDirection() {
    Readable input = new StringReader("P 2 S 1 jk W S 1 W M 14 M 2 M 1 P 1 P 1 M 13 S 1 W M 12");
    Appendable output = new StringBuilder();
    Dungeon dungeon = new MockDungeonImpl(4, 4, 2, true,
            50, 5);
    Player player = new PlayerImpl("kunal", dungeon.getShortestPath(),
            dungeon.getPlayerTreasureList());
    Monster monster = new MonsterImpl(5, dungeon.populateOtyughs());
    DungeonController c = new DungeonConsoleController(input, output);
    c.playGame(dungeon, player, monster);
    assertTrue(output.toString().contains("\nInvalid Direction\n"));
  }

}
