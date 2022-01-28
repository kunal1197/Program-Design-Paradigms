package sanctuary;

/**
 * This is used to extend the functionalities of the Housing super class, and store the Enclosure
 * housing details.
 */
public class Enclosure extends Housing {

  protected int area;
  protected Housing housing;

  /**
   * This constructor is used to initialize all the class members.
   *
   * @param housing the housing class object.
   * @param area    the area of each enclosure cage.
   */
  Enclosure(Housing housing, int area) {
    this.housing = housing;
    this.hid = hid;
    this.species = species;
    this.noOfHousing = noOfHousing;
    this.area = area;
  }

  /**
   * This is used to return the Housing class object.
   *
   * @return class object.
   */
  public Housing getEnclosure() {
    return housing;
  }

  /**
   * This is used to get the Housing Enclosure Ids.
   *
   * @return housing id.
   */
  public String getHid() {
    return hid;
  }

  /**
   * This is used to get the species in the enclosure cages.
   *
   * @return species.
   */
  public String getSpecies() {
    return species;
  }

  /**
   * This is used to get the area of the enclosure cages.
   *
   * @return area.
   */
  public int getArea() {
    return area;
  }

  /**
   * This is used to get the number of housing cages.
   *
   * @return number of housing cages.
   */
  public int getNoOfHousing() {
    return noOfHousing;
  }


}
