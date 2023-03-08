import java.util.Scanner;

public class Histogram {

    private int[] graph;
    private int lower;
    private int upper;

    public Histogram(int lowerbound, int upperbound){
        if(upperbound<lowerbound){
            lower = upperbound;
            upper = lowerbound;
        }
        else{
            lower = lowerbound;
            upper = upperbound;
        }
        graph = new int[upper+1];
        for(int i=0; i<=upper; i++){
            graph[i] = 0;
        }
    }

    public boolean add(int i){
        if(i>=lower && i<=upper){
            graph[i]++;
            return true;
        }
        else{
            System.out.println(i + " is not in the range");
            return false;
        }
    }

    public String toString(){
        String str = "";
        for(int i = lower; i<upper+1; i++){
            str = str + i + " ";
            for(int j = 0; j<graph[i]; j++){
                str = str + "*";
            }
            if(i<upper){
                str = str + "\n";
            }
        }
        return str;
    }

    // milestone 4

    public static void main(String[] args){

        int a, b, c = 0;
        Scanner s = new Scanner(System.in);

        System.out.println("\nCommands:");
        System.out.println("add - used to add numbers to the histogram");
        System.out.println("print - displays the histogram on the screen");
        System.out.println("quit - leaves the program\n");
        System.out.print("Enter a range of positive integers: ");
        a = s.nextInt();
        b = s.nextInt();
        String space = s.nextLine();
        Histogram histo = new Histogram(a,b);
        String str = s.nextLine();

        while(str.charAt(0)!='q'){
            if(str.charAt(0)=='p'){
                System.out.println(histo);;
            }
            else if(str.charAt(0)=='a'){
                System.out.print("Enter numbers: ");
                while(s.hasNextInt()){
                    c = s.nextInt();
                    histo.add(c);
                }
                space = s.nextLine();
            }
            else{
                System.out.println("Invalid command.");
            }
            str = s.nextLine();
        }
        System.out.println("Bye!");

    }

    // milestone 3

    /*public static void main(String[] args){

        Histogram histo = new Histogram(0,5);
        histo.add(3);
        histo.add(2);
        histo.add(1);
        histo.add(2);
        histo.add(3);
        histo.add(0);
        histo.add(1);
        histo.add(5);
        histo.add(3);
        System.out.println(histo);

    }*/

}
