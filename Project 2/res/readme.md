# About the project

The project is about Battle Simulation game where the two players are assigned attributes which help in determining their health, they are able to equip a list of items
called gears which enhance their abilities during a fight, with temporary affect. They are able to request weapon from the armory, all this is done randonmly. The fight continues until either of the players health reaches 0. The user is given an option for a rematch or end the game.

# List of Features

- Calculate and assign each Players attributes like strength, constitution, dexterity, charisma, etc.
- Generate an Equipment Bag having 25% negative items containing gears which can enhance players ability.
- Assign each player a list of 20 items from the equipment bag.
- Check for the validity of assigned items which can enhance a players ability according to Gears specifications as allowed.
- Player Requests for a weapon from the armory, it is assigned randomly.
- Player fighting atributes are determined before Fight Start, these are Striking Power, Avoidance Ability, Potential Striking Damage, Actual Damage.
- Check for the prerequisite conditions of fight so that it can run smoothly.
- Start the fight after all conditions are check.
- Count the rounds for every hit of both players and display their new health and damage taken.
- Gear affect wears off after some rounds.
- End fight when player health reaches 0.

# How to run

The project comes with a jar which can be used to run the program.

Considering you are in the main project folder, you need to run the following to run the jar:-

```bash
user@programmer~:$ java -jar Project 2.jar
```
You can open the Project in IntelliJ IDE and compile the program. Just Build the project and run the 'DriverClass.java' file.

# Description of examples

I have given the user option to start the game using 1 and stop the game using 0. He can apply for a rematch by pressing 1, rest sit back and enjoy the players will fight on their own. Please read the comments for better understanding.

If you need some help in understanding please refer the Dry runs in `res/` folder.

# Design/Model changes

- The changes made in the design after the initial phase:-

    1. I had to create a new class for checking the validity of gears applied to the player.
	
    2. I introduced abstract classes for Gears and Weapons for better abstraction.

    3. I checked and corrected the various access specifiers in public methods in classes.

- These are visible in the Design documents (UML diagrams) - `Design Docs.pdf` (Design document).

# Assumptions

The following assumptions are made in this project:-

- The Equipment bag can hold a maximum of 60 items from which players are assigned.

- The fight can run upto 100 rounds after which the match is declared draw.

- Belts come in SMALL, MEDIUM, LARGE sizes.

- Katana comes in pairs Single and Double with their damages affected respectively.


# Limitations

The following are limitations of this project:-

- The fight cannot continue for more than 100 rounds.

- When Actual Damage is 0 or less the fight stops instantly.

- The avoidance ability of opponent greater and the players actual damage 0 or less, occurs a deadlock so fight is stopped.

# Citations

- Java Interface. (n.d.). W3. https://www.w3schools.com/java/java_interface.asp

- Abstract Methods and Classes (The JavaTM Tutorials > Learning the Java Language > Interfaces and Inheritance). (n.d.). Oracle. https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html#:%7E:text=An%20abstract%20class%20is%20a,but%20they%20can%20be%20subclassed.&text=When%20an%20abstract%20class%20is,methods%20in%20its%20parent%20class

- java.util.Random.setSeed() Method. (n.d.). Tutorials. https://www.tutorialspoint.com/java/util/timezone_setseed.htm

- Objects (The JavaTM Tutorials > Learning the Java Language > Classes and Objects). (n.d.). Oracle. https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html
