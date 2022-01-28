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
 * HeadGear Test class.
 */
public class HeadGearTest {

  HeadGear headGear;

  /**
   * Setup test for HeadGear.
   */
  @Before
  public void setup() {
    headGear = new HeadGear(MockClass.getHeadGearStrength());
  }

  /**
   * Test the Total Gear Strength.
   */
  @Test
  public void testGearStrength() {
    assertEquals(5, headGear.getGearValue());
  }

  /**
   * Test the HeadGear method.
   */
  @Test
  public void headGearCompare() {
    HeadGear headGear1 = new HeadGear(5);
    assertEquals(0, headGear.compareHeadgear(headGear1));
  }

  /**
   * Test the Potions method.
   */
  @Test
  public void potionsCompare() {
    Potions potions = new Potions(8);
    assertEquals(1, headGear.comparePotions(potions));
  }

  /**
   * Test the Belts method.
   */
  @Test
  public void beltsCompare() {
    Belts belts = new Belts(10, "S");
    assertEquals(1, headGear.compareBelts(belts));
  }

  /**
   * Test the Footwear method.
   */
  @Test
  public void footwearCompare() {
    Footwear footwear = new Footwear(5);
    assertEquals(1, headGear.compareFootwear(footwear));
  }

  /**
   * compareTo method with Headgear.
   */
  @Test
  public void headGearCompareHeadGear() {
    GearsAbstract headGear1 = new HeadGear(5);

    assertEquals(0, headGear1.compareTo(headGear));
  }

  /**
   * compareTo method with Potions.
   */
  @Test
  public void headGearComparePotions() {
    GearsAbstract potions = new Potions(6);

    assertEquals(1, potions.compareTo(headGear));
  }

  /**
   * compareTo method with Belts.
   */
  @Test
  public void headGearCompareBelts() {
    GearsAbstract belts = new Belts(4, "S");

    assertEquals(1, belts.compareTo(headGear));
  }

  /**
   * compareTo method with Footwear.
   */
  @Test
  public void headGearCompareFootwear() {
    GearsAbstract footwear = new Footwear(8);

    assertEquals(1, footwear.compareTo(headGear));
  }

  /**
   * Test the equality for HeadGear string.
   */
  @Test
  public void testToString() {
    assertEquals(" Gear Stats: \n" +
            "Head Gear Value->7\n", headGear.toString());
  }

}
