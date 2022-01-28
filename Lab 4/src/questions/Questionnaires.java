package questions;

/**
 * This is the Abstract class for all the types of questions and their behaviours.
 */
public abstract class Questionnaires implements Question {
  protected String question;
  protected String answers;
  protected String[] options;

  /**
   * This method return if the answer is valid, correct or incorrect.
   *
   * @param answers User input answer.
   * @return answer validity.
   */
  @Override
  public String answer(String answers) {
    if (answers == null || answers.length() == 0) {
      throw new IllegalArgumentException("this cannot be empty or null.");
    }

    int answerNo = Integer.parseInt(answers);
    if (answerNo < 1 || answerNo > options.length) {
      return INCORRECT;
    }
    if (answers.equals(this.answers)) {
      return CORRECT;
    } else {
      return INCORRECT;
    }
  }

  /**
   * This method is used to get the Question.
   *
   * @return question.
   */
  @Override
  public String getText() {
    return question;
  }

  /**
   * This method is used to get the Answers.
   *
   * @return answers.
   */
  public String getAnswer() {
    return answers;
  }

  /**
   * This method is used to get the Options.
   *
   * @return String[] options.
   */
  public String[] getOptions() {
    return options;
  }

  /**
   * This method is used to compare multiple choice object with Questionnaires.
   *
   * @param o Multiple choice Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareMultipleChoice(MultipleChoice o);

  /**
   * This method is used to compare Multiple Select object with Questionnaires.
   *
   * @param o Multiple Select Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareMultipleSelect(MultipleSelect o);

  /**
   * This method is used to compare true false object with Questionnaires.
   *
   * @param o true false Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareTrueOrFalse(TrueFalse o);

  /**
   * This method is used to compare Likert object with Questionnaires.
   *
   * @param o Likert Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  public abstract int compareLikert(Likert o);

  /**
   * This method is used to get Questionnaire objects and compare them.
   *
   * @param o Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareTo(Question o) {
    return 0;
  }
}
