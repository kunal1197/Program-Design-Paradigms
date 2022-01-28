package assignments;

import java.util.Comparator;
import java.util.List;

/**
 * DifficultySchedulingStrategy is a class for scheduling strategies according to their difficulty.
 */
public class DifficultySchedulingStrategy implements SchedulingStrategy {

  /**
   * Returns a list of assignments sorted by difficulty.
   *
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
    assignments.sort(Comparator.comparing(Assignment::getDifficulty)
            .reversed().thenComparing(Assignment::getDescription));
    return "difficulty";
  }

}
