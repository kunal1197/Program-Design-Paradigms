package dungeon;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

/**
 * The implementation of the dungeon view using Swing for the Dungeon game.
 */
public class DungeonSwingView extends JFrame implements DungeonView {

  private final BoardPanel boardPanel;
  private DungeonViewController controller;

  /**
   * Constructor for the DungeonSwingView.
   *
   * @param dungeon Model the model of the dungeon.
   */
  public DungeonSwingView(Dungeon dungeon) {
    super("The Dungeon Game");
    nullChecks(dungeon);
    this.setSize(1545, 830);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setResizable(false);

    boardPanel = new BoardPanel(dungeon);

    JScrollPane scrollPane = new JScrollPane(boardPanel);
    this.add(scrollPane);

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
    this.setJMenuBar(menuBar);
    this.setVisible(true);

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
        "Enter Name",
      };
      JOptionPane.showInputDialog(null, message, "Input",
              JOptionPane.PLAIN_MESSAGE);

      try {
        int jLength = (Integer.parseInt(length.getText()));
        int jBreadth = (Integer.parseInt(breadth.getText()));
        int jInterConnectivity = (Integer.parseInt(interConnectivity.getText()));
        boolean jWrapping = (Boolean.parseBoolean(wrapping.getText()));
        int jTreasurePercent = (Integer.parseInt(treasurePercent.getText()));
        int jMonsterNumber = (Integer.parseInt(monsterNumber.getText()));
        controller.editConfig(jLength, jBreadth, jInterConnectivity, jWrapping, jTreasurePercent,
                jMonsterNumber);
      }
      catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Missing or Invalid Values");
      }


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
    this.addKeyListener(keyListener);
  }

  /**
   * This is used to repaint the board panel.
   */
  @Override
  public void refresh() {
    repaint();
  }

  /**
   * This is used to make board panel visible.
   */
  @Override
  public void makeVisible() {
    setVisible(true);
  }
}
