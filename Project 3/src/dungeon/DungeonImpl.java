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
  private final Map<Treasure, Integer> playerTreasureList;

  private final int[] parent;
  static int INF = Integer.MAX_VALUE;
  static Random random = new Random();

  /**
   * This is the constructor for the DungeonImpl class.
   *
   * @param sizeLength        length of the maze.
   * @param sizeBreadth       breadth of the maze.
   * @param interconnectivity interconnectivity of the maze.
   * @param wrapping          wrapping value of the maze.
   * @param treasurePercent   treasure percent of the maze.
   * @Throws IllegalArgumentException for null values.
   */
  public DungeonImpl(int sizeLength, int sizeBreadth, int interconnectivity, boolean wrapping,
                     int treasurePercent) {
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
    playerTreasureList = playerTreasureList();

    nullChecks();
  }

  private void nullChecks() {
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
    List<Treasure> treasures = getTreasureList().get(i);
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
  public Map<Treasure, Integer> getPlayerTreasureList() {
    return playerTreasureList;
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
    int allocationPercent = (int) Math.floor((percent / 100.0) * size);
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
    return list;
  }


  /**
   * String representation of the graph object.
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

