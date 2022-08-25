// Written by Joshua Li, li002380
import java.lang.Math;

public class Boat {
    private int boatSize = 0;
    private String boatOrientation = "Vertical"; 
    public Cell[] coordinateList; // List of cells per each boat class. Used to access row and cols for each sell by getters and setters
    public void placeBoat2(Board board){
        boolean valid = false; // Variable to ensure the coordinate point used at the top left is valid when adding
        // either constant 1, 2, 3, or 4 to it when making the length of the boat.
        coordinateList = new Cell[5]; // Presets all cell lengths at the maximum 5.
        while(valid == false){
            int randomX1 = (int)Math.floor(Math.random()*(board.getM()));
            int randomY1 = (int)Math.floor(Math.random()*(board.getN())); // Gets random two coordinate points x and y
            // for m and n of the board class respectively.
            int direction = (int)Math.floor(Math.random()*(2)); // Random direction between 0 and 1 
            // of adding to the horizontal or vertical.
            coordinateList[0] = new Cell(randomX1, randomY1, 'B');
            if(direction == 0) {
                if(board.getM() > randomX1 + 1){
                    if(board.getBattlefield()[randomX1 + 1][randomY1].get_status() == '-' && board.getBattlefield()[randomX1][randomY1].get_status() == '-'){
                        coordinateList[1] = new Cell(randomX1 + 1, randomY1, 'B'); // Adds 1 to fill the length of the boat
                        boatSize = 2; 
                        valid = true; // Set true only if last length of the boat is within m or n range
                    }
                }
            }
            else if(direction == 1){
                if(board.getN() > randomY1 + 1){
                    if(board.getBattlefield()[randomX1][randomY1 + 1].get_status() == '-' && board.getBattlefield()[randomX1][randomY1].get_status() == '-'){
                        coordinateList[1] = new Cell(randomX1, randomY1 + 1, 'B');
                        boatSize = 2;
                        boatOrientation = "Horizontal";
                        valid = true;
                    }
                }
            }
        }
    }
    public void placeBoat3(Board board){
        boolean valid = false;
        coordinateList = new Cell[5];
        while(valid == false){
            int randomX1 = (int)Math.floor(Math.random()*(board.getM()));
            int randomY1 = (int)Math.floor(Math.random()*(board.getN()));
            int direction = (int)Math.floor(Math.random()*(2));
            coordinateList[0] = new Cell(randomX1, randomY1, 'B');
            if(direction == 0) {
                if(board.getM() > randomX1 + 2){
                    if(board.getBattlefield()[randomX1 + 1][randomY1].get_status() == '-' && board.getBattlefield()[randomX1 + 2][randomY1].get_status() == '-'
                    && board.getBattlefield()[randomX1][randomY1].get_status() == '-'){
                        coordinateList[1] = new Cell(randomX1 + 1, randomY1, 'B');
                        coordinateList[2] = new Cell(randomX1 + 2, randomY1, 'B');
                        boatSize = 3;
                        valid = true;
                    }
                }
            }
            else if(direction == 1){
                if(board.getN() > randomY1 + 2){
                    if(board.getBattlefield()[randomX1][randomY1 + 1].get_status() == '-' && board.getBattlefield()[randomX1][randomY1 + 2].get_status() == '-'
                    && board.getBattlefield()[randomX1][randomY1].get_status() == '-'){
                        coordinateList[1] = new Cell(randomX1, randomY1 + 1, 'B');
                        coordinateList[2] = new Cell(randomX1, randomY1 + 2, 'B');
                        boatSize = 3;
                        boatOrientation = "Horizontal";
                        valid = true;
                    }
                }
            }
        }
    }
    public void placeBoat4(Board board){
        boolean valid = false;
        coordinateList = new Cell[5];
        while(valid == false){
            int randomX1 = (int)Math.floor(Math.random()*(board.getM()));
            int randomY1 = (int)Math.floor(Math.random()*(board.getN()));
            int direction = (int)Math.floor(Math.random()*(2));
            coordinateList[0] = new Cell(randomX1, randomY1, 'B');
            if(direction == 0) {
                if(board.getM() > randomX1 + 3){
                    if(board.getBattlefield()[randomX1 + 1][randomY1].get_status() == '-' && board.getBattlefield()[randomX1 + 2][randomY1].get_status() == '-'
                    && board.getBattlefield()[randomX1 + 3][randomY1].get_status() == '-' && board.getBattlefield()[randomX1][randomY1].get_status() == '-'){
                        coordinateList[1] = new Cell(randomX1 + 1, randomY1, 'B');
                        coordinateList[2] = new Cell(randomX1 + 2, randomY1, 'B');
                        coordinateList[3] = new Cell(randomX1 + 3, randomY1, 'B');
                        boatSize = 4;
                        valid = true;
                    }
                }
            }
            else if(direction == 1){
                if(board.getN() > randomY1 + 3){
                    if(board.getBattlefield()[randomX1][randomY1 + 1].get_status() == '-' && board.getBattlefield()[randomX1][randomY1 + 2].get_status() == '-'
                    && board.getBattlefield()[randomX1][randomY1 + 3].get_status() == '-' && board.getBattlefield()[randomX1][randomY1].get_status() == '-'){
                        coordinateList[1] = new Cell(randomX1, randomY1 + 1, 'B');
                        coordinateList[2] = new Cell(randomX1, randomY1 + 2, 'B');
                        coordinateList[3] = new Cell(randomX1, randomY1 + 3, 'B');
                        boatSize = 4;
                        boatOrientation = "Horizontal";
                        valid = true;
                    }
                }
            }
        }
    }
    public void placeBoat5(Board board){
        boolean valid = false;
        coordinateList = new Cell[5];
        while(valid == false){    
            int randomX1 = (int)Math.floor(Math.random()*(board.getM()));
            int randomY1 = (int)Math.floor(Math.random()*(board.getN()));
            int direction = (int)Math.floor(Math.random()*(2));
            coordinateList[0] = new Cell(randomX1, randomY1, 'B');
            if(direction == 0) {
                if(board.getM() > randomX1 + 4){
                    if(board.getBattlefield()[randomX1 + 1][randomY1].get_status() == '-' && board.getBattlefield()[randomX1 + 2][randomY1].get_status() == '-'
                    && board.getBattlefield()[randomX1 + 3][randomY1].get_status() == '-' && board.getBattlefield()[randomX1 + 4][randomY1].get_status() == '-'
                    && board.getBattlefield()[randomX1][randomY1].get_status() == '-'){
                        coordinateList[1] = new Cell(randomX1 + 1, randomY1, 'B');
                        coordinateList[2] = new Cell(randomX1 + 2, randomY1, 'B');
                        coordinateList[3] = new Cell(randomX1 + 3, randomY1, 'B');
                        coordinateList[4] = new Cell(randomX1 + 4, randomY1, 'B');
                        boatSize = 5;
                        valid = true;
                    }
                }
            }
            else if(direction == 1){
                if(board.getN() > randomY1 + 4){
                    if(board.getBattlefield()[randomX1][randomY1 + 1].get_status() == '-' && board.getBattlefield()[randomX1][randomY1 + 2].get_status() == '-'
                    && board.getBattlefield()[randomX1][randomY1 + 3].get_status() == '-' && board.getBattlefield()[randomX1][randomY1 + 4].get_status() == '-'
                    && board.getBattlefield()[randomX1][randomY1].get_status() == '-'){
                        coordinateList[1] = new Cell(randomX1, randomY1 + 1, 'B');
                        coordinateList[2] = new Cell(randomX1, randomY1 + 2, 'B');
                        coordinateList[3] = new Cell(randomX1, randomY1 + 3, 'B');
                        coordinateList[4] = new Cell(randomX1, randomY1 + 4, 'B');
                        boatSize = 5;
                        boatOrientation = "Horizontal";
                        valid = true;
                    }
                }
            }
        }
    }
    public int getBoatSize(){
        return boatSize;
    }
    public String getBoatOrientation(){
        return boatOrientation;
    }
    public Cell[] getCoordinateList(){
        return coordinateList;
    }
    public boolean sinkStatus(){ //Checks whether a boat class has sunk using the coordinate list above. If all 
    //cells have status 'H', then it returns true the boat has sunk.
        int check = 0;
        for(int i = 0; i < coordinateList.length; i++){
            if(coordinateList[i] != null){   
                if(coordinateList[i].get_status() == 'H'){
                    check++;
                }
            }
        }
        if(check == boatSize){
            return true;
        }
        return false;
    }
}
