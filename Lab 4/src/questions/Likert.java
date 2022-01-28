package questions;

import java.util.Arrays;

/**
 * This class represents Likert Question type.
 */
public class Likert extends Questionnaires {

  String[] getLikertList() {
    String[] likertList = new String[5];
    likertList[0] = ("Strongly agree");
    likertList[1] = ("Agree");
    likertList[2] = ("Neither agree nor disagree");
    likertList[3] = ("Disagree");
    likertList[4] = ("Strongly Disagree");

    return likertList;
  }

  /**
   * Construct Likert object.
   *
   * @param question of likert type.
   */
  public Likert(String question) {
    this.question = question;
    this.answers = null;
    this.options = getLikertList();
    checkInvalid();
  }

  private void checkInvalid() {
    if (this.question == null || this.question.equals("")) {
      throw new IllegalArgumentException("Question cannot be null or empty.");
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

    if (answers == null || answers.equals("")) {
      throw new IllegalArgumentException("User answer cannot be null or empty.");
    }

    int answerNo = Integer.parseInt(answers);
    if (answerNo >= 1 && answerNo <= 5) {
      return CORRECT;
    }
    else {
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
    return -1;
  }

  /**
   * This method is used to compare Multiple Select object with Questionnaires.
   *
   * @param o Multiple Select Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareMultipleSelect(MultipleSelect o) {
    return -1;
  }

  /**
   * This method is used to compare Likert object with Questionnaires.
   *
   * @param o Likert Object to be compared.
   * @return returns equality, greater or smaller than second.
   */
  @Override
  public int compareLikert(Likert o) {
    return o.getText().compareTo(this.getText());
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
      return obj.compareLikert(this);
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
    return String.format(" Likert: Q.%s\n ->%s\n",
            this.getText(),
            Arrays.toString(options));
  }

}
