package dungeon;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Dimension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The BoardPanel class is responsible for drawing the board and the player moves on it.
 */
public class BoardPanel extends JPanel {

  private Dungeon dungeon;
  private static List<Integer> visitedNodes;

  /**
   * Constructor for the BoardPanel class.
   *
   * @param dungeon the dungeon
   */
  public BoardPanel(Dungeon dungeon) {
    nullChecks(dungeon);
    this.dungeon = dungeon;
    visited();
  }

  private void nullChecks(Dungeon dungeon) {
    if (dungeon == null) {
      throw new IllegalArgumentException("Dungeon is null");
    }
  }

  private void visited() {
    visitedNodes = new ArrayList<>();
    for (int i = 0; i < dungeon.getVertices(); i++) {
      visitedNodes.add(i);
    }
  }

  /**
   * Paints the board.
   *
   * @param g the graphics object.
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    this.setBackground(Color.YELLOW);
    java.util.List<String> nsew = java.util.List.of("E", "N", "S", "W");
    java.util.List<String> nse = java.util.List.of("E", "N", "S");
    java.util.List<String> nsw = java.util.List.of("N", "S", "W");
    java.util.List<String> wen = java.util.List.of("E", "N", "W");
    java.util.List<String> sew = java.util.List.of("E", "S", "W");
    java.util.List<String> n = java.util.List.of("N");
    java.util.List<String> s = java.util.List.of("S");
    java.util.List<String> e = java.util.List.of("E");
    java.util.List<String> w = java.util.List.of("W");
    java.util.List<String> ns = java.util.List.of("N", "S");
    java.util.List<String> ne = java.util.List.of("E", "N");
    java.util.List<String> nw = java.util.List.of("N", "W");
    java.util.List<String> se = java.util.List.of("E", "S");
    java.util.List<String> ew = java.util.List.of("E", "W");
    java.util.List<String> sw = java.util.List.of("S", "W");

    this.setLayout(new GridLayout(dungeon.getSizeBreadth(), dungeon.getSizeLength(), 0, 0));

    List<Integer> otyughPopulations = dungeon.getOtyughLocations();
    List<Integer> arrowPopulations = dungeon.getArrowLocations();
    Map<Integer, List<Treasure>> treasureMap = dungeon.getTreasureList();
    int i = 0;
    for (int k = 0; k < dungeon.getSizeBreadth(); k++) {
      for (int j = 0; j < dungeon.getSizeLength(); j++) {

        int playerFlag = 0;
        int otyughFlag = 0;
        int arrowFlag = 0;
        int diamondFlag = 0;
        int rubyFlag = 0;
        int sapphireFlag = 0;
        int weakSmellFlag = 0;
        int strongSmellFlag = 0;
        List<String> directionList = dungeon.edgeDirectionList().get(i);
        Collections.sort(directionList);
        if (Objects.equals(dungeon.assignCaveOrTunnel(i), "Cave")) {
          if (directionList.equals(nsew)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/NESW.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(nse)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/NES.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(wen)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/NEW.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(sew)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/ESW.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(nsw)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/SWN.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(n)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/N.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(s)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/S.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(e)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/E.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(w)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Caves/W.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          }
        } else {
          if (directionList.equals(ns)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Tunnels/NS.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(ne)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Tunnels/NE.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(nw)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Tunnels/WN.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(se)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Tunnels/ES.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(ew)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Tunnels/EW.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          } else if (directionList.equals(sw)) {
            if (dungeon.getPlayerLocation() == i) {
              playerFlag = 1;
              if (visitedNodes.contains(i)) {
                visitedNodes.remove(visitedNodes.indexOf(i));
              }
              if (!otyughPopulations.contains(i)) {
                if (dungeon.getOtyughSmell(i).contains("something less Pungent")) {
                  weakSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("something more Pungent")) {
                  strongSmellFlag = 1;
                }
                if (dungeon.getOtyughSmell(i).contains("multiple smells more Pungent")) {
                  strongSmellFlag = 1;
                }
              }
            }
            if (otyughPopulations.contains(i)) {
              otyughFlag = 1;
            }
            if (arrowPopulations.get(i) != 0) {
              arrowFlag = 1;
            }
            if (treasureMap.containsKey(i)) {
              if (treasureMap.get(i).contains(Treasure.DIAMOND)) {
                diamondFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.RUBY)) {
                rubyFlag = 1;
              }
              if (treasureMap.get(i).contains(Treasure.SAPPHIRE)) {
                sapphireFlag = 1;
              }
            }
            BufferedImage image = null;
            try {
              image = ImageIO.read(Objects.requireNonNull(getClass()
                      .getResource("/Tunnels/SW.png")));
            } catch (IOException ex) {
              ex.printStackTrace();
            }
            g.drawImage(image, j * 200, k * 200, 200, 200, this);
          }
        }
        if (otyughFlag == 1) {
          BufferedImage otyugh = null;
          try {
            otyugh = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/Otyugh/otyugh.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(otyugh, j * 200, k * 200, 90, 90, this);
        }

        if (arrowFlag == 1) {
          BufferedImage arrow = null;
          try {
            arrow = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/Arrows/colouredArrow.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(arrow, j * 215, k * 225, 60, 60, this);
        }

        if (diamondFlag == 1) {
          BufferedImage diamond = null;
          try {
            diamond = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/gems/diamond.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(diamond, j * 215, k * 275, 25, 25, this);
        }
        if (rubyFlag == 1) {
          BufferedImage ruby = null;
          try {
            ruby = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/gems/ruby.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(ruby, j * 240, k * 280, 25, 25, this);
        }
        if (sapphireFlag == 1) {
          BufferedImage sapphire = null;
          try {
            sapphire = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/gems/sapphire.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(sapphire, j * 255, k * 285, 25, 25, this);
        }

        if (weakSmellFlag == 1) {
          BufferedImage weakSmell = null;
          try {
            weakSmell = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/smell/stench01.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(weakSmell, j * 200, k * 200, 200, 200, this);
        }

        if (strongSmellFlag == 1) {
          BufferedImage strongSmell = null;
          try {
            strongSmell = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/smell/stench02.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(strongSmell, j * 200, k * 200, 200, 200, this);
        }


        if (playerFlag == 1) {
          BufferedImage player = null;
          try {
            player = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/Otyugh/kratos.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(player, j * 200, k * 200, 150, 150, this);
        }

        if (visitedNodes.contains(i)) {
          BufferedImage bin = null;
          try {
            bin = ImageIO.read(Objects.requireNonNull(getClass()
                    .getResource("/Cover/black.png")));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          g.drawImage(bin, j * 200, k * 200, 200, 200, this);
        }
        i++;
      }
    }

    this.setPreferredSize(new Dimension(200 * dungeon.getSizeBreadth(),
            200 * dungeon.getSizeBreadth()));


    StatsPanel statsPanel = new StatsPanel(dungeon);
    statsPanel.paintComponent(g);

  }


  private BufferedImage getScaledImage(String path, int w, int h) {
    Image srcImg = null;
    try {
      srcImg = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
  }

  private BufferedImage getScaledBufferedImage(BufferedImage srcImg, int w, int h) {
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
  }

  private BufferedImage overlay(BufferedImage starting, String fpath, int offset) {
    BufferedImage overlay = null;
    try {
      overlay = ImageIO.read(Objects.requireNonNull(getClass().getResource(fpath)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    int w = Math.max(starting.getWidth(), overlay.getWidth());
    int h = Math.max(starting.getHeight(), overlay.getHeight());
    BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics g = combined.getGraphics();
    g.drawImage(overlay, offset, offset, null);
    g.drawImage(starting, 0, 0, null);

    return combined;
  }

  /**
   * This method is used to update the dungeon when the game is restarted.
   *
   * @param model the dungeon model
   */
  public void updateDungeon(Dungeon model) {
    this.dungeon = model;
    visited();
    this.repaint();
  }
}
