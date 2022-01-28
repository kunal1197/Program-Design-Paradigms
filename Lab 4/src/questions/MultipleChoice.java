package questions;

import java.util.Arrays;

/**
 * This class represents Multiple Choice Question type.
 */
public class MultipleChoice extends Questionnaires {

  /**
   * Construct Multiple Choice object.
   *
   * @param question of Multiple Choice type.
   */
  public MultipleChoice(String question, String answers, String... options) {
    this.question = question;
    this.answers = answers;
    this.options = options;
    checkInvalid();
  }

  private void checkInvalid() {
    if (answers == null || answers.equals("") || question == null || question.equals("")) {
      throw new IllegalArgumentException("This cannot be null or empty");
    }
    if (this.options.length < 3 || this.options.length > 8) {
      throw new IllegalArgumentException("Options cannot be " + this.options.length);
    }

    int answerNo = Integer.parseInt(this.answers);
    if (answerNo < 1 || answerNo > this.options.length) {
      throw new IllegalArgumentException("The answer option is invalid");
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
   * This method is used to compare multiple choice object with Questionnaires.
   *
   * @param o Multiple choice Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareMultipleChoice(MultipleChoice o) {
    return o.getText().compareTo(this.getText());
  }

  /**
   * This method is used to compare Multiple Select object with Questionnaires.
   *
   * @param o Multiple Select Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareMultipleSelect(MultipleSelect o) {
    return 1;
  }

  /**
   * This method is used to compare Likert object with Questionnaires.
   *
   * @param o Likert Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareLikert(Likert o) {
    return 1;
  }

  /**
   * This method is used to compare true false object with Questionnaires.
   *
   * @param o true false Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareTrueOrFalse(TrueFalse o) {
    return -1;
  }

  /**
   * This method is used to get Questionnaire objects and compare them.
   *
   * @param o Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareTo(Question o) {
    if (o instanceof Questionnaires) {
      Questionnaires obj = (Questionnaires) o;
      return obj.compareMultipleChoice(this);
    }
    return 0;
  }

  /**
   * Used to get String representation of Likert.
   *
   * @return Likert object String.
   */
  @Override
  public String toString() {
    return String.format("Multiple Choice: Q.%s\n ->%s\n",
            this.getText(),
            Arrays.toString(options));
  }
}
