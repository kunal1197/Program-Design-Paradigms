package battletest;

import org.junit.Before;
import org.junit.Test;

import battle.Arena;
import battle.MockClass;

import static org.junit.Assert.assertEquals;

/**
 * Arena Test class.
 */
public class ArenaTest {

  Arena arenaPlayerOne;
  Arena arenaPlayerTwo;

  /**
   * Setup test for Arena.
   */
  @Before
  public void setup() {
    int strikingPowersPlayerOne = MockClass.getStrikingPowerPlayerOne();
    int avoidanceAbilityPlayerOne = MockClass.getAvoidanceAbilityPlayerOne();
    int potentialStrikingDamagePlayerOne = MockClass.getPotentialStrikingDamagePlayerOne();
    int actualDamagePlayerOne = MockClass.getActualDamagePlayerOne();
    arenaPlayerOne = new Arena(strikingPowersPlayerOne, avoidanceAbilityPlayerOne,
            potentialStrikingDamagePlayerOne, actualDamagePlayerOne);

    int strikingPowersPlayerTwo = MockClass.getStrikingPowerPlayerOne();
    int avoidanceAbilityPlayerTwo = MockClass.getAvoidanceAbilityPlayerOne();
    int potentialStrikingDamagePlayerTwo = MockClass.getPotentialStrikingDamagePlayerOne();
    int actualDamagePlayerTwo = MockClass.getActualDamagePlayerOne();
    arenaPlayerTwo = new Arena(strikingPowersPlayerTwo, avoidanceAbilityPlayerTwo,
            potentialStrikingDamagePlayerTwo, actualDamagePlayerTwo);
  }

  /**
   * Test the Striking Power of Player 1.
   */
  @Test
  public void testStrikingPowersPlayerOne() {
    assertEquals(26, arenaPlayerOne.getStrikingPowers());
  }

  /**
   * Test the Avoidance Ability of Player 1.
   */
  @Test
  public void testAvoidanceAbilityPlayerOne() {
    assertEquals(17, arenaPlayerOne.getAvoidanceAbility());
  }

  /**
   * Test the Potential Striking Damage of Player 1.
   */
  @Test
  public void testPotentialStrikingDamagePlayerOne() {
    assertEquals(25, arenaPlayerOne.getPotentialStrikingDamage());
  }

  /**
   * Test the actual Damage of Player 1.
   */
  @Test
  public void testActualDamagePlayerOne() {
    assertEquals(10, arenaPlayerOne.getActualDamage());
  }

  /**
   * Test the Striking Power of Player 1.
   */
  @Test
  public void testStrikingPowersPlayerTwo() {
    assertEquals(23, arenaPlayerTwo.getStrikingPowers());
  }

  /**
   * Test the Avoidance Ability of Player 1.
   */
  @Test
  public void testAvoidanceAbilityPlayerTwo() {
    assertEquals(15, arenaPlayerTwo.getAvoidanceAbility());
  }

  /**
   * Test the Potential Striking Damage of Player 1.
   */
  @Test
  public void testPotentialStrikingDamagePlayerTwo() {
    assertEquals(24, arenaPlayerTwo.getPotentialStrikingDamage());
  }

  /**
   * Test the actual Damage of Player 1.
   */
  @Test
  public void testActualDamagePlayerTwo() {
    assertEquals(8, arenaPlayerTwo.getActualDamage());
  }

  /**
   * Test the equality for Arena string.
   */
  @Test
  public void testToString() {
    assertEquals(" Player Statistics: \n" +
            " Striking Power->22\n" +
            " Avoidance Ability->14\n" +
            " Potential Striking Damagw->23\n" +
            " Actual Damage->8", arenaPlayerOne.toString());
  }
}


