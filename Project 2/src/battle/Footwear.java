package battle;

/**
 * A Gear type subclass used for holding the gear Belts.
 */
public class Footwear extends GearsAbstract {

  /**
   * Construct Footwear Object.
   * @param gearStrength of Footwear gear.
   */
  public Footwear(int gearStrength) {
    this.gearStrength = gearStrength;
  }

  /**
   * This is used to return the Gear Strength Value.
   * @return Gear Strength.
   */
  @Override
  public int getGearValue() {
    return gearStrength;
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
    return -1;
  }

  /**
   * This method is used to compare Footwear object with Gear Abstract.
   *
   * @param o Footwear Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public int compareFootwear(Footwear o) {
    return 0;
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
      return obj.compareFootwear(this);
    }
    return 0;
  }

  /**
   * Used to get String representation of Footwear.
   *
   * @return Footwear object String.
   */
  public String toString() {
    return String.format(" Gear Stats: \nFootwear Value->%d\n",
            this.getGearValue());
  }
}

