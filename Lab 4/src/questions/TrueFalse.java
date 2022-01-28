package questions;

import java.util.Arrays;

/**
 * This class represents True False Question type.
 */
public class TrueFalse extends Questionnaires {

  String[] getTrueFalseList() {
    String[] trueFalseList = new String[2];
    trueFalseList[0] = ("True");
    trueFalseList[1] = ("False");

    return trueFalseList;
  }

  /**
   * Construct True False object.
   *
   * @param question of Select Choice type.
   */
  public TrueFalse(String question, String answers) {
    this.question = question;
    this.answers = answers;
    this.options = getTrueFalseList();
    checkInvalid();
  }

  private void checkInvalid() {
    if (answers == null || answers.equals("") || question == null || question.equals("")) {
      throw new IllegalArgumentException("This cannot be null");
    }

    if (!this.answers.equalsIgnoreCase("true")
            && !this.answers.equalsIgnoreCase("false")) {
      throw new IllegalArgumentException("The answer option is invalid");
    }
  }

  /**
   * This method return if the answer is valid, correct or incorrect.
   *
   * @param answers User input answer.
   * @return answer validity.
   */
  @Override
  public String answer(String answers) {
    if (answers == null) {
      throw new IllegalArgumentException("User answer cannot be null");
    }

    if (answers.equalsIgnoreCase(this.answers)) {
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
   * This method is used to compare multiple choice object with Questionnaires.
   *
   * @param o Multiple choice Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareMultipleChoice(MultipleChoice o) {
    return 1;
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
    return o.getText().compareTo(this.getText());
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
      return obj.compareTrueOrFalse(this);
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
    return String.format(" True or False: Q.%s\n ->%s\n",
            this.getText(),
            Arrays.toString(options));
  }

}
