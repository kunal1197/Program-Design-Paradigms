package questions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Multiple Select Test class.
 */
public class MultipleSelectTest {
  private Questionnaires multipleSelect;

  /**
   * Setup test for Multiple Select.
   */
  @Before
  public void setup() {
    multipleSelect = new MultipleSelect("How much do you like chicken?", "2 3",
            "good", "very good", "bad");

  }

  /**
   * test the correct order of answers in multiple answers.
   */
  @Test
  public void testOrderOfAnswer() {
    assertEquals("Correct", multipleSelect.answer("3 2"));
  }

  /**
   * test user correct answer.
   */
  @Test
  public void correctAnswer() {
    assertEquals("Correct", multipleSelect.answer("2 3"));
  }

  /**
   * test the user wrong answer.
   */
  @Test
  public void wrongAnswer() {
    assertEquals("Incorrect", multipleSelect.answer("1"));
  }

  /**
   * test user null answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUserNullAnswer() {
    multipleSelect.answer(null);
  }

  /**
   * test user empty answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUserEmptyAnswer() {
    multipleSelect.answer("");
  }

  /**
   * test the questions.
   */
  @Test
  public void testQuestion() {
    assertEquals("How much do you like chicken?", multipleSelect.getText());
  }

  /**
   * test the invalid answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAnswer() {
    multipleSelect = new MultipleSelect("MS2", "5",
            "MSone", "MStwo", "MSthree");

  }

  /**
   * test the negative answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void negativeAnswer() {
    multipleSelect = new MultipleSelect("MS2", "-1",
            "MSone", "MStwo", "MSthree");

  }

  /**
   * test invalid options less than 3.
   */
  @Test(expected = IllegalArgumentException.class)
  public void optionsLessThanThree() {
    multipleSelect = new MultipleSelect("MS2", "2",
            "option 1", "option 2");
  }

  /**
   * test invalid options greater than 8.
   */
  @Test(expected = IllegalArgumentException.class)
  public void optionsGreaterThanEight() {
    multipleSelect = new MultipleSelect("MS2", "2",
            "option 1", "option 2", "option 3", "option 4", "option 5", "option 6",
            "option 7", "option 8", "option 9", "option 10");

  }

  /**
   * check for null answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullAnswer() {
    multipleSelect = new MultipleSelect("MC2", "",
            "MCone", "MCtwo", "MCthree");

  }

  /**
   * check for illegal character.
   */
  @Test(expected = IllegalArgumentException.class)
  public void IllegalCharacter() {
    multipleSelect = new MultipleSelect("MC2", "fvd@",
            "MCone", "MCtwo", "MCthree");

  }

  /**
   * check for null question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullQuestion() {
    multipleSelect = new MultipleSelect("null", "fvd@",
            "MCone", "MCtwo", "MCthree");
  }


  /**
   * test the multiple choice method.
   */
  @Test
  public void multipleSelectChoice() {
    MultipleSelect ms1 = new MultipleSelect("Which all are true?", "2 3",
            "good", "very good", "bad");

    MultipleSelect ms2 = new MultipleSelect("How much do you like chicken?", "2 3",
            "good", "very good", "bad");

    MultipleSelect ms3 = new MultipleSelect("ae much do you like chicken?", "2 3",
            "good", "very good", "bad");

    assertEquals(15, multipleSelect.compareMultipleSelect(ms1));
    assertEquals(0, multipleSelect.compareMultipleSelect(ms2));
    assertEquals(25, multipleSelect.compareMultipleSelect(ms3));
  }

  /**
   * test the true false method.
   */
  @Test
  public void trueFalseCompare() {
    TrueFalse tf1 = new TrueFalse("TF1", "1");

    assertEquals(-1, multipleSelect.compareTrueOrFalse(tf1));
  }

  /**
   * test the multiple select method.
   */
  @Test
  public void multipleSelectTrueFalse() {
    MultipleSelect ms1 = new MultipleSelect("MS1", "1",
            "good", "very good", "bad");


    assertEquals(5, multipleSelect.compareMultipleSelect(ms1));
  }

  /**
   * test the likert method.
   */
  @Test
  public void likertCompare() {
    Likert l1 = new Likert("L1");

    assertEquals(1, multipleSelect.compareLikert(l1));
  }

  /**
   * compareTo method with Multiple Choice.
   */
  @Test
  public void MultipleSelectCompareMultipleCompare() {
    Questionnaires ms1 = new MultipleChoice("MCQ", "1",
            "Option 1", "Option 2", "Option 3");


    assertEquals(-1, ms1.compareTo(multipleSelect));
  }

  /**
   * compareTo method with True False.
   */
  @Test
  public void multipleSelectCompareTrueFalse() {
    Questionnaires tf1 = new TrueFalse("TF1", "1");

    assertEquals(-1, tf1.compareTo(multipleSelect));
  }

  /**
   * compareTo method with Likert Select.
   */
  @Test
  public void multipleSelectCompareLikert() {
    Questionnaires l1 = new Likert("Likert question");

    assertEquals(1, l1.compareTo(multipleSelect));
  }

  /**
   * compareTo method with Multiple Select.
   */
  @Test
  public void multipleSelectCompareMultipleSelect() {
    Questionnaires ms1 = new MultipleSelect("MSQ", "1 2",
            "Option 1", "Option 2", "Option 3");

    assertEquals(5, ms1.compareTo(multipleSelect));
  }

  /**
   * test the equality for multiple select string.
   */
  @Test
  public void testToString() {
    assertEquals(" Multiple Select: Q.How much do you like chicken?\n" +
            " ->[good, very good, bad]\n", multipleSelect.toString());

  }


}
