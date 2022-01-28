package dungeon;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This is the Driver class where we have the initial details which are required to start the
 * Dungeon Game Up and Running.
 */
public class DriverClass {

  /**
   * This is the main method where the game starts.
   * @param args String[].
   */
  public static void main(String[] args) {

    Scanner ob = new Scanner(System.in);
    System.out.println("***************************");
    System.out.println("* Welcome to Dungeon Game *");
    System.out.println("***************************");

    System.out.println("Enter Your Name");
    String playerName = args[0];
    System.out.println(playerName);

    System.out.println("Enter the Dungeon Length");
    int dungeonLength = Integer.parseInt(args[1]);
    System.out.println(dungeonLength);

    System.out.println("Enter the Dungeon Breadth");
    int dungeonBreadth = Integer.parseInt(args[2]);
    System.out.println(dungeonBreadth);

    // Max can be Nodes + interconnectivity - 1;
    System.out.println("Enter the Interconnectivity Degree");
    int interConnectivity = Integer.parseInt(args[3]);
    System.out.println(interConnectivity);

    System.out.println("Is is Wrapping or not? true : false");
    boolean wrapping = Boolean.parseBoolean(args[4]);
    System.out.println(wrapping);

    System.out.println("Enter the Treasure Percentage you want in the Caves");
    int treasure = Integer.parseInt(args[5]);
    System.out.println(treasure);

    Dungeon dungeon = new DungeonImpl(dungeonLength, dungeonBreadth, interConnectivity, wrapping,
            treasure);

    System.out.println("\nThe edges formed in the graph in Pairs");
    System.out.println(dungeon.interconnectivityList());

    System.out.println("\nThe Connections of each Node.");
    List<List<Integer>> list = dungeon.edgeAdjacencyList();
    for (int i = 0; i < list.size(); i++) {
      System.out.println("Node - " + i + ", Edges -> " + list.get(i));
    }

    System.out.println("\nThe Random Generated Maze");
    System.out.println(dungeon);

    System.out.println("\nThe Random Starting Point");
    System.out.println(dungeon.getStartPoint());

    System.out.println("\nThe Random Ending Point");
    System.out.println(dungeon.getEndPoint());

    System.out.println("\nTreasure Populated in Dungeon");
    for (int i = 0; i < dungeon.getVertices(); i++) {
      System.out.println("Node-" + i + " " + dungeon.getCaveTunnelDetails(i).toString());
    }

    System.out.println("\nDistance it took to reach from Start to End Point");
    System.out.println(dungeon.getShortestDistance());

    List<Integer> path = dungeon.getShortestPath();
    Map<Treasure, Integer> playerBag = dungeon.getPlayerTreasureList();

    Player player = new PlayerImpl(playerName, path, playerBag);
    List<Integer> playerPath = player.getPlayerPath();

    System.out.println("\nThe Path which Player took to Reach End Point");
    for (int i = 0; i < playerPath.size(); i++) {
      if (i <= playerPath.size() - 2) {
        System.out.print(playerPath.get(i) + "->");
      } else {
        System.out.print(playerPath.get(i));
      }
    }

    System.out.println("\n\nThe Final Treasure List Collected by the Player.");
    System.out.println(player.playerTreasureList());

    System.out.println("\nWow " + playerName + ",you reached the end the of the Maze.");
    System.out.println("Game Over!!");
  }

}