package polynomial;

import polynomialutil.Term;

/**
 * This is used to hold the element node containing term.
 */
public class TermElementNode implements ListOfTerm {

  private final Term term;
  private final ListOfTerm rest;

  /**
   * Constructor for Element node.
   *
   * @param t  Term object.
   * @param lt List of term object.
   */
  public TermElementNode(Term t, ListOfTerm lt) {
    term = new Term(t.getCoefficient(), t.getPower());
    rest = lt.obNode();
    nullChecks();
  }

  private void nullChecks() {
    if (term == null) {
      throw new IllegalArgumentException("Term cannot be null");
    }
    if (rest == null) {
      throw new IllegalArgumentException("Rest Polynomial cannot be null");
    }
  }

  /**
   * Element node copy.
   * @return element node.
   */
  @Override
  public ListOfTerm obNode() {
    return new TermElementNode(new Term(this.term.getCoefficient(),
            this.term.getPower()), this.rest);
  }

  /**
   * Used to get the power of the term.
   *
   * @return power.
   */
  @Override
  public int getDegree() {
    return this.term.getPower();
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
    return rest.addAcc(poly, power, equation);
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
    if (power > this.getDegree()) {
      return new TermElementNode(new Term(coefficient, power), this);
    } else if (power == this.getDegree()) {
      return new TermElementNode(new Term(this.getCoefficient(power) + coefficient, power),
              this.rest);
    }
    return new TermElementNode(this.term, rest.addTerm(coefficient, power));
  }

  /**
   * Used to check if 2 equations are same or not.
   *
   * @param poly equation.
   * @return boolean.
   */
  @Override
  public boolean isSame(Polynomial poly) {
    int power = 0;
    if (poly.getDegree() > this.getDegree()) {
      power = poly.getDegree();
    } else {
      power = this.getDegree();
    }
    return isSameAcc(poly, power);
  }

  /**
   * Accumulator helper for Is Same function.
   *
   * @param poly  polynomial.
   * @param power power of the term.
   * @return boolean.
   */
  public boolean isSameAcc(Polynomial poly, int power) {

    if (power == 0 && this.getCoefficient(power) == poly.getCoefficient(power)) {
      return true;
    }
    if (this.getCoefficient(power) != poly.getCoefficient(power)) {
      return false;
    }
    else if (this.getCoefficient(power) != 0 && poly.getCoefficient(power) == 0
            || this.getCoefficient(power) == 0 && poly.getCoefficient(power) != 0) {
      return false;
    }
    else if (this.getCoefficient(power) == 0) {
      power--;
      return this.isSameAcc(poly, power);
    }
    power--;
    return rest.isSameAcc(poly, power);
  }

  /**
   * Evaluate the result of equation.
   *
   * @param x value.
   * @return result.
   */
  @Override
  public double evaluate(double x) {
    return accumulatorEval(x, 0);
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
    sum = sum + this.term.getCoefficient() * Math.pow(x, this.term.getPower());
    return rest.accumulatorEval(x, sum);
  }

  /**
   * This is used to get the Coefficient.
   *
   * @param power of the term.
   * @return coefficient.
   */
  @Override
  public int getCoefficient(int power) {
    if (this.term.getPower() == power) {
      return this.term.getCoefficient();
    } else {
      return rest.getCoefficient(power);
    }
  }

  /**
   * To String for the class.
   *
   * @return String representation.
   */
  public String toString() {
    return helper(new StringBuilder());
  }

  /**
   * ToString helper for class.
   *
   * @param ob builder object.
   * @return String result.
   */
  public String helper(StringBuilder ob) {
    String coefficient = "" + term.getCoefficient();
    if (term.getCoefficient() > 0 && ob.length() > 0) {
      coefficient = "+" + term.getCoefficient();
    } else if (term.getCoefficient() == 0) {
      coefficient = "";
    }

    String power = "x^" + term.getPower();
    if (term.getCoefficient() == 0 || term.getPower() == 0) {
      power = "";
    }
    ob.append(coefficient).append(power).append(" ");

    return rest.helper(ob);
  }
}
