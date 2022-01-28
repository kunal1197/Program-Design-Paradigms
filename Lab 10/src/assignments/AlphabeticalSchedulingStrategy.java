package assignments;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * AlphabeticalSchedulingStrategy is a class for scheduling strategies according to their alphabets.
 */
public class AlphabeticalSchedulingStrategy implements SchedulingStrategy, Comparator<Assignment> {

  /**
   * Returns a list of assignments sorted according their alphabets.
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

    Collections.sort(assignments);
    return "alphabetical";
  }

  /**
   * Compares two assignments according to their alphabets.
   * @param o1 First assignment to compare.
   * @param o2 Second assignment to compare.
   * @return -1 if o1 is before o2, 1 if o1 is after o2, 0 if they are equal.
   */
  @Override
  public int compare(Assignment o1, Assignment o2) {
    return o2.getDescription().compareTo(o1.getDescription());
  }
}
