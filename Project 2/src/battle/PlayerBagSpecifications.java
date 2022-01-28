package battle;

/**
 * This is used to keep the valid state of Player applying only the valid gears.
 * Headgear - only 1 at a time, effects constitution.
 * Potions - all abilities, effects all abilities.
 * Belts - 3 sizes (Max 10 units per player), up to 2 abilities.
 * Footwear - only 1 at a time, effects dexterity.
 */
public class PlayerBagSpecifications {

  private final boolean state;

  /**
   * Construct PlayerBag Specifications Object.
   * @param state of the player gear bag.
   * @Throws Illegal State check.
   */
  public PlayerBagSpecifications(boolean state) {
    this.state = state;
    checkBagSpecifications();
  }

  private void checkBagSpecifications() {
    if (!state) {
      throw new IllegalArgumentException("The Player has used Illegal Items");
    }
  }

  /**
   * This is used to get the player gear application status to check before start of the fight.
   * @return state.
   */
  public boolean getPlayerBagState() {
    return state;
  }
}
