import java.util.Scanner;

public class Fibonacci {

    public static int fibonacciRecursive(int n){
        if((n==0||n==1)){
            return n;
        }
        else{
            return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
        }
    }

    public static int fibonacciIterative(int n){
        int sum = 0, second = 0, first = 1;
        if(n>0){
            for(int i = 1; i<=n; i++){
                sum = second + first;
                first = second;
                second = sum;
            }
        }
        return sum;
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = s.nextInt();
        System.out.println("The " + n + "th Fibonacci number using fibonacciRecursive is " + fibonacciRecursive(n));
        System.out.println("The " + n + "th Fibonacci number using fibonacciIterative is " + fibonacciIterative(n));

    }

}
