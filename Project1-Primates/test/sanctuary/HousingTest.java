package sanctuary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class is used for unit testing of the Housing Class.
 */
public class HousingTest {

  private Housing housing;

  /**
   * This is used to set up object.
   */
  @Before
  public void setUp() {
    Housing housing = new Housing("I2", "daisy", 20);
  }

  /**
   * This is used to test the housing ids.
   */
  @Test
  public void testHousingId() {
    assertEquals("I2", this.housing.getHid());
  }

  /**
   * This is used to test the species.
   */
  @Test
  public void testGetSpecies() {
    assertEquals("guerza", this.housing.getSpecies());
  }

  /**
   * This is used to test the total number of Housing cages available.
   */
  @Test
  public void testGetNoOfHouse() {
    assertEquals(20, this.housing.getNoOfHousing());
  }

  /**
   * This is used to test if the houses are being added in a correct proper format.
   */
  @Test
  public void testAddHousing() {
    assertEquals("[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, E11, E12, E13, E14, " +
            "E15, E16, E17, E18, E19, E20]", this.housing.arrHousing.toString());
  }

  /**
   * This is used to test if the housing cages are being allocated to Isolation cages or not.
   */
  @Test
  public void testAddIsolation() {
    assertEquals("[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]",
            this.housing.arrIsolation.toString());
  }

  /**
   * This is used to test if the housing cages are being allocated to enclosure cages or not.
   */
  @Test
  public void testAddEnclosure() {
    assertEquals("[E11, E12, E13, E14, E15, E16, E17, E18, E19, E20]",
            this.housing.arrEnclosure.toString());
  }

  /**
   * This is used to test if the housing cages are being removed from enclosure cages or not.
   */
  @Test
  public void testRemoveIsolation() {
    assertEquals("[I2, I3, I4, I5, I6, I7, I8, I9, I10]",
            this.housing.arrIsolation.toString());
  }

  /**
   * This is used to test if the housing cages are being removed from isolation cages or not.
   */
  @Test
  public void testRemoveEnclosure() {
    assertEquals("[E12, E13, E14, E15, E16, E17, E18, E19, E20]",
            this.housing.arrEnclosure.toString());
  }

}

