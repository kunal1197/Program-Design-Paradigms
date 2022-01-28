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
 * Flails Test class.
 */
public class FlailsTest {

  Flails flails;

  /**
   * Setup test for Axes.
   */
  @Before
  public void setup() {
    flails = new Flails(MockClass.getFlailsDamage());
  }

  /**
   * Test the Flails Damage.
   */
  @Test
  public void testFlailsDamage() {
    assertEquals(4, flails.getDamage());
  }

  /**
   * Test the invalid damage range.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRange() {
    flails = new Flails(2);
  }

  /**
   * Test the Katana method.
   */
  @Test
  public void katanaCompare() {
    Katanas katanas = new Katanas(5, "Double");
    assertEquals(-1, flails.compareKatana(katanas));
  }

  /**
   * Test the broad Sword method.
   */
  @Test
  public void broadSwordCompare() {
    BroadSword broadSword = new BroadSword(8);
    assertEquals(-1, flails.compareBroadSword(broadSword));
  }

  /**
   * Test the 2 Handed Sword method.
   */
  @Test
  public void twoHandedSwordCompare() {
    TwoHandedSword twoHandedSword = new TwoHandedSword(10);
    assertEquals(-1, flails.compareTwoHandedSword(twoHandedSword));
  }

  /**
   * Test the Axes method.
   */
  @Test
  public void axesCompare() {
    Axes axes1 = new Axes(5);
    assertEquals(-1, flails.compareAxes(axes1));
  }

  /**
   * Test the flails method.
   */
  @Test
  public void flailsCompare() {
    Flails flails1 = new Flails(6);
    assertEquals(0, flails.compareFlails(flails1));
  }

  /**
   * Test the Bare Hands method.
   */
  @Test
  public void bareHandsCompare() {
    BareHands bareHands = new BareHands(4);
    assertEquals(1, flails.compareBareHands(bareHands));
  }

  /**
   * Test the equality for Flails string.
   */
  @Test
  public void testToString() {
    assertEquals(" Weapon Stats: \n" +
            " Flails -> 10\n", flails.toString());
  }

}
