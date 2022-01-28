package battle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the Mock class used for unit testing as it generates a fixed sequence of values, as I
 * have used seed = 42 to get the random function to produce same testable values.
 */

public class MockClass {

  static Random random = new Random(42);
  static int gearStrengthSum1 = 0;
  static int gearConstitutionSum1 = 0;
  static int gearDexteritySum1 = 0;
  static int gearCharismaSum1 = 0;

  static int gearStrengthSum2 = 0;
  static int gearConstitutionSum2 = 0;
  static int gearDexteritySum2 = 0;
  static int gearCharismaSum2 = 0;

  static Players player1 = new Players(getDiceSum(), getDiceSum(), getDiceSum(), getDiceSum());
  static Players player2 = new Players(getDiceSum(), getDiceSum(), getDiceSum(), getDiceSum());

  /**
   * This is used to find the random dice sum to determine player abilities.
   *
   * @return dice sum.
   */
  public static int getDiceSum() {
    int[] dice = new int[4];
    int sum = 0;
    int temp = 0;
    for (int i = 0; i < 4; i++) {
      temp = random.nextInt(7);
      if (temp > 1) {
        dice[i] = temp;
      } else {
        i--;
      }
    }
    Arrays.sort(dice);
    for (int i = 1; i < 4; i++) {
      sum = sum + dice[i];
    }
    return sum;
  }

  /**
   * This is used find the HeadGear Strength.
   *
   * @return Gear Strength.
   */
  public static int getHeadGearStrength() {
    int strength = 0;
    strength = random.nextInt(10 - 5) + 5;
    return strength;
  }

  /**
   * This is used find the Potions Strength.
   *
   * @return Potions Strength.
   */
  public static int getPotionStrength() {
    int strength = 0;
    strength = random.nextInt(5 - 2) + 2;
    return strength;
  }

  /**
   * This is used find the Belts Strength.
   *
   * @return Gear Strength.
   */
  public static int getBeltsStrength() {
    int strength = 0;
    strength = random.nextInt(5 - 2) + 2;
    return strength;
  }

  /**
   * This is used find the Belt Size.
   *
   * @return Belt Size.
   */
  public static String getBeltSize() {
    int randomSize = random.nextInt(4 - 1) + 1;
    String size = "";
    if (randomSize == 1) {
      size = "S";
    } else if (randomSize == 2) {
      size = "M";
    } else if (randomSize == 3) {
      size = "L";
    }
    return size;
  }

  /**
   * This is used find the Footwear Strength.
   *
   * @return Gear Strength.
   */
  public static int getFootwearStrength() {
    int strength = 0;
    strength = random.nextInt(10 - 5) + 5;
    return strength;
  }

  /**
   * This is used to find the Katana type.
   *
   * @return Katana type.
   */
  public static String getKatanaType() {
    int rand = random.nextInt(2) + 1;
    String type = "";
    if (rand == 1) {
      type = "Single";
    } else {
      type = "Double";
    }
    return type;
  }

  /**
   * This is used to find the Katana Damage.
   *
   * @return Damage given.
   */
  public static int getKatanaDamage() {
    int damage = 0;
    int upperBound = 0;
    int lowerBound = 0;
    if (getKatanaType().equalsIgnoreCase("Double")) {
      upperBound = 6;
      lowerBound = 4;
    } else {
      upperBound = 4;
      lowerBound = 2;
    }
    damage = random.nextInt(upperBound - lowerBound) + lowerBound;
    return damage;
  }

  /**
   * This is used to find the Broad Sword Damage.
   *
   * @return Damage given.
   */
  public static int getBroadSwordDamage() {
    int damage = 0;
    int upperBound = 10;
    int lowerBound = 6;
    damage = random.nextInt(upperBound - lowerBound) + lowerBound;
    return damage;
  }

  /**
   * This is used to find the 2 Handed Sword Damage.
   *
   * @return Damage given.
   */
  public static int getTwoHandedSwordDamage() {
    int damage = 0;
    int upperBound = 0;
    int lowerBound = 0;
    int strength = getDiceSum();
    if (strength > 14) {
      upperBound = 12;
      lowerBound = 8;
    } else {
      upperBound = 6;
      lowerBound = 4;
    }
    damage = random.nextInt(upperBound - lowerBound) + lowerBound;
    return damage;
  }

  /**
   * This is used to find the Axes Damage.
   *
   * @return Damage given.
   */
  public static int getAxesDamage() {
    int damage = 0;
    int upperBound = 10;
    int lowerBound = 6;
    damage = random.nextInt(upperBound - lowerBound) + lowerBound;
    return damage;
  }

  /**
   * This is used to find the Flails Damage.
   *
   * @return Damage given.
   */
  public static int getFlailsDamage() {
    int damage = 0;
    int upperBound = 0;
    int lowerBound = 0;
    int strength = getDiceSum();
    if (strength > 14) {
      upperBound = 12;
      lowerBound = 8;
    } else {
      upperBound = 6;
      lowerBound = 4;
    }
    damage = random.nextInt(upperBound - lowerBound) + lowerBound;
    return damage;
  }

  /**
   * This is used to find the Bare Hands Damage.
   *
   * @return Damage given.
   */
  public static int getBareHandsDamage() {
    int damage = 0;
    int upperBound = 5;
    int lowerBound = 2;
    damage = random.nextInt(upperBound - lowerBound) + lowerBound;
    return damage;
  }

  /**
   * This is used to find the randomly generated Equipment bag.
   *
   * @return Equipment Bag.
   */
  public static int[] getEquipmentBag() {

    int size = random.nextInt(60 - 40) + 40;
    int[] equipmentBagArray = new int[size];

    for (int i = 0; i < size; i++) {
      int arrayVal = random.nextInt(4) + 1;
      equipmentBagArray[i] = arrayVal;
    }
    for (int i = 0; i < size / 4; i++) {
      int index = random.nextInt(size - 1);
      equipmentBagArray[index] = equipmentBagArray[index] * -1;
    }
    return equipmentBagArray;
  }

  /**
   * Display the Equipment Bag.
   */
  static void displayEquipmentBag() {
    int[] getArr = getEquipmentBag();
    String[] equipmentBagArray = new String[getArr.length];
    for (int i = 0; i < getArr.length; i++) {
      if (getArr[i] == 1) {
        equipmentBagArray[i] = "Headgear," + getHeadGearStrength();
      } else if (getArr[i] == -1) {
        equipmentBagArray[i] = "Headgear,-" + getHeadGearStrength();
      } else if (getArr[i] == 2) {
        equipmentBagArray[i] = "Potions," + getPotionStrength();
      } else if (getArr[i] == -2) {
        equipmentBagArray[i] = "Potions,-" + getPotionStrength();
      } else if (getArr[i] == 3) {
        equipmentBagArray[i] = "Belt," + getBeltsStrength();
      } else if (getArr[i] == -3) {
        equipmentBagArray[i] = "Belt,-" + getBeltsStrength();
      } else if (getArr[i] == 4) {
        equipmentBagArray[i] = "Footwear," + getFootwearStrength();
      } else if (getArr[i] == -4) {
        equipmentBagArray[i] = "Footwear,-" + getFootwearStrength();
      }
    }
    for (int i = 0; i < getArr.length; i++) {
      System.out.print("[ " + equipmentBagArray[i] + "] ");
    }
  }


  /**
   * This is used to find the player One Bag after random allocation of items in bag.
   *
   * @return equipment bag.
   */
  public static int[] getPlayerOneBag() {
    int[] equipmentBagArray = getEquipmentBag();
    int[] playerOneBagArr = new int[20];
    for (int i = 0; i < 20; i++) {
      int index1 = random.nextInt(equipmentBagArray.length);
      playerOneBagArr[i] = equipmentBagArray[index1];
    }
    return playerOneBagArr;
  }

  /**
   * This is used to find the player Two Bag after random allocation of items in bag.
   *
   * @return equipment bag.
   */
  public static int[] getPlayerTwoBag() {
    int[] equipmentBagArray = getEquipmentBag();
    int[] playerTwoBagArr = new int[20];
    for (int i = 0; i < 20; i++) {
      int index1 = random.nextInt(equipmentBagArray.length);
      playerTwoBagArr[i] = equipmentBagArray[index1];
    }
    return playerTwoBagArr;
  }

  /**
   * This is used to display the Player Bags.
   *
   * @param getArr Bag array.
   */
  static void displayPlayerBag(int[] getArr) {

    String[] playerBag = new String[getArr.length];
    int headGearCount = 0;
    int potionCount = 0;
    int beltCount = 0;
    int footwearCount = 0;
    List<String> headGearArr = new ArrayList<>();
    List<String> potionArr = new ArrayList<>();
    List<String> beltArr = new ArrayList<>();
    List<String> footwearArr = new ArrayList<>();
    for (int i = 0; i < getArr.length; i++) {
      if (getArr[i] == 1) {
        headGearCount++;
        headGearArr.add("Headgear" + String.valueOf(headGearCount) + " = " + getHeadGearStrength());
      } else if (getArr[i] == -1) {
        headGearCount++;
        headGearArr.add("Headgear" + String.valueOf(headGearCount) + " = -"
                + getHeadGearStrength());
      } else if (getArr[i] == 2) {
        potionCount++;
        potionArr.add("Potions" + String.valueOf(potionCount) + " = " + getPotionStrength());
      } else if (getArr[i] == -2) {
        potionCount++;
        potionArr.add("Potions" + String.valueOf(potionCount) + " = -" + getPotionStrength());
      } else if (getArr[i] == 3) {
        beltCount++;
        beltArr.add("Belt" + String.valueOf(beltCount) + " = " + getBeltsStrength());
      } else if (getArr[i] == -3) {
        beltCount++;
        beltArr.add("Belt" + String.valueOf(beltCount) + " = -" + getBeltsStrength());
      } else if (getArr[i] == 4) {
        footwearCount++;
        footwearArr.add("Footwear" + String.valueOf(footwearCount) + " = " + getFootwearStrength());
      } else if (getArr[i] == -4) {
        footwearCount++;
        footwearArr.add("Footwear" + String.valueOf(footwearCount) + " = -"
                + getFootwearStrength());
      }
    }
    Collections.sort(headGearArr);
    Collections.sort(potionArr);
    Collections.sort(beltArr);
    Collections.sort(footwearArr);

    for (int i = 0; i < getArr.length; i++) {
      if (i < headGearCount) {
        playerBag[i] = headGearArr.get(i);
      } else if (i < (headGearCount + potionCount)) {
        playerBag[i] = potionArr.get(i - headGearCount);
      } else if (i < (headGearCount + potionCount + beltCount)) {
        playerBag[i] = beltArr.get(i - headGearCount - potionCount);
      } else {
        playerBag[i] = footwearArr.get(i - headGearCount - potionCount - beltCount);
      }
    }
    for (int i = 0; i < getArr.length; i++) {
      System.out.print("[ " + playerBag[i] + "] ");
    }
  }


  /**
   * This is used to find the Requested Weapon of the player.
   *
   * @return Weapon Interface Object.
   */
  public static Weapons getRequestedWeapon() {
    int weaponIndex = random.nextInt(6) + 1;
    Weapons weapons = null;
    if (weaponIndex == 1) {
      weapons = new Katanas(getKatanaDamage(), getKatanaType());
    } else if (weaponIndex == 2) {
      weapons = new BroadSword(getBroadSwordDamage());
    } else if (weaponIndex == 3) {
      weapons = new TwoHandedSword(getTwoHandedSwordDamage());
    } else if (weaponIndex == 4) {
      weapons = new Axes(getAxesDamage());
    } else if (weaponIndex == 5) {
      weapons = new Flails(getFlailsDamage());
    } else {
      weapons = new BareHands(getBareHandsDamage());
    }
    return weapons;
  }

  /**
   * This is used to calculate the health of player after the gear boost given.
   *
   * @return state of the health.
   */
  public static boolean getGearsTotalStrengthPlayerOne() {

    int[] gears = getPlayerOneBag();
    int headGearCount = 0;
    int footwearCount = 0;
    int beltCapacity = 0;
    int beltSize = 0;
    boolean state = true;
    for (int i = 0; i < gears.length; i++) {
      if (gears[i] == 1) {
        if (headGearCount < 2) {
          gearConstitutionSum1 += getHeadGearStrength();
          if (headGearCount > 1) {
            state = false;
          }
        }
        headGearCount++;
      } else if (gears[i] == -1) {
        if (headGearCount < 2) {
          gearConstitutionSum1 -= getHeadGearStrength();
          if (headGearCount > 1) {
            state = false;
          }
        }
        headGearCount++;
      }

      if (gears[i] == 2) {
        gearStrengthSum1 += getPotionStrength();
        gearConstitutionSum1 += getPotionStrength();
        gearDexteritySum1 += getPotionStrength();
        gearCharismaSum1 += getPotionStrength();
      } else if (gears[i] == -2) {
        gearStrengthSum1 -= getPotionStrength();
        gearConstitutionSum1 -= getPotionStrength();
        gearDexteritySum1 -= getPotionStrength();
        gearCharismaSum1 -= getPotionStrength();
      }

      if (gears[i] == 3) {
        int abilityOne = random.nextInt(4) + 1;
        int abilityTwo = random.nextInt(4) + 1;

        if (getBeltSize().equalsIgnoreCase("L")) {
          beltSize += beltSize + 4;
        } else if (getBeltSize().equalsIgnoreCase("M")) {
          beltSize += beltSize + 2;
        } else if (getBeltSize().equalsIgnoreCase("S")) {
          beltSize += beltSize + 1;
        }
        if (beltCapacity < 11) {
          if (abilityOne == 1) {
            gearStrengthSum1 += getBeltsStrength();
          } else if (abilityOne == 2) {
            gearConstitutionSum1 += getBeltsStrength();
          } else if (abilityOne == 3) {
            gearDexteritySum1 += getBeltsStrength();
          } else {
            gearCharismaSum1 += getBeltsStrength();
          }

          if (abilityTwo == 1) {
            gearStrengthSum1 += getBeltsStrength();
          } else if (abilityTwo == 2) {
            gearConstitutionSum1 += getBeltsStrength();
          } else if (abilityTwo == 3) {
            gearDexteritySum1 += getBeltsStrength();
          } else {
            gearCharismaSum1 += getBeltsStrength();
          }
          if (beltCapacity > 11) {
            state = false;
          }
        }
        beltCapacity += beltSize;
      } else if (gears[i] == -3) {
        int abilityOne = random.nextInt(4) + 1;
        int abilityTwo = random.nextInt(4) + 1;

        if (getBeltSize().equalsIgnoreCase("L")) {
          beltSize += beltSize + 4;
        } else if (getBeltSize().equalsIgnoreCase("M")) {
          beltSize += beltSize + 2;
        } else if (getBeltSize().equalsIgnoreCase("S")) {
          beltSize += beltSize + 1;
        }
        if (beltCapacity < 11) {
          if (abilityOne == 1) {
            gearStrengthSum1 -= getBeltsStrength();
          } else if (abilityOne == 2) {
            gearConstitutionSum1 -= getBeltsStrength();
          } else if (abilityOne == 3) {
            gearDexteritySum1 -= getBeltsStrength();
          } else {
            gearCharismaSum1 -= getBeltsStrength();
          }

          if (abilityTwo == 1) {
            gearStrengthSum1 -= getBeltsStrength();
          } else if (abilityTwo == 2) {
            gearConstitutionSum1 -= getBeltsStrength();
          } else if (abilityTwo == 3) {
            gearDexteritySum1 -= getBeltsStrength();
          } else {
            gearCharismaSum1 -= getBeltsStrength();
          }
          if (beltCapacity > 11) {
            state = false;
          }
        }
        beltCapacity += beltSize;
      }

      if (gears[i] == 4) {
        if (footwearCount < 2) {
          gearDexteritySum1 += getFootwearStrength();
          if (footwearCount > 2) {
            state = false;
          }
        }
        footwearCount++;
      } else if (gears[i] == -4) {
        if (footwearCount < 2) {
          gearDexteritySum1 -= getFootwearStrength();
          if (footwearCount > 2) {
            state = false;
          }
        }
        footwearCount++;
      }
    }
    return state;
  }


  /**
   * This is used to calculate the Player 1 striking power.
   *
   * @return striking power.
   */
  public static int getStrikingPowerPlayerOne() {
    int strength = player1.getStrength();
    int strikingPower = strength + gearStrengthSum1 + (random.nextInt(10) + 1);
    return strikingPower;
  }

  /**
   * This is used to calculate the Player 1 Avoidance Ability.
   *
   * @return Avoidance Ability.
   */
  public static int getAvoidanceAbilityPlayerOne() {
    int dexterity = player1.getDexterity();
    int avoidanceAbility = dexterity + gearDexteritySum1 + (random.nextInt(6) + 1);
    return avoidanceAbility;
  }

  /**
   * This is used to calculate the Player 1 Potential Striking Damage.
   *
   * @return Potential Striking Damage.
   */
  public static int getPotentialStrikingDamagePlayerOne() {
    Weapons weapons = getRequestedWeapon();
    int strength = player1.getStrength();
    int potentialStrikingDamage = strength + gearStrengthSum1 + weapons.getDamage();
    return potentialStrikingDamage;
  }

  /**
   * This is used to calculate the Player 1 Actual Power.
   *
   * @return Actual Damage.
   */
  public static int getActualDamagePlayerOne() {
    int actualDamage = getPotentialStrikingDamagePlayerOne() - player2.getConstitution();
    return actualDamage;
  }

  /**
   * This is used to find the player 1 health.
   *
   * @return health.
   */
  public static int getHealthPlayerOne() {
    int health = 0;
    health = player1.getStrength() + player1.getConstitution() + player1.getDexterity()
            + player1.getCharisma() + gearStrengthSum1 + gearConstitutionSum1 + gearDexteritySum1
            + gearCharismaSum1;
    return health;
  }


  /**
   * This is used to calculate the health of player after the gear boost given.
   *
   * @return state of the health.
   */
  public static boolean getGearsTotalStrengthPlayerTwo() {

    int[] gears = getPlayerTwoBag();
    int headGearCount = 0;
    int footwearCount = 0;
    int beltCapacity = 0;
    int beltSize = 0;
    boolean state = true;
    for (int i = 0; i < gears.length; i++) {
      if (gears[i] == 1) {
        if (headGearCount < 2) {
          gearConstitutionSum2 += getHeadGearStrength();
          if (headGearCount > 1) {
            state = false;
          }
        }
        headGearCount++;
      } else if (gears[i] == -1) {
        if (headGearCount < 2) {
          gearConstitutionSum2 -= getHeadGearStrength();
          if (headGearCount > 1) {
            state = false;
          }
        }
        headGearCount++;
      }

      if (gears[i] == 2) {
        gearStrengthSum2 += getPotionStrength();
        gearConstitutionSum2 += getPotionStrength();
        gearDexteritySum2 += getPotionStrength();
        gearCharismaSum2 += getPotionStrength();
      } else if (gears[i] == -2) {
        gearStrengthSum2 -= getPotionStrength();
        gearConstitutionSum2 -= getPotionStrength();
        gearDexteritySum2 -= getPotionStrength();
        gearCharismaSum2 -= getPotionStrength();
      }

      if (gears[i] == 3) {
        int abilityOne = random.nextInt(4) + 1;
        int abilityTwo = random.nextInt(4) + 1;

        if (getBeltSize().equalsIgnoreCase("L")) {
          beltSize += beltSize + 4;
        } else if (getBeltSize().equalsIgnoreCase("M")) {
          beltSize += beltSize + 2;
        } else if (getBeltSize().equalsIgnoreCase("S")) {
          beltSize += beltSize + 1;
        }
        if (beltCapacity < 11) {
          if (abilityOne == 1) {
            gearStrengthSum2 += getBeltsStrength();
          } else if (abilityOne == 2) {
            gearConstitutionSum2 += getBeltsStrength();
          } else if (abilityOne == 3) {
            gearDexteritySum2 += getBeltsStrength();
          } else {
            gearCharismaSum2 += getBeltsStrength();
          }

          if (abilityTwo == 1) {
            gearStrengthSum2 += getBeltsStrength();
          } else if (abilityTwo == 2) {
            gearConstitutionSum2 += getBeltsStrength();
          } else if (abilityTwo == 3) {
            gearDexteritySum2 += getBeltsStrength();
          } else {
            gearCharismaSum2 += getBeltsStrength();
          }
          if (beltCapacity > 11) {
            state = false;
          }
        }
        beltCapacity += beltSize;
      } else if (gears[i] == -3) {
        int abilityOne = random.nextInt(4) + 1;
        int abilityTwo = random.nextInt(4) + 1;

        if (getBeltSize().equalsIgnoreCase("L")) {
          beltSize += beltSize + 4;
        } else if (getBeltSize().equalsIgnoreCase("M")) {
          beltSize += beltSize + 2;
        } else if (getBeltSize().equalsIgnoreCase("S")) {
          beltSize += beltSize + 1;
        }
        if (beltCapacity < 11) {
          if (abilityOne == 1) {
            gearStrengthSum2 -= getBeltsStrength();
          } else if (abilityOne == 2) {
            gearConstitutionSum2 -= getBeltsStrength();
          } else if (abilityOne == 3) {
            gearDexteritySum2 -= getBeltsStrength();
          } else {
            gearCharismaSum2 -= getBeltsStrength();
          }

          if (abilityTwo == 1) {
            gearStrengthSum2 -= getBeltsStrength();
          } else if (abilityTwo == 2) {
            gearConstitutionSum2 -= getBeltsStrength();
          } else if (abilityTwo == 3) {
            gearDexteritySum2 -= getBeltsStrength();
          } else {
            gearCharismaSum2 -= getBeltsStrength();
          }
          if (beltCapacity > 11) {
            state = false;
          }
        }
        beltCapacity += beltSize;
      }

      if (gears[i] == 4) {
        if (footwearCount < 2) {
          gearDexteritySum2 += getFootwearStrength();
          if (footwearCount > 2) {
            state = false;
          }
        }
        footwearCount++;
      } else if (gears[i] == -4) {
        if (footwearCount < 2) {
          gearDexteritySum2 -= getFootwearStrength();
          if (footwearCount > 2) {
            state = false;
          }
        }
        footwearCount++;
      }
    }
    return state;
  }

  /**
   * This is used to calculate the Player 2 striking power.
   *
   * @return striking power.
   */
  public static int getStrikingPowerPlayerTwo() {
    int strength = player2.getStrength();
    int strikingPower = strength + gearStrengthSum2 + (random.nextInt(10) + 1);
    return strikingPower;
  }

  /**
   * This is used to calculate the Player 2 Avoidance Ability.
   *
   * @return Avoidance Ability.
   */
  public static int getAvoidanceAbilityPlayerTwo() {
    int dexterity = player2.getDexterity();
    int avoidanceAbility = dexterity + gearDexteritySum2 + (random.nextInt(6) + 1);
    return avoidanceAbility;
  }

  /**
   * This is used to calculate the Player 2 Potential Striking Damage.
   *
   * @return Potential Striking Damage.
   */
  public static int getPotentialStrikingDamagePlayerTwo() {
    Weapons weapons = getRequestedWeapon();
    int strength = player2.getStrength();
    int potentialStrikingDamage = strength + gearStrengthSum2 + weapons.getDamage();
    return potentialStrikingDamage;
  }

  /**
   * This is used to calculate the Player 2 Actual Damage.
   *
   * @return actual Damage.
   */
  public static int getActualDamagePlayerTwo() {
    int actualDamage = getPotentialStrikingDamagePlayerTwo() - player1.getConstitution();
    return actualDamage;
  }

  /**
   * This is used to find the player 2 health.
   *
   * @return health.
   */
  public static int getHealthPlayerTwo() {
    int health = 0;
    health = player2.getStrength() + player2.getConstitution() + player2.getDexterity()
            + player2.getCharisma() + gearStrengthSum2 + gearConstitutionSum2 + gearDexteritySum2
            + gearCharismaSum2;
    return health;
  }

  /**
   * This is the MOCK Main method which is the entry point and is NOT used to run the program.
   */
  public static void main(String[] args) {
    Players player1 = new Players(getDiceSum(), getDiceSum(), getDiceSum(), getDiceSum());
    Players player2 = new Players(getDiceSum(), getDiceSum(), getDiceSum(), getDiceSum());

    Gears headGear = new HeadGear(getHeadGearStrength());

    Gears potions = new Potions(getPotionStrength());

    Gears belts = new Belts(getBeltsStrength(), getBeltSize());

    Gears footwear = new Footwear(getFootwearStrength());

    Weapons katana = new Katanas(getKatanaDamage(), getKatanaType());

    Weapons broadSword = new BroadSword(getBroadSwordDamage());

    Weapons twoHandedSword = new TwoHandedSword(getTwoHandedSwordDamage());

    Weapons axes = new Axes(getAxesDamage());

    Weapons flails = new Flails(getFlailsDamage());

    Weapons bareHands = new BareHands(getBareHandsDamage());

    EquipmentBag equipmentBag = new EquipmentBag(getEquipmentBag(), getPlayerOneBag(),
            getPlayerTwoBag());

    Armory armoryPlayer1 = new Armory(getRequestedWeapon());
    Armory armoryPlayer2 = new Armory(getRequestedWeapon());

    Arena playerOneStats = new Arena(getStrikingPowerPlayerOne(), getAvoidanceAbilityPlayerOne(),
            getPotentialStrikingDamagePlayerOne(), getActualDamagePlayerOne());

    Health playerOneHealth = new Health(getHealthPlayerOne());
    Health playerTwoHealth = new Health(getHealthPlayerTwo());

    System.out.println("*************************************");
    System.out.println("* Welcome to UFC Championship Arena *");
    System.out.println("*************************************");

    System.out.println("Press 1 to Start a Fight or have a Rematch");
    System.out.println("Press 0 to end Game");
    System.out.println();
    while (true) {
      Scanner ob = new Scanner(System.in);
      int n = ob.nextInt();
      if (n == 0) {
        break;
      }
      System.out.println("Introducing the First Contender");
      System.out.println("Player 1 Statistics:");
      System.out.println(player1);
      System.out.println("Introducing the Second Contender");
      System.out.println("Player 2 Statistics:");
      System.out.println(player2 + "\n");

      System.out.println("Entering the Battle Arena");
      System.out.println("Player 1 requesting Weapon");
      System.out.println(armoryPlayer1);

      System.out.println("Player 2 requesting Weapon");
      System.out.println(armoryPlayer2);

      System.out.println("The list of Equipment Bag");
      displayEquipmentBag();
      System.out.println("\n");
      System.out.println("\nThe Players Start Choosing Randomly");
      System.out.println("Player 1 Bag Details in Sorted order from Top to Bottom");
      displayPlayerBag(getPlayerOneBag());
      System.out.println("\nNow Modified Player 1 Health after applying all the gears");
      System.out.println(playerOneHealth);

      System.out.println("\nPlayer 2 Bag Details in Sorted order from Top to Bottom");
      displayPlayerBag(getPlayerTwoBag());
      System.out.println("\nNow Modified Player 2 Health after applying all the gears");
      System.out.println(playerTwoHealth);

      System.out.println("\nLet The Fight Begin");
      System.out.println("The players Temporary Boost abilities will remain till 3 rounds only");
      int strikePower1 = getStrikingPowerPlayerOne();
      int strikePower2 = getStrikingPowerPlayerTwo();
      int avoidAbility1 = getAvoidanceAbilityPlayerOne();
      int avoidAbility2 = getAvoidanceAbilityPlayerTwo();
      int healthPlayer1 = getHealthPlayerOne();
      int healthPlayer2 = getHealthPlayerTwo();
      int playerOneDamage = getActualDamagePlayerOne();
      int playerTwoDamage = getActualDamagePlayerTwo();
      int i = 0;

      System.out.println("Checking Conditions to allow Smooth run of the Match");
      while (true) {
        System.out.println("\nRound No. " + (i + 1));
        if (i > 100) {
          System.out.println("Fight Ended in Draw as the Number of rounds passed 100.");
          break;
        }
        if (strikePower1 < avoidAbility2 && strikePower2 < avoidAbility1) {
          System.out.println("The Fight cannot continue as Both player cannot attack as the"
                  + " Avoidance Ability of Both Opponents is greater");
          break;
        }

        if (playerOneDamage < 0 && playerTwoDamage < 0) {
          System.out.println("The Fight cannot continue as Both player cannot attack as the"
                  + " Constitution of Both Opponents is greater");
          break;
        }

        if (playerOneDamage < 0 && strikePower2 < avoidAbility1) {
          System.out.println("The Fight cannot continue as Player 1 cannot do any damage"
                  + " and player 2 cannot do damage as Player 1's Avoidance Ability is greater.");
          break;
        }

        if (playerTwoDamage < 0 && strikePower1 < avoidAbility2) {
          System.out.println("The Fight cannot continue as Player 2 cannot do any damage"
                  + " and player 1 cannot do damage as Player 2's Avoidance Ability is greater.");
          break;
        }

        if (playerOneDamage > 0 && playerTwoDamage <= 0) {
          System.out.println("Player 1 Wins as Player 2 cannot attack as damage power is <= 0,"
                  + " No need to continue the fight");
          break;
        }

        if (playerOneDamage <= 0 && playerTwoDamage > 0) {
          System.out.println("Player 2 Wins as Player 1 cannot attack as damage power is <= 0,"
                  + " No need to continue the fight");
          break;
        }

        if (player1.charisma > player2.charisma) {
          if (i == 0) {
            System.out.println("Player 1 lands the first Hit due to Higher Charisma");
          } else {
            System.out.println("Player 1's turn to Attack");
          }
          if (i == 3) {
            healthPlayer1 -= getPotionStrength();
            healthPlayer2 -= getPotionStrength();
            System.out.println("****************************************************");
            System.out.println("The Temporary Effects of Potion Gear have weared of.");
            if (healthPlayer1 > 0) {
              System.out.println("The Effective Health of Player 1 = " + healthPlayer1);
            }
            if (healthPlayer1 <= 0 && healthPlayer2 > 0) {
              System.out.println("The Effective Health of Player 1 = 0");
              System.out.println("The Effective Health of Player 2 = " + healthPlayer2);
              System.out.println("Player 2 is the Winner");
              break;
            }
            if (healthPlayer2 > 0) {
              System.out.println("The Effective Health of Player 2 = " + healthPlayer2);
            }
            if (healthPlayer2 <= 0 && healthPlayer1 > 0) {
              System.out.println("The Effective Health of Player 2 = 0");
              System.out.println("The Effective Health of Player 1 = " + healthPlayer1);
              System.out.println("Player 1 is the Winner");
              break;
            }
            if (healthPlayer1 <= 0 && healthPlayer2 <= 0) {
              System.out.println("Match Ended in Draw as both players Health is 0");
              break;
            }
          }
          System.out.println("Player Attack No. = " + (i + 1));
          int playerOneDamagePerRound = getActualDamagePlayerOne();
          System.out.println("Damage Given to Player 2 = " + playerOneDamagePerRound);
          healthPlayer2 = healthPlayer2 - playerOneDamagePerRound;
          if (healthPlayer2 > 0) {
            System.out.println("The health of Player 2 after the attack = "
                    + healthPlayer2);
          }
          if (healthPlayer2 <= 0) {
            System.out.println("The health of Player 2 after the attack = 0");
            System.out.println("Player 1 is the Winner");
            break;
          }
          System.out.println("Player 2's turn to Attack");
          System.out.println("Player Attack No. = " + (i + 1));
          int playerTwoDamagePerRound = getActualDamagePlayerTwo();
          System.out.println("Damage Given to Player 1 = " + playerTwoDamagePerRound);
          healthPlayer1 = healthPlayer1 - playerTwoDamagePerRound;
          if (healthPlayer1 > 0) {
            System.out.println("The health of Player 1 after the attack = "
                    + healthPlayer1);
          }
          if (healthPlayer1 <= 0) {
            System.out.println("The health of Player 1 after the attack = 0");
            System.out.println("Player 2 is the Winner");
            break;
          }
          i++;
        } else {
          if (player2.charisma > player1.charisma) {
            if (i == 0) {
              System.out.println("Player 2 lands the first Hit due to Higher Charisma");
            } else {
              System.out.println("Player 2's turn to attack");
            }
            if (i == 3) {
              healthPlayer1 -= getPotionStrength();
              healthPlayer2 -= getPotionStrength();
              System.out.println("****************************************************");
              System.out.println("The Temporary Effects of Potion Gear have weared of.");
              System.out.println("The Effective Health of Player 1 = " + healthPlayer1);
              System.out.println("The Effective Health of Player 2 = " + healthPlayer2);
            }
            System.out.println("Player Attack No.  = " + (i + 1));
            int playerTwoDamagePerRound = getActualDamagePlayerTwo();
            System.out.println("Damage Given to Player 1 = " + playerTwoDamagePerRound);
            healthPlayer1 = healthPlayer1 - playerTwoDamagePerRound;
            if (healthPlayer1 > 0) {
              System.out.println("The health of Player 1 after the attack = "
                      + healthPlayer1);
            }
            if (healthPlayer1 <= 0) {
              System.out.println("The health of Player 1 after the attack = 0");
              System.out.println("Player 2 is the Winner");
              break;
            }
            System.out.println("Player 1's turn to attack");
            System.out.println("Player Attack No. = " + (i + 1));
            int playerOneDamagePerRound = getActualDamagePlayerOne();
            System.out.println("Damage Given to Player 2 = " + playerOneDamagePerRound);
            healthPlayer2 = healthPlayer2 - playerOneDamagePerRound;
            if (healthPlayer2 > 0) {
              System.out.println("The health of Player 2 after the attack = "
                      + healthPlayer2);
            }
            if (healthPlayer2 <= 0) {
              System.out.println("The health of Player 2 after the attack = 0");
              System.out.println("Player 1 is the Winner");
              break;
            }
          }
          System.out.println("\nNext Round");
          i++;
        }

      }
    }


  }


}
