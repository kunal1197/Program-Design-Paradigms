package battletest;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import battle.EquipmentBag;
import battle.MockClass;

import static org.junit.Assert.assertEquals;

/**
 * Equipment Bag Test class.
 */
public class EquipmentBagTest {

  EquipmentBag equipmentBag;

  /**
   * Setup test for Equipment Bag.
   */
  @Before
  public void setup() {
    equipmentBag = new EquipmentBag(MockClass.getEquipmentBag(), MockClass.getPlayerOneBag(),
            MockClass.getPlayerTwoBag());
  }

  /**
   * Test the Random generated bag details.
   */
  @Test
  public void testGetBagDetails() {
    assertEquals("[1, -2, 1, 2, 4, 1, 2, 3, 4, 2, 2, -2, -2, 1, 1, 1, 3, 4, -1, 2, 2, 1,"
            + " 3, 2, 3, 3, 3, 4, 3, 1, 4, 2, -4, -2, 2, 3, 2, 1, 3, 1, 2, 2, 4, 2, 3, 3, 1, 3, 2,"
            + " -2, 3, 1, 3, 4, 3, -2, 3, 2]", Arrays.toString(equipmentBag.getBagDetails()));
  }

  @Test
  public void checkBagNegatives() {
    assertEquals(10,
            (equipmentBag.getBagDetails().length) / 4);
  }

  /**
   * Test the Player One Bag details.
   */
  @Test
  public void testPlayerOneBagDetails() {
    assertEquals("[2, -4, 1, 1, 3, 2, 3, 4, 2, 4, 4, 3, 3, 4, 4, 1, 3, 3, 2, 3]",
            Arrays.toString(equipmentBag.getPlayerOneBagDetails()));
  }

  /**
   * Test the Player two bag details.
   */
  @Test
  public void testPlayerTwoBagDetails() {
    assertEquals("[1, -2, 2, 2, 4, -2, 1, 2, 3, 1, -2, 2, 1, -3, 2, -3, 1, -2, 1, -2]",
            Arrays.toString(equipmentBag.getPlayerTwoBagDetails()));
  }


  /**
   * Test the equality for Equipment Bag string.
   */
  @Test
  public void testToString() {
    assertEquals(" Equipment Bag: \n"
                    + " Bag Size ->42\n"
                    + " Contents ->[4, 2, 4, 1, 2, 1, 4, 2, 2, 3, 3, 4, 4, 1, -4, 3, 3, -3,"
                    + " 1, 3, 2, -4, 1, -3, 2, 3, -1, 1, -1, 3, 4, -2, 1, 2, 3, 2, -3, 1, 1, 2,"
                    + " 2, 1]\n"
                    + " Player One Bag ->[3, 1, 3, 2, -1, 2, -3, -1, 4, 4, 2, 3, 3, 3, 3, 4, -1,"
                    + " 1, 1, 3]\n"
                    + " Player Two Bag ->[3, 3, 3, 2, 4, -4, 1, 3, 2, 4, 4, 2, 3, 4, 1, 1, 4,"
                    + " -4, 2, 2]\n",
            equipmentBag.toString());
  }

}
