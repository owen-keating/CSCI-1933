import java.util.Scanner;

public class MaxDigit {

    public static int recursiveMaxDigit(int num){
        if(num/10==0){
            return num;
        }
        else if(num/100==0){
            if(num/10>num%10){
                return num/10;
            }
            else{
                return num%10;
            }
        }
        else{
            if(recursiveMaxDigit(num/10)>recursiveMaxDigit(num%10)){
                return recursiveMaxDigit(num/10);
            }
            else{
                return recursiveMaxDigit(num%10);
            }
        }
    }

    public static int iterativeMaxDigit(int num){
        int x = num/10%10, y = num%10, z = num;
        while(z/10!=0){
            if(z/10%10>x){
                x=z/10%10;
            }
            if(z%10>y){
                y=z%10;
            }
            z/=10;
        }
        if(x>y){
            return x;
        }
        else{
            return y;
        }
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = s.nextInt();
        System.out.println("The maximum digit in " + num + " using recursiveMaxDigit is " + recursiveMaxDigit(num));
        System.out.println("The maximum digit in " + num + " using iterativeMaxDigit is " + iterativeMaxDigit(num));

    }
}
