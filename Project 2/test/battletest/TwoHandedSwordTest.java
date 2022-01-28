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
 * Two Handed Sword Test class.
 */
public class TwoHandedSwordTest {

  TwoHandedSword twoHandedSword;

  /**
   * Setup test for Two Handed Sword.
   */
  @Before
  public void setup() {
    twoHandedSword = new TwoHandedSword(MockClass.getTwoHandedSwordDamage());
  }

  /**
   * Test the 2 Handed Sword Damage.
   */
  @Test
  public void testTwoHandedSwordDamage() {
    assertEquals(11, twoHandedSword.getDamage());
  }

  /**
   * Test the invalid damage range.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRange() {
    twoHandedSword = new TwoHandedSword(15);
  }


  /**
   * Test the Katana method.
   */
  @Test
  public void katanaCompare() {
    Katanas katanas = new Katanas(5, "Double");
    assertEquals(-1, twoHandedSword.compareKatana(katanas));
  }

  /**
   * Test the broad Sword method.
   */
  @Test
  public void broadSwordCompare() {
    BroadSword broadSword = new BroadSword(8);
    assertEquals(-1, twoHandedSword.compareBroadSword(broadSword));
  }

  /**
   * Test the 2 Handed Sword method.
   */
  @Test
  public void twoHandedSwordCompare() {
    TwoHandedSword twoHandedSword1 = new TwoHandedSword(10);
    assertEquals(0, twoHandedSword.compareTwoHandedSword(twoHandedSword1));
  }

  /**
   * Test the Axes method.
   */
  @Test
  public void axesCompare() {
    Axes axes1 = new Axes(8);
    assertEquals(1, twoHandedSword.compareAxes(axes1));
  }

  /**
   * Test the flails method.
   */
  @Test
  public void flailsCompare() {
    Flails flails = new Flails(6);
    assertEquals(1, twoHandedSword.compareFlails(flails));
  }

  /**
   * Test the Bare Hands method.
   */
  @Test
  public void bareHandsCompare() {
    BareHands bareHands1 = new BareHands(4);
    assertEquals(1, twoHandedSword.compareBareHands(bareHands1));
  }

  /**
   * Test the equality for 2 Handed Sword string.
   */
  @Test
  public void testToString() {
    assertEquals(" Weapon Stats: \n" +
            " 2 Handed Sword -> 5\n", twoHandedSword.toString());
  }

}
