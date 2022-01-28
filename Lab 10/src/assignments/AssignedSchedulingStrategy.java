package assignments;

import java.util.Comparator;
import java.util.List;

/**
 * AssignedSchedulingStrategy is a class for scheduling strategies according to which they are
 * Assigned.
 */
public class AssignedSchedulingStrategy implements SchedulingStrategy {

  /**
   * Returns a list of assignments sorted according to which they are assigned.
   * @param assignments List of assignments to sort.
   * @return Sorted list of assignments.
   */
  @Override
  public String schedule(List<Assignment> assignments) {
    if (assignments == null ) {
      throw new IllegalArgumentException("Assignments cannot be null");
    }

    for (Assignment assignment : assignments) {
      if (assignment == null) {
        throw new IllegalArgumentException("Assignment elements cannot be null");
      }
    }
    assignments.sort(Comparator.comparing(Assignment::getNumber)
            .thenComparing(Assignment::getDescription));
    return "assigned";
  }


}
