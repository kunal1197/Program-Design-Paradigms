package assignments;

import java.util.List;

/**
 * This interface defines the methods that a scheduling strategy must implement.
 */
public interface SchedulingStrategy {

  /**
   * This method is called to schedule the given list of processes.
   *
   * @param assignments The list of processes to be scheduled.
   */
  String schedule(List<Assignment> assignments);
}
