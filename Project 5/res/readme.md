# About the project

The project is about the GUI Dungeon Game made using Swing. In this game we generate a random maze by using Kruskal's algorithm of minimum spanning tree. Here every node has a path to another node. 2 Random points called the start and end are generated from which the player will traverse. The user gives the number of Monsters called the Otyughs to be populated in the Dungeon but only in the cave nodes. These Otyughs are very dangerous and can kill a player when the player enters the same node as them and if there health is 100. If the health is 50 the player has a chance of survival, it will take 2 arrow hits to kill a an otyugh. They also have a peculair smell and its strength depends on the distance. Random treasures like ruby, diamond and sapphires are spread throughout the dungeon in caves. Here the nodes with 1,3,4 entrances are called caves and with 2 entrances is called Tunnels. Random number of Arrows are populated in the Dungeon, which the player can pick up while traversing the Nodes. The player pickups up these treasures while traversing from start to end point. The maze can be wrapping, i.e. the edges can be connected and can have more than 1 path between nodes if interconnectivity > 0.
To play the game use top, down, left, right arrow keys and click on the cell to move, S for shoot followed by direction on the arrow keys and P for pick up followed by option to pick treasure/ arrows. All the player and Node Statistics will be be updated in real time.
You can restart the same game/ edit the configuration/ exit the game from the menu.
Once he reaches end point the game finishes.

# List of Features

- Cover all the Nodes in the Maze with black tiles in GUI.
- Random Generation of Maze according to the given size in GUI.
- Random allocation of start and end points in ths nodes.
- Random allocation of Oyughs images in the Cave nodes.
- Random allocation of arrows images in the dungeon same as the treasure Percentage. 
- Form coonections between nodes randomly.
- Calculate Remaining list.
- If interconnectivity greater > 0 then add edges from the remaining list.
- Assign each node as Tunnels or Caves.
- Populate the caves with treasures images like sapphire, ruby, diamond.
- Player image GUI starts traversing.
- Player picks up treasure in the path and the treasure images vanishes.
- Player picks up Arrows in the path and the arrow images vanisehs.
- Player has the ability to shoot arrows, with specified direction and distance.
- Monster health has to be reduced if the arrow hits.
- Check the player avoidance ability when with an injured Otyugh in the Cave.
- Monster smell strength according to the player path and show the stench image in the cave of the player.
- Monster death, then remove the otyugh image from that cell.
- Player path checks if he has reached end point or not, if yes stop game.
- If the monster kills the player, game over notify the player and stop the game.
- If the end point is reached, game over,  notify the player and stop the game.
- Display the total treasures, arrows collected by player.
- Uncovering all the Node tiles when player traverses on the path in GUI.
- Node and Player statistics in a panel on the frame displaying all the relevant details.

# How to run

The project comes with a jar which can be used to run the program.

Considering you are in the main project folder, you need to run the following to run the jar:-
I have used command line arguments to take user input with the following format.

2 Types of games are possible :

1.) For Console Based Game follow : 

java -jar "jar Name" "Player Name" Maze-Length Maze-Breadth Interconnectivity-Degree Wrapping-Condition Treasure-Percent Otyugh-Number

```bash
user@programmer~:$ java -jar "Project 5.jar" "Kunal" 4 4 2 true 50 5
```

2.) For GUI Based Game follow : 

java -jar "jar Name"

```bash
user@programmer~:$ java -jar "Project 5.jar" 
```

You can open the Project in IntelliJ IDE and compile the program. Just Build the project, edit the run configuration for cli command inputs and run the 'DriverClass.java' file.

# Description of examples

For Console Based :
I have collected the User details, the initial Maze details which will be used in the formation of the Dungeon and the player creation.
Just enter your values of choice (Move - M, Pick - P, Shoot - S) and play the game.
For Move, give Node Number cell.
For Shoot, give distance and direction.
For Pick, give the asked output.

For GUI Based :
When you open the game first default settings of 4 by 4 matrix with name - Kunal, interconnectivity - 2, wrapping - true, treasure percentage - 50, otyugh number - 5, have been set. You can restart the game anytime, edit the config of your own choice, exit the game from the Menu Bar on the top right.
For playing the game use clicks on the adjacent cells for player movement or via the arrow keys (up, down, left, right). For Pick up press P followed by option to pick Treasure/Arrow or both. To Shoot arrow press S followed by arrow keys(up, down, left, right).
All the player and Node Statistics will be be updated in real time.

Please read the comments for better understanding.

If you need some help in understanding please refer the Dry runs in `res/` folder.

# Design/Model changes

- The changes made in the design after the initial phase:-

    1. I made some changes in the existing null checks methods and added new checks.
	
    2. I added a new StatsPanel class to display the player and Node statistics on the right hand side.

    3. I added some methods in the DungeonView interface, like updateDungeon(), startNewGame.

- These are visible in the Design documents (UML diagrams) - `Project 5 Design Docs Revised.pdf` (Design document).
- The initial deisgn is present in - `Project 5 Design Docs Old.pdf` (Design document).

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

- Graphics2D (Java Platform SE 7 ). (n.d.). Graphics. https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html

- How to Write a Mouse Listener (The JavaTM Tutorials > Creating a GUI With Swing > Writing Event Listeners). (n.d.). Mouse. https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html

- How to Write a Key Listener (The JavaTM Tutorials > Creating a GUI With Swing > Writing Event Listeners). (n.d.). Key. https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html

-MVC Framework - Introduction. (n.d.). MVC. Retrieved November 18, 2021, from https://www.tutorialspoint.com/mvc_framework/mvc_framework_introduction.htm

-GeeksforGeeks. (2021, July 8). Kruskal’s Algorithm (Simple Implementation for Adjacency Matrix). Retrieved November 1, 2021, from https://www.geeksforgeeks.org/kruskals-algorithm-simple-implementation-for-adjacency-matrix/

-GeeksforGeeks. (2021a, July 8). Kruskal’s Algorithm (Simple Implementation for Adjacency Matrix). Retrieved November 1, 2021, from https://www.geeksforgeeks.org/kruskals-algorithm-simple-implementation-for-adjacency-matrix/

-GeeksforGeeks. (2020, December 16). Shortest path in an unweighted graph. Retrieved November 1, 2021, from https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
