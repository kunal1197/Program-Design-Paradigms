package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElementVisitor;

public class HtmlStringVisitor implements TextElementVisitor<String> {
  @Override
  public String visitBasicText(BasicText text) {
    return stringRepresentation(text);
  }

  @Override
  public String visitBoldText(BoldText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("<b>");
    sb.append(stringRepresentation(text));
    sb.append("</b>");
    return sb.toString();
  }

  @Override
  public String visitItalicText(ItalicText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("<i>");
    sb.append(stringRepresentation(text));
    sb.append("</i>");
    return sb.toString();
  }

  @Override
  public String visitedHyperText(HyperText text) {
    StringBuilder sb = new StringBuilder();
    sb.append("<a href=\"");
    sb.append(text.getUrl());
    sb.append("\">");
    sb.append(stringRepresentation(text));
    sb.append("</a>");
    return sb.toString();
  }

  @Override
  public String visitHeader(Heading text) {
    StringBuilder sb = new StringBuilder();
    sb.append("<h");
    sb.append(text.getLevel());
    sb.append(">");
    sb.append(stringRepresentation(text));
    sb.append("</h");
    sb.append(text.getLevel());
    sb.append(">");
    return sb.toString();
  }

  @Override
  public String visitParagraph(Paragraph text) {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>");
    sb.append(text.getText());
    sb.append("</p>");
    sb.append(text.accept(this));
    return sb.toString();
  }

  private String stringRepresentation(BasicText text) {
    return text.getText();
  }
}
