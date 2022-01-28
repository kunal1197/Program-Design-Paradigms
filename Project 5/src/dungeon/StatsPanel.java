package dungeon;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

/**
 * A panel that displays the player's and Node statistics.
 */
public class StatsPanel extends JPanel {

  private final Dungeon dungeon;

  /**
   * Constructor for the StatsPanel.
   *
   * @param dungeon the dungeon that the player is playing in.
   */
  public StatsPanel(Dungeon dungeon) {
    nullChecks(dungeon);
    this.dungeon = dungeon;
  }

  private void nullChecks(Dungeon dungeon) {
    if (dungeon == null) {
      throw new IllegalArgumentException("Dungeon is null");
    }
  }

  /**
   * Paints the panel.
   *
   * @param g the graphics object to paint with.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int breadth = 0;
    if (dungeon.getSizeBreadth() < 7) {
      breadth = dungeon.getSizeBreadth() * 200;
    } else {
      breadth = 0;
    }
    this.setBackground(Color.YELLOW);

    g.setColor(Color.RED);
    g.setFont(new Font("Times New Roman", Font.BOLD, 30));
    g.drawString("Player & Node Stats:", breadth + 10, 80);

    g.setColor(Color.BLUE);
    g.setFont(new Font("Times New Roman", Font.BOLD, 18));
    g.drawString("Node Type : " + dungeon.assignCaveOrTunnel(dungeon.getPlayerLocation()),
            breadth + 10, 120);
    g.drawString("Smell Type : ", breadth + 10, 140);
    if (!dungeon.getOtyughLocations().contains(dungeon.getPlayerLocation())) {
      g.drawString(dungeon.getOtyughSmell(dungeon.getPlayerLocation()),
              breadth + 10, 160);
    }
    g.drawString("Player Location : " + dungeon.getPlayerLocation(),
            breadth + 10, 180);
    g.drawString("You find all these gems here : ", breadth + 10,
            200);
    g.drawString(String.valueOf(dungeon.getCaveTunnelDetails(dungeon.getPlayerLocation())),
            breadth + 10, 220);
    g.drawString("The number of arrows you find here : " + dungeon.getArrowLocations()
                    .get(dungeon.getPlayerLocation()),
            breadth + 10, 240);
    g.drawString("The number of arrows you have : " + dungeon.getPlayerArrowlist(),
            breadth + 10, 260);
    g.drawString("The number of Gems the player has : ", breadth + 10,
            280);
    g.drawString(String.valueOf(dungeon.getPlayerTreasureList()), breadth + 10,
            300);
    g.drawString("Doors Lead to : " + dungeon.edgeDirectionList()
            .get(dungeon.getPlayerLocation()), breadth + 10, 320);

  }
}


