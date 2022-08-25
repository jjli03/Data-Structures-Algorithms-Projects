// Written by Joshua Li, li002380
public class Cell{
    public int row;
    public int col;
    public char status;
    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = status;
    }
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.status = '-'; // Base status is no boat.
    }
    public char get_status(){
        return status;
    }
    public void set_status(char c){
        this.status = c;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public void setRow(int newR){
        row = newR;
    }
    public void setCol(int newC){
        col = newC;
    }
}