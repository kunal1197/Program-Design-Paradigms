package battletest;

import org.junit.Before;
import org.junit.Test;

import battle.MockClass;
import battle.PlayerBagSpecifications;

import static org.junit.Assert.assertEquals;

/**
 * Player Bag Specifications Test class.
 */
public class PlayerBagSpecificationsTest {

  PlayerBagSpecifications playerBagSpecifications;

  /**
   * Setup test for Player Bag Specifications.
   */
  @Before
  public void setup() {
    playerBagSpecifications = new
            PlayerBagSpecifications(MockClass.getGearsTotalStrengthPlayerOne());
  }

  /**
   * Test the Player Bag gear applied state validity.
   */
  @Test
  public void testPlayerBagState() {
    assertEquals(true, playerBagSpecifications.getPlayerBagState());
  }

  /**
   * Test the illegal use of item.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalItemUse() {
    playerBagSpecifications = new PlayerBagSpecifications(false);
  }
}
