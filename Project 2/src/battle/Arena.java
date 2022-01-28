package battle;

/**
 * Arena is used for the Players Fighting attributes which help in determining it's
 * fighting ability with respect to the other player.
 */
public class Arena {

  private final int strikingPowers;
  private final int avoidanceAbility;
  private final int potentialStrikingDamage;
  private final int actualDamage;

  /**
   * Construct Arena object.
   *
   * @param strikingPowers of a player used in fight.
   * @param avoidanceAbility of a player used in fight.
   * @param potentialStrikingDamage of a player used in fight.
   * @param actualDamage calculated based on other player's attribute.
   */
  public Arena(int strikingPowers, int avoidanceAbility, int potentialStrikingDamage,
               int actualDamage) {
    this.strikingPowers = strikingPowers;
    this.avoidanceAbility = avoidanceAbility;
    this.potentialStrikingDamage = potentialStrikingDamage;
    this.actualDamage = actualDamage;
  }

  /**
   * Method used to get Striking Powers.
   * @return Striking Power.
   */
  public int getStrikingPowers() {
    return strikingPowers;
  }

  /**
   * Method used to get Avoidance Ability.
   * @return Avoidance Ability.
   */
  public int getAvoidanceAbility() {
    return avoidanceAbility;
  }

  /**
   * Method used to get Potential Striking Damage.
   * @return Potential Striking Damage.
   */
  public int getPotentialStrikingDamage() {
    return potentialStrikingDamage;
  }

  /**
   * Method used to get the Actual.
   * @return Actual Damage.
   */
  public int getActualDamage() {
    return actualDamage;
  }

  /**
   * Method used to get the String representation of Arena.
   * @return Arena Object String.
   */
  public String toString() {
    return String.format(" Player Statistics: \n Striking Power->%d"
                     + "\n Avoidance Ability->%d"
                     + "\n Potential Striking Damagw->%d"
             + "\n Actual Damage->%d",
            this.getStrikingPowers(),
            this.getAvoidanceAbility(),
            this.getPotentialStrikingDamage(),
            this.getActualDamage());
  }
}

