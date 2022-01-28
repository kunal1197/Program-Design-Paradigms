package sanctuary;

import java.util.ArrayList;

/**
 * This is the Sanctuary Class of type SanctuaryStart Interface, used to hold
 * all the methods of monkey and housing classes.
 */
public final class Sanctuary implements SanctuaryStart {

  /**
   * This is used to setup object for Sanctuary Class.
   */
  public Sanctuary() {
    ArrayList<Monkey> monkeys = new ArrayList<Monkey>();
    ArrayList<String> isolations = new ArrayList<String>();
    ArrayList<String> enclosures = new ArrayList<String>();
  }

  Monkey monkey = new Monkey();
  Housing housing = new Housing();

  /**
   * Adding new monkeys to the Sanctuary for the first time.
   *
   * @param monkey class object.
   */
  @Override
  public void addMonkeys(Monkey monkey) {
    monkey.addMonkey();
  }

  /**
   * Get the list of all the monkeys after their examination.
   *
   * @return Return Monkey Attributes.
   */
  @Override
  public ArrayList<Monkey> getMonkeys() {
    return Monkey.monkeys;
  }

  /**
   * Get all the Isolation cages list which are constructed in the Sanctuary.
   *
   * @return ArrayList of Isolation Cage Ids.
   */
  @Override
  public ArrayList<String> getIsolations() {
    return housing.arrIsolation;
  }

  /**
   * Get all the Enclosure cages list which are constructed in the Sanctuary.
   *
   * @return ArrayList of Enclosure Cage Ids.
   */
  @Override
  public ArrayList<String> getEnclosures() {
    return housing.arrEnclosure;
  }

  /**
   * Adding new Isolation Cage if funds are provided.
   *
   * @param housing class object.
   */
  @Override
  public void addIsolation(Housing housing) {
    housing.addIsolation();
  }

  /**
   * Adding new Enclosure Cage if funds are provided.
   *
   * @param housing class object.
   */
  @Override
  public void addEnclosure(Housing housing) {
    housing.addEnclosure();
  }

  /**
   * Removing Isolation Cages if funds are taken back.
   *
   * @param housing class object.
   */
  @Override
  public void removeIsolation(Housing housing) {
    housing.removeIsolation();
  }

  /**
   * Removing Enclosure Cages if funds are taken back.
   *
   * @param housing class object.
   */
  @Override
  public void removeEnclosure(Housing housing) {
    housing.removeEnclosure();
  }

  /**
   * After monkeys are added in Isolation, update the Isolation cells with animals present.
   *
   * @param monkey class object.
   */
  @Override
  public void updateIsolationDetails(Monkey monkey) {
    monkey.updateIsolationDetails();
  }

  /**
   * Here for a given Enclosure Cell, all the species with their name,favourite food and gender
   * will be listed, and report as a fact if not present.
   *
   * @param monkey class object.
   */
  @Override
  public void signGeneration(Monkey monkey) {
    monkey.signGeneration();
  }

  /**
   * Here we generate the list of all the food items with their total quantities required for all
   * the animals of the Sanctuary.
   *
   * @param monkey class object.
   */
  @Override
  public void generateShopList(Monkey monkey) {
    monkey.generateShopList();
  }

  /**
   * This is used to find all the species where they are located in the sanctuary.
   *
   * @param monkey  class object.
   * @param housing class object.
   */
  @Override
  public void lookUpSpecies(Monkey monkey, Housing housing) {
    monkey.lookUpSpecies();
  }

  /**
   * This should generate the list of all the monkeys present in the Sanctuary in alphabetical
   * order with their cage locations.
   *
   * @param monkey  class object.
   * @param housing class object.
   */
  @Override
  public void lookUpName(Monkey monkey, Housing housing) {
    monkey.lookUpName();
  }
}
