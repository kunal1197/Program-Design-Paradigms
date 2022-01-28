package dungeon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Listens for mouse clicks on the dungeon map.
 */
public class MouseClickListener extends MouseAdapter {

  private final DungeonViewController listener;

  /**
   * Constructor for the MouseClickListener.
   *
   * @param listener The DungeonViewController that will handle the mouse click.
   */
  public MouseClickListener(DungeonViewController listener) {
    nullChecks(listener);
    this.listener = listener;
  }

  private void nullChecks(DungeonViewController listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Controller is null");
    }
  }

  /**
   * Handles the mouse click event.
   *
   * @param e The mouse event.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    super.mouseClicked(e);
    List<Integer> coords = List.of(e.getX(), e.getY());
    int x = coords.get(0);
    int y = coords.get(1);
    listener.handleMouseClick(x, y);
  }
}
