package questions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Likert Test class.
 */
public class LikertTest {
  private Questionnaires likert;

  /**
   * Setup test for Likert.
   */
  @Before
  public void setup() {
    likert = new Likert("How much do you like chicken?");
  }

  /**
   * Check if question is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testQuestionNull() {
    likert = new Likert(null);
  }

  /**
   * Check id question is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testQuestionEmpty() {
    likert = new Likert("");
  }

  /**
   * Check to see if the answer is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnswer() {
    likert.answer("6");
  }

  /**
   * Used to check if the answer is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEmptyAnswer() {
    likert.answer("");
  }

  /**
   * Used to check for invalid character in answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCharacter() {
    likert.answer("$");
  }

  /**
   * Check is answer is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNullAnswer() {
    likert.answer(null);
  }

  /**
   * test the compareLikert method.
   */
  @Test
  public void likertCompare() {
    Likert l1 = new Likert("How much do you like chicken?");

    Likert l2 = new Likert("How do you like chicken?");

    Likert l3 = new Likert("Why much do you like chicken?");

    assertEquals(0, likert.compareLikert(l1));
    assertEquals(-9, likert.compareLikert(l2));
    assertEquals(15, likert.compareLikert(l3));
  }

  /**
   * test the compareTrueFalse method.
   */
  @Test
  public void trueFalseCompare() {
    TrueFalse l1 = new TrueFalse("TF1", "1");

    assertEquals(-1, likert.compareTrueOrFalse(l1));
  }

  /**
   * test the compareMultipleSelect method.
   */
  @Test
  public void multipleSelectCompare() {
    MultipleSelect l1 = new MultipleSelect("MS1", "2 3", "good", "bad"
            , "very good");

    assertEquals(-1, likert.compareMultipleSelect(l1));
  }

  /**
   * test the compareMultipleChoice method.
   */
  @Test
  public void multipleChoiceCompare() {
    MultipleChoice l1 = new MultipleChoice("MC1", "2", "good", "bad",
            "very good");

    assertEquals(-1, likert.compareMultipleChoice(l1));
  }

  /**
   * compareTo method with Multiple Choice.
   */
  @Test
  public void likertCompareMultipleChoice() {
    Questionnaires mc1 = new MultipleChoice("MCQ", "1",
            "Option 1", "Option 2", "Option 3");


    assertEquals(-1, mc1.compareTo(likert));
  }

  /**
   * compareTo method with True False.
   */
  @Test
  public void likertCompareTrueFalse() {
    Questionnaires tf1 = new TrueFalse("TF1", "1");

    assertEquals(-1, tf1.compareTo(likert));
  }

  /**
   * compareTo method with Likert.
   */
  @Test
  public void likertCompareLikert() {
    Questionnaires l1 = new Likert("Likert question");

    assertEquals(4, l1.compareTo(likert));
  }

  /**
   * compareTo method with Multiple Select.
   */
  @Test
  public void likertCompareMultipleSelect() {
    Questionnaires ms1 = new MultipleSelect("MSQ", "1 2",
            "Option 1", "Option 2", "Option 3");

    assertEquals(-1, ms1.compareTo(likert));
  }

  /**
   * Test the equality of the strings.
   */
  @Test
  public void testToString() {
    assertEquals(" Likert: Q.How much do you like chicken?\n ->[Strongly agree, " +
            "Agree, Neither agree nor disagree, Disagree, Strongly Disagree]\n", likert.toString());
  }

}
