package dungeon;

import java.util.List;

/**
 * This is the implementation of the Monster interface, which is used create Monster and populate
 * them in the dungeon and its associated methods.
 */
public class MonsterImpl implements Monster {

  private final int otyughNumber;
  private final List<Integer> otyughList;

  /**
   * Constructor for the monster class.
   *
   * @param otyughNumber Number of Otyugh in Class.
   * @param otyughList   List of Otyugh in Class.
   * @throws IllegalArgumentException if otyughList is null or otyughNumber is 0.
   */
  public MonsterImpl(int otyughNumber, List<Integer> otyughList) {
    nullChecks(otyughNumber, otyughList);
    this.otyughNumber = otyughNumber;
    this.otyughList = otyughList;
  }

  private void nullChecks(int otyughNumber, List<Integer> otyughList) {
    if (otyughList == null) {
      throw new IllegalArgumentException("Otyugh List cannot be null");
    }
    if (otyughNumber == 0) {
      throw new IllegalArgumentException("Otyugh Number cannot be 0");
    }
  }

  /**
   * This method is used to get the otyugh list.
   *
   * @return otyugh list.
   */
  @Override
  public List<Integer> getOtyughList() {
    return otyughList;
  }

  /**
   * This method is used to get the otyugh number.
   *
   * @return number of otyugh.
   */
  @Override
  public int getOtyughNumber() {
    return otyughNumber;
  }

  /**
   * Used to get the String representation of Monster Object.
   *
   * @return Monster object String.
   */
  public String toString() {
    return String.format("Otyugh Details: %s\n Total Otyughs: %s\n",
            this.getOtyughList(),
            this.getOtyughNumber());
  }

}
