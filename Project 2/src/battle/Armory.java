package battle;

/**
 * Armory is used for Storing all the available list of weapons, from which the player
 * can request a weapon, which is then assigned randomly.
 */
public class Armory {

  private final Weapons weapon;

  /**
   * This is used create Armory object to initialize class all class members.
   *
   * @param weapon the one which is requested by the Player.
   * @Throws Null value checks.
   */
  public Armory(Weapons weapon) {
    this.weapon = weapon;
    checkInvalid();
  }

  private void checkInvalid() {
    if (weapon == null) {
      throw new IllegalArgumentException("Requested weapon cannot be null");
    }
  }

  /**
   * Method used to get the Requested Weapon.
   * @return Requested weapon.
   */
  public Weapons getRequestedWeapon() {
    return weapon;
  }

  /**
   * Method used to get the String representation of Armory.
   * @return Armory Object String.
   */
  public String toString() {
    return String.format(" Requested Weapon: \n%s\n",
            this.getRequestedWeapon());
  }
}
