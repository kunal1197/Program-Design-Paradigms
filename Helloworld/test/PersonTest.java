

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {

  private Person john;

  /**
   * Used to setup the Person Object.
   */

  @Before
  public void setUp() {

    john = new Person("John", "Doe", 1945);
  }

  /**
   * This is used to test if it is returning first name correctly.
   */

  @Test
  public void testFirst() {
    assertEquals("John", john.getFirstName());

  }

  /**
   * This is used to test the valid year of Birth.
   */

  @Test
  public void testSecond() {
    assertEquals("Doe", john.getLastName());
  }

  /**
   * This is used to test if it is returning year of birth correctly.
   */

  @Test
  public void testYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
  }

  /**
   * This is used to test the valid year of Birth.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeYearOfBirth() {
    Person person = new Person("Poe", "James", -2);
  }

  /**
   * This is used to test the valid year of Birth.
   */

  @Test(expected = IllegalArgumentException.class)
  public void greaterYearOfBirth() {
    Person person = new Person("Poe", "James", 2080);
  }

  /**
   * This is used to test the non equality of person objects by comparing their hash value.
   */

  @Test
  public void notEqualHashCode() {
    Person hames = new Person("hames", "Doe", 1945);
    assertNotEquals("Objects not expected to be equal", hames, john);
  }

  /**
   * This is used to test the equality of person objects by comparing their hash value.
   */

  @Test
  public void equalTestHashCode() {
    Person papaJohn = new Person("John", "Doe", 1945);
    assertEquals("Objects expected to be equal", papaJohn, john);
  }

  /**
   * This is used to test the equality of person objects by comparing their heap value.
   */
  @Test
  public void testEquals() {
    Person hames = new Person("hames", "Doe", 1945);
    assertNotEquals("Objects not expected to be equal", hames, john);

    Person papaJohn = new Person("John", "Doe", 1945);
    assertEquals("Objects expected to be equal", papaJohn, john);
  }

}
