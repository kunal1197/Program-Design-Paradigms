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
 * Axes Test class.
 */
public class AxesTest {

  Axes axes;

  /**
   * Setup test for Axes.
   */
  @Before
  public void setup() {
    axes = new Axes(MockClass.getAxesDamage());
  }

  /**
   * Test the Axe Damage.
   */
  @Test
  public void testAxesDamage() {
    assertEquals(8, axes.getDamage());
  }

  /**
   * Test the invalid damage range.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRange() {
    axes = new Axes(4);
  }

  /**
   * Test the Katana method.
   */
  @Test
  public void katanaCompare() {
    Katanas katanas = new Katanas(5, "Double");
    assertEquals(-1, axes.compareKatana(katanas));
  }

  /**
   * Test the broad Sword method.
   */
  @Test
  public void broadSwordCompare() {
    BroadSword broadSword = new BroadSword(8);
    assertEquals(-1, axes.compareBroadSword(broadSword));
  }

  /**
   * Test the 2 Handed Sword method.
   */
  @Test
  public void twoHandedSwordCompare() {
    TwoHandedSword twoHandedSword = new TwoHandedSword(10);
    assertEquals(-1, axes.compareTwoHandedSword(twoHandedSword));
  }

  /**
   * Test the Axes method.
   */
  @Test
  public void axesCompare() {
    Axes axes1 = new Axes(5);
    assertEquals(0, axes.compareAxes(axes1));
  }

  /**
   * Test the flails method.
   */
  @Test
  public void flailsCompare() {
    Flails flails = new Flails(6);
    assertEquals(1, axes.compareFlails(flails));
  }

  /**
   * Test the Bare Hands method.
   */
  @Test
  public void bareHandsCompare() {
    BareHands bareHands = new BareHands(4);
    assertEquals(1, axes.compareBareHands(bareHands));
  }

  /**
   * Test the equality for Axes string.
   */
  @Test
  public void testToString() {
    assertEquals(" Weapon Stats: \n" +
            " Axes -> 6\n", axes.toString());
  }

}
