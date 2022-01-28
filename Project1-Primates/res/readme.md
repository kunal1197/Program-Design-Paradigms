# About the project

The project is about a sanctuary named Jungles Friends Primates Sanctuary. Their job is to take in sick and cast-off animals. They can examine the animals and choose a shelter accordingly. This way management is free to use it to easily manage the project.

# List of Features

- Add new Housing (Isolation)
- Add new Housing (Enclosure) 
- Add a new Monkey
- Update the Isolation Cage Details after the monkeys are examined.
- Transfer the monkey from Isolation to Enclosure by checking it's health and space in the Enclosure Cage and designated Species.
- Get all the Species present in the Sanctuary in form of list.
- Generate the species with their location in Housing Cages(Enclosure/Inclosure).
- Generate Sign outside an Enclosure cage cell listing all the animals inside with their name, sex and favourite food.
- Generate list of all the monkeys by their names in alphabetical order with their locations in the Housing Cages.
- Generate a shopping list of all the food required by the animals of the Sanctuary with their total quantity in grams.
- Remove an Isolation Cage if the the funds are taken back due to emergency.
- Remove an Enclosure Cage if the the funds are taken back due to emergency.

# How to run

The project comes with a jar which can be used to run the program.

Considering you are in the main project folder, you need to run the following to run the jar:-

```bash
user@programmer~:$ java -jar Project1-Primates.jar
```
You can open the Project in IntelliJ IDE and compile the program. Just Build the project and run the 'DriverClass.java' file.

# Description of examples

I have hardcoded all the monkey and initial Sanctuary details to get started with program. Please read the comments for better understanding.

If you need some help in understanding please refer the Dry runs in `res/` folder.

# Design/Model changes

- The changes made in the design after the design meeting:-

    1. I changed the position of monkey health method from Housing class to Monkey Class. As we can check for its health at a time.
	
    2. I changed the shopping list method from Housing class to Monkey Class. As it is not related to any of the housing fields.

    3. I checked and corrected the various access specifiers in public methods in classes.

- These changes are visible in the Design documents (UML diagrams) - `Design Docs Old.pdf` (old design document) and `Design Docs Revised.pdf` (new design document).

# Assumptions

The following assumptions are made in this project:-

- The monkeys have only have eggs, fruits, insects, leaves, nuts, seeds, and tree sap as the available foods to them.

- Monkeys can be of genders male, female and unspecified comes in category other.

- The size of monkeys can either be SMALL, MEDIUM or LARGE.


# Limitations

The following are limitations of this project:-

- This is a non user interactive program so if a user wants different inputs he cannot do that without editing the code.

- If a housing has a monkey, and then the particular housing is removed the monkey also is removed.

- The Isolation Chamber cages have same area as at the start until their health check is done, we do not know the monkey sizes.
