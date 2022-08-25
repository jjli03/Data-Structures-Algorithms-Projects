// Written by Joshua Li, li002380
import java.util.Scanner;
import java.lang.Integer;

public class Board {
    private int m;
    private int n;
    private Cell[][] battlefield; // Battlefield which is displayed
    // IMPORTANT: This battlefield is NOT oriented like a first quadrant graph.
    // The 0, 0 coordinate is the top left element so the max is one less than the one set by the user.
    // The X and Y axis are FLIPPED so the user should ensure he or she flips their coordinates.
    public Boat[] boats = new Boat[5]; // List of boats in a given board class
    public int turns = 1; // User turns
    public Board(int m, int n) {
        this.m = m;
        this.n = n;
        battlefield = new Cell[m + 1][n + 1];
        fillBoard();
    }
    private void fillBoard(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){ // Reads through the entire 2D array
                battlefield[i][j] = new Cell(i, j); // Initiallizes all null as cell objects with base char '-'
            }
        }
    }
    public int getM(){
        return m;
    }
    public int getN(){
        return n;
    }
    public Cell[][] getBattlefield(){
        return battlefield;
    }
    public void placeBoats(){
        if(m == 3 && n == 3){
            Boat boat1 = new Boat(); //Creates new boat object
            boat1.placeBoat2(this); // Runs the place function in boat to generate a random set of coordinates and create a cell 
            // with status 'B'.
            for(int i = 0; i <= 1; i++){
                battlefield[boat1.getCoordinateList()[i].getRow()][boat1.getCoordinateList()[i].getCol()] = boat1.getCoordinateList()[i];
            } // Places all the boat object's cell which have been changed to status 'B' onto the board with the random coordinates
            // created in the boat class. The If statement gets the boat's coordinates and sets the board's coordinates to the boat's cell.
            boats[0] = boat1; // Adds boat object to the boats array
        }
        else if((m > 3 && m <= 4) || (m > 3 && m <= 4)){
            Boat boat1 = new Boat();
            boat1.placeBoat2(this);
            for(int i = 0; i <= 1; i++){
                battlefield[boat1.getCoordinateList()[i].getRow()][boat1.getCoordinateList()[i].getCol()] = boat1.getCoordinateList()[i];
            }
            boats[0] = boat1;
            Boat boat2 = new Boat(); // Adds another boat because this type of array requires a 2 length boat and a 3 length boat.
            boat2.placeBoat3(this);
            for(int j = 0; j <= 2; j++){
                battlefield[boat2.getCoordinateList()[j].getRow()][boat2.getCoordinateList()[j].getCol()] = boat2.getCoordinateList()[j];
            }
            boats[1] = boat2;
        }
        else if((m > 4 && m <= 6) || (m > 4 && m <= 6)){
            Boat boat1 = new Boat();
            boat1.placeBoat2(this);
            for(int i = 0; i <= 1; i++){
                battlefield[boat1.getCoordinateList()[i].getRow()][boat1.getCoordinateList()[i].getCol()] = boat1.getCoordinateList()[i];
            }
            boats[0] = boat1;
            Boat boat2 = new Boat();
            boat2.placeBoat3(this);
            for(int j = 0; j <= 2; j++){
                battlefield[boat2.getCoordinateList()[j].getRow()][boat2.getCoordinateList()[j].getCol()] = boat2.getCoordinateList()[j];
            }
            boats[1] = boat2;
            Boat boat3 = new Boat();
            boat3.placeBoat3(this);
            for(int k = 0; k <= 2; k++){
                battlefield[boat3.getCoordinateList()[k].getRow()][boat3.getCoordinateList()[k].getCol()] = boat3.getCoordinateList()[k];
            }
            boats[2] = boat3;
        }
        else if((m > 6 && m <= 8) || (m > 6 && m <= 8)){
            Boat boat1 = new Boat();
            boat1.placeBoat2(this);
            for(int i = 0; i <= 1; i++){
                battlefield[boat1.getCoordinateList()[i].getRow()][boat1.getCoordinateList()[i].getCol()] = boat1.getCoordinateList()[i];
            }
            boats[0] = boat1;
            Boat boat2 = new Boat();
            boat2.placeBoat3(this);
            for(int j = 0; j <= 2; j++){
                battlefield[boat2.getCoordinateList()[j].getRow()][boat2.getCoordinateList()[j].getCol()] = boat2.getCoordinateList()[j];
            }
            boats[1] = boat2;
            Boat boat3 = new Boat();
            boat3.placeBoat3(this);
            for(int k = 0; k <= 2; k++){
                battlefield[boat3.getCoordinateList()[k].getRow()][boat3.getCoordinateList()[k].getCol()] = boat3.getCoordinateList()[k];
            }
            boats[2] = boat3;
            Boat boat4 = new Boat();
            boat4.placeBoat4(this);
            for(int k = 0; k <= 3; k++){
                battlefield[boat4.getCoordinateList()[k].getRow()][boat4.getCoordinateList()[k].getCol()] = boat4.getCoordinateList()[k];
            }
            boats[3] = boat4;
        }
        else if((m > 8 && m <= 10) || (m > 8 && m <= 10)){
            Boat boat1 = new Boat();
            boat1.placeBoat2(this);
            for(int i = 0; i <= 1; i++){
                battlefield[boat1.getCoordinateList()[i].getRow()][boat1.getCoordinateList()[i].getCol()] = boat1.getCoordinateList()[i];
            }
            boats[0] = boat1;
            Boat boat2 = new Boat();
            boat2.placeBoat3(this);
            for(int j = 0; j <= 2; j++){
                battlefield[boat2.getCoordinateList()[j].getRow()][boat2.getCoordinateList()[j].getCol()] = boat2.getCoordinateList()[j];
            }
            boats[1] = boat2;
            Boat boat3 = new Boat();
            boat3.placeBoat3(this);
            for(int k = 0; k <= 2; k++){
                battlefield[boat3.getCoordinateList()[k].getRow()][boat3.getCoordinateList()[k].getCol()] = boat3.getCoordinateList()[k];
            }
            boats[2] = boat3;
            Boat boat4 = new Boat();
            boat4.placeBoat4(this);
            for(int k = 0; k <= 3; k++){
                battlefield[boat4.getCoordinateList()[k].getRow()][boat4.getCoordinateList()[k].getCol()] = boat4.getCoordinateList()[k];
            }
            boats[3] = boat4;
            Boat boat5 = new Boat();
            boat5.placeBoat5(this);
            for(int l = 0; l <= 4; l++){
                battlefield[boat5.getCoordinateList()[l].getRow()][boat5.getCoordinateList()[l].getCol()] = boat5.getCoordinateList()[l];
            }
            boats[4] = boat5;
        }
    }
    public void fire(String choice){
        int[] arr = new int[2];
                String[] coordinates = choice.split(" "); // Splits input of 2 string numbers with a space into an array
                for(int p = 0;p < 2; p++){
                    arr[p]=Integer.parseInt(coordinates[p]); // Adds 2 split string numbers to another array while parsing to integers
                }
                if(m < arr[0] + 1 || n < arr[1] + 1){ // Checks if the user input is greater than the max row and col they set. Plus one to
                    // account for the discrepancy of starting at zero.
                    System.out.println("Out of range. Penalty. Turn Skipped.");
                    turns++; // Skips a turn with the addition of the ++ at the bottom
                }
                else if(battlefield[arr[0]][arr[1]].get_status() == 'B'){ //(0, 0) at the top left marker of the array
                    // Checks if the user input, when inputted into the battlefield, corresponds with a cell that has status 'B'
                    System.out.println("User selects (" + arr[0] + ", " + arr[1] + "). Hit");
                    battlefield[arr[0]][arr[1]].set_status('H'); // Sets status to 'H' hit
                }
                else if(battlefield[arr[0]][arr[1]].get_status() == 'H'){ // Checks if user input when inputted into the battlefield
                    // corresponds with a cell with status 'H'
                    System.out.println("Already Hit. Penalty. Turn Skipped. ");
                    turns++;
                }
                else{
                    battlefield[arr[0]][arr[1]].set_status('M'); // Sets select status to 'M' Miss
                    System.out.println("Miss");
                }
                turns++;
    }
    public void missile(){
        boolean validCoordinate = false;
                while(validCoordinate == false){
                    System.out.println("Choose coordinates: ");
                    Scanner myScanner = new Scanner(System.in);
                    String scannerChoice = myScanner.nextLine();
                    int[] arr = new int[2];
                    String[] coordinates = scannerChoice.split(" ");
                    for(int p = 0;p < 2; p++){
                        arr[p]=Integer.parseInt(coordinates[p]); 
                    }
                    if((arr[0] > m || arr[0] < 0) ||  (arr[1] > n || arr[1] < 0)){ // Checks if chosen center point is 
                        // within the battlefield.
                        System.out.println("Coordinates for missile out of range. ");
                        continue; // Credit: My brother taught me about this method
                        // If the center point is outside, skips to the beginning of the while loop.
                    }
                    if(arr[0] + 1 < m && battlefield[arr[0] + 1][arr[1]].get_status() == 'B'){ //Checks middle right for 'B'
                        battlefield[arr[0] + 1][arr[1]].set_status('H'); // sets status to 'H' if 'B' was found
                    }
                    if(arr[0] + 1 < m && arr[1] + 1 < n && battlefield[arr[0] + 1][arr[1] + 1].get_status() == 'B'){ // Upper right
                        battlefield[arr[0] + 1][arr[1] + 1].set_status('H');
                    }
                    if(arr[1] + 1 < n && battlefield[arr[0]][arr[1] + 1].get_status() == 'B'){ // Top
                        battlefield[arr[0]][arr[1] + 1].set_status('H');
                    }
                    if(battlefield[arr[0]][arr[1]].get_status() == 'B'){ // Center
                        battlefield[arr[0]][arr[1]].set_status('H');
                    }
                    if(arr[0] - 1 >= 0 && battlefield[arr[0] - 1][arr[1]].get_status() == 'B'){ // Middle left
                        battlefield[arr[0] - 1][arr[1]].set_status('H');
                    }
                    if(arr[0] - 1 >= 0 && arr[1] - 1 >= 0 && battlefield[arr[0] - 1][arr[1] - 1].get_status() == 'B'){ // Bottom left
                        battlefield[arr[0] - 1][arr[1] - 1].set_status('H');
                    }
                    if(arr[1] - 1 >= 0 && battlefield[arr[0]][arr[1] - 1].get_status() == 'B'){ // Bottom middle
                        battlefield[arr[0]][arr[1] - 1].set_status('H');
                    }
                    if(arr[0] + 1 < m && arr[1] - 1 >= 0 && battlefield[arr[0] + 1][arr[1] - 1].get_status() == 'B'){ // Bottom left
                        battlefield[arr[0] + 1][arr[1] - 1].set_status('H');
                    }
                    if(arr[0] - 1 >= 0 && arr[1] + 1 < n && battlefield[arr[0] - 1][arr[1] + 1].get_status() == 'B'){ // Top right
                        battlefield[arr[0] - 1][arr[1] + 1].set_status('H');
                    }
                    validCoordinate = true; // Kills the loop for checking if the coordinate inputted is within the battlefield
                }
                turns++; 
    }
    public void drone(){
        boolean responseValidity = false; // Check for validity of both row/col input and row/col number input.
                while(responseValidity == false){ //To continually prompt the user to correctly input
                    System.out.println("Row or Column (row)(col): ");
                    Scanner myScanner = new Scanner(System.in);
                    String rowcol = myScanner.nextLine();
                    int boatCellCounter = 0;
                    if(rowcol.equals("row")){ // Case row
                        System.out.println("Choose Row Number: ");
                        String rowNumS = myScanner.nextLine();
                        int rowNum = Integer.parseInt(rowNumS);
                        if(rowNum > m || rowNum < 0){ // Checks if input is larger or smaller than number of rows
                            System.out.println("Error. Index out of range. ");
                            continue;
                        }
                        for(int i = 0; i < m; i++){
                            if(battlefield[rowNum][i].get_status() == 'B' || battlefield[rowNum][i].get_status() == 'H'){
                                // Checks if each element in the constant row has status 'B' or 'H'. Adds to boat counter if this is the case.
                                boatCellCounter++;
                            }
                        }
                        responseValidity = true;
                    }
                    else if(rowcol.equals("col")){ // Case column
                        System.out.println("Choose Column Number: ");
                        String colNumS = myScanner.nextLine();
                        int colNum = Integer.parseInt(colNumS);
                        if(colNum > n || colNum < 0){ // Checks if input is larger or smaller than number of columns
                            System.out.println("Error. Index out of range. ");
                            continue;
                        }
                        for(int i = 0; i < n; i++){
                            if(battlefield[i][colNum].get_status() == 'B' || battlefield[i][colNum].get_status() == 'H'){
                                boatCellCounter++;
                            }
                        }
                        responseValidity = true; // Kills while loop
                    }
                    else{
                        System.out.println("Input not one of the choices."); // Check if input isn't row or col
                        continue;
                    }
                    System.out.println("Drone has scanned " + boatCellCounter + " targets in the specified area.");
                }
    }
    public void scanner(){
        int scannerSize = 0;
                String scannerOrientation = ""; // Meant to be printed to show boat orientation
                System.out.println("Choose coordinates: "); // Meant to be printed to show size
                Scanner myScanner = new Scanner(System.in);
                String scannerChoice = myScanner.nextLine();
                int[] arr = new int[2];
                String[] coordinates = scannerChoice.split(" ");
                for(int p = 0;p < 2; p++){
                    arr[p]=Integer.parseInt(coordinates[p]);
                }
                if(battlefield[arr[0]][arr[1]].get_status() == 'B'){ // Check to make sure the coordinate point is a hit
                    for(int i = 0; i < 5; i++){
                        for(int j = 0; j < 5; j++){ // To read the boats list and compare with the elements' coordinate list. NOT battlefield
                            if(boats[i] != null){ // Prevent null pointer exception 
                                if(boats[i].coordinateList[j] != null){
                                    if(boats[i].coordinateList[j].getRow() == arr[0] && boats[i].coordinateList[j].getCol() == arr[1]){ // Check if
                                        // each boat's coordinate list contains the point the user inputs. This is meant to find the boat element in the 
                                        // boats list that was selected by the user. 
                                        scannerSize = boats[i].getBoatSize(); // Gets selected boat size and orientation.
                                        scannerOrientation = boats[i].getBoatOrientation();
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Boat Size: " + scannerSize + ", Boat orientation: " + scannerOrientation);
                    System.out.println("User selects (" + arr[0] + ", " + arr[1] + "). Hit");
                    battlefield[arr[0]][arr[1]].set_status('H');
                    turns++;
                }
                else if(battlefield[arr[0]][arr[1]].get_status() == 'H'){ // Case if the boat is already hit. No setting of status
                    for(int i = 0; i < 5; i++){
                        for(int j = 0; j < 5; j++){
                            if(boats[i] != null){
                                if(boats[i].coordinateList[j] != null){
                                    if(boats[i].coordinateList[j].getRow() == arr[0] && boats[i].coordinateList[j].getCol() == arr[1]){
                                        scannerSize = boats[i].getBoatSize();
                                        scannerOrientation = boats[i].getBoatOrientation();
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Boat Size: " + scannerSize + ", Boat orientation: " + scannerOrientation);
                    System.out.println("User selects (" + arr[0] + ", " + arr[1] + "). Already Hit");
                    turns++;
                }
    }
    public void printBattlefield(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(battlefield[i][j].get_status()); // Prints status of the cells into a 2D graph 
            }
            System.out.println();
        }
    }
}
