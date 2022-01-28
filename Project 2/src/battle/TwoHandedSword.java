package battle;

/**
 * A weapon type subclass used for holding the weapon 2 Handed Sword.
 */
public class TwoHandedSword extends WeaponAbstract {

  /**
   * Construct 2 Handed Sword object.
   *
   * @param damage of 2 Handed Sword weapon.
   * @Throws Null value and invalid range value checks.
   */
  public TwoHandedSword(int damage) {
    this.damage = damage;
    checkInvalidRange();
  }

  private void checkInvalidRange() {
    if (damage > 12 || damage < 4) {
      throw new IllegalArgumentException("Invalid Weapon Damage Range");
    }
  }

  /**
   * This method is used to compare Katana object with Weapon Abstract.
   *
   * @param o Katana Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareKatana(Katanas o) {
    return -1;
  }

  /**
   * This method is used to compare Broad Sword object with Weapon Abstract.
   *
   * @param o Broad Sword Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareBroadSword(BroadSword o) {
    return -1;
  }

  /**
   * This method is used to compare 2 Handed Sword object with Weapon Abstract.
   *
   * @param o 2 Handed Sword Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareTwoHandedSword(TwoHandedSword o) {
    return 0;
  }

  /**
   * This method is used to compare Axes object with Weapon Abstract.
   *
   * @param o Axes Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareAxes(Axes o) {
    return 1;
  }

  /**
   * This method is used to compare Flails object with Weapon Abstract.
   *
   * @param o Flails Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareFlails(Flails o) {
    return 1;
  }

  /**
   * This method is used to compare Bare Hands object with Weapon Abstract.
   *
   * @param o Bare Hands Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareBareHands(BareHands o) {
    return 1;
  }

  /**
   * This method is used to get Weapon Abstract objects and compare them.
   *
   * @param o Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareTo(Weapons o) {
    if (o instanceof WeaponAbstract) {
      WeaponAbstract obj = (WeaponAbstract) o;
      return obj.compareTwoHandedSword(this);
    }
    return 0;
  }

  /**
   * Used to get String representation of 2 Handed Swords.
   *
   * @return 2 Handed Swords object String.
   */
  public String toString() {
    return String.format(" Weapon Stats: \n 2 Handed Sword -> %d\n",
            this.getDamage());
  }
}
