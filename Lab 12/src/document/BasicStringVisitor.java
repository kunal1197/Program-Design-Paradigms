package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElementVisitor;

public class BasicStringVisitor implements TextElementVisitor<String> {

  public BasicStringVisitor() {

  }

  @Override
  public String visitBasicText(BasicText text) {
    StringBuilder sb = new StringBuilder();
    sb.append(stringRepresentation(text));
    return sb.toString();
  }

  @Override
  public String visitBoldText(BoldText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append(text.accept(this));
    return sb.toString();
  }

  @Override
  public String visitItalicText(ItalicText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append(text.accept(this));
    return sb.toString();
  }

  @Override
  public String visitedHyperText(HyperText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append(text.accept(this));
    return sb.toString();
  }

  @Override
  public String visitHeader(Heading text) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append(text.accept(this));
    return sb.toString();
  }

  @Override
  public String visitParagraph(Paragraph text) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append(text.accept(this));
    return sb.toString();
  }

  private String stringRepresentation(BasicText text) {
    return text.getText();
  }

  public String toString() {
    return "";
  }
}
