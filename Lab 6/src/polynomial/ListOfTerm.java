package polynomial;

/**
 * List of terms is used to handle different types of term in Polynomial.
 */
public interface ListOfTerm {

  /**
   * Used to get the power of the term.
   *
   * @return power.
   */
  int getDegree();

  /**
   * Used to get copy of Node.
   * @return node.
   */
  ListOfTerm obNode();

  /**
   * Used to add 2 polynomials.
   *
   * @param poly polynomial equation.
   * @return polynomial result.
   */
  Polynomial add(Polynomial poly);

  /**
   * Accumulator helper for add function.
   *
   * @param poly  polynomial.
   * @param power power.
   * @param acc   accumulator,
   * @return Polynomial result.
   */
  Polynomial addAcc(Polynomial poly, int power, Polynomial acc);

  /**
   * Used to add new terms to the polynomial equation.
   *
   * @param coefficient coefficient of term.
   * @param power       power of term.
   * @return list of term object.
   */
  ListOfTerm addTerm(int coefficient, int power);

  /**
   * Used to check if 2 equations are same or not.
   *
   * @param poly equation.
   * @return boolean.
   */
  boolean isSame(Polynomial poly);

  /**
   * Accumulator helper for Is Same function.
   *
   * @param poly  polynomial.
   * @param power power of the term.
   * @return boolean.
   */
  boolean isSameAcc(Polynomial poly, int power);

  /**
   * Evaluate the result of equation.
   *
   * @param x value.
   * @return result.
   */
  double evaluate(double x);

  /**
   * Accumualtor helper for evaluate.
   *
   * @param x   value.
   * @param sum result.
   * @return result.
   */
  double accumulatorEval(double x, double sum);

  /**
   * This is used to get the Coefficient.
   *
   * @param power of the term.
   * @return coefficient.
   */
  int getCoefficient(int power);

  /**
   * ToString helper for class.
   *
   * @param ob builder object.
   * @return String result.
   */
  String helper(StringBuilder ob);


}
