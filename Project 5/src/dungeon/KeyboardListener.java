package dungeon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/**
 * This class is used to listen for keyboard input.
 */
public class KeyboardListener extends KeyAdapter {

  private final DungeonViewController listener;
  private static boolean directionBool;

  /**
   * Constructor for the KeyboardListener.
   *
   * @param listener The DungeonViewController that is listening for keyboard input.
   */
  public KeyboardListener(DungeonViewController listener) {
    nullChecks(listener);
    this.listener = listener;
  }

  private void nullChecks(DungeonViewController listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Listener is null");
    }
  }

  /**
   * This method is used to listen for keyboard input.
   *
   * @param e The KeyEvent that is being listened for.
   */
  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (!directionBool) {
      if (keyCode == KeyEvent.VK_UP) {
        listener.movePlayer(listener.possibleDirections("N"));
      } else if (keyCode == KeyEvent.VK_DOWN) {
        listener.movePlayer(listener.possibleDirections("S"));
      } else if (keyCode == KeyEvent.VK_LEFT) {
        listener.movePlayer(listener.possibleDirections("W"));
      } else if (keyCode == KeyEvent.VK_RIGHT) {
        listener.movePlayer(listener.possibleDirections("E"));
      }
    } else {
      String direction = "";
      if (keyCode == KeyEvent.VK_UP) {
        direction = "N";
      } else if (keyCode == KeyEvent.VK_DOWN) {
        direction = "S";
      } else if (keyCode == KeyEvent.VK_LEFT) {
        direction = "W";
      } else if (keyCode == KeyEvent.VK_RIGHT) {
        direction = "E";
      }
      String distance = JOptionPane.showInputDialog("Enter the Distance you want to shoot");
      try {
        listener.shootArrow(Integer.parseInt(distance), direction);
      } catch (NumberFormatException e1) {
        JOptionPane.showMessageDialog(null, "Please enter a number");
      }
      directionBool = false;
    }
    if (keyCode == KeyEvent.VK_P) {
      String value = JOptionPane.showInputDialog("Press 1 for Treasure, 2 for Arrow, 3 for Both");
      if (value.equals("1")) {
        listener.pickTreasure();
      } else if (value.equals("2")) {
        listener.pickArrow();
      } else if (value.equals("3")) {
        listener.pickBoth();
      } else {
        JOptionPane.showMessageDialog(null, "Invalid Input");
      }
    } else if (keyCode == KeyEvent.VK_S) {
      directionBool = true;
    }
  }

}
