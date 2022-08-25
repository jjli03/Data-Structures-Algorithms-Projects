// Written by Joshua Li, li002380
import java.util.Scanner;
import javax.swing.BoxLayout;

public class Game {
    public static void main(String[] agrs) {
        System.out.println("Input dimension rows: ");
		Scanner myScanner = new Scanner(System.in);
		String rows  = myScanner.nextLine();
        int m = Integer.parseInt(rows);
        if(m < 3) {
            System.out.println("Input too small.");
            return;
        }
        else if(m > 10) {
            System.out.println("Input too large.");
            return;
        }
        System.out.println("Input dimension columns: ");
        String cols = myScanner.nextLine();
        int n = Integer.parseInt(cols);
        if(n < 3) {
            System.out.println("Input too small.");
            return;
        }
        else if(n > 10) {
            System.out.println("Input too large.");
            return;
        }
        System.out.println("Enter mode (debug)(gamer): ");
        String debugger = myScanner.nextLine();
        boolean debug = false; // Determines whether or not the debugger method will happen
        if(debugger.equals("debug")){
            debug = true; // Debug will happen
        }
        else if(debugger.equals("gamer")){
            debug = false;
        }
        Board tester = new Board(m, n);
        Boat[] boatStatus = tester.boats;
        tester.placeBoats();
        while(true && debug == true){ // Debug will happen and the board is printed out after each while iteration/turn
            tester.printBattlefield();
            int cellChecker = 0; // To determine how many cells on the board are still status 'B'. This is meant to mark the end 
            // of the game, turns, and user input/the program. 
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){ // Runs through battlefield
                    if(tester.getBattlefield()[i][j].get_status() == 'B'){
                        cellChecker += 1;
                    }
                }
            }
            for(int p = 0; p < 5; p++){
                if(boatStatus[p] != null){
                    if(boatStatus[p].sinkStatus() == true){ // Checks if any of the boat elements in a clone of boats
                        // have been sunk. This means their entire compliment of cells is status 'H'.
                        boatStatus[p] = null;
                        System.out.println("Boat sunk.");
                    }
                }
            }
            if(cellChecker == 0){ // Kills the while loop
                break; 
            }
            System.out.println("Turn " + tester.turns + ": ");
            String choice = myScanner.nextLine();
            if(choice.equals("missile")){ // Missile case
                tester.missile();
            }
            else if(choice.equals("drone")){ // Drone case
                tester.drone();
            }
            else if(choice.equals("scanner")){ // Scanner case
                tester.scanner();
            }
            else{ // Fire case
                tester.fire(choice);
            }
        }
        while(true && debug == false){ // Debug won't happen
            int cellChecker = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(tester.getBattlefield()[i][j].get_status() == 'B'){
                        cellChecker += 1;
                    }
                }
            }
            for(int p = 0; p < 5; p++){
                if(boatStatus[p] != null){
                    if(boatStatus[p].sinkStatus() == true){
                        boatStatus[p] = null;
                        System.out.println("Boat sunk.");
                    }
                }
            }
            if(cellChecker == 0){
                break;
            }
            System.out.println("Turn " + tester.turns + ": ");
            String choice = myScanner.nextLine();
            if(choice.equals("missile")){
                tester.missile();
            }
            else if(choice.equals("drone")){
                tester.drone();
            }
            else if(choice.equals("scanner")){
                tester.scanner();
            }
            else{
                tester.fire(choice);
            }
        }
    }
}
