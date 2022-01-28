package battle;

/**
 * This class is used to create a player, basically it has all the player base characteristic
 * attributes.
 */
public class Players {

  private final int strength;
  private final int constitution;
  private final int dexterity;
  int charisma;

  /**
   * Construct the Player Object.
   * @param strength of the player.
   * @param constitution of the player.
   * @param dexterity of the player.
   * @param charisma of the player.
   */
  public Players(int strength, int constitution, int dexterity, int charisma) {
    this.strength  = strength;
    this.constitution = constitution;
    this.dexterity = dexterity;
    this.charisma = charisma;
  }

  /**
   * This is used to get the player Strength.
   * @return strength.
   */
  public int getStrength() {
    return strength;
  }

  /**
   * This is used to get the player constitution.
   * @return constitution.
   */
  public int getConstitution() {
    return constitution;
  }

  /**
   * This is used to get the player Dexterity.
   * @return dexterity.
   */
  public int getDexterity() {
    return dexterity;
  }

  /**
   * This is used to get the player charisma.
   * @return charisma.
   */
  public int getCharisma() {
    return charisma;
  }

  /**
   * Used to get String representation of Player.
   *
   * @return PLayer  object String.
   */
  public String toString() {
    return String.format("\n Strength->%d\n Constitution->%d\n"
                    + " Dexterity->%d\n Charisma->%d\n",
            this.getStrength(),
            this.getConstitution(),
            this.getDexterity(),
            this.getCharisma());
  }
}
