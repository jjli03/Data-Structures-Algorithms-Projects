// Joshua Li; li002380
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

/**
 * Updated by Yuha Yoo and Austin Franzen 3.3.2022
 * Written by Cormac Pearce on 11.10.2021
 * Significant portions of code taken from Noah Park's Spring 2021 solution
 */
public class MyGrid {
    Cell[][] grid;
    int rows, cols, startRow, endRow, moves;
    int[][] packages;

    /**
     * Default constructor for MyMaze object.
     *
     * @param rows     total rows for the maze.
     * @param cols     total columns for the maze.
     * @param startRow row index of maze entrance
     * @param endRow   row index of maze exit
     */
    public MyGrid(int rows, int cols, int startRow, int endRow) {
        grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) { // Initialize a 2D Array with cell objects
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }
        this.startRow = startRow;
        this.endRow = endRow;
    }

    /**
     * Draws grid and displays to the user.
     */
    public void drawGrid() {
        // Visited Cells Color: Green
        // Non-visited Cells Color: Blue
        // Start/End Cells Color: Yellow
        // Wall Color: Black
        int startBorderY = 0; // Y location of left wall border column on the canvas
        int x = 25; // Initial X Pos
        int y = 25; // Initial Y pos
        Color change1 = Color.BLACK; // Top Left of 2x2 block (this represents the actual index taken from the initial grid
        Color change2 = Color.BLACK; // Top Right
        Color change3 = Color.BLACK; // Bottom Left
        Color change4 = Color.BLACK; // Bottom Right
        Canvas present = new Canvas(1000, 1000);
        for (int i = 0; i < grid[0].length; i++) {
            if (i == startRow) { // Check for the start row turns that square yellow
                Square temp = new Square(x, y, 22, 22, Color.YELLOW);
                present.drawShape(temp);
                startBorderY = y;
            }
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i].getRight() && grid[j][i].getBottom()) { // Right and bottom are borders, the bottom right must also
                    // be a border with the assumption the top left is always blue if it's read off the initial grid
                    change1 = Color.BLUE;
                    change4 = Color.BLACK;
                    change2 = Color.BLACK;
                    change3 = Color.BLACK;
                    if (grid[j][i].getVisited()) { // Visited check turns it to green
                        change1 = Color.GREEN;
                    }
                } else if (!grid[j][i].getRight() && !grid[j][i].getBottom()) { // Right and bottom are not borders.
                    change1 = Color.BLUE;
                    change4 = Color.BLACK;
                    change2 = Color.BLUE;
                    change3 = Color.BLUE;
                    if (grid[j][i].getVisited()) {
                        change1 = Color.GREEN;
                        change2 = Color.GREEN;
                        change3 = Color.GREEN;
                    }
                } else if (grid[j][i].getRight() && !grid[j][i].getBottom()) { // Bottom clear
                    change2 = Color.BLACK;
                    change1 = Color.BLUE;
                    change3 = Color.BLUE;
                    change4 = Color.BLACK;
                    if (grid[j][i].getVisited()) {
                        change1 = Color.GREEN;
                        change3 = Color.GREEN;
                    }
                } else if (!grid[j][i].getRight() && grid[j][i].getBottom()) { // Right clear
                    change2 = Color.BLUE;
                    change1 = Color.BLUE;
                    change3 = Color.BLACK;
                    change4 = Color.BLACK;
                    if (grid[j][i].getVisited()) {
                        change1 = Color.GREEN;
                        change2 = Color.GREEN;
                    }
                }
                x += 25;
                Square temp = new Square(x, y, 22, 22, change1); // Draw top left
                present.drawShape(temp);
                y += 25;
                temp = new Square(x, y, 22, 22, change3); // Draw bottom left
                present.drawShape(temp);
                y -= 25; // Reset to initial Y for the top right square to be drawn
                x += 25; // Shift right one square
                temp = new Square(x, y, 22, 22, change2); // Draw top right
                present.drawShape(temp);
                y += 25;
                temp = new Square(x, y, 22, 22, change4); // Draw bottom right
                present.drawShape(temp);
                y -= 25;
                if (i == endRow && j == grid.length - 1) { // endRow check
                    temp = new Square(x, y, 22, 22, Color.YELLOW);
                    present.drawShape(temp);
                }
            }
            x = 25;
            y += 50;
        }
        int startBorderX = grid.length * 2 * 25 + 25; // Total length of the drawing plus one square for the left border
        while (y != 0) { // Builds rightmost wall border
            y -= 25;
            if (y != startBorderY) {
                Square temp = new Square(25, y, 22, 22, Color.BLACK);
                present.drawShape(temp);

            }
        }
        while (x <= startBorderX) { // Builds uppermost wall border
            Square temp = new Square(x, 0, 22, 22, Color.BLACK);
            present.drawShape(temp);
            x += 25;
        }
    }

    /**
     * Generates a random maze using the algorithm from the write up.
     *
     * @param level difficulty level for maze (1-3) that decides maze dimensions
     *              level 1 -> 5x5, level 2 -> 5x20, level 3 -> 20x20
     * @return MyMaze object fully generated.
     */
    public static MyGrid makeGrid(int level) {
        MyGrid turn = new MyGrid(0, 0, 0, 0);
        Random rand = new Random();
        if (level == 1) { // Level Differentiator
            int ranStart = rand.nextInt(5); // Random start row
            int ranEnd = rand.nextInt(5); // Random end row
            turn = new MyGrid(5, 5, ranStart, ranEnd);
        } else if (level == 2) {
            int ranStart = rand.nextInt(5);
            int ranEnd = rand.nextInt(5);
            turn = new MyGrid(10, 5, ranStart, ranEnd);
        } else if (level == 3) {
            int ranStart = rand.nextInt(12);
            int ranEnd = rand.nextInt(12);
            turn = new MyGrid(12, 12, ranStart, ranEnd);
        }
        StackGen<int[]> stack = new Stack1Gen<>();
        stack.push(new int[]{0, turn.startRow}); // Initial starting point
        turn.grid[0][turn.startRow].setVisited(true); // Initial push (start row and 0 flipped to make x axis horizontal)
        int[] temp = stack.top();
        while (!stack.isEmpty()) { // While stack is not empty
            boolean inRange = false; // Check for random unvisited cell
            while (!inRange) { // Ensure random continually generates until it gets a random number that is unvisited and
                // in bounds.
                int randomNum = rand.nextInt(4);
                if (randomNum == 0) { // x-right
                    if (temp[0] + 1 < turn.grid.length && !turn.grid[temp[0] + 1][temp[1]].getVisited()) {
                        stack.push(new int[]{temp[0] + 1, temp[1]});
                        turn.grid[temp[0] + 1][temp[1]].setVisited(true); // Set right cell to visited
                        turn.grid[temp[0]][temp[1]].setRight(false); // Set initial cell right border to clear
                        inRange = true; // Kill while loop once valid coordinate is generated
                    }
                } else if (randomNum == 1) { // y-up
                    if (temp[1] - 1 >= 0 && !turn.grid[temp[0]][temp[1] - 1].getVisited()) {
                        stack.push(new int[]{temp[0], temp[1] - 1});
                        turn.grid[temp[0]][temp[1] - 1].setVisited(true);
                        turn.grid[temp[0]][temp[1] - 1].setBottom(false);
                        inRange = true;
                    }
                } else if (randomNum == 2) { // x-left
                    if (temp[0] - 1 >= 0 && !turn.grid[temp[0] - 1][temp[1]].getVisited()) {
                        stack.push(new int[]{temp[0] - 1, temp[1]});
                        turn.grid[temp[0] - 1][temp[1]].setVisited(true);
                        turn.grid[temp[0] - 1][temp[1]].setRight(false);
                        inRange = true;
                    }
                } else if (randomNum == 3) { // y-down
                    if (temp[1] + 1 < turn.grid[0].length && !turn.grid[temp[0]][temp[1] + 1].getVisited()) {
                        stack.push(new int[]{temp[0], temp[1] + 1});
                        turn.grid[temp[0]][temp[1] + 1].setVisited(true);
                        turn.grid[temp[0]][temp[1]].setBottom(false);
                        inRange = true;
                    }
                }
                if (stack.isEmpty()) { // Prevent excessive addition into the stack
                    break;
                }
                temp = stack.top();
                if (temp[1] == 0) { // Top of the array checker for if all neighbors visited
                    if (temp[0] == 0) { // Top Left Corner
                        if (turn.grid[temp[0] + 1][temp[1]].getVisited() && turn.grid[temp[0]][temp[1] + 1].getVisited()) {
                            if (!stack.isEmpty()) {
                                stack.pop();
                            }
                        }
                    } else if (temp[0] == turn.grid.length - 1) { // Top Right Corner
                        if (turn.grid[temp[0]][temp[1] + 1].getVisited() && turn.grid[temp[0] - 1][temp[1]].getVisited()) {
                            if (!stack.isEmpty()) {
                                stack.pop();
                            }
                        }
                    } else if (turn.grid[temp[0] + 1][temp[1]].getVisited() && turn.grid[temp[0]][temp[1] + 1].getVisited()
                            && turn.grid[temp[0] - 1][temp[1]].getVisited()) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                } else if (temp[0] == 0) { // Left side
                    if (temp[1] == turn.grid[0].length - 1) { // Left Bottom corner
                        if (turn.grid[temp[0] + 1][temp[1]].getVisited() && turn.grid[temp[0]][temp[1] - 1].getVisited()) {
                            if (!stack.isEmpty()) {
                                stack.pop();
                            }
                        }
                    } else if (turn.grid[temp[0] + 1][temp[1]].getVisited() && turn.grid[temp[0]][temp[1] - 1].getVisited()
                            && turn.grid[temp[0]][temp[1] + 1].getVisited()) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                } else if (temp[0] == turn.grid.length - 1) { // Right side
                    if (temp[1] == turn.grid[0].length - 1) { // Right Bottom Corner
                        if (turn.grid[temp[0]][temp[1] - 1].getVisited() && turn.grid[temp[0] - 1][temp[1]].getVisited()) {
                            if (!stack.isEmpty()) {
                                stack.pop();
                            }
                        }
                    } else if (turn.grid[temp[0]][temp[1] - 1].getVisited()
                            && turn.grid[temp[0]][temp[1] + 1].getVisited() && turn.grid[temp[0] - 1][temp[1]].getVisited()) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                } else if (temp[1] == turn.grid[0].length - 1) { // Bottom side
                    if (temp[0] == turn.grid.length - 1) { // Bottom Right corner
                        if (turn.grid[temp[0]][temp[1] - 1].getVisited() && turn.grid[temp[0] - 1][temp[1]].getVisited()) {
                            if (!stack.isEmpty()) {
                                stack.pop();
                            }
                        }
                    } else if (turn.grid[temp[0] + 1][temp[1]].getVisited()
                            && turn.grid[temp[0]][temp[1] - 1].getVisited() && turn.grid[temp[0] - 1][temp[1]].getVisited()) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                } else if (turn.grid[temp[0] + 1][temp[1]].getVisited() && turn.grid[temp[0]][temp[1] - 1].getVisited()
                        && turn.grid[temp[0]][temp[1] + 1].getVisited() && turn.grid[temp[0] - 1][temp[1]].getVisited()) {
                    // If and only if all neighbors are in array index can we check the visited attribute of each
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
        }
        for (int i = 0; i < turn.grid.length; i++) {
            for (int j = 0; j < turn.grid[i].length; j++) { // Set all cells back to unvisited
                turn.grid[i][j].setVisited(false);
            }
        }
        return turn;
    }

    /**
     * Solves the maze using the algorithm from the writeup.
     */
    public void solveGrid() {
        Q1Gen<int[]> queue = new Q1Gen<>();
        queue.add(new int[]{0, startRow}); // Initial add to the queue with the start row, again swapped.
        while (queue.length() > 0) { // While queue isn't empty
            int[] temp = queue.remove(); // Gets bottom dequeued
            grid[temp[0]][temp[1]].setVisited(true); // Set said bottom to visited
            if (temp[0] == grid.length - 1 && temp[1] == endRow) { // End row break checker
                break;
            }
            if (!grid[temp[0]][temp[1]].getRight() && !grid[temp[0] + 1][temp[1]].getVisited()) { // Right neighbor
                queue.add(new int[]{temp[0] + 1, temp[1]});
                grid[temp[0] + 1][temp[1]].setVisited(true);
                if (temp[0] + 1 == grid.length - 1 && temp[1] == endRow) {
                    break;
                }
            }
            if (!grid[temp[0]][temp[1]].getBottom() && !grid[temp[0]][temp[1] + 1].getVisited()) { // Bottom neighbor
                queue.add(new int[]{temp[0], temp[1] + 1});
                grid[temp[0]][temp[1] + 1].setVisited(true);
                if (temp[0] == grid.length - 1 && temp[1] + 1 == endRow) {
                    break;
                }
            }
            if (temp[0] - 1 >= 0 && !grid[temp[0] - 1][temp[1]].getRight() && !grid[temp[0] - 1][temp[1]].getVisited()) {
                // Left neighbor
                queue.add(new int[]{temp[0] - 1, temp[1]});
                grid[temp[0] - 1][temp[1]].setVisited(true);

            }
            if (temp[1] - 1 >= 0 && !grid[temp[0]][temp[1] - 1].getBottom() && !grid[temp[0]][temp[1] - 1].getVisited()) {
                // Top neighbor
                queue.add(new int[]{temp[0], temp[1] - 1});
                grid[temp[0]][temp[1] - 1].setVisited(true);
                if (temp[0] == grid.length - 1 && temp[1] - 1 == endRow) {
                    break;
                }
            }
        }
    }

    public static <T> void main(String[] args) {
        System.out.print("Input level (1) (2) (3): ");
        Scanner myScanner = new Scanner(System.in);
        String level = myScanner.nextLine();
        switch (level) {
            case "1": {
                MyGrid test = makeGrid(1);
                test.solveGrid();
                test.drawGrid();
                break;
            }
            case "2": {
                MyGrid test = makeGrid(2);
                test.solveGrid();
                test.drawGrid();
                break;
            }
            case "3": {
                MyGrid test = makeGrid(3);
                test.solveGrid();
                test.drawGrid();
                break;
            }
            default:
                System.out.println("!User Input Error!");
                break;
        }
    }
}