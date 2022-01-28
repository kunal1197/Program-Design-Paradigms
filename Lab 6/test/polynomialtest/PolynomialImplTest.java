package polynomialtest;

import org.junit.Before;
import org.junit.Test;

import polynomial.PolynomialImpl;

import static org.junit.Assert.assertEquals;

/**
 * Testing class for Polynomial Implementation.
 */
public class PolynomialImplTest {

  private PolynomialImpl emptyPolynomial;
  private PolynomialImpl fullPolynomial;

  /**
   * Setting up the list of Polynomials for each of the tests.
   */
  @Before
  public void setup() {
    emptyPolynomial = new PolynomialImpl();

    fullPolynomial = new PolynomialImpl("4x^3 +3x^1 -5");
  }

  /**
   * Test for positive Degree.
   */
  @Test
  public void testGetDegree() {
    assertEquals(3, fullPolynomial.getDegree());
  }

  /**
   * Test for Zero Degree.
   */
  @Test
  public void testZeroDegree() {
    PolynomialImpl testpoly = new PolynomialImpl("5");
    assertEquals(0, testpoly.getDegree());
  }

  /**
   * Test for adding with Unique Powers.
   */
  @Test
  public void testAdd() {
    PolynomialImpl testPoly = new PolynomialImpl("8x^3 +6x^1 -10");
    assertEquals(testPoly.toString(),
            fullPolynomial.add(new PolynomialImpl("4x^3 +3x^1 -5")).toString());
  }

  /**
   * Test for adding with Different Powers.
   */
  @Test
  public void testAddDifferentPower() {
    PolynomialImpl testPoly = new PolynomialImpl("8x^2");
    assertEquals("4x^3 +8x^2 +3x^1 -5",
            fullPolynomial.add(testPoly).toString());
  }

  /**
   * Test for adding constants.
   */
  @Test
  public void testAddConstants() {
    PolynomialImpl testPoly = new PolynomialImpl("10");
    PolynomialImpl testPoly1 = new PolynomialImpl("0");
    assertEquals("10", testPoly1.add(testPoly).toString());
  }

  /**
   * Test add illegal Polynomial.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddIllegal() {
    PolynomialImpl testPoly = new PolynomialImpl("hh");
    fullPolynomial.add(testPoly);
  }

  /**
   * Test is Same with same powers.
   */
  @Test
  public void testIsSamePowers() {
    PolynomialImpl testPoly = new PolynomialImpl("4x^3 +3x^1 -5");
    assertEquals(true, fullPolynomial.isSame(testPoly));
  }

  /**
   * Test is Same with Different Powers.
   */
  @Test
  public void testDifferentPowers() {
    PolynomialImpl testPoly = new PolynomialImpl("4x^4 +3x^2 -5");
    assertEquals(false, fullPolynomial.isSame(testPoly));
  }

  /**
   * Test is Same with Constants.
   */
  @Test
  public void testIsSameConstants() {
    PolynomialImpl testPoly = new PolynomialImpl("0");
    PolynomialImpl testPoly1 = new PolynomialImpl("5");
    assertEquals(false, testPoly1.isSame(testPoly));
  }

  /**
   * Test for given power in Equation.
   */
  @Test
  public void testGetCoefficient() {
    assertEquals(4, fullPolynomial.getCoefficient(3));
  }

  /**
   * Test for power not in equation.
   */
  @Test
  public void testInvalidCoefficient() {
    assertEquals(0, fullPolynomial.getCoefficient(4));
  }

  /**
   * Test Evaluate with positive x.
   */
  @Test
  public void testEvaluatePos() {
    assertEquals(510, fullPolynomial.evaluate(5), 1e-6);
  }

  /**
   * Test Evaluate with negative x.
   */
  @Test
  public void testEvaluateNeg() {
    assertEquals(-43, fullPolynomial.evaluate(-2), 1e-6);
  }

  /**
   * Test add term with same powers.
   */
  @Test
  public void testAddTerm() {
    PolynomialImpl testPoly = new PolynomialImpl("4x^3 +3x^1 -5");
    PolynomialImpl addPoly = new PolynomialImpl("4x^3 -5");
    addPoly.addTerm(3, 1);
    assertEquals(testPoly.toString(), addPoly.toString());
  }

  /**
   * Test add term with different powers.
   */
  @Test
  public void testAddTermDifferentPowers() {
    PolynomialImpl testPoly = new PolynomialImpl("3x^4 +4x^3 +3x^2");
    PolynomialImpl addPoly = new PolynomialImpl("3x^4 +3x^2");
    addPoly.addTerm(4, 3);
    assertEquals(testPoly.toString(), addPoly.toString());
  }

  /**
   * Test for invalid powers in evaluate.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddTermInvalidPower() {
    PolynomialImpl addPoly = new PolynomialImpl("3x^4 +3x^2");
    addPoly.addTerm(4, -3);
  }

  /**
   * Test to String method.
   */
  @Test
  public void testToString() {
    assertEquals("4x^3 +3x^1 -5", fullPolynomial.toString());
  }

  /**
   * Test to String with Coefficient as 1.
   */
  @Test
  public void testToStringOneCoeff() {
    PolynomialImpl addPoly = new PolynomialImpl("1x^3 +1x^1 -5");
    assertEquals("1x^3 +1x^1 -5", addPoly.toString());
  }

  /**
   * Test for String with invalid equation.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    PolynomialImpl addPoly = new PolynomialImpl("1x^3 +1x^1 -e");
  }

  /**
   * Test for null constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNull() {
    PolynomialImpl addPoly = new PolynomialImpl(null);
  }

  /**
   * Test for empty constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorEmpty() {
    PolynomialImpl addPoly = new PolynomialImpl("");
  }

  /**
   * Test for constants String Constructor.
   */
  @Test
  public void testConstructorConstant() {
    PolynomialImpl addPoly = new PolynomialImpl("2");
    assertEquals("2", addPoly.toString());
  }

  /**
   * test constructor with same power.
   */
  @Test
  public void testConstructorSamePower() {
    PolynomialImpl addPoly = new PolynomialImpl("3x^2 +4x^2 +2");
    assertEquals("7x^2 +2", addPoly.toString());
  }

  /**
   * Test with Different powers in constructor.
   */
  @Test
  public void testConstructorUnique() {
    PolynomialImpl addPoly = new PolynomialImpl("3x^2 +4x^1 +2");
    assertEquals("3x^2 +4x^1 +2", addPoly.toString());
  }

  /**
   * Test with empty Argument Constructor.
   */
  @Test
  public void testConstructorEmptyArg() {
    assertEquals("0", emptyPolynomial.toString());
  }
}
