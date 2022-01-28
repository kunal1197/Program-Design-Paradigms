package dungeon;

import java.io.IOException;
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
   *
   * @param args String[].
   */
  public static void main(String[] args) throws IOException {

    if (args.length == 0) {
      String playerName = "Kunal";
      int dungeonLength = 4;
      int dungeonBreadth = 4;
      int interConnectivity = 2;
      boolean wrapping = true;
      int treasure = 50;
      int monsterNo = 5;

      Dungeon dungeon = new DungeonImpl(dungeonLength, dungeonBreadth, interConnectivity, wrapping,
              treasure, monsterNo);

      List<Integer> path = dungeon.getShortestPath();
      Map<Treasure, Integer> playerBag = dungeon.getFinalPlayerTreasureList();

      Player player = new PlayerImpl(playerName, path, playerBag);


      Monster monster = new MonsterImpl(monsterNo, dungeon.populateOtyughs());

      // GUI Based Controller Game
      DungeonView view = new DungeonSwingView(dungeon);
      DungeonViewController controller = new DungeonViewConsoleController(dungeon, view);

      view.makeVisible();
      view.addClickListener(controller);
      view.addKeyListener(controller);
      controller.playGame(dungeon, player, monster);
      view.startNewGame(controller);
    } else {

      Scanner ob = new Scanner(System.in);
      System.out.println("***************************");
      System.out.println("* Welcome to Dungeon Game *");
      System.out.println("***************************");

      String playerName = "Kunal";
      int dungeonLength = 0;
      int dungeonBreadth = 0;
      int interConnectivity = 0;
      boolean wrapping = false;
      int treasure = 0;
      int monsterNo = 0;

      System.out.println("Enter Your Name");
      try {
        playerName = args[0];
        System.out.println(playerName);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Name Missing");
      }

      System.out.println("Enter the Dungeon Length");
      try {
        dungeonLength = Integer.parseInt(args[1]);
        System.out.println(dungeonLength);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Dungeon Length Missing");
      }

      System.out.println("Enter the Dungeon Breadth");
      try {
        dungeonBreadth = Integer.parseInt(args[2]);
        System.out.println(dungeonBreadth);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Dungeon Breadth Missing");
      }

      // Max can be Nodes + interconnectivity - 1;
      System.out.println("Enter the Interconnectivity Degree");
      try {
        interConnectivity = Integer.parseInt(args[3]);
        System.out.println(interConnectivity);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Interconnectivity Degree Missing");
      }

      System.out.println("Is is Wrapping or not? true : false");
      try {
        wrapping = Boolean.parseBoolean(args[4]);
        System.out.println(wrapping);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Wrapping Missing");
      }

      System.out.println("Enter the Treasure Percentage you want in the Caves");
      try {
        treasure = Integer.parseInt(args[5]);
        System.out.println(treasure);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Treasure Percentage Missing");
      }

      System.out.println("Enter the Number of Monsters you want in the Caves");
      try {
        monsterNo = Integer.parseInt(args[6]);
        System.out.println(monsterNo);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Monster Number Missing");
      }

      Dungeon dungeon = new DungeonImpl(dungeonLength, dungeonBreadth, interConnectivity, wrapping,
              treasure, monsterNo);

      List<Integer> path = dungeon.getShortestPath();
      Map<Treasure, Integer> playerBag = dungeon.getFinalPlayerTreasureList();

      Player player = new PlayerImpl(playerName, path, playerBag);


      Monster monster = new MonsterImpl(monsterNo, dungeon.populateOtyughs());

      // Console Based Controller Game
      Readable input = new InputStreamReader(System.in);
      Appendable output = System.out;
      new DungeonConsoleController(input, output).playGame(dungeon, player, monster);

    }
  }

}