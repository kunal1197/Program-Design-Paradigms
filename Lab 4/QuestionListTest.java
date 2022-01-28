package questions;

import org.junit.Before;
import org.junit.Test;

public class QuestionListTest {
  private Questionnaires[] questionBank;
  static MultipleChoice[] multipleChoice = new MultipleChoice[2];
  static MultipleSelect[] multipleSelect = new MultipleSelect[2];
  static TrueOrFalse[] trueOrFalse = new TrueOrFalse[2];
  static Likert[] likert = new Likert[2];
  static int j=0;

  @Before
  public void setup() {
    questionBank = getQuestions();
  }

  private void multipleChoiceQuestions() {

    multipleChoice[0] = new MultipleChoice("MC1", "1","MCone","MCtwo","MCthree");

    multipleChoice[1] = new MultipleChoice("MC2", "2", "MCone", "MCtwo", "MCthree");

    for (int i = 0; i < 2; i++) {
      questionBank[j++] = multipleChoice[i];
    }
  }

  private void multipleSelectQuestions() {

    multipleSelect[0] = new MultipleSelect("MS1", "1 2","MSone", "MStwo", "MSthree");

    multipleSelect[1] = new MultipleSelect("MS2", "1 3","MSone", "MStwo", "MSthree");

    for (int i = 0; i < 2; i++) {
      questionBank[j++] = multipleSelect[i];
    }
  }

  private void trueOrFalseQuestions() {

    trueOrFalse[0] = new TrueOrFalse("TF1", "1");
    trueOrFalse[1] = new TrueOrFalse("TF2", "2");

    for (int i = 0; i < 2; i++) {
      questionBank[j++] = trueOrFalse[i];
    }
  }

  private void likertQuestions() {

    likert[0] = new Likert("L1");
    likert[1] = new Likert("L2");

    for (int i = 0; i < 2; i++) {
      questionBank[j++] = likert[i];
    }
  }

  private Questionnaires[] getQuestions() {
    multipleSelectQuestions();
    multipleChoiceQuestions();
    likertQuestions();
    trueOrFalseQuestions();

    java.util.Arrays.sort(questionBank);
    return questionBank;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullQuestionsArray() {
    new QuestionBank(null);
  }
}
