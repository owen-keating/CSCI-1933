// Written by Owen Keating, keati090

import java.util.Scanner;

public class Game {

    /*  enter_coordinates() is a helper function used on turns when the player has to enter in coordinates to attack
        enter_coordinates() prevents errors while using Scanner and separates the row and column coordinates
     */
    public static int[] enter_coordinates(){
        int[] arr = new int[2];
        Scanner s = new Scanner(System.in);
        boolean works = false;
        while(!works){
            try{
                System.out.print("Enter coordinates in the form 'row,column': ");
                String[] c = s.nextLine().split(",");
                arr[0] = Integer.parseInt(c[0]);
                arr[1] = Integer.parseInt(c[1]);
                works = true;
            }catch(IndexOutOfBoundsException e){
                System.out.println("Invalid coordinates");
            }catch(NumberFormatException e){
                System.out.println("Invalid coordinates");
            }
        }
        return arr;
    }

    /*  turn() simulates one turn by a player during the game
        turn() starts by displaying the debugging view if it is set to do so, followed by a player view
        of the grid regardless of if the game is in the debugging mode or not
        turn() navigates the player through their possible moves including (f)ire, (m)issile, (d)rone, and (s)ubmarine
        turn() calls the appropriate method in the Board class and then increments the turns variable
     */
    public static void turn(Board b, boolean mode){
        Scanner s = new Scanner(System.in);
        if(mode){
            System.out.println("Debugging View");
            b.print();
            System.out.println("Player View");
        }
        b.display();
        System.out.println("Turn " + b.getTurns() + " - Remaining boats: " + b.getRemaining_boats() + " - Remaining powers: " + b.getRemaining_powers());
        System.out.print("Enter 'p' for Power, 'f' for Fire: ");
        String str = s.nextLine();
        while(str.equals("")||(str.charAt(0)!='f'&&str.charAt(0)!='F'&&str.charAt(0)!='p'&&str.charAt(0)!='P')){
            System.out.println("Invalid command");
            System.out.println("Turn " + b.getTurns() + " - Remaining boats: " + b.getRemaining_boats() + " - Remaining powers: " + b.getRemaining_powers());
            System.out.print("Enter 'p' for Power, 'f' for Fire: ");
            str = s.nextLine();
        }
        if(str.charAt(0)=='f'||str.charAt(0)=='F') {
            int[] temp = enter_coordinates();
            b.fire(temp[0], temp[1]);
            b.setTurns(b.getTurns()+1);
        }
        else if(b.getRemaining_powers()==0){
            System.out.println("No powers remaining");
        }
        else{
            System.out.print("Enter 'm' for Missile, 'd' for Drone, or 's' for Submarine: ");
            String attack = s.nextLine();
            while(attack.equals("")||(attack.charAt(0)!='m'&&attack.charAt(0)!='M'&&attack.charAt(0)!='d'&&attack.charAt(0)!='D'&&attack.charAt(0)!='s'&&attack.charAt(0)!='S')){
                System.out.println("Invalid command");
                System.out.print("Enter 'm' for Missile, 'd' for Drone, or 's' for Submarine: ");
                attack = s.nextLine();
            }
            if(attack.charAt(0)=='m'||attack.charAt(0)=='M'){
                int[] temp = enter_coordinates();
                while(temp[0]>=b.getSize()||temp[0]<0||temp[1]>=b.getSize()||temp[1]<0){
                    System.out.println("Invalid coordinates");
                    temp = enter_coordinates();
                }
                b.missile(temp[0],temp[1]);
                b.setTurns(b.getTurns()+1);
            }
            else if(attack.charAt(0)=='d'||attack.charAt(0)=='D'){
                b.drone();
                b.setTurns(b.getTurns()+1);
            }
            else{
                int[] temp = enter_coordinates();
                while(temp[0]>=b.getSize()||temp[0]<0||temp[1]>=b.getSize()||temp[1]<0){
                    System.out.println("Invalid coordinates");
                    temp = enter_coordinates();
                }
                b.submarine(temp[0],temp[1]);
                b.setTurns(b.getTurns()+1);
            }
        }
    }

    /*  main() creates a Scanner object and then asks the player for their desired difficulty level
        main() also asks the user about their preference in entering the debugging mode
        main() then initializes a new Board object and simulates turns using the turn() method
        until the board has been cleared of all boats, ending by printing out the total number of turns
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("Battleboats Game");
        System.out.println("----------------------------------------------");
        System.out.println("What Difficulty Would You Like To Play On?");
        int level = 0;
        while(level==0){
            System.out.print("Enter '1' For Beginner, '2' For Intermediate, '3' For Expert: ");
            try{
                level = Integer.parseInt(s.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Invalid Difficulty");
                continue;
            }
            if(level!=1 && level!=2 && level!=3){
                level = 0;
                System.out.println("Invalid Difficulty");
            }
        }
        System.out.print("Would you like to enter the debugging mode? Enter 'y' or 'n': ");
        String debug = s.nextLine();
        while(debug.equals("")||(debug.charAt(0)!='y')&&debug.charAt(0)!='Y'&&debug.charAt(0)!='n'&&debug.charAt(0)!='N'){
            System.out.println("Invalid response");
            System.out.print("Would you like to enter the debugging mode? Enter 'y' or 'n': ");
            debug = s.nextLine();
        }
        boolean mode = false;
        if(debug.charAt(0)=='y'||debug.charAt(0)=='Y'){ mode = true; }
        Board b = new Board(level);
        while(b.getRemaining_boats()>0){ turn(b, mode); }
        b.display();
        b.setTurns(b.getTurns()-1);
        System.out.println("You won after " + b.getTurns() + " turns!");
    }

}
