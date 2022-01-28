package transmission;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class is used for Unit Testing.
 */

public class AutomaticTransmissionTest {

  private Transmission automaticTransmission;

  /**
   * This is used to setup object for Transmission interface.
   */

  @Before
  public void setup() {
    this.automaticTransmission = getTransmission(1, 2, 5, 8, 10);
  }

  private Transmission getTransmission(int threshold1, int threshold2, int threshold3,
                                       int threshold4, int threshold5) {
    return new AutomaticTransmission(threshold1, threshold2, threshold3, threshold4, threshold5);
  }

  /**
   * This is used to check if threshold gears are not set to negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void gearVal() {
    Transmission automaticTransmission = getTransmission(10, -20, 30, 40, 50);
  }

  /**
   * This is used to check if the gear is correct or not when speed Increases.
   */
  @Test
  public void testGearRatioInc() {
    for (int i = 0; i < 11; i++) {
      automaticTransmission.increaseSpeed();
    }
    assertEquals("The Gear should be 6", 6, automaticTransmission.getGear());
  }

  /**
   * This is used to check if the gear is correct or not when speed Decreases.
   */
  @Test
  public void testGearRatioDec() {
    for (int i = 0; i < 11; i++) {
      automaticTransmission.increaseSpeed();
    }
    for (int i = 0; i < 11; i++) {
      automaticTransmission.decreaseSpeed();
    }
    assertEquals("The Gear should be 0", 0, automaticTransmission.getGear());
  }

  /**
   * This is used to test the increase Speed Function.
   */
  @Test
  public void testIncreaseSpeed() {
    automaticTransmission.increaseSpeed();
    automaticTransmission.increaseSpeed();
    assertEquals("The speed should be 2", 2, automaticTransmission.getSpeed());
  }

  /**
   * This is used to test the Decrease Speed Function.
   */
  @Test
  public void testDecreaseSpeed() {
    automaticTransmission.increaseSpeed();
    automaticTransmission.increaseSpeed();
    automaticTransmission.increaseSpeed();
    automaticTransmission.decreaseSpeed();
    automaticTransmission.decreaseSpeed();
    assertEquals("The speed should be 1", 1, automaticTransmission.getSpeed());
  }

  /**
   * This is used to test if the gear and the corresponding speed match.
   */
  @Test
  public void testGear() {
    assertEquals("Testing if the gear is correct or not", 0, automaticTransmission.getGear());
  }

  /**
   * This is used to test speed between gears 0 and 1.
   */
  @Test
  public void testSpeed() {
    assertEquals("Testing if the speed is correct or not", 0, automaticTransmission.getSpeed());
  }

  /**
   * This is used to test the To String Method Representation.
   */
  @Test
  public void toStringFuncTest() {
    assertEquals("The Following String is expected",
            "Transmission (speed = 0, gear = 0)", automaticTransmission.toString());
  }
}
