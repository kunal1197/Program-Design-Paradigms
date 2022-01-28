package sanctuary;

import java.util.ArrayList;

/**
 * The Jungle Friends Primate Sanctuary is a place were all the animals which have been cast-off
 * can come, get treated here, and can have a shelter as long as the space permits in the cages.
 */

public interface SanctuaryStart {

  /**
   * Adding new monkeys to the Sanctuary for the first time.
   *
   * @param monkey class object.
   */
  void addMonkeys(Monkey monkey);

  /**
   * Get the list of all the monkeys after their examination.
   *
   * @return Return Monkey Attributes.
   */
  ArrayList<Monkey> getMonkeys();

  /**
   * Get all the Isolation cages list which are constructed in the Sanctuary.
   *
   * @return ArrayList of Isolation Cage Ids.
   */
  ArrayList<String> getIsolations();

  /**
   * Get all the Enclosure cages list which are constructed in the Sanctuary.
   *
   * @return ArrayList of Enclosure Cage Ids.
   */
  ArrayList<String> getEnclosures();

  /**
   * Adding new Isolation Cage if funds are provided.
   *
   * @param housing class object.
   */
  void addIsolation(Housing housing);

  /**
   * Adding new Enclosure Cage if funds are provided.
   *
   * @param housing class object.
   */
  void addEnclosure(Housing housing);

  /**
   * Removing Isolation Cages if funds are taken back.
   *
   * @param housing class object.
   */
  void removeIsolation(Housing housing);

  /**
   * Removing Enclosure Cages if funds are taken back.
   *
   * @param housing class object.
   */
  void removeEnclosure(Housing housing);

  /**
   * After monkeys are added in Isolation, update the Isolation cells with animals present.
   *
   * @param monkey class object.
   */
  void updateIsolationDetails(Monkey monkey);

  /**
   * Here for a given Enclosure Cell, all the species with their name,favourite food and gender
   * will be listed, and report as a fact if not present.
   *
   * @param monkey class object.
   */
  void signGeneration(Monkey monkey);

  /**
   * Here we generate the list of all the food items with their total quantities required for all
   * the animals of the Sanctuary.
   *
   * @param monkey class object.
   */
  void generateShopList(Monkey monkey);

  /**
   * This is used to find all the species where they are located in the sanctuary.
   *
   * @param monkey  class object.
   * @param housing class object.
   */
  void lookUpSpecies(Monkey monkey, Housing housing);

  /**
   * This should generate the list of all the monkeys present in the Sanctuary in alphabetical
   * order with their cage locations.
   *
   * @param monkey  class object.
   * @param housing class object.
   */
  void lookUpName(Monkey monkey, Housing housing);


}
