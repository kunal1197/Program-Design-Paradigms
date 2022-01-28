package assignmenttest;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import assignments.AlphabeticalSchedulingStrategy;
import assignments.AssignedSchedulingStrategy;
import assignments.Assignment;
import assignments.AssignmentList;
import assignments.DeadlineSchedulingStrategy;
import assignments.DifficultySchedulingStrategy;

import static org.junit.Assert.assertEquals;

/**
 * Class that tests the tasks.
 */
public class AssignmentTest {

  LocalDate now;
  Assignment t1;
  Assignment t2;

  /**
   * Setup method to avoid code duplication.
   */
  @Before
  public void setUp() {
    now = LocalDate.now();
    t1 = new Assignment("task 1");
    t2 = new Assignment("task 2");
  }


  /**
   * Testing constructor and toString().
   */
  @Test
  public void testConstructor() {
    LocalDate now = LocalDate.now();
    System.out.println(now);
    Assignment t1 = new Assignment("task 1");
    assertEquals("task 1, starting " + now + ", ending " + now, t1.toString());
    Assignment t2 = new Assignment("task 2");
    t2.setDeadline(3, 4, 2025);
    assertEquals("task 2, starting " + now + ", ending 2025-03-04", t2.toString());
  }

  /**
   * Test that verifies that the AssignedSchedulingStrategy orders assignments according to
   * their difficulty.
   */
  @Test
  public void testAssignedSchedulingAlone() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new AssignedSchedulingStrategy());
    assertEquals("Ordered by assigned\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that the AssignedSchedulingStrategy works even after another strategy
   * has been used to order the tasks.
   */
  @Test
  public void testAssignedSchedulingAnother() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    list.scheduleAssignments(new AssignedSchedulingStrategy());
    assertEquals("Ordered by assigned\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new DeadlineSchedulingStrategy());
    list.scheduleAssignments(new AssignedSchedulingStrategy());
    assertEquals("Ordered by assigned\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new DifficultySchedulingStrategy());
    list.scheduleAssignments(new AssignedSchedulingStrategy());
    assertEquals("Ordered by assigned\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that the AlphabeticalSchedulingStrategy orders assignments according to
   * their difficulty.
   */
  @Test
  public void testAlphabeticalSchedulingAlone() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    assertEquals("Ordered by alphabetical\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that the AlphabeticalSchedulingStrategy works even after another strategy
   * has been used to order the tasks.
   */
  @Test
  public void testAlphabeticalSchedulingAnother() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new AssignedSchedulingStrategy());
    list.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    assertEquals("Ordered by alphabetical\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new DeadlineSchedulingStrategy());
    list.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    assertEquals("Ordered by alphabetical\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new DifficultySchedulingStrategy());
    list.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    assertEquals("Ordered by alphabetical\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that the DeadlineSchedulingStrategy orders assignments according to
   * their difficulty.
   */
  @Test
  public void testDeadlineSchedulingAlone() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new DeadlineSchedulingStrategy());
    assertEquals("Ordered by deadline\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that the DeadlineSchedulingStrategy works even after another strategy
   * has been used to order the tasks.
   */
  @Test
  public void testDeadlineSchedulingAnother() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new AssignedSchedulingStrategy());
    list.scheduleAssignments(new DeadlineSchedulingStrategy());
    assertEquals("Ordered by deadline\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    list.scheduleAssignments(new DeadlineSchedulingStrategy());
    assertEquals("Ordered by deadline\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new DifficultySchedulingStrategy());
    list.scheduleAssignments(new DeadlineSchedulingStrategy());
    assertEquals("Ordered by deadline\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that the DifficultySchedulingStrategy orders assignments according to
   * their difficulty.
   */
  @Test
  public void testDifficultySchedulingAlone() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that the DifficultySchedulingStrategy works even after another strategy
   * has been used to order the tasks.
   */
  @Test
  public void testDifficultySchedulingAnother() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new AssignedSchedulingStrategy());
    list.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    list.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new DeadlineSchedulingStrategy());
    list.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that tasks added after the call to schedule are added at the end of
   * the assignment list.
   */
  @Test
  public void taskAfterSchedule() {
    AssignmentList list = new AssignmentList();
    list.add(t1);
    list.add(t2);
    list.scheduleAssignments(new DifficultySchedulingStrategy());
    Assignment t3 = new Assignment("task 3");
    Assignment t4 = new Assignment("task 4");
    list.add(t3);
    list.add(t4);
    assertEquals("Ordered by difficulty\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n"
            + "3 -- task 3, starting 2021-11-20, ending 2021-11-20\n"
            + "4 -- task 4, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new AssignedSchedulingStrategy());
    Assignment t5 = new Assignment("task 5");
    Assignment t6 = new Assignment("task 6");
    list.add(t5);
    list.add(t6);
    assertEquals("Ordered by assigned\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n"
            + "3 -- task 3, starting 2021-11-20, ending 2021-11-20\n"
            + "4 -- task 4, starting 2021-11-20, ending 2021-11-20\n"
            + "5 -- task 5, starting 2021-11-20, ending 2021-11-20\n"
            + "6 -- task 6, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    Assignment t7 = new Assignment("task 7");
    Assignment t8 = new Assignment("task 8");
    list.add(t7);
    list.add(t8);
    assertEquals("Ordered by alphabetical\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n"
            + "3 -- task 3, starting 2021-11-20, ending 2021-11-20\n"
            + "4 -- task 4, starting 2021-11-20, ending 2021-11-20\n"
            + "5 -- task 5, starting 2021-11-20, ending 2021-11-20\n"
            + "6 -- task 6, starting 2021-11-20, ending 2021-11-20\n"
            + "7 -- task 7, starting 2021-11-20, ending 2021-11-20\n"
            + "8 -- task 8, starting 2021-11-20, ending 2021-11-20\n", list.toString());

    list.scheduleAssignments(new DeadlineSchedulingStrategy());
    Assignment t9 = new Assignment("task 9");
    Assignment t10 = new Assignment("task 10");
    list.add(t9);
    list.add(t10);
    assertEquals("Ordered by deadline\n"
            + "1 -- task 1, starting 2021-11-20, ending 2021-11-20\n"
            + "2 -- task 2, starting 2021-11-20, ending 2021-11-20\n"
            + "3 -- task 3, starting 2021-11-20, ending 2021-11-20\n"
            + "4 -- task 4, starting 2021-11-20, ending 2021-11-20\n"
            + "5 -- task 5, starting 2021-11-20, ending 2021-11-20\n"
            + "6 -- task 6, starting 2021-11-20, ending 2021-11-20\n"
            + "7 -- task 7, starting 2021-11-20, ending 2021-11-20\n"
            + "8 -- task 8, starting 2021-11-20, ending 2021-11-20\n"
            + "9 -- task 9, starting 2021-11-20, ending 2021-11-20\n"
            + "10 -- task 10, starting 2021-11-20, ending 2021-11-20\n", list.toString());
  }

  /**
   * Test that verifies that schedule raises an IllegalArgumentException if the assignment
   * list is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void AssignmentListNull() {
    List<Assignment> assignments = null;
    DifficultySchedulingStrategy strategy = new DifficultySchedulingStrategy();
    strategy.schedule(assignments);
  }

  /**
   * Test that verifies that schedule raises an IllegalArgumentException if an invalid assignment
   * list is given.
   */
  @Test(expected = IllegalArgumentException.class)
  public void AssignmentListInvalid() {
    List<Assignment> assignments = new ArrayList<>();
    assignments.add(new Assignment("task 1"));
    assignments.add(null);
    assignments.add(new Assignment("task 2"));
    AssignedSchedulingStrategy strategy = new AssignedSchedulingStrategy();
    strategy.schedule(assignments);
  }

}
