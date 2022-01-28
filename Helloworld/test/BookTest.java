import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * A JUnit test class for the Book class.
 */
public class BookTest {
  private Book abc;
  private Person john;

  /**
   * This is used to setup the Book Object.
   */

  @Before
  public void setUp() {

    john = new Person("john", "Parker", 1945);
    abc = new Book("abc", john, 500);
  }

  /**
   * This is used to test the title of Book.
   */

  @Test
  public void testTitle() {
    assertEquals("abc", abc.getTitle());
  }

  /**
   * This is used to check the author.
   */

  @Test
  public void testAuthor() {
    assertEquals(new Person("john", "Parker",
            1945), abc.getAuthor());
  }

  /**
   * This is used to check the price.
   */

  @Test
  public void testPrice() {
    assertEquals(500, abc.getPrice(), 1e-6);
  }

  /**
   * This is used to check if price is negative.
   */

  @Test(expected = IllegalArgumentException.class)
  public void negativePrice() {
    Book effectiveJava = new Book("effectiveJava", new Person("john", "Doe",
          1999), -20);
  }

  /**
   * This is used to test the equality of person objects by comparing their heap value.
   */

  @Test
  public void testEquals() {
    Book effectiveJava = new Book("effectiveJava", new Person("john", "Doe",
            1999), 100);
    assertNotEquals("Objects not expected to be equal", effectiveJava, abc);

    Book book2 = new Book("abc", John, 500);
    assertEquals("Objects expected to be equal", book2, abc);
  }

  /**
   * This is used to test the non equality of person objects by comparing their hash value.
   */

  @Test
  public void notEqualHashCode() {
    Book effectiveJava = new Book("effectiveJava", new Person("john", "Doe",
            1999), 100);
    assertNotEquals("Objects not expected to be equal", effectiveJava, abc);
  }

  /**
   * This is used to test the equality of person objects by comparing their hash value.
   */

  @Test
  public void equalTestHashCode() {
    Book book2 = new Book("abc", john, 500);
    assertEquals("Objects expected to be equal", book2, abc);
  }

}
