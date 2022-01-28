package battle;

/**
 * This is the Abstract class for all the types of Gears, their attributes and their Strength.
 */
public abstract class GearsAbstract implements Gears {
  protected int gearStrength;

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
  public abstract int compareHeadgear(HeadGear o);

  /**
   * This method is used to compare Potions object with Gear Abstract.
   *
   * @param o Potions Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int comparePotions(Potions o);

  /**
   * This method is used to compare Belts object with Gear Abstract.
   *
   * @param o Belts Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareBelts(Belts o);

  /**
   * This method is used to compare Footwear object with Gear Abstract.
   *
   * @param o Footwear Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareFootwear(Footwear o);

  /**
   * This method is used to get Gear Abstract objects and compare them.
   *
   * @param o Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public int compareTo(Gears o) {
    return 0;
  }

}
