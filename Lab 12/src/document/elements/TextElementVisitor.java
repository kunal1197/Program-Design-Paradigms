package document.elements;

public interface TextElementVisitor<R> {

  R visitBasicText(BasicText text);

  R visitBoldText(BoldText text);

  R visitItalicText(ItalicText text);

  R visitedHyperText(HyperText text);

  R visitHeader(Heading text);

  R visitParagraph(Paragraph text);

}
