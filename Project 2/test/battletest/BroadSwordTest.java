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
 * BroadSword Test class.
 */
public class BroadSwordTest {

  BroadSword broadSword;

  /**
   * Setup test for BroadSword.
   */
  @Before
  public void setup() {
    broadSword = new BroadSword(MockClass.getBroadSwordDamage());
  }

  /**
   * Test the BroadSword Damage.
   */
  @Test
  public void testBroadSwordDamage() {
    assertEquals(6, broadSword.getDamage());
  }

  /**
   * Test the invalid damage range.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRange() {
    broadSword = new BroadSword(4);
  }

  /**
   * Test the Katana method.
   */
  @Test
  public void katanaCompare() {
    Katanas katanas = new Katanas(5, "Double");
    assertEquals(-1, broadSword.compareKatana(katanas));
  }

  /**
   * Test the broad Sword method.
   */
  @Test
  public void broadSwordCompare() {
    BroadSword broadSword = new BroadSword(8);
    assertEquals(0, broadSword.compareBroadSword(broadSword));
  }

  /**
   * Test the 2 Handed Sword method.
   */
  @Test
  public void twoHandedSwordCompare() {
    TwoHandedSword twoHandedSword1 = new TwoHandedSword(10);
    assertEquals(1, broadSword.compareTwoHandedSword(twoHandedSword1));
  }

  /**
   * Test the Axes method.
   */
  @Test
  public void axesCompare() {
    Axes axes1 = new Axes(5);
    assertEquals(1, broadSword.compareAxes(axes1));
  }

  /**
   * Test the flails method.
   */
  @Test
  public void flailsCompare() {
    Flails flails = new Flails(6);
    assertEquals(1, broadSword.compareFlails(flails));
  }

  /**
   * Test the Bare Hands method.
   */
  @Test
  public void bareHandsCompare() {
    BareHands bareHands1 = new BareHands(4);
    assertEquals(1, broadSword.compareBareHands(bareHands1));
  }

  /**
   * Test the equality for BroadSword string.
   */
  @Test
  public void testToString() {
    assertEquals(" Weapon Stats: \n" +
            " Broadsword -> 9\n", broadSword.toString());
  }

}
