# About the project

The project is about the Dungeon Game. In this game we generate a random maze by using Kruskal's algorithm of minimum spanning tree. Here every node has a path to another node. 2 Random points called the start and end are generated from which the player will traverse. Random treasures like ruby, diamond and sapphires are spread throughout the dungeon in caves. Here the nodes with 1,3,4 entrances are called caves and with 2 entrances is called Tunnels. The player pickups up these treasures wjile traversing from start to end point. The maze can be wrapping, i.e. the edges can be connected and can have more than 1 path between nodes if interconnectivity > 0.
Once he reaches end point the game finishes.

# List of Features

- Random Generation of Maze according to the given size.
- Random allocation of start and end points in ths nodes.
- Form coonections between nodes randomly.
- Calculate Remaining list.
- If interconnectivity grater > 0 then add edges from the remaining list.
- Assign each node as Tunnels or Caves.
- Populate the caves with treasures.
- Player starts traversing.
- Player picks up treasure in the path.
- Player path checks if he has reached end point or not.
- If the end point is reached, game over.
- Display the total treasures collected by player. 

# How to run

The project comes with a jar which can be used to run the program.

Considering you are in the main project folder, you need to run the following to run the jar:-
I have used command line arguments to take user input with the following format.

java -jar "jar Name" "Player Name" Maze-Length Maze-Breadth Interconnectivity-Degree Wrapping-Condition Treasure-Percent

```bash
user@programmer~:$ java -jar "Project 3.jar" "Kunal" 4 4 2 true 50
```
You can open the Project in IntelliJ IDE and compile the program. Just Build the project, edit the run configuration for cli command inputs and run the 'DriverClass.java' file.

# Description of examples

I have collected the User details, the initial Maze details whoch will be used in the formation of the Dungeon and the player creation. Just Enter the asked values.
rest sit back and enjoy the players will find its path inside the dungeon. Please read the comments for better understanding.

If you need some help in understanding please refer the Dry runs in `res/` folder.

# Design/Model changes

- The changes made in the design after the initial phase:-

    1. I removed the north, south, east move player methods to a generic method.
	
    2. I removed the location class as it was being handled in the dungeon.

    3. I added some methods in the dungeon interface, like remaininglist, edgeAdjacency List.

- These are visible in the Design documents (UML diagrams) - `Project 3 Design Docs Revised.pdf` (Design document).
- The initial deisgn is present in - `Project 3 Design Docs Old.pdf` (Design document).

# Assumptions

The following assumptions are made in this project:-

- The assumption is made that the player always choose the lowest distance path.

- The player always picks up the treasures in the nodes he visits.

- Treasures are only of Ruby, Diamond and sapphire type.

- their is no limit to the items the player can pick.


# Limitations

The following are limitations of this project:-

- The matrix lower than 4*4 cannot be formed as the mininmum distance will be then less than 5.

- The matrix with size greater tha 40*40 will take some time to calculate due to the random allocaiton of start and end points.


# Citations

-GeeksforGeeks. (2021, July 8). Kruskal’s Algorithm (Simple Implementation for Adjacency Matrix). Retrieved November 1, 2021, from https://www.geeksforgeeks.org/kruskals-algorithm-simple-implementation-for-adjacency-matrix/

-GeeksforGeeks. (2021a, July 8). Kruskal’s Algorithm (Simple Implementation for Adjacency Matrix). Retrieved November 1, 2021, from https://www.geeksforgeeks.org/kruskals-algorithm-simple-implementation-for-adjacency-matrix/

-GeeksforGeeks. (2020, December 16). Shortest path in an unweighted graph. Retrieved November 1, 2021, from https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
