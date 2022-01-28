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
  Map<Treasure, Integer> getPlayerTreasureList();

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
   * This used to check the neighbour nodes.
   *
   * @param i node index.
   * @param j node index.
   * @return list of neighbours.
   */
  List<Integer> getNeighbour(int i, int j);
}
