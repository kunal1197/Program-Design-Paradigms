package battle;

import java.util.Arrays;

/**
 * This is used to hold the Randomly gears from which players will choose 20 gears randomly each.
 */
public class EquipmentBag {

  private final int[] bag;
  private final int[] playerOneBag;
  private final int[] playerTwoBag;

  /**
   * Construct Equipment Bag Object.
   * @param bag Equipment Bag.
   * @param playerOneBag Player 1 bag.
   * @param playerTwoBag Player 2 bag.
   */
  public EquipmentBag(int[] bag, int[] playerOneBag, int[] playerTwoBag) {
    this.bag = bag;
    this.playerOneBag = playerOneBag;
    this.playerTwoBag = playerTwoBag;
  }

  /**
   * This is used to get the Equipment Bag list.
   * @return equipment bag.
   */
  public int[] getBagDetails() {
    return bag;
  }

  /**
   * his is used to get the Equipment Bag list for player 1.
   * @return equipment bag.
   */
  public int[] getPlayerOneBagDetails() {
    return playerOneBag;
  }

  /**
   * his is used to get the Equipment Bag list for player 2.
   * @return equipment bag.
   */
  public int[] getPlayerTwoBagDetails() {
    return playerTwoBag;
  }

  /**
   * Used to get String representation of all Equipment Bags.
   *
   * @return Equipment Bag object String.
   */
  public String toString() {
    return String.format(" Equipment Bag: \n Bag Size ->%d\n Contents ->%s\n Player One Bag"
                    + " ->%s\n Player Two Bag ->%s\n",
            this.getBagDetails().length,
            Arrays.toString(this.getBagDetails()),
            Arrays.toString(this.getPlayerOneBagDetails()),
            Arrays.toString(this.getPlayerTwoBagDetails()));
  }
}
