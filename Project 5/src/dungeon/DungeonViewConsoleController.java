package dungeon;

import java.util.List;

import javax.swing.JOptionPane;

/**
 * DungeonViewConsoleController is the implementation of the DungeonViewController.
 */
public class DungeonViewConsoleController implements DungeonViewController {

  private DungeonView view;
  private Dungeon model;
  private static int gameEnd = 0;

  /**
   * Constructor for DungeonViewConsoleController.
   *
   * @param model the model of the dungeon.
   * @param view  the view of the dungeon.
   */
  public DungeonViewConsoleController(Dungeon model, DungeonView view) {
    this.model = model;
    this.view = view;
    checkGameEndCondition();
  }

  /**
   * Execute a single game of Dungeon given a dungeon, Player, Monster Model. When the game is over,
   * the playGame method ends.
   *
   * @param dungeon is a non-null model for Dungeon.
   * @param p       is a non-null model for Player.
   * @param m       is a non-null model for Monster.
   */
  @Override
  public void playGame(Dungeon dungeon, Player p, Monster m) {

    JOptionPane.showMessageDialog(null, "Welcome to the dungeon!");

    if (dungeon.getPlayerLocation() != dungeon.getEndPoint()
            && dungeon.checkPlayerAvoidanceAbility(dungeon.getPlayerLocation()).containsKey(1)) {
      view.refresh();
    }
  }

  private void checkGameEndCondition() {
    if (model.getPlayerLocation() == model.getEndPoint()) {
      gameEnd = 1;
    }
    if (model.checkPlayerAvoidanceAbility(model.getPlayerLocation()).containsKey(1)) {
      gameEnd = 1;
    }
  }

  /**
   * This is used to start a new game with edited new parameters.
   *
   * @param dungeonLength     is the length of the dungeon.
   * @param dungeonBreadth    is the breadth of the dungeon.
   * @param interConnectivity is the interconnectivity of the dungeon.
   * @param wrapping          Value is the wrapping value of the dungeon.
   * @param treasure          Percent is the percentage of treasure in the dungeon.
   * @param monsterNo         is the number of monsters in the dungeon.
   */
  @Override
  public void editConfig(int dungeonLength, int dungeonBreadth, int interConnectivity,
                         boolean wrapping, int treasure, int monsterNo) {
    this.model = new DungeonImpl(dungeonLength, dungeonBreadth, interConnectivity, wrapping,
            treasure, monsterNo);
    gameEnd = 0;
    view.updateDungeon(model);
  }

  /**
   * This is used to restart the game.
   */
  @Override
  public void restartGame() {
    int seed = model.getRandomSeed();
    model.setSeed(seed);
    this.model = new DungeonImpl(model.getSizeBreadth(), model.getSizeLength(),
            model.getInterconnectivity(), model.getWrappingValue(), model.getTreasurePercent(),
            model.getNoOfOtyughs());
    gameEnd = 0;
    view.updateDungeon(model);
  }

  /**
   * This is used to move the player in the dungeon.
   *
   * @param i input is the direction of the player.
   */
  @Override
  public void movePlayer(int i) {
    if (gameEnd == 0) {
      if (model.getPlayerLocation() != model.getEndPoint()) {
        model.updatePlayerLocation(i);
        view.refresh();
        System.out.println(model.getPlayerLocation());
        if (model.checkPlayerAvoidanceAbility(model.getPlayerLocation()).containsKey(1)) {
          JOptionPane.showMessageDialog(null, "You have been killed by Otyugh");
          gameEnd = 1;
        }
      } else {
        view.refresh();
        JOptionPane.showMessageDialog(null, "Game Over");
      }
    }
  }

  /**
   * This is used to find the possible move directions of the player.
   *
   * @param direction is the direction of the player.
   * @return player location.
   */
  @Override
  public int possibleDirections(String direction) {
    if (model.edgeDirectionList().get(model.getPlayerLocation())
            .contains(direction)) {
      int index = model.edgeDirectionList().get(model.getPlayerLocation()).indexOf(direction);
      return model.edgeAdjacencyList().get(model.getPlayerLocation()).get(index);
    }
    return model.getPlayerLocation();
  }

  /**
   * This is used to pick up the treasure.
   *
   * @return the treasure.
   */
  @Override
  public String pickTreasure() {
    List<Treasure> treasures = model.getTreasureList().get(model.getPlayerLocation());
    String message = "";
    if (treasures.size() > 0) {
      for (int i = 0; i < treasures.size(); i++) {
        model.pickUpTreasure(treasures.get(i), model.getPlayerLocation());
      }
      message = "Picked up treasure";
      JOptionPane.showMessageDialog(null, message);
    } else {
      message = "No treasure to pick up";
      JOptionPane.showMessageDialog(null, message);
    }
    view.refresh();
    return message;
  }

  /**
   * This is used to pick up the Arrows.
   *
   * @return the arrows.
   */
  @Override
  public String pickArrow() {
    String message = "";
    if (model.getArrowLocations().get(model.getPlayerLocation()) > 0) {
      model.pickArrows(model.getArrowLocations().get(model.getPlayerLocation()),
              model.getPlayerLocation());
      message = "Picked up arrows";
      JOptionPane.showMessageDialog(null, message);
    } else {
      message = "No arrows to pick up";
      JOptionPane.showMessageDialog(null, message);
    }
    view.refresh();
    return message;
  }

  /**
   * This is used to pich the Treasure and the Arrow together.
   *
   * @return the treasure and the arrow.
   */
  @Override
  public String pickBoth() {
    String message = "";
    String message1 = "";
    List<Treasure> treasures = model.getTreasureList().get(model.getPlayerLocation());
    if (treasures.size() > 0) {
      for (int i = 0; i < treasures.size(); i++) {
        model.pickUpTreasure(treasures.get(i), model.getPlayerLocation());
      }
      message = "Picked up treasure";
      JOptionPane.showMessageDialog(null, message);
    } else {
      message = "No treasure to pick up";
      JOptionPane.showMessageDialog(null, message);
    }

    if (model.getArrowLocations().get(model.getPlayerLocation()) > 0) {
      model.pickArrows(model.getArrowLocations().get(model.getPlayerLocation()),
              model.getPlayerLocation());
      message1 = "Picked up arrows";
      JOptionPane.showMessageDialog(null, "Picked up arrows");
    } else {
      message1 = "No arrows to pick up";
      JOptionPane.showMessageDialog(null, message1);
    }
    view.refresh();
    return message + " " + message1;
  }

  /**
   * This is used to shoot the arrows.
   *
   * @param distance  is the distance of the arrow.
   * @param direction is the direction of the arrow.
   * @return the message.
   */
  @Override
  public String shootArrow(int distance, String direction) {
    String message = model.shootArrow(distance, direction);
    JOptionPane.showMessageDialog(null, message);
    view.refresh();
    return message;
  }

  /**
   * This is used to handle the player's movement through the maze via mouse clicks.
   *
   * @param x is the x coordinate of the mouse click.
   * @param y is the y coordinate of the mouse click.
   */
  @Override
  public void handleMouseClick(int x, int y) {
    int playerLocation = model.getPlayerLocation();
    int col = playerLocation / model.getSizeBreadth();
    int row = playerLocation - (col * model.getSizeBreadth());
    int playerX = row * 200;
    int playerY = col * 200;

    if (gameEnd == 0) {
      if (model.getPlayerLocation() != model.getEndPoint()) {

        if ((playerX - x) < 200 && (playerX - x) > 0 && (playerY - y) < 0 && (playerY - y) > -200) {
          if (model.edgeDirectionList().get(playerLocation).contains("W")) {
            model.updatePlayerLocation(playerLocation - 1);
          }
        } else if ((playerX - x) < -200 && (playerX - x) > -400 && (playerY - y) < 0
                && (playerY - y) > -200) {
          if (model.edgeDirectionList().get(playerLocation).contains("E")) {
            model.updatePlayerLocation(playerLocation + 1);
          }
        } else if ((playerX - x) < 0 && (playerX - x) > -200 && (playerY - y) < 200
                && (playerY - y) > 0) {
          if (model.edgeDirectionList().get(playerLocation).contains("N")) {
            model.updatePlayerLocation(playerLocation - model.getSizeBreadth());
          }
        } else if ((playerX - x) < 0 && (playerX - x) > -200 && (playerY - y) < -200
                && (playerY - y) > -400) {
          if (model.edgeDirectionList().get(playerLocation).contains("S")) {
            model.updatePlayerLocation(playerLocation + model.getSizeBreadth());
          }
        }
        //Wrapping cases
        else if ((playerX - x) < (model.getSizeBreadth() * 200) && (playerX - x) > 200
                && (playerY - y) < 0 && (playerY - y) > -200) {
          if (model.edgeDirectionList().get(playerLocation).contains("E")) {
            model.updatePlayerLocation(model.edgeAdjacencyList().get(playerLocation)
                    .get(model.edgeDirectionList().get(playerLocation).indexOf("E")));
          }
        } else if ((playerX - x) > -(model.getSizeBreadth() * 200) && (playerX - x) < -400
                && (playerY - y) < 0 && (playerY - y) > -200) {
          if (model.edgeDirectionList().get(playerLocation).contains("W")) {
            model.updatePlayerLocation(model.edgeAdjacencyList().get(playerLocation)
                    .get(model.edgeDirectionList().get(playerLocation).indexOf("W")));
          }
        } else if ((playerX - x) < 0 && (playerX - x) > -200
                && (playerY - y) < (model.getSizeBreadth() * 200) && (playerY - y) > 200) {
          if (model.edgeDirectionList().get(playerLocation).contains("S")) {
            model.updatePlayerLocation(model.edgeAdjacencyList().get(playerLocation)
                    .get(model.edgeDirectionList().get(playerLocation).indexOf("S")));
          }
        } else if ((playerX - x) < 0 && (playerX - x) > -200
                && (playerY - y) > -(model.getSizeBreadth() * 200) && (playerY - y) < -400) {
          if (model.edgeDirectionList().get(playerLocation).contains("N")) {
            model.updatePlayerLocation(model.edgeAdjacencyList().get(playerLocation)
                    .get(model.edgeDirectionList().get(playerLocation).indexOf("N")));
          }
        }
        if (model.checkPlayerAvoidanceAbility(model.getPlayerLocation()).containsKey(1)) {
          gameEnd = 1;
          JOptionPane.showMessageDialog(null, "You have been killed by Otyugh");
        }
      } else {
        JOptionPane.showMessageDialog(null, "Game Over");
      }
      view.refresh();
    }
  }

  /**
   * This is used to update the view when the player moves.
   *
   * @param view is the view of the game.
   */
  @Override
  public void updateView(DungeonView view) {
    this.view = view;
  }
}
