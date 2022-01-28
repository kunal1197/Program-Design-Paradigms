package dungeon;

import java.util.List;

/**
 * This class is used to hold the Node Cave Type - Tunnel/Cave and the treasure contained in each
 * node.
 */
public class CaveTunnel {

  private final String caveType;
  private final List<Treasure> treasureList;

  /**
   * Construct the Tunnel/Cave type of object.
   *
   * @param caveType     Tunnel/Cave.
   * @param treasureList List.
   */
  public CaveTunnel(String caveType, List<Treasure> treasureList) {
    this.caveType = caveType;
    this.treasureList = treasureList;
  }

  /**
   * Used to get the Cave Type.
   *
   * @return Cave Type.
   */
  public String getCaveType() {
    return caveType;
  }

  /**
   * Used to get the list in the Node.
   *
   * @return List of Treasure.
   */
  public List<Treasure> getTreasureList() {
    return treasureList;
  }

  /**
   * Used to get the String representation of Cave Object.
   *
   * @return CaveTunnel object String.
   */
  public String toString() {
    return String.format("%s - %s",
            getCaveType(),
            getTreasureList());
  }
}
