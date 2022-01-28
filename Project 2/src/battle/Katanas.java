package battle;

/**
 * A weapon type subclass used for holding the weapon Axe.
 */
public class Katanas extends WeaponAbstract {

  private final String type;

  /**
   * Construct Katana object.
   *
   * @param damage of Katana weapon.
   * @param type   of Katana weapon.
   * @Throws Null value and invalid range checks.
   */
  public Katanas(int damage, String type) {
    this.damage = damage;
    this.type = type;
    checkInvalidRange();
    checkNullValues();
  }

  /**
   * This method is used to get the Blade Type.
   *
   * @return Katana Type.
   */
  public String getKatanaType() {
    return type;
  }

  private void checkInvalidRange() {
    if ((damage > 6 || damage < 2) && type.equalsIgnoreCase("Double")) {
      throw new IllegalArgumentException("Invalid Weapon Damage Range");
    }
    if ((damage > 6 || damage < 2) && type.equalsIgnoreCase("Single")) {
      throw new IllegalArgumentException("Invalid Weapon Damage Range");
    }
  }

  private void checkNullValues() {
    if (type == null) {
      throw new IllegalArgumentException("Katana Type cannot be null");
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
    return 0;
  }

  /**
   * This method is used to compare Broad Sword object with Weapon Abstract.
   *
   * @param o Broad Sword Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareBroadSword(BroadSword o) {
    return 1;
  }

  /**
   * This method is used to compare 2 Handed Sword object with Weapon Abstract.
   *
   * @param o 2 Handed Sword Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareTwoHandedSword(TwoHandedSword o) {
    return 1;
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
      return obj.compareKatana(this);
    }
    return 0;
  }

  /**
   * Used to get String representation of Katanas.
   *
   * @return Katanas object String.
   */
  public String toString() {
    return String.format(" Weapon Stats: \n Katana -> %d\n Type -> %s\n",
            this.getDamage(),
            this.getKatanaType());
  }
}
