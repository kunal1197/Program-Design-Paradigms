package polynomialutil;

/**
 * This class is used to hold the term with a coefficient and power.
 */
public class Term {

  private final int coefficient;
  private final int power;

  /**
   * Constructor to hold the Term object.
   *
   * @param c to hold coefficient.
   * @param p to hold power.
   */
  public Term(int c, int p) {
    coefficient = c;
    power = p;
    nullChecks();
  }

  private void nullChecks() {
    if (power < 0) {
      throw new IllegalArgumentException("Power should be greater than 0");
    }
  }

  /**
   * This is used to get the coefficient.
   *
   * @return coefficient.
   */
  public int getCoefficient() {
    return this.coefficient;
  }

  /**
   * This is used to get the Power.
   *
   * @return power.
   */
  public int getPower() {
    return this.power;
  }

}
