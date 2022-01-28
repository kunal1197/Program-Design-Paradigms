import java.util.Calendar;
import java.util.Objects;

/**
 * This class represents a person The person has a first name, last name and an year of birth.
 */
public class Person {
  private String firstName;
  private String lastName;
  private int yearOfBirth;

  /**
   * Constructs a Person object and initializes it to the given first name, last name and year of
   * birth.
   *
   * @param firstName   the first name of this person.
   * @param lastName    the last name of this person.
   * @param yearOfBirth the year of birth of this person.
   */

  public Person(String firstName, String lastName, int yearOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;

    int currYear = Calendar.getInstance().get(Calendar.YEAR);
    if (yearOfBirth < 0 || yearOfBirth > currYear) {
      throw new IllegalArgumentException("year of birth cannot be 0 or cannot be greater than"
              + currYear);
    }
    this.yearOfBirth = yearOfBirth;
  }

  /**
   * Get the first name of this person.
   *
   * @return the first name of this person.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return the last name of this person.
   *
   * @return the last name of this person.
   */

  public String getLastName() {
    return this.lastName;
  }

  /**
   * Return the year of birth of this person.
   *
   * @return the year of birth of this person.
   */
  public int getYearOfBirth() {
    return this.yearOfBirth;
  }

  /**
   * Compare two objects.
   * @param o that are to be compared.
   * @return output whether equal or not.
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }
    Person person = (Person) o;
    return yearOfBirth == person.yearOfBirth && Objects.equals(firstName, person.firstName)
            && Objects.equals(lastName, person.lastName);
  }

  /**
   * Compare two objects.
   *
   * @return output whether equal or not.
   */

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, yearOfBirth);
  }
}

