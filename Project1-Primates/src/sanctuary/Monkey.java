package sanctuary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * This is the Monkey Class used to store all the attributes and perform functions related to
 * monkeys.
 */

public class Monkey {

  static String monkeyName;
  private static String species;
  private static String gender;
  private static String size;
  private static String weight;
  private static String age;
  private static String food;

  static ArrayList<Monkey> monkeys = new ArrayList<Monkey>();
  static HashMap<String, String> enclosureMonkey = new HashMap<String, String>();
  static HashMap<String, String> isolationMonkey = new HashMap<String, String>();
  static TreeMap<String, String> sorted = new TreeMap<>();

  static String[] monkeyIdArr = new String[5];
  static String[] monkeyNameArr = {"Mike", "daisy", "hero", "messi", "ronaldo"};
  static String[] monkeySpeciesArr = {"drill", "guerza", "howler", "saki", "drill"};
  static String[] monkeyGenderArr = {"male", "male", "female", "female", "female"};
  static String[] monkeySizeArr = {"LARGE", "MEDIUM", "MEDIUM", "SMALL", "LARGE"};
  static String[] monkeyWeightArr = {"30", "25", "15", "50", "40"};
  static String[] monkeyAgeArr = {"5", "4", "10", "12", "3"};
  static String[] monkeyFoodArr = {"insects", "leaves", "seeds", "seeds", "nuts"};

  /**
   * This constructor is used to initials all the monkeys fields.
   *
   * @param monkeyName Name of the monkey.
   * @param species    The species of the monkey.
   * @param gender     The gender of the monkey.
   * @param size       The size of the monlkey.
   * @param weight     The weight in kgs.
   * @param age        The age of the monkey.
   * @param food       The favourite Food of the monkey.
   */
  public Monkey(String monkeyName, String species, String gender, String size, String weight,
                String age, String food) {
    Monkey.monkeyName = monkeyName;
    Monkey.species = species;
    Monkey.gender = gender;
    Monkey.size = size;
    Monkey.weight = weight;
    Monkey.age = age;
    Monkey.food = food;
  }

  /**
   * This is used for constructor overloading.
   */
  public Monkey() {
    // Used in creating objects in Housing class.
  }

  /**
   * This function is used to all add all the attributes of the monkey and display them.
   */
  void addMonkey() {
    for (int i = 0; i < 5; i++) {

      monkeyName = monkeyNameArr[i];
      System.out.println("The Name of the Animal: " + monkeyName);

      species = monkeySpeciesArr[i];
      System.out.println("The species of the Animal: " + species);

      monkeyIdArr[i] = species + String.valueOf(i + 1);

      gender = monkeyGenderArr[i];
      Sex sex = Sex.valueOf(gender.toUpperCase());
      System.out.println("The gender of the Animal: " + gender);

      size = monkeySizeArr[i];
      AnimalSize animalSize = AnimalSize.valueOf(size.toUpperCase());
      System.out.println("The size of the Animal: " + size);

      weight = monkeyWeightArr[i];
      System.out.println("The weight of the Animal in kgs: " + weight);

      age = monkeyAgeArr[i];
      System.out.println("The age of the Animal: " + age);

      food = monkeyFoodArr[i];
      FavouriteFood favouriteFood = FavouriteFood.valueOf(food.toUpperCase());
      System.out.println("It's Favourite Food: " + food);

      Monkey details = new Monkey(monkeyName, species, gender, size, weight, age, food);
      System.out.println(details + "\n");
      monkeys.add(details);
    }
  }

  /**
   * This is used to get the Name of the monkey.
   *
   * @return Monkey Name.
   */
  public String getName() {
    return monkeyName;
  }

  /**
   * This is used to get the Species of the monkey.
   *
   * @return Species Name.
   */
  public String getSpecies() {
    return species;
  }

  /**
   * This is used to get the gender of the monkey.
   *
   * @return Gender.
   */
  public String getSex() {
    return gender;
  }

  /**
   * This is used to get the size of the monkey.
   *
   * @return Size.
   */
  public String getSize() {
    return size;
  }

  /**
   * This is used to get the weight of the monkey in kgs.
   *
   * @return weight.
   */
  public String getWeight() {
    return weight;
  }

  /**
   * This is used to get the age of the monkey.
   *
   * @return age.
   */
  public String getApproxAge() {
    return age;
  }

  /**
   * This is used to get the Favourite food of the monkey.
   *
   * @return food.
   */
  public String getFavouriteFood() {
    return food;
  }

  /**
   * Monkey Details are displayed in the given format.
   *
   * @return Used to return the details of the string format.
   */
  @Override
  public String toString() {
    return "Monkey Details{"
            + "name='" + monkeyName + '\'' + ", species=" + species + ", sex='" + gender + '\''
            + ", size='" + size + '\'' + ", weight=" + weight + ", approxAge=" + age
            + ", favouriteFood=" + food + '}';
  }


  static boolean checkHealth(String name) {
    return true;
  }

  boolean checkSpace(int area) {
    return area > 0;
  }

  void cageEntry() {
    Housing housing = new Housing();
    System.out.println("Adding new Monkeys to the Sanctuary Isolation cage");
    housing.arrIsolation.add("I" + String.valueOf(11));
    housing.arrHousing.add("I" + String.valueOf(11));
  }

  void updateIsolationDetails() {
    System.out.println("The current state of Isolation Housings:");
    Housing housing = new Housing();
    housing.addIsolation();
    housing.addEnclosure();
    for (int i = 0; i < 5; i++) {
      isolationMonkey.put(housing.arrIsolation.get(i), monkeyIdArr[i]);
    }
    System.out.println(isolationMonkey + "\n");
  }

  HashMap<String, String> getUpdateIsolationDetails() {
    return isolationMonkey;
  }

  void cageTransfer() {
    Housing housing = new Housing();
    housing.addIsolation();
    housing.addEnclosure();
    for (int i = 0; i < 2; i++) {
      if (checkHealth(monkeyNameArr[i]) && checkSpace(housing.arrEnclosureArea.get(i))) {
        enclosureMonkey.put(housing.arrEnclosure.get(0), monkeyIdArr[0] + "," + monkeyIdArr[4]);
        enclosureMonkey.put(housing.arrEnclosure.get(1), monkeyIdArr[2]);
        enclosureMonkey.put(housing.arrEnclosure.get(2), monkeyIdArr[3]);
        isolationMonkey.remove(housing.arrEnclosure.get(i));
      }
    }
    System.out.println(enclosureMonkey);
  }

  HashMap<String, String> getCageTransfer() {
    return enclosureMonkey;
  }

  void updateEnclosureDetails() {
    Housing housing = new Housing();
    housing.addIsolation();
    housing.addEnclosure();
    System.out.println(enclosureMonkey);
  }

  void signGeneration() {
    cageTransfer();
    String a = Monkey.enclosureMonkey.get("E11");
    System.out.println("Sign Generation for the Enclosure E11");
    String[] values = a.split(",");
    for (int i = 0; i < 5; i++) {
      for (String value : values) {
        if (Objects.equals(monkeyIdArr[i], value)) {
          System.out.println("Sign Generation: " + monkeyNameArr[i] + ", " + monkeyGenderArr[i]
                  + ", " + monkeyFoodArr[i]);
        }
      }
    }
    System.out.println("\n");
  }


  void getSpeciesList() {
    System.out.println("The total List of Species present in the Sanctuary");
    HashSet<String> monkeyFoodSet = new HashSet<String>(List.of(monkeySpeciesArr));
    System.out.println(monkeyFoodSet + "\n");
  }

  void lookUpSpecies() {
    cageTransfer();
    System.out.println("All the available species in the Sanctuary");
    HashSet<String> monkeySpeciesSet = new HashSet<String>(List.of(monkeySpeciesArr));
    System.out.println(monkeySpeciesSet);
    System.out.println("Their locations in Sanctuary");
    String[] values = Monkey.enclosureMonkey.get("E11").split(",");
    String[] values1 = Monkey.enclosureMonkey.get("E12").split(",");
    String[] values2 = Monkey.enclosureMonkey.get("E13").split(",");
    String[] values3 = Monkey.isolationMonkey.get("I2").split(",");
    for (String s : monkeySpeciesSet) {
      if (values[0].contains(s)) {
        System.out.println("The Species " + s + " is in Enclosure Cage: E11");
      } else if (values1[0].contains(s)) {
        System.out.println("The Species " + s + " is in Enclosure Cage: E12");
      } else if (values2[0].contains(s)) {
        System.out.println("The Species " + s + " is in Enclosure Cage: E13");
      } else if (values3[0].contains(s)) {
        System.out.println("The Species " + s + " is in Inclosure: I2");
      }
      else {
        System.out.println("The Requested Species Tamarin is not in the Sanctuary.");
      }
    }
    System.out.println("\n");
  }

  void lookUpName() {
    cageTransfer();
    System.out.println("All the Animals present in the Sanctuary");
    HashMap<String, String> monkeyNameMap = new HashMap<String, String>();
    for (String s : enclosureMonkey.keySet()) {
      for (int i = 0; i < 5; i++) {
        String[] values = enclosureMonkey.get(s).split(",");
        for (int j = 0; j < values.length; j++) {
          if (Objects.equals(monkeyIdArr[i], values[j])) {
            monkeyNameMap.put(monkeyNameArr[i], s);
            break;
          }
        }
      }
    }
    monkeyNameMap.put("daisy", "I2");
    sorted.putAll(monkeyNameMap);
    for (Map.Entry<String, String> entry : sorted.entrySet()) {
      System.out.println("Monkey Name = " + entry.getKey() + ", Cage = " + entry.getValue());
    }
    System.out.println("\n");
  }

  TreeMap<String, String> getLookUpName() {
    return sorted;
  }

  void generateShopList() {
    int grams = 0;
    int j = 0;
    System.out.println("The Shopping List for all the monkeys int the Sanctuary");
    HashSet<String> monkeyFoodSet = new HashSet<String>(List.of(monkeyFoodArr));
    for (String s : monkeyFoodSet) {
      grams = 0;
      for (int i = 0; i < 5; i++) {
        if (Objects.equals(s, monkeyFoodArr[i])) {
          if (Objects.equals(monkeySizeArr[i], "LARGE")) {
            grams = grams + 500;
          } else if (Objects.equals(monkeySizeArr[i], "MEDIUM")) {
            grams = grams + 250;
          } else if (Objects.equals(monkeySizeArr[i], "SMALL")) {
            grams = grams + 100;
          }
        }
      }
      System.out.println(s + " - " + grams + "gms");
    }
    System.out.println("\n");
  }
}
