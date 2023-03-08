// Written by Owen Keating, keati090

public class Boat {

    //  instance variables
    private int size;
    private boolean align;
    private Cell[] loc;

    //  constructor
    public Boat(int len, boolean al, int a, int b){
        size = len;
        align = al;
        loc = new Cell[size];
        initCells(a,b);
    }

    //  accessor methods
    public int getSize(){ return size; }
    public boolean getAlign(){ return align; }
    public Cell[] getCells(){ return loc; }

    //  modifier methods
    public void setSize(int s){ size = s; }
    public void setAlign(boolean a){ align = a; }

    /*  initCells() is called by the constructor when a Boat object is initialized
        initCells() creates as many new cells as the length of the Boat
        each cell's status is set to 'B' and is given a set of coordinates
     */
    public void initCells(int a, int b){
        for(int i = 0; i<size; i++){
            if(align){
                loc[i] = new Cell(a,b,'B');
                a++;
            }
            else{
                loc[i] = new Cell(a,b,'B');
                b++;
            }
        }
    }

}
