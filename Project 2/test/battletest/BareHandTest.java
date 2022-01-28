package battletest;

import org.junit.Before;
import org.junit.Test;

import battle.Axes;
import battle.BareHands;
import battle.BroadSword;
import battle.Flails;
import battle.Katanas;
import battle.MockClass;
import battle.TwoHandedSword;

import static org.junit.Assert.assertEquals;

/**
 * Bare Hands Test class.
 */
public class BareHandTest {

  BareHands bareHands;

  /**
   * Setup test for Bare Hands.
   */
  @Before
  public void setup() {
    bareHands = new BareHands(MockClass.getBareHandsDamage());
  }

  /**
   * Test the Bare Hands Damage.
   */
  @Test
  public void testBareHandsDamage() {
    assertEquals(2, bareHands.getDamage());
  }

  /**
   * Test the invalid damage range.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRange() {
    bareHands = new BareHands(10);
  }

  /**
   * Test the Katana method.
   */
  @Test
  public void katanaCompare() {
    Katanas katanas = new Katanas(5, "Double");
    assertEquals(-1, bareHands.compareKatana(katanas));
  }

  /**
   * Test the broad Sword method.
   */
  @Test
  public void broadSwordCompare() {
    BroadSword broadSword = new BroadSword(8);
    assertEquals(-1, bareHands.compareBroadSword(broadSword));
  }

  /**
   * Test the 2 Handed Sword method.
   */
  @Test
  public void twoHandedSwordCompare() {
    TwoHandedSword twoHandedSword = new TwoHandedSword(10);
    assertEquals(-1, bareHands.compareTwoHandedSword(twoHandedSword));
  }

  /**
   * Test the Axes method.
   */
  @Test
  public void axesCompare() {
    Axes axes1 = new Axes(5);
    assertEquals(-1, bareHands.compareAxes(axes1));
  }

  /**
   * Test the flails method.
   */
  @Test
  public void flailsCompare() {
    Flails flails = new Flails(6);
    assertEquals(-1, bareHands.compareFlails(flails));
  }

  /**
   * Test the Bare Hands method.
   */
  @Test
  public void bareHandsCompare() {
    BareHands bareHands1 = new BareHands(4);
    assertEquals(0, bareHands.compareBareHands(bareHands1));
  }

  /**
   * Test the equality for Bare Hands string.
   */
  @Test
  public void testToString() {
    assertEquals(" Weapon Stats: \n" +
            "Bare Hands ->2\n", bareHands.toString());
  }

}

