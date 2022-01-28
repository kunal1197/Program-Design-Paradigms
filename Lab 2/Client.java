package transmission;

public class Client {
  public static void main(String[] args) {
    AutomaticTransmission automaticTransmission = new AutomaticTransmission(10, -20, 30, 40, 50);
  }
}

  /**
   * This is used to test speed between gears 1 and 2.
   */
  @Test
  public void testSpeed2() {
    assertEquals("Testing speed between gear 1 and 2", 20, automaticTransmission.getSpeed());
  }

  /**
   * This is used to test speed between gears 2 and 3.
   */
  @Test
  public void testSpeed3() {
    assertEquals("Testing speed between gear 2 and 3", 30, automaticTransmission.getSpeed());
  }

  /**
   * This is used to test speed between gears 3 and 4.
   */
  @Test
  public void testSpeed4() {
    assertEquals("Testing speed between gear 3 and 4", 40, automaticTransmission.getSpeed());
  }

  /**
   * This is used to test speed between gears 4 and 5.
   */
  @Test
  public void testSpeed5() {
    assertEquals("Testing speed between gear 4 and 5", 50, automaticTransmission.getSpeed());
  }
