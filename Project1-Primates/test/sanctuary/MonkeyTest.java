package sanctuary;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * This class is used for unit testing of the Monkey Class.
 */
public class MonkeyTest {
  private Monkey monkey;

  /**
   * This is used to set up object.
   */
  @Before
  public void setUp() {
    Monkey monkey = new Monkey("Mike", "drill", "male",
            "LARGE", "30", "5", "insects");
  }

  /**
   * This is used to test the monkey name.
   */
  @Test
  public void testMonkeyName() {
    assertEquals("Mike", this.monkey.getName());
  }

  /**
   * This is used to test the monkey species.
   */
  @Test
  public void testMonkeySpecies() {
    assertEquals("drill", this.monkey.getSpecies());
  }

  /**
   * This is used to test the monkey Gender.
   */
  @Test
  public void testMonkeySex() {
    assertEquals("male", this.monkey.getSex());
  }

  /**
   * This is used to test the monkey Sizes.
   */
  @Test
  public void testMonkeySize() {
    assertEquals("LARGE", this.monkey.getSize());
  }

  /**
   * This is used to test the monkey weight.
   */
  @Test
  public void testMonkeyWeight() {
    assertEquals("30", this.monkey.getWeight());
  }

  /**
   * This is used to test the monkey age.
   */
  @Test
  public void testMonkeyAge() {
    assertEquals("5", this.monkey.getApproxAge());
  }

  /**
   * This is used to test the monkeys favourite food.
   */
  @Test
  public void testMonkeyFood() {
    assertEquals("insects", this.monkey.getFavouriteFood());
  }

  /**
   * This is used to test if the Isolation Details are being updated or not.
   */
  @Test
  public void testUpdateIsolationDetails() {
    HashMap<String, String> test = new HashMap<String, String>();
    test.put("I1", "drill1");
    test.put("I2", "guerza2");
    test.put("I3", "howler3");
    test.put("I4", "saki4");
    test.put("I5", "drill5");
    assertEquals(test, this.monkey.getUpdateIsolationDetails());
  }

  /**
   * This is used to test the successful cage transfer of monkeys from isolation to enclosure.
   */
  @Test
  public void testCageTransfer() {
    HashMap<String, String> test = new HashMap<String, String>();
    test.put("E11", "drill1,drill5,");
    test.put("E13", "saki4");
    test.put("E12", "howler3");
    assertEquals(test, this.monkey.getCageTransfer());
  }

  /**
   * This is used to test the Name of the Monkeys in alphabetical order with their locations.
   */
  @Test
  public void testLookUpName() {
    TreeMap<String, String> test = new TreeMap<>();
    test.put("Mike", "E11");
    test.put("daisy", "I2");
    test.put("hero", "E12");
    test.put("messi", "E13");
    test.put("ronaldo", "E11");
    assertEquals(test, this.monkey.getLookUpName());
  }
}
