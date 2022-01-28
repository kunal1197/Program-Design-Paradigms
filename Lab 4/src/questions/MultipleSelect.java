package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class represents Multiple Select Question type.
 */
public class MultipleSelect extends Questionnaires {

  protected String question;
  protected String answers;
  protected String[] options;

  /**
   * Construct Multiple Select object.
   *
   * @param question of Select Choice type.
   */
  public MultipleSelect(String question, String answers, String... options) {
    this.question = question;
    this.answers = answers;
    this.options = options;
    checkInvalid();
  }

  private void checkInvalid() {
    if (answers == null || answers.equals("") || question == null || question.equals("")) {
      throw new IllegalArgumentException("This cannot be null");
    }
    if (this.options.length < 3 || this.options.length > 8) {
      throw new IllegalArgumentException("Options cannot be " + this.options.length);
    }
    List<String> answerList = new ArrayList<>(List.of(this.answers.split(" ")));
    int answerNo;
    for (String s : answerList) {
      answerNo = Integer.parseInt(s);
      if (answerNo < 1 || answerNo > this.options.length) {
        throw new IllegalArgumentException("The answer option is invalid");
      }
    }


    if (answerList.size() > options.length) {
      throw new IllegalArgumentException("Number of answers should be less than Options");
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

    List<String> answerList = new ArrayList<>(List.of(answers.split(" ")));
    int answerNo;
    for (String s : answerList) {
      answerNo = Integer.parseInt(s);
      if (answerNo < 1 || answerNo > this.options.length) {
        return INCORRECT;
      }
    }
    if (answerList.size() > this.options.length) {
      throw new IllegalArgumentException("Number of answers should be less than Options");
    }

    List<String> correctList = new ArrayList<>(List.of(this.answers.split(" ")));
    Collections.sort(correctList);
    Collections.sort(answerList);
    if (correctList.equals(answerList)) {
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
    return o.getText().compareTo(this.getText());
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
      return obj.compareMultipleSelect(this);
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
    return String.format(" Multiple Select: Q.%s\n ->%s\n",
            this.getText(),
            Arrays.toString(options));
  }
}
