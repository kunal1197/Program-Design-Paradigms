package battle;

/**
 * This Health class is used to find the health of the players depending on their attributes and
 * the applied gears.
 */
public class Health {

  private final int health;

  /**
   * Construct Health object.
   * @param health health of player.
   */
  public Health(int health) {
    this.health = health;
  }

  /**
   * This is to get the health of the player.
   * @return health.
   */
  public int getHealth() {
    return health;
  }

  /**
   * Used to get String representation of Health.
   *
   * @return health object String.
   */
  public String toString() {
    return String.format(" Players Stats: \nHealth -> %d",
            this.getHealth());
  }
}
