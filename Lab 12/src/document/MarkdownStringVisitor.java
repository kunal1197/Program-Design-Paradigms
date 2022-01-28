package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElementVisitor;

public class MarkdownStringVisitor implements TextElementVisitor<String> {
  @Override
  public String visitBasicText(BasicText text) {
    return markDownRepresentation(text);
  }

  @Override
  public String visitBoldText(BoldText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("**");
    sb.append(markDownRepresentation(text));
    sb.append("**");
    return sb.toString();
  }

  @Override
  public String visitItalicText(ItalicText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("*");
    sb.append(markDownRepresentation(text));
    sb.append("*");
    return sb.toString();
  }

  @Override
  public String visitedHyperText(HyperText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append(markDownRepresentation(text));
    sb.append("]");
    sb.append("(");
    sb.append(text.getUrl());
    sb.append(")");
    return sb.toString();
  }

  @Override
  public String visitHeader(Heading text) {
    StringBuilder sb = new StringBuilder();
    sb.append("#");
    sb.append(markDownRepresentation(text));
    return sb.toString();
  }

  @Override
  public String visitParagraph(Paragraph text) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    sb.append(text.accept(this));
    return sb.toString();
  }

  private String markDownRepresentation(BasicText text) {
    return text.getText();
  }
}
