// Written by Owen Keating, keati090

public class Cell {

    //  instance variables
    private int row;
    private int col;
    private char status;

    //  constructor
    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = status;
    }

    //  accessor methods
    public int getRow(){ return row; }
    public int getCol(){ return col; }
    public char getStatus(){ return status; }

    //  modifier methods
    public void setRow(int r){ row = r; }
    public void setCol(int c){ col = c; }
    public void setStatus(char s){ status = s; }

}
