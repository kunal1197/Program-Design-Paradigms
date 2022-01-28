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
 * Potions Test class.
 */
public class PotionsTest {

  Potions potions;

  /**
   * Setup test for Potions.
   */
  @Before
  public void setup() {
    potions = new Potions(MockClass.getPotionStrength());
  }

  /**
   * Test the Total Gear Strength.
   */
  @Test
  public void testGearStrength() {
    assertEquals(3, potions.getGearValue());
  }

  /**
   * Test the HeadGear method.
   */
  @Test
  public void headGearCompare() {
    HeadGear headGear = new HeadGear(5);
    assertEquals(-1, potions.compareHeadgear(headGear));
  }

  /**
   * Test the Potions method.
   */
  @Test
  public void potionsCompare() {
    Potions potions1 = new Potions(8);
    assertEquals(0, potions.comparePotions(potions1));
  }

  /**
   * Test the Belts method.
   */
  @Test
  public void beltsCompare() {
    Belts belts = new Belts(10, "S");
    assertEquals(1, potions.compareBelts(belts));
  }

  /**
   * Test the Footwear method.
   */
  @Test
  public void footwearCompare() {
    Footwear footwear = new Footwear(5);
    assertEquals(1, potions.compareFootwear(footwear));
  }

  /**
   * compareTo method with Headgear.
   */
  @Test
  public void potionsCompareHeadGear() {
    GearsAbstract headGear = new HeadGear(5);

    assertEquals(-1, headGear.compareTo(potions));
  }

  /**
   * compareTo method with Potions.
   */
  @Test
  public void potionsComparePotions() {
    GearsAbstract potions1 = new Potions(6);

    assertEquals(0, potions1.compareTo(potions));
  }

  /**
   * compareTo method with Belts.
   */
  @Test
  public void potionsCompareBelts() {
    GearsAbstract belts = new Belts(4, "S");

    assertEquals(1, belts.compareTo(potions));
  }

  /**
   * compareTo method with Footwear.
   */
  @Test
  public void potionsCompareFootwear() {
    GearsAbstract footwear = new Footwear(8);

    assertEquals(1, footwear.compareTo(potions));
  }

  /**
   * Test the equality for Potions string.
   */
  @Test
  public void testToString() {
    assertEquals(" Gear Stats: \n" +
            "Potion Value->3\n", potions.toString());
  }

}
