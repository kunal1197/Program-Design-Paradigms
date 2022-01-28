package sanctuary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class is used for unit testing of the Enclosure Class.
 */
public class EnclosureTest {

  private Housing housing;
  private Enclosure enclosure;

  /**
   * This is used to set up object.
   */
  @Before
  public void setUp() {
    Housing housing = new Housing("I1", "guerza", 20);
    Enclosure enclosure = new Enclosure(housing, this.enclosure.area);
  }

  /**
   * This is used to test if the Housing Ids are equal or not.
   */
  @Test
  public void testHousingId() {
    assertEquals("E11", this.enclosure.getHid());
  }

  /**
   * This is used to test the if the animal species are equal or not.
   */
  @Test
  public void testGetSpecies() {
    assertEquals("drill", this.enclosure.getSpecies());
  }

  /**
   * This is used to test the total number of enclosure housings present.
   */
  @Test
  public void testGetNoOfHousing() {
    assertEquals(20, this.enclosure.getNoOfHousing());
  }

  /**
   * This is used to test the area of each enclosure housings.
   */
  @Test
  public void testGetArea() {
    assertEquals("50", this.enclosure.getSpecies());
  }

}
