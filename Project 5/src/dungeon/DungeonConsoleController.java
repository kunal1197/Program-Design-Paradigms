package dungeon;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This is the implementation of the DungeonController interface, which is used create a
 * console-based dungeon game.
 */
public class DungeonConsoleController implements DungeonController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   *
   * @param in  the source to read from.
   * @param out the target to print to.
   * @throws IOException if the input or output cannot be read or written to.
   */
  public DungeonConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  /**
   * Execute a single game of Dungeon given a dungeon, Player, Monster Model. When the game is over,
   * the playGame method ends.
   *
   * @param dungeon is a non-null model for Dungeon.
   * @param player  is a non-null model for Player.
   * @param monster is a non-null model for Monster.
   */
  @Override
  public void playGame(Dungeon dungeon, Player player, Monster monster) {
    if (dungeon == null || player == null || monster == null) {
      throw new IllegalArgumentException("Dungeon can't be null");
    }
    try {
      out.append("---------------------\n");
      out.append("The Generated Dungeon\n");
      out.append(dungeon.toString()).append("\n");

      out.append("\nThe Connections of each Node.\n");
      List<List<Integer>> list = dungeon.edgeAdjacencyList();
      for (int i = 0; i < list.size(); i++) {
        out.append("Node - ").append(String.valueOf(i))
                        .append(", Edges -> ").append(String.valueOf(list.get(i))).append("\n");
      }

      out.append("\nThe Random Starting Point\n");
      out.append(String.valueOf(dungeon.getStartPoint())).append("\n");

      out.append("\nThe Random Ending Point\n");
      out.append(String.valueOf(dungeon.getEndPoint())).append("\n");

      out.append("\nTreasure Populated in Dungeon\n");
      for (int i = 0; i < dungeon.getVertices(); i++) {
        out.append("Node-").append(String.valueOf(i)).append(" ")
                .append(dungeon.getCaveTunnelDetails(i).toString()).append("\n");
      }

      out.append("\nArrows populated in the Dungeon\n");
      for (int i = 0; i < dungeon.getVertices(); i++) {
        if (dungeon.getArrowLocations().get(i) == 0) {
          out.append("Node-").append(String.valueOf(i)).append(" ")
          .append("No Arrow").append("\n");
        } else {
          out.append("Node-").append(String.valueOf(i)).append(" ")
                  .append(String.valueOf(dungeon.getArrowLocations().get(i)))
                  .append(" Arrow").append("\n");
        }
      }

      out.append("\nOtyugh Locations inside the Dungeon\n");
      for (int i = 0; i < dungeon.getOtyughLocations().size(); i++) {
        out.append("Cave - ").append(dungeon.getOtyughLocations().get(i).toString()).append("\n");
      }

      out.append("\nThe Minimum Distance from Start to End Point\n");
      out.append(String.valueOf(dungeon.getShortestDistance())).append("\n");

      List<Integer> playerPath = player.getPlayerPath();
      out.append("\nThe Suggested Path from Start to End Point\n");
      for (int i = 0; i < playerPath.size(); i++) {
        if (i <= playerPath.size() - 2) {
          out.append(String.valueOf(playerPath.get(i))).append("->");
        } else {
          out.append(String.valueOf(playerPath.get(i)));
        }
      }
      out.append("\n");

      String choice = "";
      int directionCell = 0;
      int choice2 = 0;
      int distance = 0;
      String direction = "";
      while (true) {

        if (dungeon.checkPlayerAvoidanceAbility(dungeon.getPlayerLocation()).containsKey(1)) {
          out.append("\nPlayer is in a Cave with Otyugh\n");
          out.append(dungeon.checkPlayerAvoidanceAbility(dungeon.getPlayerLocation()).get(1));
          out.append("Game Over!!");
          break;
        }
        else if (dungeon.checkPlayerAvoidanceAbility(dungeon.getPlayerLocation()).containsKey(0)) {
          out.append("\nPlayer is in a Cave with Otyugh\n");
          out.append(dungeon.checkPlayerAvoidanceAbility(dungeon.getPlayerLocation()).get(0));
          out.append("Game Continues");
        }

        if (dungeon.getPlayerLocation() == dungeon.getEndPoint()) {
          out.append("\nThe player has reached end point\n");
          out.append("Game Over!!");
          break;
        }

        out.append("\nYou are in a ")
                .append(dungeon.assignCaveOrTunnel(dungeon.getPlayerLocation())).append("\n");

        out.append(dungeon.getOtyughSmell(dungeon.getPlayerLocation())).append("\n");

        out.append("The Player's Location is ")
                .append(String.valueOf(dungeon.getPlayerLocation())).append(" Node");

        out.append("\nYou find all these gems here\n");
        out.append(dungeon.getCaveTunnelDetails(dungeon.getPlayerLocation()).toString());

        out.append("\nThe number of arrows you find here\n");
        out.append(String.valueOf(dungeon.getArrowLocations().get(dungeon.getPlayerLocation())));

        out.append("\nThe number of arrows the player has\n");
        out.append(String.valueOf(dungeon.getPlayerArrowlist()));

        out.append("\nThe number of Gems the player has\n");
        out.append(String.valueOf(dungeon.getPlayerTreasureList()));

        out.append("\nDoors Lead to\n")
                .append(String.valueOf(dungeon.edgeDirectionList()
                        .get(dungeon.getPlayerLocation())));
        out.append("\nMove, Pickup, or Shoot (M-P-S)?\n");

        try {
          choice = scan.next();
        } catch (NoSuchElementException e) {
          out.append("\nIncomplete Inputs");
        }

        if (choice.equalsIgnoreCase("M")) {
          out.append("\nWhere do you want to go? \n");
          int t = dungeon.edgeAdjacencyList().get(dungeon.getPlayerLocation()).size();
          for (int i = 0; i < t; i++) {
            out.append(String.valueOf(dungeon.edgeAdjacencyList()
                    .get(dungeon.getPlayerLocation()).get(i))).append(" will lead to ");
            out.append(dungeon.edgeDirectionList()
                    .get(dungeon.getPlayerLocation()).get(i)).append("\n");
          }
          out.append("Enter Cell Number you want to go next\n");

          try {
            directionCell = scan.nextInt();
          } catch (NoSuchElementException e) {
            out.append("\nIncomplete Inputs");
          }
          if (!dungeon.edgeAdjacencyList().get(dungeon.getPlayerLocation())
                  .contains(directionCell)) {
            out.append("\nInvalid Cell Number\n");
            out.append("Enter Value Again\n");
          } else {
            dungeon.updatePlayerLocation(directionCell);
          }
        } else if (choice.equalsIgnoreCase("P")) {
          out.append("\nWhat do you want to pick?");
          out.append("\n Press 1 for treasure");
          out.append("\n Press 2 for arrow");
          out.append("\n Press 3 for both\n");

          try {
            choice2 = scan.nextInt();
          } catch (NoSuchElementException e) {
            out.append("\nIncomplete Inputs");
          }
          if (choice2 == 1) {
            List<Treasure> treasures = dungeon.getTreasureList().get(dungeon.getPlayerLocation());
            for (int i = 0; i < treasures.size(); i++) {
              dungeon.pickUpTreasure(treasures.get(i), dungeon.getPlayerLocation());
            }
            out.append("\nYou have picked up all the treasures\n");
          } else if (choice2 == 2) {
            dungeon.pickArrows(dungeon.getArrowLocations().get(dungeon.getPlayerLocation()),
                    dungeon.getPlayerLocation());
            out.append("\nYou have picked up all the arrows\n");
          } else if (choice2 == 3) {
            List<Treasure> treasures = dungeon.getTreasureList().get(dungeon.getPlayerLocation());
            for (int i = 0; i < treasures.size(); i++) {
              dungeon.pickUpTreasure(treasures.get(i), dungeon.getPlayerLocation());
            }
            dungeon.pickArrows(dungeon.getArrowLocations().get(dungeon.getPlayerLocation()),
                    dungeon.getPlayerLocation());
            out.append("\nYou have picked up all the treasures and arrows\n");
          } else {
            out.append("\nInvalid Input\n");
            out.append("Enter Value Again\n");
          }
        } else if (choice.equalsIgnoreCase("S")) {
          out.append("\nEnter the Distance you want to shoot\n");

          try {
            try {
              distance = scan.nextInt();
            } catch (NoSuchElementException e) {
              out.append("\nIncomplete Inputs");
            }
            out.append("\nWhere do you want to shoot?");
            out.append("\nEnter the Direction\n");

            try {
              direction = scan.next();
            } catch (NoSuchElementException e) {
              out.append("\nIncomplete Inputs");
            }
            if (direction.equalsIgnoreCase("N") || direction.equalsIgnoreCase("S")
                    || direction.equalsIgnoreCase("E") || direction.equalsIgnoreCase("W")) {
              out.append(dungeon.shootArrow(distance, direction));
            } else {
              out.append("\nInvalid Direction\n");
            }
          } catch (InputMismatchException e) {
            out.append("\nPlease Enter a valid Distance\n");
          }

        } else {
          out.append("\nInvalid Input\n");
          out.append("Please enter a valid value\n");
        }
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    }
  }
}
