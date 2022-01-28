package battletest;

import org.junit.Before;
import org.junit.Test;

import battle.Health;
import battle.MockClass;

import static org.junit.Assert.assertEquals;

/**
 * Health Test class.
 */
public class HealthTest {

  Health healthPlayer1;
  Health healthPlayer2;

  /**
   * Setup test for Health.
   */
  @Before
  public void setup() {
    healthPlayer1 = new Health(MockClass.getHealthPlayerOne());
    healthPlayer2 = new Health(MockClass.getHealthPlayerTwo());
  }

  /**
   * Test the player One health.
   */
  @Test
  public void testGetHealthPlayer1() {
    assertEquals(50, healthPlayer1.getHealth());
  }

  /**
   * Test the player two health.
   */
  @Test
  public void testGetHealthPlayer2() {
    assertEquals(59, healthPlayer2.getHealth());
  }

  /**
   * Test the equality for Health string.
   */
  @Test
  public void testToString() {
    assertEquals(" Players Stats: \n" +
            "Health -> 50", healthPlayer1.toString());
  }

}
