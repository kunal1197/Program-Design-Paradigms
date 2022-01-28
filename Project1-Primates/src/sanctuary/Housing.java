package sanctuary;

import java.util.ArrayList;

/**
 * This is the base class, it is used to store the Housing details of Enclosure Cages and Isolation
 * Cages and perform functions on them.
 */
public class Housing {

  protected String hid;
  protected String species;
  protected int noOfHousing = 20;
  ArrayList<String> arrHousing = new ArrayList<String>();
  ArrayList<String> arrIsolation = new ArrayList<String>();
  ArrayList<String> arrEnclosure = new ArrayList<String>();
  ArrayList<Integer> arrEnclosureArea = new ArrayList<Integer>();

  /**
   * This is used for constructor overloading.
   */
  public Housing() {
    // Used in creating objects in Monkey class.
  }

  /**
   * This constructor is used to initialize all the class members.
   *
   * @param species     used to store the species values.
   * @param hid         used to store the housing ids.
   * @param noOfHousing used to store the number of housings.
   */
  public Housing(String species, String hid, int noOfHousing) {
    this.species = species;
    this.hid = hid;
    this.noOfHousing = noOfHousing;
  }

  /**
   * This is used to get the Housing Id.
   *
   * @return Housing id.
   */
  public String getHid() {
    return hid;
  }

  /**
   * This is used to get the species of the animal.
   *
   * @return species.
   */
  public String getSpecies() {
    return species;
  }

  /**
   * This is used to get the Number of housing cages in total.
   *
   * @return number of housing.
   */
  public int getNoOfHousing() {
    return noOfHousing;
  }

  /**
   * This is used to get the list of Isolation cages.
   *
   * @return Isolation Ids.
   */
  public ArrayList<String> getArrIsolation() {
    return arrIsolation;
  }


  void addHousing() {
    System.out.println("The total number of Cages that can be accommodated in 1000 metre square: "
            + noOfHousing);
    for (int i = 0; i < (noOfHousing / 2); i++) {
      arrHousing.add("I" + String.valueOf(i + 1));
    }
    for (int i = (noOfHousing / 2); i < noOfHousing; i++) {
      arrHousing.add("E" + String.valueOf(i + 1));
    }
  }

  ArrayList<String> getAddHousing() {
    return this.arrHousing;
  }


  void addIsolation() {
    for (int i = 0; i < (noOfHousing / 2); i++) {
      arrIsolation.add("I" + String.valueOf(i + 1));
    }
  }

  ArrayList<String> getAddIsolation() {
    return this.arrIsolation;
  }


  void removeIsolation() {
    System.out.println("Removing one Isolation Housing Cage No. - I1\n");
    arrIsolation.remove(0);
    arrHousing.remove(0);
    System.out.println("The state of the Isolation Housing after Removal");
    System.out.println(arrIsolation + "\n");
  }

  ArrayList<String> getRemoveIsolation() {
    return this.arrIsolation;
  }

  void addEnclosure() {
    for (int i = (noOfHousing / 2); i < noOfHousing; i++) {
      arrEnclosure.add("E" + String.valueOf(i + 1));
    }
    for (int i = (noOfHousing / 2); i < noOfHousing; i = i + 3) {
      arrEnclosureArea.add(50);
      arrEnclosureArea.add(100);
      arrEnclosureArea.add(150);
    }
  }

  ArrayList<String> getAddEnclosure() {
    return this.arrEnclosure;
  }

  void removeEnclosure() {
    System.out.println("Removing one Enclosure Housing Cage No. - E11\n");
    arrEnclosure.remove(0);
    arrHousing.remove(11);
    arrEnclosureArea.remove(0);
    System.out.println("The state of the Enclosure Housing after Removal");
    System.out.println(arrEnclosure + "\n");
  }

  ArrayList<String> getRemoveEnclosure() {
    return this.arrEnclosure;
  }

}
