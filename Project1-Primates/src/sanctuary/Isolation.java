package sanctuary;

/**
 * This is used to extend the functionalities of the Housing super class, and store the Inclosure
 * housing details.
 */
public class Isolation extends Housing {

  private Housing housing;

  /**
   * This constructor is used to initialize all the class members.
   *
   * @param housing the housing class object.
   */
  Isolation(Housing housing) {
    this.housing = housing;
    this.hid = hid;
    this.species = species;
    this.noOfHousing = noOfHousing;
  }

  /**
   * This is used to get the housing class object.
   *
   * @return class object.
   */
  public Housing getIsolation() {
    return housing;
  }

  /**
   * This is used to return the Housing Insoaltion cage ids.
   *
   * @return Housing Ids.
   */
  public String getHid() {
    return hid;
  }

  /**
   * This is used to get the type of species currently in the Isolaiton cages.
   *
   * @return species.
   */
  public String getSpecies() {
    return species;
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
