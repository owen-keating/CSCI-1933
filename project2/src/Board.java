// Written by Owen Keating, keati090

public class Board {

    //  instance variables
    private int size;
    private int turns;
    private int remaining_boats;
    private int remaining_powers;
    private Cell[][] cells;
    private Boat[] boats;

    //  constructor
    public Board(int level){
        turns = 1;
        size = level*3;
        remaining_boats = 0;
        cells = new Cell[size][size];
        for(int i = 0; i<level*3; i++){
            for(int j = 0; j<level*3; j++){
                cells[i][j] = new Cell(i,j,'-');
            }
        }
        placeBoats(level);
        remaining_powers = remaining_boats;
    }

    //  accessor methods
    public int getSize(){ return size; }
    public int getRemaining_boats(){ return remaining_boats; }
    public int getRemaining_powers(){ return remaining_powers; }
    public int getTurns(){ return turns; }

    //  modifier methods
    public void setSize(int s){ size = s; }
    public void setRemaining_boats(int r){ remaining_boats = r; }
    public void setRemaining_powers(int r){ remaining_powers = r; }
    public void setTurns(int t){ turns = t; }

    /*  coordinates() is called by initBoat whenever a new Boat is being initialized
        coordinates() returns a 2 item array of integers representing a possible row and column
     */
    public int[] coordinates(int len, double rows, boolean al){
        int[] arr = new int[2];
        if(al){
            arr[0] = (int)Math.floor(Math.random()*(rows-len+1));
            arr[1] = (int)Math.floor(Math.random()*rows);
        }
        else{
            arr[0] = (int)Math.floor(Math.random()*rows);
            arr[1] = (int)Math.floor(Math.random()*(rows-len+1));
        }
        return arr;
    }

    /*  alignment() is called by several methods and used to randomize select between the
        vertical and horizontal directions
     */
    public boolean alignment(){
        int rand = (int)Math.floor(Math.random()*2.0);
        if(rand==0){ return true; }
        else{ return false; }
    }

    /*  addToGrid() is called when a new Boat object has found coordinates that will allow
        it to be placed without being restricted by out-of-bounds or other Boats
     */
    public void addToGrid(int x){
        Cell[] temp = boats[x].getCells();
        for(int i = 0; i<temp.length; i++){
            int r = temp[i].getRow();
            int c = temp[i].getCol();
            cells[r][c].setStatus('B');
        }
    }

    /*  checkSpace() is called when a new Boat object is being initialized
        checkSpace() takes in a random alignment parameter, a length parameter and a pair of coordinates
        it checks to see if the new Boat will fit on the grid based on the given parameters
     */
    public boolean checkSpace(int len, int r, int c, boolean al){
        for(int i = 0; i<len; i++){
            if(cells[r][c].getStatus()=='B'){ return false; }
            if(al && r<(cells.length-1)){ r++; }
            if(!al && c<(cells.length-1)){ c++; }
        }
        return true;
    }

    /*  initBoat() is called between 1 and 5 times based on the difficulty that is being played
        initBoat() calls the alignment() and coordinates() methods in order to collect parameters
        that can be used in the checkSpace() method
     */
    public void initBoat(boolean open, int len, int num){
        while(!open){
            boolean align = alignment();
            int[] c = coordinates(len,1.0*cells.length, align);
            open = checkSpace(len,c[0],c[1],align);
            boats[num] = new Boat(len,align,c[0],c[1]);
        }
        addToGrid(num);
    }

    /*  placeBoats() is called by the constructor when a new Board object is created
        placeBoats() calls the initBoat() method multiple times based on the difficulty being played
        placeBoats() also initializes the number for remaining_boats on the board
     */
    public void placeBoats(int n){
        boats = new Boat[5];
        initBoat(false,2,0); remaining_boats++;
        if(n>1){ initBoat(false,3,1); initBoat(false,4,3); remaining_boats+=2; }
        if(n>2){ initBoat(false,3,2); initBoat(false,5,4); remaining_boats+=2; }
    }

    /*  checkBoat() is called by the fire() method whenever a Boat object is hit
        checkBoat() takes in an index of Cell objects representing the Boat that has been hit
        checkBoat() determines if the Boat that has been fired upon has been sunk or not
     */
    public void checkBoat(Cell[] b){
        boolean check = true;
        for(int i = 0; i<b.length; i++){
            if(cells[b[i].getRow()][b[i].getCol()].getStatus()!='H'){ check = false; }
        }
        if(check){ System.out.println("Boat Sunk!"); remaining_boats--; }
    }

    /*  fire() is called from main on turns when the player selects to fire rather than use a power
        fire() first determines if the coordinates from main match with those of a Boat Cell
        if a match is found, checkBoat() is called in order to see if the Boat will be sunk
        if not, the player may either miss or be penalized for firing at a previous target
     */
    public void fire(int x, int y){
        if(x<0||x>=cells.length||y<0||y>=cells.length){
            System.out.println("Penalized for firing out-of-bounds at " + x + "," + y);
            turns++;
            System.out.println("Turn " + turns + " - Skipped");
        }
        else if(cells[x][y].getStatus()=='B'){
            System.out.println("Firing at " + x + "," + y + " Hit!");
            cells[x][y].setStatus('H');
            for(int i = 0; i<boats.length; i++){
                if(boats[i]!=null){
                    Cell[] temp = boats[i].getCells();
                    for(int j = 0; j<temp.length; j++){
                        if(temp[j].getRow()==x && temp[j].getCol()==y){
                            checkBoat(temp);
                        }
                    }
                }
            }
        }
        else if(cells[x][y].getStatus()=='-'){
            System.out.println("Firing at " + x + "," + y + " Missed!");
            cells[x][y].setStatus('M');
        }
        else{
            System.out.println("Penalized for re-firing at " + x + "," + y);
            turns++;
            System.out.println("Turn " + turns + " - Skipped");
        }
    }

    /*  display() is called from main once every player turn
        display() shows the grid view that the player has during a given round
     */
    public void display(){
        for(int i = 0; i<cells.length; i++){
            for(int j = 0; j<cells.length; j++){
                if(cells[i][j].getStatus()!='B'){
                    System.out.print(cells[i][j].getStatus() + " ");
                }
                else{
                    System.out.print('-' + " ");
                }
            }
            System.out.print(i + "\n");
        }
        for(int i = 0; i<cells.length; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*  findLength() is called by print() in order to replace 'B's with length numbers
        findLength() is used in order to differentiate between the different Boats on the grid
     */
    public int findLength(int x, int y){
        for(int i = 0; i<cells.length; i++){
            if(boats[i]!=null){
                Cell[] temp = boats[i].getCells();
                for(int j = 0; j<temp.length; j++){
                    if(temp[j].getRow()==x && temp[j].getCol()==y){
                        return temp.length;
                    }
                }
            }
        }
        return 0;
    }

    /*  print() is called from main once every player turn if the game is in the debugging mode
        print() does not display the row and column numbers similar to display() because the
        'B' icons that represent boats are replaced with length numbers from findLength()
        this ensures that users do not get confused between the playing field and the row/column
        numbers when referencing the debugging feature
     */
    public void print(){
        for(int i = 0; i<cells.length; i++){
            for(int j = 0; j<cells.length; j++){
                if(cells[i][j].getStatus()!='B'){
                    System.out.print(cells[i][j].getStatus() + " ");
                }
                else{
                    System.out.print(findLength(i,j) + " ");
                }
            }
            System.out.println();
        }
    }

    /*  missile() is called from main on turns when the player decides to use a power on a missile attack
        missile() attacks a 3x3 area on the grid (unless it is on the borders) and uses one power unit
     */
    public void missile(int x, int y){
        for(int i = -1; i<2; i++){
            for(int j = -1; j<2; j++){
                int r = x+i;
                int c = y+j;
                if(r>=0 && r<cells.length && c>=0 && c<cells.length){
                    if(cells[r][c].getStatus()=='-'||cells[r][c].getStatus()=='B'){
                        fire(r,c);
                    }
                }
            }
        }
        remaining_powers--;
    }

    /*  drone() is called from main on turns when the player decides to use a power on a drone mission
        drone() scans a random row or column and gives the player information about how many boat cells
        exist in the given area
     */
    public void drone(){
        int count = 0;
        boolean align = alignment();
        if(align){
            int y = (int)Math.floor(Math.random()*size*1.0);
            for(int i = 0; i<size; i++){
                if(cells[i][y].getStatus()=='B'||cells[i][y].getStatus()=='H'){ count++; }
            }
            System.out.println("Drone has scanned " + count + " targets in column " + y);
        }
        else{
            int x = (int)Math.floor(Math.random()*size*1.0);
            for(int i = 0; i<size; i++){
                if(cells[x][i].getStatus()=='B'||cells[x][i].getStatus()=='H'){ count++; }
            }
            System.out.println("Drone has scanned " + count + " targets in row " + x);
        }
        remaining_powers--;
    }

    /*  submarine() is called from main on turns when the player decides to use a power on a submarine strike
        submarine() fires at one only coordinate, but will sink the entire boat if it successfully hits
     */
    public void submarine(int x, int y){
        if(cells[x][y].getStatus()=='B'||cells[x][y].getStatus()=='H'){
            int bt = 0;
            for(int i = 0; i<boats.length; i++){
                if(boats[i]!=null){
                    Cell[] temp = boats[i].getCells();
                    for(int j = 0; j<temp.length; j++){
                        if(temp[j].getRow()==x && temp[j].getCol()==y){
                            bt = i;
                        }
                    }
                }
            }
            Cell[] targets = boats[bt].getCells();
            for(int i = 0; i<targets.length; i++){
                int row = targets[i].getRow();
                int col = targets[i].getCol();
                fire(row,col);
            }
        }
        else{
            cells[x][y].setStatus('M');
            System.out.println("Firing at " + x + "," + y + " Missed!");
        }
        remaining_powers--;
    }

}
