package battle;

/**
 * This interface represents general Gears which will be used in the Battle Arena by the
 * players.
 */
public interface Gears extends Comparable<Gears> {

  /**
   * This is used to get the gear values of each gear in form of their strength which will effect
   * the players health on battle field.
   * These will have a temporary effect and may wear off in the middle fight depending on the
   * number of rounds.
   * @return Gear strength value.
   */
  int getGearValue();

  /**
   * This method is used to compare HeadGear object with Gear Abstract.
   *
   * @param o HeadGear Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int compareHeadgear(HeadGear o);

  /**
   * This method is used to compare Potions object with Gear Abstract.
   *
   * @param o Potions Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int comparePotions(Potions o);

  /**
   * This method is used to compare Belts object with Gear Abstract.
   *
   * @param o Belts Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int compareBelts(Belts o);

  /**
   * This method is used to compare Footwear object with Gear Abstract.
   *
   * @param o Footwear Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int compareFootwear(Footwear o);
}




