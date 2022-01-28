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
 * Footwear Test class.
 */
public class FootwearTest {

  Footwear footwear;

  /**
   * Setup test for Footwear.
   */
  @Before
  public void setup() {
    footwear = new Footwear(MockClass.getFootwearStrength());
  }

  /**
   * Test the Total Gear Strength.
   */
  @Test
  public void testGearStrength() {
    assertEquals(6, footwear.getGearValue());
  }

  /**
   * Test the HeadGear method.
   */
  @Test
  public void headGearCompare() {
    HeadGear headGear = new HeadGear(5);
    assertEquals(-1, footwear.compareHeadgear(headGear));
  }

  /**
   * Test the Potions method.
   */
  @Test
  public void potionsCompare() {
    Potions potions = new Potions(8);
    assertEquals(-1, footwear.comparePotions(potions));
  }

  /**
   * Test the Belts method.
   */
  @Test
  public void beltsCompare() {
    Belts belts = new Belts(10, "S");
    assertEquals(-1, footwear.compareBelts(belts));
  }

  /**
   * Test the Footwear method.
   */
  @Test
  public void footwearCompare() {
    Footwear footwear1 = new Footwear(5);
    assertEquals(0, footwear.compareFootwear(footwear1));
  }

  /**
   * compareTo method with Headgear.
   */
  @Test
  public void footwearCompareHeadGear() {
    GearsAbstract headGear = new HeadGear(5);

    assertEquals(-1, headGear.compareTo(footwear));
  }

  /**
   * compareTo method with Potions.
   */
  @Test
  public void footwearComparePotions() {
    GearsAbstract potions = new Potions(6);

    assertEquals(-1, potions.compareTo(footwear));
  }

  /**
   * compareTo method with Belts.
   */
  @Test
  public void footwearCompareBelts() {
    GearsAbstract belts = new Belts(4, "S");

    assertEquals(-1, belts.compareTo(footwear));
  }

  /**
   * compareTo method with Footwear.
   */
  @Test
  public void footwearCompareFootwear() {
    GearsAbstract footwear1 = new Footwear(8);

    assertEquals(0, footwear1.compareTo(footwear));
  }

  /**
   * Test the equality for Footwear string.
   */
  @Test
  public void testToString() {
    assertEquals(" Gear Stats: \n" +
            "Footwear Value->7\n", footwear.toString());
  }

}
