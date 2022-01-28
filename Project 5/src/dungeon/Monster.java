package dungeon;

import java.util.List;

/**
 * The monster interface is used to create monsters and populate them in the Dungeon.
 */
public interface Monster {

  /**
   * This method is used to get the otyugh list.
   *
   * @return otyugh list.
   */
  List<Integer> getOtyughList();

  /**
   * This method is used to get the otyugh number.
   *
   * @return number of otyugh.
   */
  int getOtyughNumber();
}
