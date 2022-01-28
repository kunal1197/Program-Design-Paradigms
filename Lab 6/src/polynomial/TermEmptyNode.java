package polynomial;

import polynomialutil.Term;

/**
 * This is used to hold empty element nodes.
 */
public class TermEmptyNode implements ListOfTerm {

  /**
   * Used to get the power of the term.
   *
   * @return power.
   */
  @Override
  public int getDegree() {
    return -1;
  }

  /**
   * Used to get copy of empty node.
   * @return empty node copy.
   */
  @Override
  public ListOfTerm obNode() {
    return new TermEmptyNode();
  }

  /**
   * Used to add 2 polynomials.
   *
   * @param poly polynomial equation.
   * @return polynomial result.
   */
  @Override
  public Polynomial add(Polynomial poly) {
    int power = 0;
    if (poly.getDegree() > this.getDegree()) {
      power = poly.getDegree();
    } else {
      power = this.getDegree();
    }
    return addAcc(poly, power, new PolynomialImpl());
  }

  /**
   * Accumulator helper for add function.
   *
   * @param poly     polynomial.
   * @param power    power.
   * @param equation accumulator,
   * @return Polynomial result.
   */
  @Override
  public Polynomial addAcc(Polynomial poly, int power, Polynomial equation) {
    if (power == -1) {
      return equation;
    }

    if (this.getCoefficient(power) == 0 && poly.getCoefficient(power) != 0) {
      equation.addTerm(this.getCoefficient(power) + poly.getCoefficient(power), power);
      power--;
      return this.addAcc(poly, power, equation);
    } else if (poly.getCoefficient(power) == 0 && this.getCoefficient(power) != 0) {
      equation.addTerm(poly.getCoefficient(power) + this.getCoefficient(power), power);
      power--;
      return this.addAcc(poly, power, equation);
    }
    else if (this.getCoefficient(power) == 0) {
      power--;
      return this.addAcc(poly, power, equation);
    }

    equation.addTerm((this.getCoefficient(power) + poly.getCoefficient(power)), power);
    power--;
    return this.addAcc(poly, power, equation);
  }

  /**
   * Used to add new terms to the polynomial equation.
   *
   * @param coefficient coefficient of term.
   * @param power       power of term.
   * @return list of term object.
   */
  @Override
  public ListOfTerm addTerm(int coefficient, int power) {
    return new TermElementNode(new Term(coefficient, power), this);
  }

  /**
   * Used to check if 2 equations are same or not.
   *
   * @param poly equation.
   * @return boolean.
   */
  @Override
  public boolean isSame(Polynomial poly) {
    return poly.getDegree() == -1;
  }

  /**
   * Accumulator helper for Is Same function.
   *
   * @param poly  polynomial.
   * @param power power of the term.
   * @return boolean.
   */
  @Override
  public boolean isSameAcc(Polynomial poly, int power) {
    return true;
  }

  /**
   * Evaluate the result of equation.
   *
   * @param x value.
   * @return result.
   */
  @Override
  public double evaluate(double x) {
    return accumulatorEval(x,0);
  }

  /**
   * Accumualtor helper for evaluate.
   *
   * @param x   value.
   * @param sum result.
   * @return result.
   */
  @Override
  public double accumulatorEval(double x, double sum) {
    return sum;
  }

  /**
   * This is used to get the Coefficient.
   *
   * @param power of the term.
   * @return coefficient.
   */
  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  /**
   * To String for the class.
   *
   * @return String representation.
   */
  @Override
  public String helper(StringBuilder ob) {
    if (ob.length() == 0) {
      ob.append("0");
    }
    return ob.toString();
  }

  /**
   * To String implementation.
   *
   * @return String representation.
   */
  public String toString() {
    return helper(new StringBuilder());
  }
}
