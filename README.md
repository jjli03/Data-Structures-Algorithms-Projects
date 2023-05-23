## Project 1:
### Recursion and user interface
This project uses recurive functions along with a canvas class to draw fractal shapes based on user input. The user can specify the detail and amount of recursive calls by inputing a number as well as the shape by inputing square, triangle, and circle. 
To compile, use a standard terminal and locate where the FractalDrawer class is. Compile with javac FractalDrawer.java and run with java FractalDrawer.
Assumptions are that the user types in one of the three shapes correctly in all lowercase letters. If this is not the case, the program will print out '93invalid shape'94 along with an empty canvas. Total Area will remain at zero.
Bugs/Defects: Error when projecting the fractal onto the canvas. Sometimes the complete fractal does not appear fully on the canvas. This problem is usually fixed by pulling out the canvas window and expanding it.
Sources:
-How scaling for fractals worked and how I could implement it using recessive calls: https://nrich.maths.org/4757
-How color worked in java and how I was supposed to format it so that it would pass correctly through the parameter: https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html\
-IgnoreCase: My brother
-Generating random colors from integers: https://www.baeldung.com/java-generating-random-numbers-in-range

## Project 2:
### Random number generation and 2D arrays
This project creates a rough user interface which allows for multiplayer battleship. A 2D array of boat objects is used to create a grid. The game offers different tools like a scanner or missile with different affects to try and sink boats. It also offers a debugger method which allows the user to see what ships have been sunk and still exist. The board is randomly generated. 
To compile, use a standard terminal and locate where the Game class is. Compile with javac Game.java Board.java Boat.java Cell.java and run with java Game. Game contains the main method and all of the user input prompts.
Assumptions are that the user knows the battlefield is oriented so the 0, 0 is at the top left and that the x axis and y axis are flipped. It is also assumed the user inputs coordinates as integer (space) integer. 
Bugs/Defects: No known bugs or errors.
Sources:
-Utilizing the random method to find random numbers within a range. https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
-Continue: My brother

## Project 3:
### Linked lists and array lists
This project compares the efficiency and complexity of different array and list operations. Some operations might include adding, removing, inserting, merging, roatating, mergesort and others. the goal is to understand the benefits and consequences of certain operations on linked lists. 
Assumptions are that the user utilizes the unit tests. There is a lot of error handling in the code however they are not try/catch blocks so running into an error will stop the classes from running. For the analysis, an assumption is made that the is sorted method is not taken into runtime consideration.
-Reverse a linked list and insertion sort from CSCI 1933 Modules Chris Dovolis
-Pseudocode and splitting my linked list insertion sort into two methods: My brother & https://www.softwaretestinghelp.com/insertion-sort-in-java/
-Linked List operations and in-depth understanding: https://www.tutorialspoint.com/data_structures_algorithms/linked_list_algorithms.htm

## Project 4:
### Stacks and Queues
This project utilizes a stack to build a 2D array of cells with different attributes which are updated based on random direction. The canvas class uses the the 2D array to build a visual representation of the maze created by the stack. A final method uses a queue to gather all reachable neighbors within the 2D array maze and update their attributes if they are within the pathway. Multiple different maze sizes can be chosen. The green pathway represents the path sought by random selection and the queue. 
Assumptions are that the user inputs a correct number to build the grid. There is also an assumption made that the user knows that accessing down in the make and search methods can be done by adding to the initial y and vice versa. 
Credit: 
-Generating a random number within a range: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html and IntelliJ 
-BFS search method from Lab 11 was used to help construct the search method
Bugs: When search is run and there is a case the end is directly right of the cell accessed, if there is an accessible cell below, that one will also be visited.

## Project 5:
### Hash tables and hash functions
This project creates hash functions and an addition method to fill created hash tables based on the results of such functions. It include collision handling when adding and to create a function that reduces collisions and chaining as much as possible compared to the initial simple function.
Assumptions are that the user provides a valid txt file to be read.
Bugs/Defects: No known bugs or errors.
Sources:
-Hash1 from Professor Chris Dovolis’ example in lecture
