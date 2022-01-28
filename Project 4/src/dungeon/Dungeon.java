package dungeon;

import java.util.List;
import java.util.Map;

/**
 * This interface represents the Dungeon Game and the various steps involved in creating the maze,
 * with a number of set constraints.
 */
public interface Dungeon {

  /**
   * This is used to get the to total Number of Vertices.
   *
   * @return vertices.
   */
  int getVertices();

  /**
   * This is used to get the length of the maze.
   *
   * @return length.
   */
  int getSizeLength();

  /**
   * This is used to get the breadth of the maze.
   *
   * @return breadth.
   */
  int getSizeBreadth();

  /**
   * This is used to ge the degree of interconnectivity.
   *
   * @return degree.
   */
  int getInterconnectivity();

  /**
   * This is used to get the boolean wrapping value.
   *
   * @return true/false.
   */
  boolean getWrappingValue();

  /**
   * This is used to get the treasure Percent.
   *
   * @return percent.
   */
  int getTreasurePercent();

  /**
   * This is used to get the Treasure List in the dungeon.
   *
   * @return Treasure map.
   */
  Map<Integer, List<Treasure>> getTreasureList();

  /**
   * This is used to get the treasure collected by the player.
   *
   * @return Treasure map.
   */
  Map<Treasure, Integer> getFinalPlayerTreasureList();

  /**
   * This is used to get the Cave/Tunnel Details.
   *
   * @param i node index.
   * @return class object.
   */
  CaveTunnel getCaveTunnelDetails(int i);

  /**
   * This is used to get the shortest distance between start and end point.
   *
   * @return distance.
   */
  int getShortestDistance();

  /**
   * This is used to get the shortest Path between start and end points.
   *
   * @return Path.
   */
  List<Integer> getShortestPath();

  /**
   * This is used to get the start Point.
   *
   * @return start point.
   */
  int getStartPoint();

  /**
   * This is used to get the end point.
   *
   * @return end point.
   */
  int getEndPoint();

  /**
   * This is used to assign the nodes as tunnel or cave.
   *
   * @param j node index.
   * @return cave/tunnel.
   */
  String assignCaveOrTunnel(int j);

  /**
   * This used to get the interconnectivity of the graph.
   *
   * @return interconnectivity.
   */
  List<List<Integer>> interconnectivityList();

  /**
   * This is used to get the adjaceny edge list.
   *
   * @return adjacency list.
   */
  List<List<Integer>> edgeAdjacencyList();

  /**
   * This is used to get the Directions available to move for a given node.
   *
   * @return Direction list per node.
   */
  List<List<String>> edgeDirectionList();

  /**
   * This is used to update the player 's current location.
   */
  void updatePlayerLocation(int playerLocation);

  /**
   * This is used to get the player location.
   *
   * @return Player location node.
   */
  int getPlayerLocation();

  /**
   * This used to get the Otyugh Smell from the plyaers current location.
   *
   * @param playerLocation Player location node.
   * @return Otyugh Smell.
   */
  String getOtyughSmell(int playerLocation);

  /**
   * This is used to get the Number of Player Arrows.
   *
   * @return playerArrowlist Number of arrows.
   */
  int getPlayerArrowlist();

  /**
   * This is used to pickup the Arrows.
   */
  void pickArrows(int noOfArrows, int playerLocation);

  /**
   * This used to check the neighbour nodes.
   *
   * @param i node index.
   * @param j node index.
   * @return list of neighbours.
   */
  List<Integer> getNeighbour(int i, int j);

  /**
   * This is used to populate the Otyughs in the dungeon.
   *
   * @return list of Otyughs.
   */
  List<Integer> populateOtyughs();

  /**
   * This is used to populate the Arrows in the dungeon.
   *
   * @return List of Arrows.
   */
  List<Integer> getArrowLocations();


  /**
   * This is used to shoot arrows at the Otyugh.
   *
   * @param arrowDistance Distance of the arrow.
   * @param direction     Direction of the arrow.
   * @return Message.
   */
  String shootArrow(int arrowDistance, String direction);

  /**
   * This is used to get the number of Treasures which the player has.
   *
   * @return Number of treasures.
   */
  Map<Treasure, Integer> getPlayerTreasureList();

  /**
   * This is used to pick the treasure from the list.
   *
   * @param treasure Treasure to be picked.
   */
  void pickUpTreasure(Treasure treasure, int playerLocation);

  /**
   * This used to check if the player survives the dungeon with otyugh or not.
   *
   * @param playerLocation location of the player.
   * @return true if the player survives the dungeon with otyugh.
   */
  Map<Integer, String> checkPlayerAvoidanceAbility(int playerLocation);

  /**
   * This is used to get the Otyugh nodes and their health.
   *
   * @return Otyugh List.
   */
  Map<Integer, Integer> getOtyughHealthList();

  /**
   * This method is used to get the Otyugh Locations in the Dungeon.
   * @return List of Otyugh Locations.
   */
  List<Integer> getOtyughLocations();
}
