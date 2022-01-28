package questions;

/**
 * This class holds the Questionbank List.
 */
public class QuestionList {

  Questionnaires[] questionBank;
  static MultipleChoice[] multipleChoice = new MultipleChoice[2];
  static MultipleSelect[] multipleSelect = new MultipleSelect[2];
  static TrueFalse[] trueOrFalse = new TrueFalse[2];
  static Likert[] likert = new Likert[2];
  static int j = 0;

  /**
   * Construct object for Question List.
   *
   * @param questionBank the question list.
   */
  public QuestionList(Questionnaires[] questionBank) {
    this.questionBank = questionBank;
    checkInvalid();
  }

  /**
   * Check for invalid questions.
   */
  void checkInvalid() {
    if (this.questionBank == null || this.questionBank.length == 0) {
      throw new IllegalArgumentException("The Question Bank cannot be null or empty");
    }
  }

  /**
   * For storing Multiple Choice Questions.
   */
  void multipleChoiceQuestions() {

    multipleChoice[0] = new MultipleChoice("MC1", "1", "MCone", "MCtwo", "MCthree");

    multipleChoice[1] = new MultipleChoice("MC2", "2", "MCone", "MCtwo", "MCthree");

    for (int i = 0; i < 2; i++) {
      questionBank[j++] = multipleChoice[i];
    }
  }

  /**
   * For storing Multiple Select Questions.
   */
  void multipleSelectQuestions() {

    multipleSelect[0] = new MultipleSelect("MS1", "1 2", "MSone", "MStwo", "MSthree");

    multipleSelect[1] = new MultipleSelect("MS2", "1 3", "MSone", "MStwo", "MSthree");

    for (int i = 0; i < 2; i++) {
      questionBank[j++] = multipleSelect[i];
    }
  }

  /**
   * For storing True False Questions.
   */
  void trueOrFalseQuestions() {

    trueOrFalse[0] = new TrueFalse("TF1", "1");
    trueOrFalse[1] = new TrueFalse("TF2", "2");

    for (int i = 0; i < 2; i++) {
      questionBank[j++] = trueOrFalse[i];
    }
  }

  /**
   * For storing Likert Questions.
   */
  void likertQuestions() {

    likert[0] = new Likert("L1");
    likert[1] = new Likert("L2");

    for (int i = 0; i < 2; i++) {
      questionBank[j++] = likert[i];
    }
  }

  /**
   * used to get the final list of questions.
   *
   * @return Question list.
   */
  public Questionnaires[] getQuestions() {
    multipleSelectQuestions();
    multipleChoiceQuestions();
    likertQuestions();
    trueOrFalseQuestions();

    java.util.Arrays.sort(questionBank);
    return questionBank;
  }

}
