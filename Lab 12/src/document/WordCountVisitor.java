package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElementVisitor;

public class WordCountVisitor implements TextElementVisitor<Integer> {


  @Override
  public Integer visitBasicText(BasicText text) {
    return countWords(text);
  }

  @Override
  public Integer visitBoldText(BoldText text) {
    return countWords(text);
  }

  @Override
  public Integer visitItalicText(ItalicText text) {
    return countWords(text);
  }

  @Override
  public Integer visitedHyperText(HyperText text) {
    return countWords(text);
  }

  @Override
  public Integer visitHeader(Heading text) {
    return countWords(text);
  }

  @Override
  public Integer visitParagraph(Paragraph text) {
    return countWordsParagraph(text);
  }

  private Integer countWords(BasicText text) {
    String s = text.getText();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        count++;
      }
    }
    return count;
  }

  private Integer countWordsParagraph(Paragraph text) {
    String s = text.getText();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        count++;
      }
    }
    return count;
  }
}
