import java.util.Objects;

/**
 * This class represents a book. A book has a title, an author and a price.
 */
public class Book {
  private String title;
  private Person author;
  private float price;

  /**
   * Construct a Book object that has the provided title, author and  price.
   *
   * @param title  the title to be given to this book.
   * @param author the author to be given to this book.
   * @param price  the price to be assigned to this book.
   */

  public Book(String title, Person author, float price) {
    this.title = title;
    this.author = author;

    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be less than 0 ");
    }
    this.price = price;
  }

  /**
   * Return the title of this book.
   *
   * @return the title of this book.
   */

  public String getTitle() {
    return this.title;
  }

  /**
   * Return the price of this book.
   *
   * @return the price of this book.
   */
  public float getPrice() {
    return this.price;
  }

  /**
   * Return the author of this object.
   *
   * @return the author of this object as a @link{Person}.
   */
  public Person getAuthor() {
    return this.author;
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
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return Float.compare(book.price, price) == 0 && Objects.equals(title, book.title)
            && Objects.equals(author, book.author);
  }

  /**
   * Compare two objects.
   *
   * @return output whether equal or not.
   */

  @Override
  public int hashCode() {
    return Objects.hash(title, author, price);
  }
}