package questions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * True False Test class.
 */
public class TrueOrFalseTest {
  private Questionnaires trueOrFalse;

  /**
   * Setup test for True False.
   */
  @Before
  public void setup() {
    trueOrFalse = new TrueFalse("How much do you like chicken?", "2");
  }

  /**
   * test for user correct answer.
   */
  @Test
  public void testCorrectAnswer() {
    assertEquals("Correct", trueOrFalse.answer("2"));
  }

  /**
   * test for user wrong answer.
   */
  @Test
  public void testWrongAnswer() {
    assertEquals("Incorrect", trueOrFalse.answer("1"));
  }

  /**
   * test for user null answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUserNullAnswer() {
    trueOrFalse.answer(null);
  }

  /**
   * test for user empty answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUserEmptyAnswer() {
    trueOrFalse.answer("");
  }

  /**
   * check for correct question.
   */
  @Test
  public void testCorrectQuestion() {
    assertEquals("How much do you like chicken?", trueOrFalse.getText());
  }

  /**
   * test for invalid answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnswer() {
    trueOrFalse = new TrueFalse("TF1", "4");

  }

  /**
   * test for negative answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void negativeAnswer() {
    trueOrFalse = new TrueFalse("TF1", "-1");

  }

  /**
   * test for multiple selection condition.
   */
  @Test(expected = IllegalArgumentException.class)
  public void multipleSelection() {
    trueOrFalse = new TrueFalse("TF1", "2 1");

  }

  /**
   * test for null answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullAnswer() {
    trueOrFalse = new TrueFalse("TF1", "");

  }

  /**
   * test for illegal character answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void IllegalCharacter() {
    trueOrFalse = new TrueFalse("TF1", "fvd@");

  }

  /**
   * check for empty questions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void emptyQuestion() {
    trueOrFalse = new TrueFalse("", "2");
  }

  /**
   * check for null questions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullQuestion() {
    trueOrFalse = new TrueFalse(null, "2");
  }

  /**
   * test the multiple choice method.
   */
  @Test
  public void multipleChoiceCompare() {
    MultipleChoice mc1 = new MultipleChoice("do you like chicken?", "2",
            "good", "very good", "bad");

    assertEquals(1, trueOrFalse.compareMultipleChoice(mc1));
  }

  /**
   * test the true false method.
   */
  @Test
  public void trueFalseCompare() {
    TrueFalse tf1 = new TrueFalse("TF1", "1");
    TrueFalse tf2 = new TrueFalse("FF2", "1");
    TrueFalse tf3 = new TrueFalse("How much do you like chicken?", "1");

    assertEquals(12, trueOrFalse.compareTrueOrFalse(tf1));
    assertEquals(-2, trueOrFalse.compareTrueOrFalse(tf2));
    assertEquals(0, trueOrFalse.compareTrueOrFalse(tf3));
  }

  /**
   * test the multiple select method.
   */
  @Test
  public void multipleSelectCompare() {
    MultipleSelect ms1 = new MultipleSelect("MS1", "1",
            "good", "very good", "bad");

    assertEquals(1, trueOrFalse.compareMultipleSelect(ms1));
  }

  /**
   * test the likert method.
   */
  @Test
  public void likertCompare() {
    Likert l1 = new Likert("L1");

    assertEquals(1, trueOrFalse.compareLikert(l1));
  }

  /**
   * compareTo method with Multiple Choice.
   */
  @Test
  public void trueOrFalseCompareMultipleChoice() {
    Questionnaires mc1 = new MultipleChoice("MCQ", "1",
            "Option 1", "Option 2", "Option 3");


    assertEquals(1, mc1.compareTo(trueOrFalse));
  }

  /**
   * compareTo method with True False.
   */
  @Test
  public void trueOrFalseCompareTrueFalse() {
    Questionnaires tf1 = new TrueFalse("TF1", "1");

    assertEquals(12, tf1.compareTo(trueOrFalse));
  }

  /**
   * compareTo method with Likert Select.
   */
  @Test
  public void TrueOrFalseCompareLikert() {
    Questionnaires l1 = new Likert("Likert question");

    assertEquals(1, l1.compareTo(trueOrFalse));
  }

  /**
   * compareTo method with Multiple Select.
   */
  @Test
  public void TrueOrFalseCompareMultipleSelect() {
    Questionnaires ms1 = new MultipleSelect("MSQ", "1 2",
            "Option 1", "Option 2", "Option 3");

    assertEquals(1, ms1.compareTo(trueOrFalse));
  }

  /**
   * test the equality for True False string.
   */
  @Test
  public void testToString() {
    assertEquals(" True or False: Q.How much do you like chicken?\n" +
            " ->[True, False]\n", trueOrFalse.toString());

  }

}



