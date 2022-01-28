package battle;

/**
 * This interface represents general Weapons which will be requested and allocated randomly
 * and will be used in the Battle Arena by the players.
 */
public interface Weapons extends Comparable<Weapons> {

  /**
   * This is used to get the Weapon Damage values of each weapon in form of their damage which
   * will effect the player health on battle field.
   * Some weapons have player strength based allocation damages.
   * @return Weapon Damage Values.
   */
  int getDamage();

  /**
   * This method is used to compare Katana object with Weapon Abstract.
   *
   * @param o Katana Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int compareKatana(Katanas o);

  /**
   * This method is used to compare Broad Sword object with Weapon Abstract.
   *
   * @param o Broad Sword Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int compareBroadSword(BroadSword o);

  /**
   * This method is used to compare 2 Handed Sword object with Weapon Abstract.
   *
   * @param o 2 Handed Sword Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int compareTwoHandedSword(TwoHandedSword o);

  /**
   * This method is used to compare Axes object with Weapon Abstract.
   *
   * @param o Axes Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int compareAxes(Axes o);


  /**
   * This method is used to compare Flails object with Weapon Abstract.
   *
   * @param o Flails Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  int compareFlails(Flails o);
  /**
   * This method is used to compare Bare Hands object with Weapon Abstract.
   *
   * @param o Bare Hands Object to be compared.
   * @return returns equality, greater or smaller than second.
   */

  int compareBareHands(BareHands o);
}
