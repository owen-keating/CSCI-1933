import java.util.Scanner;

public class Application {

    public static void main(String[] args){

        // milestone 4

        /*Scanner s = new Scanner(System.in);
        double r, ra;
        System.out.print("Radius? ");
        r = s.nextDouble();
        ApplicationClass a = new ApplicationClass(r);
        System.out.println("Area: " + a.getArea());
        System.out.println("Diameter: " + a.getDiameter());
        System.out.println("Circumference: " + a.getCircumference());
        System.out.print("Enter a new radius: ");
        ra = s.nextDouble();
        ApplicationClass n = new ApplicationClass(ra);
        boolean b = a.equals(n);
        System.out.print("The circles ");
        if(b==false){
            System.out.print("do not ");
        }
        System.out.println("have equal radii");*/

        // milestone 3

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int len = str.length();
        ApplicationClass a = new ApplicationClass(str, len);
        System.out.println(a.isPalindrome());

        // milestone 2

        /*String str;
        Scanner s = new Scanner(System.in);
        str = s.nextLine();

        char a, b, c;
        int x = 0;
        int y = 0;
        int len = 0;
        c = str.charAt(x);
        len = str.length();
        for(int i = 0; i<len; i++){
            a = str.charAt(i);
            y = 0;
            for(int j = 0; j<len; j++){
                b = str.charAt(j);

                if(a==b){
                    y++;
                }
            }
            if(y>x){
                c = a;
                x = y;
            }
        }
        System.out.println("Most frequent letter: " + c + ", Amount: " + x);*/

        // milestone 1

        /*System.out.println("MATH 1272");
        System.out.println("---------");
        System.out.println("ECON 1101");
        System.out.println("---------");
        System.out.println("PHYS 1101");
        System.out.println("---------");
        System.out.println("CSCI 1933");*/

    }

}
