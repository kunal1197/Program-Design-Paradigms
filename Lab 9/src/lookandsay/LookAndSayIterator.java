package lookandsay;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/**
 * The class implementation for the Reverse Iterator. Which is used to iterate in forward and
 * backward direction until the seed is less than the end value.
 */
public class LookAndSayIterator implements RIterator<BigInteger> {

  private BigInteger seed;
  private final BigInteger endValue;
  private boolean checkFirst;

  /**
   * Constructor with the seed and end value.
   *
   * @param seed     the seed value.
   * @param endValue the end value.
   */
  public LookAndSayIterator(BigInteger seed, BigInteger endValue) {
    seedCheck(seed, endValue);
    this.seed = seed;
    this.endValue = endValue;
    this.checkFirst = true;
  }

  /**
   * Constructor with the seed and default end value.
   *
   * @param seed the seed value.
   */
  public LookAndSayIterator(BigInteger seed) {
    this(seed, new BigInteger("9".repeat(100)));
  }

  /**
   * Constructor with the default seed and default end value.
   */
  public LookAndSayIterator() {
    this(BigInteger.ONE, new BigInteger("9".repeat(100)));
  }

  private void seedCheck(BigInteger seed, BigInteger endValue) {
    if (seed.compareTo(endValue) > 0) {
      throw new IllegalArgumentException("The iterator should not produce a "
              + "number greater than the end value.");
    }
    if (seed.compareTo(BigInteger.ZERO) <= 0) {
      throw new IllegalArgumentException("The iterator should not produce a "
              + "number less than the start value.");
    }
    if (seed.toString().contains("0")) {
      throw new IllegalArgumentException("The iterator should not produce a "
              + "number with a zero in it.");
    }
    if (endValue.compareTo(new BigInteger("9".repeat(100))) > 0) {
      throw new IllegalArgumentException("The iterator should not produce a "
              + "number greater than the end value.");
    }
  }

  /**
   * Returns the previous element in the sequence and moves the cursor position
   * backwards. This method may be called repeatedly to iterate backwards through
   * the sequence.
   *
   * @return the previous element in the sequence.
   * @throws NoSuchElementException if there is no previous element in the sequence.
   */
  @Override
  public BigInteger prev() throws NoSuchElementException {
    if (hasPrevious()) {
      StringBuilder sb = new StringBuilder();
      int t = seed.toString().length();
      String s = seed.toString();
      for (int i = 0; i < (t - 1); i = i + 2) {
        int val = Character.getNumericValue(s.charAt(i));
        String rep = String.valueOf(s.charAt(i + 1)).repeat(val);
        sb.append(rep);
      }
      seed = new BigInteger(sb.toString());
    } else if (seed.toString().length() == 1) {
      return seed;
    } else {
      throw new NoSuchElementException();
    }

    if (checkFirst) {
      checkFirst = false;
      seed = prev();
    }

    return seed;
  }

  /**
   * Returns true if this iterator has more elements when traversing the sequence
   * in the reverse direction.
   *
   * @return true if the sequence has more elements when traversing the sequence
   *          in the reverse direction.
   */
  @Override
  public boolean hasPrevious() {
    if (seed.toString().length() % 2 != 0 && seed.toString().length() > 1) {
      return false;
    }

    return seed.toString().length() != 1 && prevHelper(seed).compareTo(endValue) <= 0;
  }

  private BigInteger prevHelper(BigInteger seed) {
    if (seed.toString().length() == 1) {
      return seed;
    }
    StringBuilder sb = new StringBuilder();
    int t = seed.toString().length();
    String s = seed.toString();
    for (int i = 0; i < (t - 1); i = i + 2) {
      int val = Character.getNumericValue(s.charAt(i));
      String rep = String.valueOf(s.charAt(i + 1)).repeat(val);
      sb.append(rep);
    }
    return new BigInteger(sb.toString());
  }

  /**
   * Returns true if this iterator has more elements when traversing the sequence
   * in the forward direction.
   *
   * @return true if the sequence has more elements when traversing the sequence
   *          in the forward direction.
   */
  @Override
  public boolean hasNext() {
    return seed.compareTo(endValue) < 0;
  }

  /**
   * Returns the next element in the sequence and moves the cursor position
   * forwards. This method may be called repeatedly to iterate forward through
   * the sequence.
   *
   * @return the next element in the sequence.
   * @throws NoSuchElementException if there is no next element in the sequence.
   */
  @Override
  public BigInteger next() {
    BigInteger firstSeed = seed;
    if (hasNext()) {
      StringBuilder sb = new StringBuilder();
      int t = seed.toString().length();
      String s = seed.toString();
      int c = 0;
      for (int i = 0; i < t; i = i + c) {
        c = 0;
        for (int j = i; j < t; j++) {
          if (s.charAt(i) == s.charAt(j)) {
            c++;
          } else {
            break;
          }
        }
        sb.append(c).append(s.charAt(i));
      }
      seed = new BigInteger(sb.toString());
    } else {
      throw new NoSuchElementException();
    }
    return firstSeed;
  }
}