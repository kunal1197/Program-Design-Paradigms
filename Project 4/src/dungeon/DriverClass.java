package dungeon;

import java.io.InputStreamReader;
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

    System.out.println("Enter the Number of Monsters you want in the Caves");
    int monsterNo = Integer.parseInt(args[6]);
    System.out.println(monsterNo);

    Dungeon dungeon = new DungeonImpl(dungeonLength, dungeonBreadth, interConnectivity, wrapping,
            treasure, monsterNo);

    List<Integer> path = dungeon.getShortestPath();
    Map<Treasure, Integer> playerBag = dungeon.getFinalPlayerTreasureList();

    Player player = new PlayerImpl(playerName, path, playerBag);


    Monster monster = new MonsterImpl(monsterNo, dungeon.populateOtyughs());

    Readable input = new InputStreamReader(System.in);
    Appendable output = System.out;
    new DungeonConsoleController(input, output).playGame(dungeon, player, monster);

  }

}