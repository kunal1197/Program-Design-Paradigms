package battle;

/**
 * A Gear type subclass used for holding the gear Belts.
 */
public class Belts extends GearsAbstract {

  private final String beltSize;

  /**
   * Construct Belts Object.
   * @param gearStrength of Belts gear.
   * @param beltSize of Belts gear.
   * @Throws Null value checks.
   */
  public Belts(int gearStrength, String beltSize) {
    this.gearStrength = gearStrength;
    this.beltSize = beltSize;
    nullChecks();
  }

  private void nullChecks() {
    if (beltSize == null) {
      throw new IllegalArgumentException("Belt Size cannot be null");
    }
  }

  /**
   * This is used to return the Gear Strength Value.
   * @return gear Strength.
   */
  @Override
  public int getGearValue() {
    return gearStrength;
  }

  /**
   * This is used ot get the Belt Size.
   * @return Belt Size.
   */
  public String getBeltSize() {
    return beltSize;
  }

  /**
   * This method is used to compare HeadGear object with Gear Abstract.
   *
   * @param o HeadGear Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public int compareHeadgear(HeadGear o) {
    return -1;
  }

  /**
   * This method is used to compare Potions object with Gear Abstract.
   *
   * @param o Potions Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public int comparePotions(Potions o) {
    return -1;
  }

  /**
   * This method is used to compare Belts object with Gear Abstract.
   *
   * @param o Belts Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public int compareBelts(Belts o) {
    return 0;
  }

  /**
   * This method is used to compare Footwear object with Gear Abstract.
   *
   * @param o Footwear Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public int compareFootwear(Footwear o) {
    return 1;
  }

  /**
   * This method is used to get Gear Abstract objects and compare them.
   *
   * @param o Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareTo(Gears o) {
    if (o instanceof GearsAbstract) {
      GearsAbstract obj = (GearsAbstract) o;
      return obj.compareBelts(this);
    }
    return 0;
  }

  /**
   * Used to get String representation of Belts.
   *
   * @return Belts object String.
   */
  public String toString() {
    return String.format(" Gear Stats: \nBelts Value->%d\n Belts Size->%s\n",
            this.getGearValue(),
            this.getBeltSize());
  }
}

