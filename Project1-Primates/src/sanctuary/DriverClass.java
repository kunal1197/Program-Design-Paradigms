package sanctuary;

/**
 * This is the Driver class where we have the initial details which are required to start the
 * Sanctuary Up and Running.
 */
public class DriverClass {
  private static void initialDetails() {

    System.out.println("*******************************************");
    System.out.println("Welcome to Jungle Friends Primate Sanctuary");
    System.out.println("*******************************************\n");
    int funds = 100500;
    System.out.println("The available funds to construct Sanctuary: " + funds);

    int totalArea = 600;
    System.out.println("Total Area(in metre square) of Sanctuary: " + totalArea);

    int isolationArea = 300;
    System.out.println("The area to be allocated for Isolation Area from: " + isolationArea);

    int enclosureArea = 300;
    System.out.println("The area to be allocated for Enclosure Area from: " + enclosureArea);

    int noOfAnimals = 5;
    System.out.println("The number of Animals to be transferred initially: " + noOfAnimals);

    System.out.println("We are ready to transfer the first Batch of "
            + "Animals to Isolation Chambers\n");

  }

  /**
   * This is the Main method which is the entry point and is used to run the Program.
   */
  public static void main(String[] args) {

    initialDetails();
    System.out.println("The following functions will be performed in order");
    final Monkey monkey = new Monkey();
    Housing housing = new Housing();
    housing.addHousing();

    System.out.println("1) Add an isolation");
    System.out.println("Adding Isolation Housing");
    housing.addIsolation();
    System.out.println("Format - Prefix I with counter, eg-I1\n");

    System.out.println("2) Add an enclosure");
    System.out.println("Adding Enclosure Housing");
    housing.addEnclosure();
    System.out.println("Format - Prefix E with counter, eg-E11\n");

    System.out.println("3) Add a monkey");
    monkey.addMonkey();

    System.out.println("4) The current list of Monkeys after adding in Isolation");
    monkey.updateIsolationDetails();

    System.out.println("5) Transfer a monkey");
    System.out.println("Checking if monkey the monkeys are Healthy or not.");
    System.out.println("Monkeys Tested: Mike, hero, messi, ronaldo");
    monkey.cageTransfer();
    System.out.println("After Transferring the monkey from Isolation to Enclosure cage\n");

    System.out.println("6) Get list of species");
    monkey.getSpeciesList();

    System.out.println("7) Find a particular species");
    monkey.lookUpSpecies();

    System.out.println("8) Produce sign for each enclosure/isolation");
    monkey.signGeneration();

    System.out.println("9) List all monkeys name and their location");
    monkey.lookUpName();

    System.out.println("10) Get Shopping list of all monkeys");
    monkey.generateShopList();

    System.out.println("11) Remove an isolation");
    housing.removeIsolation();

    System.out.println("12) Remove an enclosure");
    housing.removeEnclosure();

  }
}

