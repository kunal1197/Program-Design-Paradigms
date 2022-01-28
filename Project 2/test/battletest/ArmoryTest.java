package battletest;

import org.junit.Before;
import org.junit.Test;

import battle.Armory;
import battle.MockClass;

import static org.junit.Assert.assertEquals;

/**
 * Armory Test Class.
 */
public class ArmoryTest {
  Armory armory;

  /**
   * Setup test for Armory Test.
   */
  @Before
  public void setup() {
    armory = new Armory(MockClass.getRequestedWeapon());
  }

  /**
   * Test the Striking powers of the Players.
   */
  @Test
  public void testStrikingPowers() {
    assertEquals(" Weapon Stats: \n" +
            "Bare Hands ->2\n", armory.getRequestedWeapon().toString());
  }

  /**
   * Test if the requested weapon is null or not.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyRequestedWeapon() {
    armory = new Armory(null);
  }

  /**
   * Test the equality for Armory string.
   */
  @Test
  public void testToString() {
    assertEquals(" Requested Weapon: \n" +
            " Weapon Stats: \n" +
            " Axes -> 6\n\n", armory.toString());
  }
}
