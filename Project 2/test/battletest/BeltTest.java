package battletest;

import org.junit.Before;
import org.junit.Test;

import battle.Belts;
import battle.Footwear;
import battle.GearsAbstract;
import battle.HeadGear;
import battle.MockClass;
import battle.Potions;

import static org.junit.Assert.assertEquals;

/**
 * Belt Test class.
 */
public class BeltTest {

  Belts belts;

  /**
   * Setup test for Belts.
   */
  @Before
  public void setup() {
    belts = new Belts(MockClass.getBeltsStrength(), MockClass.getBeltSize());
  }

  /**
   * Test the Total Gear Strength.
   */
  @Test
  public void testGearStrength() {
    assertEquals(2, belts.getGearValue());
  }

  /**
   * Test the Belt Size.
   */
  @Test
  public void testBeltSize() {
    assertEquals("M", belts.getBeltSize());
  }

  /**
   * Test the Gear for Invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullValues() {
    belts = new Belts(4, null);
  }

  /**
   * Test the HeadGear method.
   */
  @Test
  public void headGearCompare() {
    HeadGear headGear = new HeadGear(5);
    assertEquals(-1, belts.compareHeadgear(headGear));
  }

  /**
   * Test the Potions method.
   */
  @Test
  public void potionsCompare() {
    Potions potions = new Potions(8);
    assertEquals(-1, belts.comparePotions(potions));
  }

  /**
   * Test the Belts method.
   */
  @Test
  public void beltsCompare() {
    Belts belts1 = new Belts(10, "S");
    assertEquals(0, belts.compareBelts(belts1));
  }

  /**
   * Test the Footwear method.
   */
  @Test
  public void footwearCompare() {
    Footwear footwear = new Footwear(5);
    assertEquals(1, belts.compareFootwear(footwear));
  }

  /**
   * compareTo method with Headgear.
   */
  @Test
  public void beltsCompareHeadGear() {
    GearsAbstract headGear = new HeadGear(5);

    assertEquals(-1, headGear.compareTo(belts));
  }

  /**
   * compareTo method with Potions.
   */
  @Test
  public void beltsComparePotions() {
    GearsAbstract potions = new Potions(6);

    assertEquals(-1, potions.compareTo(belts));
  }

  /**
   * compareTo method with Belts.
   */
  @Test
  public void beltsCompareBelts() {
    GearsAbstract belts1 = new Belts(4, "S");

    assertEquals(0, belts1.compareTo(belts));
  }

  /**
   * compareTo method with Footwear.
   */
  @Test
  public void beltsCompareFootwear() {
    GearsAbstract footwear = new Footwear(8);

    assertEquals(1, footwear.compareTo(belts));
  }

  /**
   * Test the equality for Belt string.
   */
  @Test
  public void testToString() {
    assertEquals(" Gear Stats: \n" +
            "Belts Value->3\n" +
            " Belts Size->L\n", belts.toString());
  }

}
