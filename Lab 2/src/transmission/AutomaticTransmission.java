package transmission;

/**
 * Here we define the class AutomaticTransmission which implements the Transmission interface.
 */

public final class AutomaticTransmission implements Transmission {

  private final int threshold1;
  private final int threshold2;
  private final int threshold3;
  private final int threshold4;
  private final int threshold5;
  private int []gears;
  private double speed;
  private double gearTransmission;

  /**
   * This constructor is used to initialize all class members.
   *
   * @param threshold1  This is used to set the gear shift value from 0 to 1.
   * @param threshold2  This is used to set the gear shift value from 1 to 2.
   * @param threshold3  This is used to set the gear shift value from 2 to 3.
   * @param threshold4  This is used to set the gear shift value from 3 to 4.
   * @param threshold5  This is used to set the gear shift value from 4 to 5.
   *
   * @throws IllegalArgumentException - if (Gear thresholds not correctly set).
   * @throws IllegalStateException - if (speed < 0), (Gear and Speed not in sync).
   */

  public AutomaticTransmission(int threshold1, int threshold2,
                               int threshold3, int threshold4,
                               int threshold5) {
    this.threshold1 = threshold1;
    this.threshold2 = threshold2;
    this.threshold3 = threshold3;
    this.threshold4 = threshold4;
    this.threshold5 = threshold5;
    gears = new int[]{threshold1, threshold2, threshold3, threshold4, threshold5};
    thresholdVal();
    gearFunction();
    this.speed = 0;
    this.gearTransmission = getGear();
  }

  private void thresholdVal() {
    if (threshold1 <= 0 || threshold2 <= 0 || threshold3 <= 0 || threshold4 <= 0
            || threshold5 <= 0) {
      throw new IllegalArgumentException("Threshold cannot be negative or zero");
    }
  }

  private void gearFunction() {
    int t = gears.length;
    int flag = 0;
    for (int i = 0; i < (t - 1);i++) {
      if (gears[i] < gears[i + 1]) {
        flag = 0;
      }
      else {
        flag = 1;
        break;
      }
    }
    if (flag == 1) {
      throw new IllegalArgumentException("Gears not correctly aligned");
    }
  }

  private void speedChanges(int n) {
    speed = speed + n;
    if (speed < 0) {
      throw new IllegalStateException("Speed cannot be less than 0");
    }
    gearTransmission = getGear();
  }

  /**
   * Method used to increase speed and set gear.
   */
  @Override
  public void increaseSpeed() {
    speedChanges(1);
  }

  /**
   * Method used to decrease speed and set gear.
   */
  @Override
  public void decreaseSpeed() {
    speedChanges(-1);
  }

  /**
   * Accessor method for the speed.
   *
   * @return Used to get the total speed.
   */
  @Override
  public int getSpeed() {
    return (int) Math.round(speed);
  }

  /**
   * Method used to calculate the correct gear for the given speed.
   *
   * @return It returns the gear value.
   */
  @Override
  public int getGear() {
    if (speed == 0) {
      return 0;
    }
    if (speed < threshold1 && speed > 0) {
      return 1;
    }
    else if (speed >= threshold1 && speed < threshold2) {
      return 2;
    }
    else if (speed >= threshold2 && speed < threshold3) {
      return 3;
    }
    else if (speed >= threshold3 && speed < threshold4) {
      return 4;
    }
    else if (speed >= threshold4 && speed < threshold5) {
      return 5;
    }
    else if (speed >= threshold5) {
      return 6;
    }
    throw new IllegalStateException("Gear not in sync with speed");
  }

  /**
   * Readings are displayed in the given format.
   *
   * @return Used to return the Readings in String format.
   */
  @Override
  public String toString() {

    return String.format("Transmission (speed = %d, gear = %d)", getSpeed(), getGear());
  }
}
