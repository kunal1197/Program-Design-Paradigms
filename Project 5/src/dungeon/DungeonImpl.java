package dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * This is the implementation of the Dungeon interface, which is used create dungeon and maze
 * generation.
 */
public class DungeonImpl implements Dungeon {

  private static int sizeLength;
  private static int sizeBreadth;
  private final int interconnectivity;
  private final boolean wrapping;
  private final int treasurePercent;
  private int startPoint;
  private int endPoint;
  private final int[][] adjacencyMatrix;
  private final List<List<Integer>> edgeList;
  private final List<List<Integer>> interconnectivityList;
  private final List<List<Integer>> edgeAdjacencyList;
  private final Map<Integer, List<Treasure>> treasureList;
  private final Map<Treasure, Integer> finalPlayerTreasureList;
  private Map<Treasure, Integer> playerTreasureList;
  private final int noOfOtyughs;
  private final List<Integer> otyughLocations;
  private Map<Integer, Integer> otyughHealthList;
  private final List<Integer> arrowLocations;
  private int playerLocation;
  private int playerArrowlist;
  private final Map<Integer, String> playerAvoidanceAbility;

  private final int[] parent;
  static int INF = Integer.MAX_VALUE;
  static Random random = new Random();
  static int randomSeed;

  /**
   * This is the constructor for the DungeonImpl class.
   *
   * @param sizeLength        length of the maze.
   * @param sizeBreadth       breadth of the maze.
   * @param interconnectivity interconnectivity of the maze.
   * @param wrapping          wrapping value of the maze.
   * @param treasurePercent   treasure percent of the maze.
   * @throws IllegalArgumentException for null values.
   */
  public DungeonImpl(int sizeLength, int sizeBreadth, int interconnectivity, boolean wrapping,
                     int treasurePercent, int noOfOtyughs) {
    nullChecks(sizeLength, sizeBreadth, interconnectivity, wrapping, treasurePercent, noOfOtyughs);
    DungeonImpl.sizeLength = sizeLength;
    DungeonImpl.sizeBreadth = sizeBreadth;
    this.interconnectivity = interconnectivity;
    this.wrapping = wrapping;
    this.treasurePercent = treasurePercent;
    parent = new int[getVertices()];

    adjacencyMatrix = adjacencyMatrix();
    edgeList = kruskalmst(adjacencyMatrix());
    interconnectivityList = interconnectivityList();
    edgeAdjacencyList = edgeAdjacencyList();
    do {
      startPoint = setStartPoint();
      endPoint = setEndPoint();
      if (shortestDistance(edgeAdjacencyList, startPoint, endPoint, getVertices()) >= 5) {
        break;
      }
    }
    while (shortestDistance(edgeAdjacencyList, startPoint, endPoint, getVertices()) < 5);
    treasureList = populateTreasure();
    finalPlayerTreasureList = playerTreasureList();

    this.playerLocation = startPoint;
    this.noOfOtyughs = noOfOtyughs;
    this.otyughLocations = populateOtyughs();
    this.otyughHealthList = otyughHealthList();
    this.arrowLocations = populateArrows();
    this.playerArrowlist = 3;
    this.playerTreasureList = setPlayerTreasureList();
    this.playerAvoidanceAbility = new HashMap<>();
  }

  private void nullChecks(int sizeLength, int sizeBreadth, int interconnectivity, boolean wrapping,
                          int treasurePercent, int noOfOtyughs) {
    if (sizeLength < 4 && sizeLength > 0 || sizeBreadth < 4 && sizeBreadth > 0) {
      throw new IllegalArgumentException("The Size of the maze cannot be less than 4.");
    }

    if (sizeLength < 0 || sizeBreadth < 0) {
      throw new IllegalArgumentException("The Size of the maze cannot be Negative");
    }

    if (interconnectivity > (sizeBreadth * sizeLength) - 1) {
      throw new IllegalArgumentException("Invalid Interconnectivity Degree.");
    }

    if (interconnectivity < 0) {
      throw new IllegalArgumentException("Interconnectivity cannot be Negative");
    }

    if (wrapping && !wrapping) {
      throw new IllegalArgumentException("Invalid wrapping value.");
    }

    if (treasurePercent > 100) {
      throw new IllegalArgumentException("Treasure Percent cannot be more than 100");
    }

    if (noOfOtyughs < 1) {
      throw new IllegalArgumentException("Number of Otyughs cannot be less than 1");
    }

    if (noOfOtyughs > (sizeBreadth * sizeLength) - 1) {
      throw new IllegalArgumentException("Number of Otyughs cannot be more than the number of "
              + "vertices");
    }
  }


  private int genrateRandomSeed() {
    Random randomSeed = new Random();
    return randomSeed.nextInt(43);
  }

  /**
   * This is used to return the random seed.
   * @return randomSeed.
   */
  @Override
  public int getRandomSeed() {
    return 42;
  }

  /**
   * This is used to set the seed of the dungeon.
   * @param seed Seed of the dungeon.
   */
  @Override
  public void setSeed(int seed) {
    random = new Random(seed);
  }


  /**
   * This method is used to get the Otyugh Locations in the Dungeon.
   * @return List of Otyugh Locations.
   */
  @Override
  public List<Integer> getOtyughLocations() {
    return otyughLocations;
  }

  /**
   * This is used to populate the Otyughs in the dungeon.
   *
   * @return list of Otyughs.
   */
  @Override
  public List<Integer> populateOtyughs() {
    List<Integer> otyughs = new ArrayList<>();
    int otyughsCount = noOfOtyughs - 1;
    for (int i = 0; i < noOfOtyughs; i++) {
      otyughs.add(0);
    }
    while (otyughsCount != 0) {
      int randomNumber = random.nextInt(getVertices());
      if (randomNumber != startPoint && randomNumber != endPoint) {
        if (!(assignCaveOrTunnel(randomNumber).equals("Tunnel"))
                && !otyughs.contains(randomNumber)) {
          otyughs.set(otyughsCount, randomNumber);
          otyughsCount--;
        }
      }
    }
    otyughs.set(noOfOtyughs - 1, endPoint);

    return otyughs;
  }

  /**
   * This used to check if the player survives the dungeon with otyugh or not.
   *
   * @param playerLocation location of the player.
   * @return true if the player survives the dungeon with otyugh.
   */
  @Override
  public Map<Integer, String> checkPlayerAvoidanceAbility(int playerLocation) {
    Map<Integer, Integer> list = otyughHealthList;
    String message = "";
    if (list.containsKey(playerLocation) && list.get(playerLocation) == 0) {
      message = "You survived as dead body of Otyugh was in your location\n";
      playerAvoidanceAbility.put(0, message);
    }
    else if (list.containsKey(playerLocation) && list.get(playerLocation) == 100) {
      message = "You have been killed by the Otyugh\n";
      playerAvoidanceAbility.put(1, message);
    }
    else if (list.containsKey(playerLocation) && list.get(playerLocation) == 50) {
      message = "The Otyugh health is at 50%, there is a chance you might die.\n";
      int randomNumber = random.nextInt(2);
      if (randomNumber == 1) {
        message = message + "You have been killed by the Otyugh\n";
        playerAvoidanceAbility.put(1, message);
      } else {
        message = message + "You managed to escape the Otyugh\n";
        playerAvoidanceAbility.put(0, message);
      }
    }
    else {
      playerAvoidanceAbility.put(0, message);
    }
    return playerAvoidanceAbility;
  }

  /**
   * This is used to populate the Arrows in the dungeon.
   *
   * @return List of Arrows.
   */
  @Override
  public List<Integer> getArrowLocations() {
    return arrowLocations;
  }

  private List<Integer> populateArrows() {

    List<Integer> arrows = new ArrayList<>();
    double percent = treasurePercent;
    int allocationPercent = (int) Math.floor((percent / 100.0) * getVertices());
    int k = 0;
    for (int i = 0; i < getVertices(); i++) {

      if (treasurePercent != 0) {
        if (k < allocationPercent) {

          k = k + 1;
          int gen = random.nextInt(4 - 1) + 1;
          if (gen == 3) {
            arrows.add(3);
          } else if (gen == 2) {
            arrows.add(2);
          } else {
            arrows.add(1);
          }
        } else {
          arrows.add(0);
        }
      } else {
        arrows.add(0);
      }
    }
    Collections.shuffle(arrows, random);
    return arrows;
  }


  /**
   * This is used to get the length of the maze.
   *
   * @return length.
   */
  @Override
  public int getSizeLength() {
    return sizeLength;
  }

  /**
   * This is used to get the breadth of the maze.
   *
   * @return breadth.
   */
  @Override
  public int getSizeBreadth() {
    return sizeBreadth;
  }

  /**
   * This is used to ge the degree of interconnectivity.
   *
   * @return degree.
   */
  @Override
  public int getInterconnectivity() {
    return interconnectivity;
  }

  /**
   * This is used to get the boolean wrapping value.
   *
   * @return true/false.
   */
  @Override
  public boolean getWrappingValue() {
    return wrapping;
  }

  /**
   * This is used to get the treasure Percent.
   *
   * @return percent.
   */
  @Override
  public int getTreasurePercent() {
    return treasurePercent;
  }

  /**
   * This is used to get the number of Otyughs.
   *
   * @return number of Otyughs.
   */
  @Override
  public int getNoOfOtyughs() {
    return noOfOtyughs;
  }

  /**
   * This is used to get the to total Number of Vertices.
   *
   * @return vertices.
   */
  @Override
  public int getVertices() {
    return getSizeLength() * getSizeBreadth();
  }

  int find(int i) {
    while (parent[i] != i) {
      i = parent[i];
    }
    return i;
  }

  private void union1(int i, int j) {
    int a = find(i);
    int b = find(j);
    parent[a] = b;
  }

  private List<List<Integer>> kruskalmst(int[][] cost) {

    List<List<Integer>> edgeList = new ArrayList<>();
    int mincost = 0; // Cost of min MST.

    // Initialize sets of disjoint sets.
    for (int i = 0; i < getVertices(); i++) {
      parent[i] = i;
    }

    // Include minimum weight edges one by one
    int edge_count = 0;
    while (edge_count < getVertices() - 1) {
      int min = INF;
      int a = -1;
      int b = -1;
      for (int i = 0; i < getVertices(); i++) {
        for (int j = 0; j < getVertices(); j++) {

          if (find(i) != find(j) && cost[i][j] < min) {
            min = cost[i][j];
            a = i;
            b = j;
          }
        }
      }

      List<Integer> inner = new ArrayList<>();
      inner.add(a);
      inner.add(b);
      Collections.sort(inner);
      edgeList.add(inner);

      union1(a, b);
      edge_count++;
      mincost += min;
    }
    return edgeList;
  }

  /**
   * This used to get the interconnectivity of the graph.
   *
   * @return interconnectivity.
   */
  @Override
  public List<List<Integer>> interconnectivityList() {
    List<List<Integer>> edgeList = this.edgeList;
    if (interconnectivity > ((sizeBreadth * sizeLength) - 1)) {
      throw new IllegalArgumentException("Invalid Interconnectivity");
    }
    if (interconnectivity > 0) {
      Set<List<Integer>> remainSet = getRemainingList();
      List<List<Integer>> remainList = new ArrayList<>();
      remainList.addAll(remainSet);
      Collections.shuffle(remainList, random);
      for (int i = 0; i < interconnectivity; i++) {
        edgeList.add(remainList.get(i));
      }
    }
    return edgeList;
  }


  private int[][] getArray() {
    int[][] temp = adjacencyMatrix;
    int[][] arr = new int[sizeLength][sizeBreadth];
    int k = 0;
    for (int i = 0; i < sizeLength; i++) {
      for (int j = 0; j < sizeBreadth; j++) {
        arr[i][j] = k++;
      }
    }
    return arr;
  }

  private boolean isPresent(int i, int j) {
    int[][] arr = getArray();
    boolean state;
    List<Integer> list = new ArrayList<>();
    for (int k = 0; k < arr.length; k++) {
      for (int m = 0; m < arr.length; m++) {
        list.add(arr[k][m]);
      }
    }
    if (i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
      state = list.contains(arr[i][j]);
      return state;
    } else {
      return false;
    }
  }

  /**
   * This used to check the neighbour nodes.
   *
   * @param i node index.
   * @param j node index.
   * @return list of neighbours.
   */
  @Override
  public List<Integer> getNeighbour(int i, int j) {
    int[][] arr = getArray();
    List<Integer> list = new ArrayList<>();

    if (!wrapping) {
      //    Check West
      if (isPresent(i, j - 1)) {
        list.add(arr[i][j - 1]);
      }

      //    Check East
      if (isPresent(i, j + 1)) {
        list.add(arr[i][j + 1]);
      }

      //    Check North
      if (isPresent(i - 1, j)) {
        list.add(arr[i - 1][j]);
      }

      //    Check South
      if (isPresent(i + 1, j)) {
        list.add(arr[i + 1][j]);
      }
    } else {
      if (j == 0) {
        list.add(arr[i][sizeBreadth - 1]);
      } else {
        if (isPresent(i, j - 1)) {
          list.add(arr[i][j - 1]);
        }
      }

      //    Check East
      if (j == sizeBreadth - 1) {
        list.add(arr[i][0]);
      } else {
        if (isPresent(i, j + 1)) {
          list.add(arr[i][j + 1]);
        }
      }

      //    Check North
      if (i == 0) {
        list.add(arr[sizeLength - 1][j]);
      } else {
        if (isPresent(i - 1, j)) {
          list.add(arr[i - 1][j]);
        }
      }

      //    Check South
      if (i == sizeLength - 1) {
        list.add(arr[0][j]);
      } else {
        if (isPresent(i + 1, j)) {
          list.add(arr[i + 1][j]);
        }
      }
    }
    return list;
  }

  private List<List<Integer>> getAdjacentList() {
    List<List<Integer>> adjacent = new ArrayList<>();

    for (int i = 0; i < sizeLength; i++) {
      for (int j = 0; j < sizeBreadth; j++) {
        adjacent.add(getNeighbour(i, j));
      }
    }
    return adjacent;
  }


  private int[][] adjacencyMatrix() {
    if (sizeLength < 0 || sizeBreadth < 0) {
      throw new IllegalArgumentException("The Size of the maze cannot be Negative");
    }
    int[][] cost = new int[getVertices()][getVertices()];
    List<List<Integer>> adjacent = getAdjacentList();
    for (int i = 0; i < getVertices(); i++) {
      for (int j = 0; j < getVertices(); j++) {
        if (adjacent.get(i).contains(j)) {
          cost[i][j] = random.nextInt(1000);
        } else {
          cost[i][j] = INF;
        }
      }
    }
    return cost;
  }

  private Set<List<Integer>> getRemainingList() {
    List<List<Integer>> edgeList = this.edgeList;
    List<List<Integer>> adjacent = getAdjacentList();

    Set<List<Integer>> remainingList = new HashSet<>();
    for (int i = 0; i < adjacent.size(); i++) {
      for (int j = 0; j < adjacent.get(i).size(); j++) {
        List<Integer> inner1 = new ArrayList<>();
        inner1.add(i);
        inner1.add(adjacent.get(i).get(j));
        List<Integer> inner2 = new ArrayList<>();
        inner2.add(adjacent.get(i).get(j));
        inner2.add(i);
        if (!edgeList.contains(inner1) && !edgeList.contains(inner2)) {
          Collections.sort(inner1);
          remainingList.add(inner1);
        }
      }
    }
    return remainingList;
  }

  private int setStartPoint() {
    return random.nextInt(getVertices());
  }

  /**
   * This is used to get the start Point.
   *
   * @return start point.
   */
  @Override
  public int getStartPoint() {
    return startPoint;
  }

  private int setEndPoint() {
    int endpoint = startPoint;
    while (endpoint == startPoint) {
      endpoint = random.nextInt(getVertices());
      if (endpoint != startPoint) {
        break;
      }
    }
    return endpoint;
  }

  /**
   * This is used to get the end point.
   *
   * @return end point.
   */
  @Override
  public int getEndPoint() {
    return endPoint;
  }

  /**
   * This is used to get the adjaceny edge list.
   *
   * @return adjacency list.
   */
  @Override
  public List<List<Integer>> edgeAdjacencyList() {
    List<List<Integer>> edgeList = this.interconnectivityList;
    List<List<Integer>> edgeAdjacencyList = new ArrayList<>();

    for (int i = 0; i < getVertices(); i++) {
      edgeAdjacencyList.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < edgeList.size(); i++) {
      addEdge(edgeAdjacencyList, edgeList.get(i).get(0), edgeList.get(i).get(1));
    }
    return edgeAdjacencyList;
  }

  private static void addEdge(List<List<Integer>> adj, int i, int j) {
    adj.get(i).add(j);
    adj.get(j).add(i);
  }

  /**
   * This is used to get the Directions available to move for a given node.
   *
   * @return Direction list per node.
   */
  @Override
  public List<List<String>> edgeDirectionList() {
    List<List<Integer>> list = edgeAdjacencyList;
    List<List<String>> edgeDirectionList = new ArrayList<>();
    int index = 0;
    for (List<Integer> inner : list) {
      List<String> temp = new ArrayList<>();
      for (int i = 0; i < inner.size(); i++) {
        if (index - inner.get(i) == 1) {
          temp.add("W");
        }
        if (index - inner.get(i) == -1) {
          temp.add("E");
        }
        if (index - inner.get(i) == -sizeBreadth) {
          temp.add("S");
        }
        if (index - inner.get(i) == sizeBreadth) {
          temp.add("N");
        }

        if (index - inner.get(i) == -(sizeBreadth - 1)) {
          temp.add("W");
        }
        if (index - inner.get(i) == (sizeBreadth - 1)) {
          temp.add("E");
        }
        if (index - inner.get(i) < -sizeBreadth) {
          temp.add("N");
        }
        if (index - inner.get(i) > sizeBreadth) {
          temp.add("S");
        }
      }
      edgeDirectionList.add(temp);
      index++;
    }
    return edgeDirectionList;
  }

  /**
   * This is used to update the player 's current location.
   */
  @Override
  public void updatePlayerLocation(int playerLocation) {
    if (this.playerLocation == getEndPoint()) {
      throw new IllegalArgumentException("Player is already at the end point");
    }
    this.playerLocation = playerLocation;
  }

  /**
   * This is used to get the player location.
   *
   * @return Player location node.
   */
  @Override
  public int getPlayerLocation() {
    return playerLocation;
  }

  /**
   * This used to get the Otyugh Smell from the plyaers current location.
   *
   * @param playerLocation Player location node.
   * @return Otyugh Smell.
   */
  @Override
  public String getOtyughSmell(int playerLocation) {
    List<Integer> distances = new ArrayList<>();
    String smell = "";
    for (int i = 0; i < getOtyughLocations().size(); i++) {
      distances.add(shortestDistance(edgeAdjacencyList, playerLocation,
              getOtyughLocations().get(i), getVertices()));
    }
    smell = "No smell nearby";
    if (Collections.frequency(distances, 2) == 1) {
      smell = "You can smell something less Pungent nearby";
    }
    if (Collections.frequency(distances, 1) >= 1) {
      smell = "You can smell something more Pungent nearby";
    }
    if (Collections.frequency(distances, 2) > 1) {
      smell = "You can smell multiple smells more Pungent nearby";
    }
    return smell;
  }

  private Map<Treasure, Integer> setPlayerTreasureList() {
    Map<Treasure, Integer> treasureList = new HashMap<>();
    treasureList.put(Treasure.SAPPHIRE, 0);
    treasureList.put(Treasure.RUBY, 0);
    treasureList.put(Treasure.DIAMOND, 0);
    return treasureList;
  }

  /**
   * This is used to get the number of Treasures which the player has.
   *
   * @return Number of treasures.
   */
  @Override
  public Map<Treasure, Integer> getPlayerTreasureList() {
    return playerTreasureList;
  }

  /**
   * This is used to pick the treasure from the list.
   *
   * @param treasure Treasure to be picked.
   */
  @Override
  public void pickUpTreasure(Treasure treasure, int playerLocation) {
    playerTreasureList.put(treasure, playerTreasureList.get(treasure) + 1);
    treasureList.get(playerLocation).remove(treasure);
  }

  /**
   * This is used to get the Number of Player Arrows.
   *
   * @return playerArrowlist Number of arrows.
   */
  @Override
  public int getPlayerArrowlist() {
    return playerArrowlist;
  }

  /**
   * This is used to pickup the Arrows.
   */
  @Override
  public void pickArrows(int noOfArrows, int playerLocation) {
    playerArrowlist = playerArrowlist + noOfArrows;
    arrowLocations.set(playerLocation, 0);
  }

  /**
   * This is used to get the Otyugh nodes and their health.
   * @return Otyugh List.
   */
  @Override
  public Map<Integer, Integer> getOtyughHealthList() {
    return otyughHealthList;
  }

  private Map<Integer, Integer> otyughHealthList() {
    Map<Integer, Integer> otyughHealthList = new HashMap<>();
    List<Integer> otyughList = otyughLocations;
    for (int i = 0; i < otyughList.size(); i++) {
      otyughHealthList.put(otyughList.get(i), 100);
    }
    return otyughHealthList;
  }

  private Map<Integer, Integer> updateOtyugHealthList(Map<Integer, Integer> list) {
    otyughHealthList = list;
    return otyughHealthList;
  }

  /**
   * This is used to shoot arrows at the Otyugh.
   *
   * @param arrowDistance Distance of the arrow.
   * @param direction     Direction of the arrow.
   * @return Message.
   */
  @Override
  public String shootArrow(int arrowDistance, String direction) {
    String message = "";
    if (playerArrowlist <= 0) {
      message = "You have no arrows left\n";
      return message;
    } else {
      playerArrowlist = playerArrowlist - 1;
    }
    int arrowLocation = getPlayerLocation();
    List<List<String>> directionList = edgeDirectionList();
    List<List<Integer>> adjacencyList = edgeAdjacencyList();

    if (directionList.get(arrowLocation).contains(direction)) {
      message = "Arrow shot in the dark\n";
      while (arrowDistance > 0) {
        int index = directionList.get(arrowLocation).indexOf(direction);
        if (index == -1) {
          message = "Arrow did not hit the monster\n";
          return message;
        }
        arrowLocation = adjacencyList.get(arrowLocation).get(index);
        if (assignCaveOrTunnel(arrowLocation).equalsIgnoreCase("Cave")) {
          arrowDistance--;
        } else {
          for (int i = 0; i < directionList.get(arrowLocation).size(); i++) {
            if (i != index) {
              direction = directionList.get(arrowLocation).get(i);
            }
          }
        }
      }
      if (otyughHealthList.containsKey(arrowLocation)) {
        otyughHealthList.put(arrowLocation, otyughHealthList.get(arrowLocation) - 50);
        updateOtyugHealthList(otyughHealthList);
        message = message + "Otyugh Hit by Arrow\n";
        if (otyughHealthList.get(arrowLocation) == 0) {
          otyughLocations.remove((Integer) arrowLocation);
          otyughHealthList.remove(arrowLocation);
          message = message + "Otyugh is Dead\n";
        } else {
          message = message + "Otyugh Health is " + otyughHealthList.get(arrowLocation) + "\n";
        }
      }
    } else {
      message = "Arrow Shot and it hit the wall\n";
    }

    return message;
  }

  /**
   * This is used to get the shortest distance between start and end point.
   *
   * @return distance.
   */
  @Override
  public int getShortestDistance() {
    return shortestDistance(edgeAdjacencyList, startPoint, endPoint, getVertices());
  }

  /**
   * This is used to get the shortest Path between start and end points.
   *
   * @return Path.
   */
  @Override
  public List<Integer> getShortestPath() {
    return shortestPath(edgeAdjacencyList, startPoint, endPoint, getVertices());
  }

  private int shortestDistance(List<List<Integer>> adj, int s, int dest, int v) {
    int[] pred = new int[v];
    int[] dist = new int[v];

    if (!bfs(adj, s, dest, v, pred, dist)) {
      throw new IllegalArgumentException("Nodes are not connected.");
    }

    // LinkedList to store path
    LinkedList<Integer> path = new LinkedList<Integer>();
    int crawl = dest;
    path.add(crawl);
    while (pred[crawl] != -1) {
      path.add(pred[crawl]);
      crawl = pred[crawl];
    }
    return dist[dest];
  }

  private List<Integer> shortestPath(List<List<Integer>> adj, int s, int dest, int v) {
    int[] pred = new int[v];
    int[] dist = new int[v];

    if (!bfs(adj, s, dest, v, pred, dist)) {
      throw new IllegalArgumentException("Nodes are not connected.");
    }

    // LinkedList to store path
    LinkedList<Integer> path = new LinkedList<Integer>();
    int crawl = dest;
    path.add(crawl);
    while (pred[crawl] != -1) {
      path.add(pred[crawl]);
      crawl = pred[crawl];
    }

    List<Integer> shortestPath = new LinkedList<Integer>();
    for (int i = path.size() - 1; i >= 0; i--) {
      shortestPath.add(path.get(i));
    }
    if (shortestPath == null) {
      throw new IllegalArgumentException("Path cannot be null");
    }
    if (shortestPath.size() < 5) {
      throw new IllegalArgumentException("Path cannot be less tha 5");
    }

    return shortestPath;
  }


  private static boolean bfs(List<List<Integer>> adj, int src,
                             int dest, int v, int[] pred, int[] dist) {

    boolean[] visited = new boolean[v];

    for (int i = 0; i < v; i++) {
      visited[i] = false;
      dist[i] = Integer.MAX_VALUE;
      pred[i] = -1;
    }

    LinkedList<Integer> queue = new LinkedList<Integer>();
    visited[src] = true;
    dist[src] = 0;
    queue.add(src);

    // bfs Algorithm
    while (!queue.isEmpty()) {
      int u = queue.remove();
      for (int i = 0; i < adj.get(u).size(); i++) {
        if (!visited[adj.get(u).get(i)]) {
          visited[adj.get(u).get(i)] = true;
          dist[adj.get(u).get(i)] = dist[u] + 1;
          pred[adj.get(u).get(i)] = u;
          queue.add(adj.get(u).get(i));

          if (adj.get(u).get(i) == dest) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * This is used to assign the nodes as tunnel or cave.
   *
   * @param j node index.
   * @return cave/tunnel.
   */
  @Override
  public String assignCaveOrTunnel(int j) {
    List<List<Integer>> edgeList = this.interconnectivityList;
    List<Integer> result = new ArrayList<>();
    edgeList.forEach(result::addAll);
    int openings = Collections.frequency(result, j);
    if (openings == 2) {
      return "Tunnel";
    } else {
      return "Cave";
    }
  }

  /**
   * This is used to get the Cave/Tunnel Details.
   *
   * @param i node index.
   * @return class object.
   */
  @Override
  public CaveTunnel getCaveTunnelDetails(int i) {
    List<Treasure> treasures = treasureList.get(i);
    String caveType = assignCaveOrTunnel(i);
    CaveTunnel caveTunnel = new CaveTunnel(caveType, treasures);
    return caveTunnel;
  }

  private Map<Treasure, Integer> playerTreasureList() {
    HashMap<Treasure, Integer> treasureList = new HashMap<>();
    treasureList.put(Treasure.DIAMOND, 0);
    treasureList.put(Treasure.SAPPHIRE, 0);
    treasureList.put(Treasure.RUBY, 0);
    Map<Integer, List<Treasure>> treasureMap = getTreasureList();
    List<Integer> path = getShortestPath();
    for (Integer key : treasureMap.keySet()) {
      if (path.contains(key)) {
        List<Treasure> inner = treasureMap.get(key);
        int diamond = Collections.frequency(inner, Treasure.DIAMOND);
        int sapphire = Collections.frequency(inner, Treasure.SAPPHIRE);
        int ruby = Collections.frequency(inner, Treasure.RUBY);
        treasureList.put(Treasure.DIAMOND, treasureList.get(Treasure.DIAMOND) + diamond);
        treasureList.put(Treasure.SAPPHIRE, treasureList.get(Treasure.SAPPHIRE) + sapphire);
        treasureList.put(Treasure.RUBY, treasureList.get(Treasure.RUBY) + ruby);
      }
    }

    return treasureList;
  }

  /**
   * This is used to get the treasure collected by the player.
   *
   * @return Treasure map.
   */
  @Override
  public Map<Treasure, Integer> getFinalPlayerTreasureList() {
    return finalPlayerTreasureList;
  }

  private Map<Integer, List<Treasure>> populateTreasure() {
    HashMap<Integer, List<Treasure>> treasureList = new HashMap<>();
    List<Treasure> treasures = new ArrayList<>();
    int size = 0;
    for (int i = 0; i < getVertices(); i++) {
      if (assignCaveOrTunnel(i).equalsIgnoreCase("Cave")) {
        size++;
      }
    }
    double percent = treasurePercent;
    int allocationPercent = (int) Math.ceil((percent / 100.0) * size);
    int k = random.nextInt(allocationPercent + 1);
    for (int i = 0; i < getVertices(); i++) {
      List<Treasure> treasure = new ArrayList<>();
      if (assignCaveOrTunnel(i).equalsIgnoreCase("Tunnel")) {
        treasureList.put(i, treasure);
      } else {
        if (treasurePercent != 0) {
          if (k < getVertices()) {
            k = k + allocationPercent;

            treasures.add(Treasure.DIAMOND);
            treasures.add(Treasure.RUBY);
            treasures.add(Treasure.SAPPHIRE);
            Collections.shuffle(treasures, random);
            int gen = random.nextInt(4 - 1) + 1;
            List<Treasure> inner = new ArrayList<>();
            if (gen == 3) {
              inner.add(treasures.get(0));
              inner.add(treasures.get(1));
              inner.add(treasures.get(2));
            } else if (gen == 2) {
              inner.add(treasures.get(0));
              inner.add(treasures.get(1));
            } else {
              inner.add(treasures.get(0));
            }
            treasureList.put(i, inner);
          } else {
            treasureList.put(i, treasure);
          }
        } else {
          treasureList.put(i, treasure);
        }
      }
    }

    return treasureList;
  }

  /**
   * This is used to get the Treasure List in the dungeon.
   *
   * @return Treasure map.
   */
  @Override
  public Map<Integer, List<Treasure>> getTreasureList() {
    HashMap<Integer, List<Treasure>> list = new HashMap<>();
    for (int i = 0; i < getVertices(); i++) {
      list.put(i, treasureList.get(i));
    }
    return treasureList;
  }


  /**
   * String representation of the graph object.
   *
   * @return String representation of the graph object.
   */
  public String toString() {
    return helper(getArray());
  }

  private String helper(int[][] maze) {
    List<List<Integer>> edgeAdjacencyList = this.edgeAdjacencyList;
    StringBuilder ob = new StringBuilder();
    int rowSize = 0;
    int maxSize = String.valueOf(getVertices() - 1).length();
    int connectorVer = 0;
    int connectorVer1 = 0;
    String connectorVarStr = "";
    String connectorVarStr1 = "";
    for (int i = 0; i < getVertices(); i++) {
      int eleSize = String.valueOf(i).length();
      rowSize++;
      String repeat = " ".repeat(Math.max(0, maxSize - eleSize) + 1);
      int connectorHor = 0;
      int connectorHor1 = 0;

      for (int j = 0; j < edgeAdjacencyList.get(i).size(); j++) {

        int ele = edgeAdjacencyList.get(i).get(j);
        int diff = ele - i;
        if (diff == Math.abs(1)) {
          connectorHor = 1;
        }
        if (diff > Math.abs(1) && diff < sizeLength) {
          connectorHor1 = 1;
        }
        if (diff == sizeLength) {
          connectorVer = 1;
          connectorVarStr = connectorVarStr + "|  ";
        }
        if (Math.abs(diff) > sizeLength && i >= getVertices() - sizeLength) {
          connectorVer1 = 1;
          connectorVarStr1 = connectorVarStr1 + "|  ";
        }
      }
      if (assignCaveOrTunnel(i).equalsIgnoreCase("Cave")) {
        if (connectorHor == 1 && connectorHor1 == 1) {
          ob.append("--");
          ob.append(i).append("C");
          ob.append("--");
          ob.append(repeat);
          connectorVarStr = connectorVarStr + repeat + "   ";
          connectorVarStr1 = "  " + connectorVarStr1 + repeat + "   ";
        } else if (connectorHor == 1) {
          ob.append("  ");
          ob.append(i).append("C");
          ob.append("--");
          ob.append(repeat);
          connectorVarStr = connectorVarStr + repeat + " ";
          connectorVarStr1 = " " + connectorVarStr1 + repeat + "   ";
        } else if (connectorHor1 == 1) {
          ob.append("--");
          ob.append(i).append("C");
          ob.append("--");
          ob.append(repeat);
          connectorVarStr = connectorVarStr + repeat + " ";
          connectorVarStr1 = " " + connectorVarStr1 + repeat + "   ";
        } else {
          ob.append("  ");
          ob.append(i).append("C");
          ob.append(repeat);
          ob.append("  ");
          connectorVarStr = "   " + connectorVarStr + repeat + "   ";
          connectorVarStr1 = "   " + connectorVarStr1 + repeat + "   ";
        }
      } else {
        if (connectorHor == 1 && connectorHor1 == 1) {
          ob.append("--");
          ob.append(i).append("T");
          ob.append("--");
          ob.append(repeat);
          connectorVarStr = connectorVarStr + repeat + "   ";
          connectorVarStr1 = "  " + connectorVarStr1 + repeat + "   ";
        } else if (connectorHor == 1) {
          ob.append("  ");
          ob.append(i).append("T");
          ob.append("--");
          ob.append(repeat);
          connectorVarStr = connectorVarStr + repeat + " ";
          connectorVarStr1 = " " + connectorVarStr1 + repeat + "   ";
        } else if (connectorHor1 == 1) {
          ob.append("--");
          ob.append(i).append("T");
          ob.append("  ");
          ob.append(repeat);
          connectorVarStr = connectorVarStr + repeat + " ";
          connectorVarStr1 = " " + connectorVarStr1 + repeat + "   ";
        } else {
          ob.append("  ");
          ob.append(i).append("T");
          ob.append(repeat);
          ob.append("  ");
          connectorVarStr = "   " + connectorVarStr + repeat + "   ";
          connectorVarStr1 = "   " + connectorVarStr1 + repeat + "   ";
        }
      }
      if (rowSize >= sizeBreadth) {
        if (connectorVer == 1) {
          ob.append("\n");
          ob.append("  ").append(connectorVarStr);
        }
        if (connectorVer1 == 1) {
          ob.append("\n");
          ob.append("  ").append(connectorVarStr1);
        }
        ob.append("\n");
        rowSize = 0;
        connectorVer = 0;
        connectorVer1 = 0;
        connectorVarStr = "";
        connectorVarStr1 = "";
      }
    }
    ob.append("\n");
    return ob.toString();
  }

}

