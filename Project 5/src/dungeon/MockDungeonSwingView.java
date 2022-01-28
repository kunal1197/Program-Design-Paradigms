package dungeon;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 * Mock class for DungeonSwingView used for testing.
 */
public class MockDungeonSwingView implements DungeonView {

  private final BoardPanel boardPanel;
  private DungeonViewController controller;
  private static Appendable out;

  /**
   * Constructor for MockDungeonSwingView.
   */
  public MockDungeonSwingView(Dungeon dungeon) {
    nullChecks(dungeon);
    boardPanel = new BoardPanel(dungeon);
  }

  private void nullChecks(Dungeon dungeon) {
    if (dungeon == null) {
      throw new IllegalArgumentException("Dungeon is null");
    }
  }

  private void setMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem menuItem = new JMenuItem("Restart Game");
    JMenuItem menuItem2 = new JMenuItem("Edit Config");
    JMenuItem menuItem3 = new JMenuItem("Exit Game");
    menu.add(menuItem);
    menu.add(menuItem2);
    menu.add(menuItem3);
    menuBar.add(menu);

    menuItem.addActionListener(e -> {
      controller.restartGame();
    });


    menuItem2.addActionListener(e -> {

      JTextField length = new JTextField();
      JTextField breadth = new JTextField();
      JTextField interConnectivity = new JTextField();
      JTextField wrapping = new JTextField();
      JTextField treasurePercent = new JTextField();
      JTextField monsterNumber = new JTextField();

      Object[] message = {
        "Length:", length,
        "Breadth:", breadth,
        "InterConnectivity:", interConnectivity,
        "Wrapping Value:", wrapping,
        "Treasure Percent:", treasurePercent,
        "Otyugh Number:", monsterNumber,
      };
      JOptionPane.showInputDialog(null, message, "Input", JOptionPane.PLAIN_MESSAGE);

      int jLength = (Integer.parseInt(length.getText()));
      int jBreadth = (Integer.parseInt(breadth.getText()));
      int jInterConnectivity = (Integer.parseInt(interConnectivity.getText()));
      boolean jWrapping = (Boolean.parseBoolean(wrapping.getText()));
      int jTreasurePercent = (Integer.parseInt(treasurePercent.getText()));
      int jMonsterNumber = (Integer.parseInt(monsterNumber.getText()));

      controller.editConfig(jLength, jBreadth, jInterConnectivity, jWrapping, jTreasurePercent,
              jMonsterNumber);
    });

    menuItem3.addActionListener(e -> {
      System.exit(0);
    });
  }

  /**
   * This is used to restart a new game.
   *
   * @param listener button listener.
   */
  @Override
  public void startNewGame(DungeonViewController listener) {
    this.controller = listener;
    setMenuBar();
    try {
      out.append("New Game started.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This is used to update the model of the dungeon.
   *
   * @param model the model of the dungeon.
   */
  @Override
  public void updateDungeon(Dungeon model) {
    boardPanel.updateDungeon(model);
  }

  /**
   * This is used to add a mouse listener to the board panel.
   *
   * @param listener the mouse listener.
   */
  @Override
  public void addClickListener(DungeonViewController listener) {
    MouseAdapter mouseAdapter = new MouseClickListener(listener);
    try {
      out.append("Mouse Listener Added");
    } catch (IOException e) {
      e.printStackTrace();
    }
    boardPanel.addMouseListener(mouseAdapter);
  }

  /**
   * This is used to add a key listener to the board panel.
   *
   * @param listener the key listener.
   */
  @Override
  public void addKeyListener(DungeonViewController listener) {
    KeyListener keyListener = new KeyboardListener(listener);
    try {
      out.append("Key Listener Added");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This is used to repaint the board panel.
   */
  @Override
  public void refresh() {
    System.out.println("Refreshing");
  }

  /**
   * This is used to make board panel visible.
   */
  @Override
  public void makeVisible() {
    System.out.println("Making board panel visible");
  }
}
