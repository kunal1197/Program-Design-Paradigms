# About the project

The project is about the Dungeon Game. In this game we generate a random maze by using Kruskal's algorithm of minimum spanning tree. Here every node has a path to another node. 2 Random points called the start and end are generated from which the player will traverse. The user gives the number of Monsters called the Otyughs to be populated in the Dungeon but only in the cave nodes. These Otyughs are very dangerous and can kill a player when the player enters the same node as them and if there health is 100. If the health is 50 the player has a chance of survival, it will take 2 arrow hits to kill a an otyugh. They also have a peculair smell and its strength depends on the distance. Random treasures like ruby, diamond and sapphires are spread throughout the dungeon in caves. Here the nodes with 1,3,4 entrances are called caves and with 2 entrances is called Tunnels. Random number of Arrows are populated in the Dungeon, which the player can pick up while traversing the Nodes. The player pickups up these treasures wjile traversing from start to end point. The maze can be wrapping, i.e. the edges can be connected and can have more than 1 path between nodes if interconnectivity > 0.
Once he reaches end point the game finishes.

# List of Features

- Random Generation of Maze according to the given size.
- Random allocation of start and end points in ths nodes.
- Random allocation of Oyughs in the Cave nodes.
- Random allocation of arrows in the dungeon same as the treasure Percentage. 
- Form coonections between nodes randomly.
- Calculate Remaining list.
- If interconnectivity grater > 0 then add edges from the remaining list.
- Assign each node as Tunnels or Caves.
- Populate the caves with treasures.
- Player starts traversing.
- Player picks up treasure in the path.
- Player picks up Arrows in the path.
- Player has the ability to shoot arrows, with specified direction and distance.
- Monster health has to be reduced if the arrow hits.
- Check the player avoidance ability when with an injured Otyugh in the Cave.
- Monster smell strength according to the player path.
- Monster death.
- Player path checks if he has reached end point or not.
- If the monster kills the player, game over.
- If the end point is reached, game over.
- Display the total treasures, arrows collected by player.

# How to run

The project comes with a jar which can be used to run the program.

Considering you are in the main project folder, you need to run the following to run the jar:-
I have used command line arguments to take user input with the following format.

java -jar "jar Name" "Player Name" Maze-Length Maze-Breadth Interconnectivity-Degree Wrapping-Condition Treasure-Percent Otyugh-Number

```bash
user@programmer~:$ java -jar "Project 4.jar" "Kunal" 4 4 2 true 50 5
```
You can open the Project in IntelliJ IDE and compile the program. Just Build the project, edit the run configuration for cli command inputs and run the 'DriverClass.java' file.

# Description of examples

I have collected the User details, the initial Maze details which will be used in the formation of the Dungeon and the player creation.
Just enter your values of choice (Move - M, Pick - P, Shoot - S) and play the game.
For Move, give Node Number cell.
For Shoot, give distance and direction.
For Pick, give the asked output.

Please read the comments for better understanding.

If you need some help in understanding please refer the Dry runs in `res/` folder.

# Design/Model changes

- The changes made in the design after the initial phase:-

    1. I made some changes in the existing null checks methods and added new checks.
	
    2. I added Monster Interface and its implementation to create monsters and its associated methods.

    3. I added some methods in the dungeon interface, like edgeDirectionList, populateArrows, populateOtyughs.

- These are visible in the Design documents (UML diagrams) - `Project 4 Design Docs Revised.pdf` (Design document).
- The initial deisgn is present in - `Project 4 Design Docs Old.pdf` (Design document).

# Assumptions

The following assumptions are made in this project:-

- The assumption is made that the player can pick up only 2 treasures at once, as he has 2 hands.

- The arrow which hits the wall cannot be picked up again and is deemed useless.

- Treasures which are picked up from the nodes are removed from that node in the dungeon.

- their is no limit to the items the player can pick.


# Limitations

The following are limitations of this project:-

- The Dungeon lower than 4*4 cannot be formed as the mininmum distance will be then less than 5.

- The player can only travel in North, South, East, West directions and not diagonal.

- The player cannot shoot arrows once inside the node with a monster.

- The Dungeon with size greater tha 40*40 will take some time to calculate due to the random allocation of start and end points.


# Citations

-MVC Framework - Introduction. (n.d.). MVC. Retrieved November 18, 2021, from https://www.tutorialspoint.com/mvc_framework/mvc_framework_introduction.htm

-GeeksforGeeks. (2021, July 8). Kruskal’s Algorithm (Simple Implementation for Adjacency Matrix). Retrieved November 1, 2021, from https://www.geeksforgeeks.org/kruskals-algorithm-simple-implementation-for-adjacency-matrix/

-GeeksforGeeks. (2021a, July 8). Kruskal’s Algorithm (Simple Implementation for Adjacency Matrix). Retrieved November 1, 2021, from https://www.geeksforgeeks.org/kruskals-algorithm-simple-implementation-for-adjacency-matrix/

-GeeksforGeeks. (2020, December 16). Shortest path in an unweighted graph. Retrieved November 1, 2021, from https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
