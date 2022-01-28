package assignments;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of task that need to be completed.
 */
public class AssignmentList {

  private List<Assignment> tasks;
  private String ordering;

  /**
   * Default constructor.
   */
  public AssignmentList() {
    tasks = new ArrayList<>();
    ordering = "assigned";
  }

  /**
   * Add a task to the task list.
   *
   * @param t the task
   */
  public void add(Assignment t) {
    tasks.add(t);
  }

  /**
   * This is used to schedule the Assignments by using the given Scheduling Strategy.
   */
  public void scheduleAssignments(SchedulingStrategy strategy) {
    if (strategy == null) {
      throw new IllegalArgumentException("Strategy cannot be null");
    }
    ordering = strategy.schedule(tasks);
  }

  /**
   * String representation of the AssignmentList.
   * @return String representation of the AssignmentList.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Ordered by ");
    sb.append(ordering);
    sb.append("\n");
    for (int i = 0; i < tasks.size(); i++) {
      sb.append(i + 1);
      sb.append(" -- ");
      sb.append(tasks.get(i));
      sb.append("\n");
    }
    return sb.toString();
  }

}
