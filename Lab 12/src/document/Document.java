package document;

import java.util.ArrayList;
import java.util.List;

import document.elements.TextElement;
import document.elements.TextElementVisitor;

/**
 * A class that represents a document. It contains a list of the elements of the
 * document in the order that they appear in the document. This class is
 * provided as a starting point for the Visitor lab in CS 5010.
 */
public class Document {

  private List<TextElement> content;

  /**
   * Default constructor initializes the fields of the class.
   */
  public Document() {
    content = new ArrayList<>();
  }

  /**
   * Add an element to the document. Elements are added in order.
   *
   * @param e the element to add
   */
  public void add(TextElement e) {
    content.add(e);
  }

  public int countWords(TextElement e) {
    WordCountVisitor visitor = new WordCountVisitor();
    return e.accept(visitor);
  }

  public String toText(TextElement e) {
    TextElementVisitor<String> visitor = new BasicStringVisitor();
    {;
      return e.accept(visitor);
    }
  }
}
