// Written by Owen Keating, keati090

import java.util.Scanner;

public class MyMaze{
    Cell[][] maze;
    int startRow;
    int endRow;

    public MyMaze(int rows, int cols, int startRow, int endRow) {
        this.startRow = startRow;
        this.endRow = endRow;
        maze = new Cell[rows][cols];
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                maze[i][j] = new Cell();
            }
        }
    }

    public static MyMaze makeMaze(int level) {
        int rows = 0; int cols = 0;
        if(level==1){ rows = 5; cols = 5; }
        if(level==2){ rows = 5; cols = 20; }
        if(level==3){ rows = 20; cols = 20; }
        int startRow = (int)Math.floor(Math.random()*rows);
        int endRow = (int)Math.floor(Math.random()*rows);
        MyMaze maze1 = new MyMaze(rows,cols,startRow,endRow);
        Stack1Gen<int[]> stack = new Stack1Gen<>();
        int[] enter = {maze1.startRow, 0};
        stack.push(enter);
        while (!stack.isEmpty()) {
            int[] cell = stack.top();
            int row = cell[0]; int col = cell[1];
            maze1.maze[cell[0]][cell[1]].setVisited(true);
            boolean up = false; boolean down = false; boolean left = false; boolean right = false;
            if(row>0 && !(maze1.maze[row-1][col].getVisited())) up = true;
            if(row<maze1.maze.length-1 && !(maze1.maze[row+1][col].getVisited())) down = true;
            if(col>0 && !(maze1.maze[row][col-1].getVisited())) left = true;
            if(col<maze1.maze[0].length-1 && !(maze1.maze[row][col+1].getVisited())) right = true;
            if (!(up || down || left || right)){
                stack.pop();
                continue;
            }
            boolean visit = false;
            while(!visit){
                visit = true;
                int r = (int)Math.floor(Math.random()*4);
                if(r==0 && up){
                    stack.push(new int[]{row-1,col});
                    maze1.maze[row-1][col].setBottom(false);
                }
                else if(r==1 && down){
                    stack.push(new int[]{row+1,col});
                    maze1.maze[row][col].setBottom(false);
                }
                else if(r==2 && left){
                    stack.push(new int[]{row,col-1});
                    maze1.maze[row][col-1].setRight(false);
                }
                else if(right){
                    stack.push(new int[]{row,col+1});
                    maze1.maze[row][col].setRight(false);
                }
                else visit = false;
            }
        }
        for(int i = 0; i < maze1.maze.length; i++){
            for (int j = 0; j < maze1.maze[0].length; j++) maze1.maze[i][j].setVisited(false);
        }
        return maze1;
    }

    public void printMaze() {
        for(int i = 0; i<maze.length; i++){
            String first = "|";
            for(int j = 0; j<maze[0].length; j++){
                if(i==0) first += "---|";
                else{
                    if(maze[i-1][j].getBottom()) first += "---";
                    else first += "   ";
                    first += "|";
                }
            }
            System.out.println(first);
            String second = " ";
            if(i!=startRow) second = "|";
            for(int j = 0; j<maze[0].length; j++){
                if(maze[i][j].getVisited()) second += " * ";
                else second += "   ";
                if(!(i==endRow && j==maze[0].length-1)){
                    if(maze[i][j].getRight()) second += "|";
                    else second += " ";
                }
            }
            System.out.println(second);
        }
        String bottom = "|";
        for(int j = 0; j<maze[0].length; j++){
            bottom += "---|";
        }
        System.out.println(bottom);
    }

    public void solveMaze() {
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("What Level Maze Do You Want To Solve?");
        int level = 0;
        while(level==0){
            System.out.print("Enter '1' For 5x5, '2' For 5x20, '3' for 20x20: ");
            try{
                level = Integer.parseInt(s.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Invalid Level");
                continue;
            }
            if(level!=1 && level!=2 && level!=3){
                level = 0;
                System.out.println("Invalid Level");
            }
        }
        MyMaze maze1 = makeMaze(level);
        maze1.printMaze();
    }
}
