package assignments;

import java.util.Comparator;
import java.util.List;

/**
 * DeadlineSchedulingStrategy is a class for scheduling strategies according to their Deadline.
 */
public class DeadlineSchedulingStrategy implements SchedulingStrategy {

  /**
   * Returns a list of assignments sorted by deadline.
   * @param assignments List of assignments to sort.
   * @return Sorted list of assignments.
   */
  @Override
  public String schedule(List<Assignment> assignments) {
    if (assignments == null) {
      throw new IllegalArgumentException("Assignments cannot be null");
    }

    for (Assignment assignment : assignments) {
      if (assignment == null) {
        throw new IllegalArgumentException("Assignment elements cannot be null");
      }
    }
    assignments.sort(Comparator.comparing(Assignment::getEndDate)
            .thenComparing(Assignment::getDescription));
    return "deadline";
  }

}
