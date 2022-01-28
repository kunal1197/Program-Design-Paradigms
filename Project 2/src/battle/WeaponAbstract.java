package battle;

/**
 * This is the Abstract class for all the types of Weapons, their damages and particular
 * allocation specifications.
 */
public abstract class WeaponAbstract implements Weapons {
  protected int damage;

  /**
   * This is used to get the damage per weapon allotted to the player.
   */
  @Override
  public int getDamage() {
    return damage;
  }

  /**
   * This method is used to compare Katana object with Weapon Abstract.
   *
   * @param o Katana Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareKatana(Katanas o);

  /**
   * This method is used to compare Broad Sword object with Weapon Abstract.
   *
   * @param o Broad Sword Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareBroadSword(BroadSword o);

  /**
   * This method is used to compare 2 Handed Sword object with Weapon Abstract.
   *
   * @param o 2 Handed Sword Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareTwoHandedSword(TwoHandedSword o);

  /**
   * This method is used to compare Axes object with Weapon Abstract.
   *
   * @param o Axes Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareAxes(Axes o);


  /**
   * This method is used to compare Flails object with Weapon Abstract.
   *
   * @param o Flails Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareFlails(Flails o);
  /**
   * This method is used to compare Bare Hands object with Weapon Abstract.
   *
   * @param o Bare Hands Object to be compared.
   * @return returns equality, greater or smaller than second.
   */

  public abstract int compareBareHands(BareHands o);

  /**
   * This method is used to get Weapon Abstract objects and compare them.
   *
   * @param o Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public int compareTo(Weapons o) {
    return 0;
  }
}
