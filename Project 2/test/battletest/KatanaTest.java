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
 * Katana Test class.
 */
public class KatanaTest {

  Katanas katanas;

  /**
   * Setup test for Katana.
   */
  @Before
  public void setup() {
    katanas = new Katanas(MockClass.getKatanaDamage(), MockClass.getKatanaType());
  }

  /**
   * Test the Katana Damage.
   */
  @Test
  public void testKatanaDamage() {
    assertEquals(4, katanas.getDamage());
  }

  /**
   * Test the Katana Type.
   */
  @Test
  public void testKatanaType() {
    assertEquals("Double", katanas.getKatanaType());
  }

  /**
   * Test the type for null values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullValues() {
    katanas = new Katanas(5, null);
  }

  /**
   * Test the invalid damage range for double blade.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRangeDoubleBlade() {
    katanas = new Katanas(8, "Double");
  }

  /**
   * Test the invalid damage range for single blade.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRangeSingleBlade() {
    katanas = new Katanas(1, "Single");
  }

  /**
   * Test the Katana method.
   */
  @Test
  public void katanaCompare() {
    Katanas katanas = new Katanas(5, "Double");
    assertEquals(0, katanas.compareKatana(katanas));
  }

  /**
   * Test the broad Sword method.
   */
  @Test
  public void broadSwordCompare() {
    BroadSword broadSword = new BroadSword(8);
    assertEquals(1, katanas.compareBroadSword(broadSword));
  }

  /**
   * Test the 2 Handed Sword method.
   */
  @Test
  public void twoHandedSwordCompare() {
    TwoHandedSword twoHandedSword1 = new TwoHandedSword(10);
    assertEquals(1, katanas.compareTwoHandedSword(twoHandedSword1));
  }

  /**
   * Test the Axes method.
   */
  @Test
  public void axesCompare() {
    Axes axes1 = new Axes(5);
    assertEquals(1, katanas.compareAxes(axes1));
  }

  /**
   * Test the flails method.
   */
  @Test
  public void flailsCompare() {
    Flails flails = new Flails(6);
    assertEquals(1, katanas.compareFlails(flails));
  }

  /**
   * Test the Bare Hands method.
   */
  @Test
  public void bareHandsCompare() {
    BareHands bareHands1 = new BareHands(4);
    assertEquals(1, katanas.compareBareHands(bareHands1));
  }

  /**
   * Test the equality for Katana string.
   */
  @Test
  public void testToString() {
    assertEquals(" Weapon Stats: \n"
            + " Katana -> 5\n"
            + " Type -> Single\n", katanas.toString());
  }

}
