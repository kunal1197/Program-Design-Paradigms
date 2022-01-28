package polynomial;

/**
 * Polynomial class is used to implement and handle equations with 0 or more terms.
 */
public class PolynomialImpl implements Polynomial {

  private ListOfTerm head;
  private String polynomial;

  /**
   * Constructor for an empty list.
   */
  public PolynomialImpl() {
    head = new TermEmptyNode();
  }

  /**
   * Construct a PolynomialImpl Object.
   *
   * @param poly Is the Polynomial String.
   * @throws IllegalArgumentException if poly is null or empty.
   */
  public PolynomialImpl(String poly) {

    head = new TermEmptyNode();
    polynomial = poly;
    nullChecks();
    polyParse();

  }

  private void nullChecks() {
    if (polynomial == null) {
      throw new IllegalArgumentException("Polynomial cannot be null");
    }
  }


  private void polyParse() {
    polynomial = polynomial.replace("+ ", "+");
    polynomial = polynomial.replace("- ", "-");
    String[] polyarr = polynomial.split(" ");
    String coefficient = "";
    String power = "";
    int pos = 0;
    for (String traver : polyarr) {
      String[] ele = traver.strip().split("x\\^");
      coefficient = ele[0];
      if (ele.length > 1) {
        power = ele[1];
      } else {
        power = "0";
      }
      addTerm(Integer.parseInt(coefficient), Integer.parseInt(power));
    }
  }

  /**
   * This function is used to add 2 polynomials.
   *
   * @param other the other polynomial to be added.
   * @return Polynomial Object.
   * @throws IllegalArgumentException if Polynomial is null.
   */
  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (other == null) {
      throw new IllegalArgumentException("Polynomial cannot be null");
    }
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Illegal type");
    }
    return head.add(other);
  }

  /**
   * This is used to add new terms.
   *
   * @param coefficient the coefficient of the term to be added.
   * @param power       the power of the term to be added.
   * @throws IllegalArgumentException when power is negative.
   */
  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    this.head = head.addTerm(coefficient, power);
  }

  /**
   * Used to check equality of 2 polynomials.
   *
   * @param poly the polynomial to use.
   * @return boolean value.
   */
  @Override
  public boolean isSame(Polynomial poly) {
    if (poly == null) {
      throw new IllegalArgumentException("Polynomial cannot be null");
    }

    if (!(poly instanceof PolynomialImpl)) {
      return false;
    }
    return head.isSame(poly);
  }

  /**
   * This is used to evaluate the equation by providing power x.
   *
   * @param x the value at which the polynomial is to be evaluated.
   * @return value.
   */
  @Override
  public double evaluate(double x) {
    return head.evaluate(x);
  }

  /**
   * This is used to get the Coefficient of term.
   *
   * @param power the power whose coefficient is sought
   * @return coefficient.
   */
  @Override
  public int getCoefficient(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be less than 0");
    }
    return head.getCoefficient(power);
  }

  /**
   * This is used to get the highest power of polynomial.
   *
   * @return degree.
   */
  @Override
  public int getDegree() {
    return head.getDegree();
  }

  /**
   * To String to represent Polynomial Object.
   *
   * @return String.
   */
  public String toString() {
    return head.toString().trim();
  }
}
