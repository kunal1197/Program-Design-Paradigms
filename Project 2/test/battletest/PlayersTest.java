package battletest;

import org.junit.Before;
import org.junit.Test;

import battle.MockClass;
import battle.Players;

import static org.junit.Assert.assertEquals;

/**
 * Players Test class.
 */
public class PlayersTest {

  Players player1;
  Players player2;

  /**
   * Setup test for Players.
   */
  @Before
  public void setup() {
    player1 = new Players(MockClass.getDiceSum(), MockClass.getDiceSum(), MockClass.getDiceSum(),
            MockClass.getDiceSum());
    player2 = new Players(MockClass.getDiceSum(), MockClass.getDiceSum(), MockClass.getDiceSum(),
            MockClass.getDiceSum());
  }

  /**
   * Test the strength of player One.
   */
  @Test
  public void testStrengthPlayerOne() {
    assertEquals(10, player1.getStrength());
  }

  /**
   * Test the constitution of player one.
   */
  @Test
  public void testConstitutionPlayerOne() {
    assertEquals(14, player1.getCharisma());
  }

  /**
   * Test the dexterity of player one.
   */
  @Test
  public void testDexterityPlayerOne() {
    assertEquals(14, player1.getDexterity());
  }

  /**
   * Test the charisma of player one.
   */
  @Test
  public void testCharismaPlayerOne() {
    assertEquals(13, player1.getCharisma());
  }

  /**
   * Test the strength of player two.
   */
  @Test
  public void testStrengthPlayerTwo() {
    assertEquals(16, player2.getStrength());
  }

  /**
   * Test the constitution of player two.
   */
  @Test
  public void testConstitutionPlayerTwo() {
    assertEquals(14, player2.getConstitution());
  }

  /**
   * Test the dexterity of player two.
   */
  @Test
  public void testDexterityPlayerTwo() {
    assertEquals(12, player2.getDexterity());
  }

  /**
   * Test the charisma of player two.
   */
  @Test
  public void testCharismaPlayerTwo() {
    assertEquals(11, player2.getCharisma());
  }

  /**
   * Test the equality for Players string.
   */
  @Test
  public void testToString() {
    assertEquals("\n" +
            " Strength->10\n" +
            " Constitution->12\n" +
            " Dexterity->15\n" +
            " Charisma->13\n", player1.toString());
  }

}
