package sanctuary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class is used for unit testing of the Isolation Class.
 */
public class IsolationTest {

  private Housing housing;
  private Isolation isolation;

  /**
   * This is used to set up object.
   */
  @Before
  public void setUp() {
    Housing housing = new Housing("I2", "daisy", 20);
    Isolation isolation = new Isolation(housing);
  }

  /**
   * This is used to test if the Housing Ids are equal or not.
   */
  @Test
  public void testHousingId() {
    assertEquals("I2", this.isolation.getHid());
  }

  /**
   * This is used to test the if the animal species are equal or not.
   */
  @Test
  public void testGetSpecies() {
    assertEquals("guerza", this.isolation.getSpecies());
  }

  /**
   * This is used to test the total number of inclosure housings present.
   */
  @Test
  public void testGetNoOfHousing() {
    assertEquals(20, this.isolation.noOfHousing);
  }


}
