package lookandsaytest;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.NoSuchElementException;

import lookandsay.LookAndSayIterator;
import lookandsay.RIterator;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for the LookAndSayIterator class.
 */
public class LookAndSayIteratorTest {

  RIterator<BigInteger> rIterator;
  RIterator<BigInteger> rIterator1;
  RIterator<BigInteger> rIterator2;

  /**
   * Set up objects for testing.
   */
  @Before
  public void setUp() {
    rIterator = new LookAndSayIterator(new BigInteger("112321"), new BigInteger("9".repeat(100)));
    rIterator1 = new LookAndSayIterator(new BigInteger("112321"));
    rIterator2 = new LookAndSayIterator();
  }

  /**
   * Test that verifies that the constructor with TWO arguments throws an IllegalArgumentException
   * if given an invalid seed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTwoConstructor() {
    RIterator<BigInteger> rIterator = new LookAndSayIterator(new BigInteger("-1"),
            new BigInteger("9".repeat(100)));
  }

  /**
   * Test that verifies that the constructor with TWO arguments throws an IllegalArgumentException
   * if the end is not larger than the seed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTwoConstructorLarge() {
    RIterator<BigInteger> rIterator = new LookAndSayIterator(new BigInteger("1".repeat(101)),
            new BigInteger("9".repeat(100)));
  }

  /**
   * Test that the constructor with ONE argument throws an
   * IllegalArgumentException if given an invalid seed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testOneConstructorLarge() {
    RIterator<BigInteger> rIterator = new LookAndSayIterator(new BigInteger("1003"));
  }

  /**
   * Test that verifies that next() returns the correct value in the sequence.
   */
  @Test
  public void testNext() {
    assertEquals(new BigInteger("112321"), rIterator.next());
    assertEquals(new BigInteger("2112131211"), rIterator.next());
  }

  /**
   * Test that verifies that next() throws a NoSuchElementException when there is no next value.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNextError() {
    RIterator<BigInteger> rIterator = new LookAndSayIterator(new BigInteger("112321"));
    for (int i = 0; i < 11; i++) {
      System.out.println(rIterator.next());
    }
  }

  /**
   * Test that verifies that prev() returns the correct value in the sequence.
   */
  @Test
  public void testPrev() {
    assertEquals(new BigInteger("112321"), rIterator.next());
    assertEquals(new BigInteger("2112131211"), rIterator.next());
    assertEquals(new BigInteger("112321"), rIterator.prev());
  }

  /**
   * Test that verifies that prev() throws a NoSuchElementException when there is no previous value.
   */
  @Test(expected = NoSuchElementException.class)
  public void testPrevError() {
    RIterator<BigInteger> rIterator = new LookAndSayIterator(new BigInteger("112321"));
    for (int i = 0; i < 5; i++) {
      System.out.println(rIterator.prev());
    }
  }

  /**
   * Test that verifies that hasNext() returns true when there is no next value.
   */
  @Test
  public void testHasNext() {
    assertTrue(rIterator.hasNext());
  }

  /**
   * Test that verifies that hasNext() returns false when there is no next value.
   */
  @Test
  public void testHasNextFalse() {
    RIterator<BigInteger> rIterator = new LookAndSayIterator(new BigInteger("9".repeat(100)));
    assertFalse(rIterator.hasNext());
  }

  /**
   * Test that verifies that hasPrevious() return true when there is a previous value.
   */
  @Test
  public void testHasPrev() {
    assertTrue(rIterator.hasPrevious());
  }

  /**
   * Test that verifies that hasPrevious() returns false when there is no previous value.
   */
  @Test
  public void testHasPrevFalse() {
    RIterator<BigInteger> rIterator = new LookAndSayIterator(new BigInteger("13311"));
    assertFalse(rIterator.hasPrevious());
  }
}
