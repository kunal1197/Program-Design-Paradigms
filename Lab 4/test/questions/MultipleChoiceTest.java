package questions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Multiple Choice Test class.
 */
public class MultipleChoiceTest {
  private Questionnaires multipleChoice;

  /**
   * Setup test for Multiple Choice.
   */
  @Before
  public void setup() {
    multipleChoice = new MultipleChoice("How much do you like chicken?", "2",
            "good", "very good", "bad");

  }

  /**
   * test the user correct answer.
   */
  @Test
  public void testCorrectAnswer() {
    assertEquals("Correct", multipleChoice.answer("2"));
  }

  /**
   * test the user wrong answer.
   */
  @Test
  public void testWrongAnswer() {
    assertEquals("Incorrect", multipleChoice.answer("1"));
  }

  /**
   * test the Null user answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUserNullAnswer() {
    multipleChoice.answer(null);
  }

  /**
   * test the Empty user answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUserEmptyAnswer() {
    multipleChoice.answer("");
  }

  /**
   * test the correctness of question.
   */
  @Test
  public void testCorrectQuestion() {
    assertEquals("How much do you like chicken?", multipleChoice.getText());
  }

  /**
   * test the invalid option answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnswer() {
    multipleChoice = new MultipleChoice("MC2", "5",
            "MCone", "MCtwo", "MCthree");

  }

  /**
   * test the negative answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void negativeAnswer() {
    multipleChoice = new MultipleChoice("MC2", "-1",
            "MCone", "MCtwo", "MCthree");
  }

  /**
   * test the number of options less than 3.
   */
  @Test(expected = IllegalArgumentException.class)
  public void optionsLessThanThree() {
    multipleChoice = new MultipleChoice("MC2", "2",
            "option 1", "option 2");
  }

  /**
   * test the number of options greater than 8.
   */
  @Test(expected = IllegalArgumentException.class)
  public void optionsGreaterThanEight() {
    multipleChoice = new MultipleChoice("MC2", "2",
            "option 1", "option 2", "option 3", "option 4", "option 5", "option 6",
            "option 7", "option 8", "option 9", "option 10");
  }

  /**
   * test the multiple choice answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void multipleSelection() {
    multipleChoice = new MultipleChoice("MC2", "2 3",
            "MCone", "MCtwo", "MCthree");
  }

  /**
   * test the null answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullAnswer() {
    multipleChoice = new MultipleChoice("MC2", "",
            "MCone", "MCtwo", "MCthree");
  }

  /**
   * test the answer for illegal character.
   */
  @Test(expected = IllegalArgumentException.class)
  public void IllegalCharacter() {
    multipleChoice = new MultipleChoice("MC2", "fvd@",
            "MCone", "MCtwo", "MCthree");
  }

  /**
   * test for null question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullQuestion() {
    multipleChoice = new MultipleChoice("null", "fvd@",
            "MCone", "MCtwo", "MCthree");
  }

  /**
   * test the multiple choice method.
   */
  @Test
  public void multipleChoiceCompare() {
    MultipleChoice mc1 = new MultipleChoice("do you like chicken?", "2",
            "good", "very good", "bad");

    MultipleChoice mc2 = new MultipleChoice("How do you like chicken?", "2",
            "good", "very good", "bad");

    MultipleChoice mc3 = new MultipleChoice("How much do you like chicken?", "2",
            "good", "very good", "bad");

    assertEquals(28, multipleChoice.compareMultipleChoice(mc1));
    assertEquals(-9, multipleChoice.compareMultipleChoice(mc2));
    assertEquals(0, multipleChoice.compareMultipleChoice(mc3));
  }

  /**
   * test the true false method.
   */
  @Test
  public void trueFalseCompare() {
    TrueFalse tf1 = new TrueFalse("TF1", "1");

    assertEquals(-1, multipleChoice.compareTrueOrFalse(tf1));
  }

  /**
   * test the multiple select method.
   */
  @Test
  public void multipleSelectCompare() {
    MultipleSelect ms1 = new MultipleSelect("MS1", "1",
            "good", "very good", "bad");


    assertEquals(1, multipleChoice.compareMultipleSelect(ms1));
  }

  /**
   * test the likert method.
   */
  @Test
  public void likertCompare() {
    Likert l1 = new Likert("L1");

    assertEquals(1, multipleChoice.compareLikert(l1));
  }

  /**
   * compareTo method with Multiple Choice.
   */
  @Test
  public void multipleChoiceCompareMultipleChoice() {
    Questionnaires mc1 = new MultipleChoice("MCQ", "1",
            "Option 1", "Option 2", "Option 3");


    assertEquals(5, mc1.compareTo(multipleChoice));
  }

  /**
   * compareTo method with True False.
   */
  @Test
  public void multipleChoiceCompareTrueFalse() {
    Questionnaires tf1 = new TrueFalse("TF1", "1");

    assertEquals(-1, tf1.compareTo(multipleChoice));
  }

  /**
   * compareTo method with Likert Select.
   */
  @Test
  public void multipleChoiceCompareLikert() {
    Questionnaires l1 = new Likert("Likert question");

    assertEquals(1, l1.compareTo(multipleChoice));
  }

  /**
   * compareTo method with Multiple Select.
   */
  @Test
  public void multipleChoiceCompareMultipleSelect() {
    Questionnaires ms1 = new MultipleSelect("MSQ", "1 2",
            "Option 1", "Option 2", "Option 3");

    assertEquals(1, ms1.compareTo(multipleChoice));
  }

  /**
   * test the equality for multiple choice string.
   */
  @Test
  public void testToString() {
    assertEquals("Multiple Choice: Q.How much do you like chicken?\n" +
            " ->[good, very good, bad]\n", multipleChoice.toString());

  }

}


