import java.util.Scanner;

public class BankAccount {

    String name;
    String password;
    double balance;

    public BankAccount(String initName, String initPass, double initBalance){
        name = initName;
        password = initPass;
        balance = initBalance;
    }

    public void withdraw(String enteredPassword, double amount){
        if(password.equals(enteredPassword) && balance>=amount){
            balance-=amount;
        }
    }

    public void deposit(String enteredPassword, double amount){
        if(password.equals(enteredPassword)){
            balance+=amount;
        }
    }

    public void transfer(BankAccount other, String enteredPassword, double amount){
        if(balance<amount){
            System.out.println("Not sufficient funds.");
        }
        else if(password.equals(enteredPassword)){
            setBalance(getBalance(enteredPassword)-amount);
            other.setBalance(other.getBalance(other.password)+amount);
        }
        else{
            System.out.println("Incorrect password.");
        }
    }

    public void setBalance(double new_balance){
        balance = new_balance;
    }

    public double getBalance(String enteredPassword){
        if(password.equals(enteredPassword)){
            return balance;
        }
        else{
            return -1;
        }
    }

    public boolean setPassword(String oldPassword, String newPassword){
        if(password.equals(oldPassword)){
            password = newPassword;
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){

        // milestone 4

        Scanner s = new Scanner(System.in);

        System.out.print("Enter an account name: ");
        String name = s.nextLine();
        System.out.print("Your password will be set to: ");
        String pass = s.nextLine();
        System.out.print("Your initial balance is? ");
        double b = s.nextDouble();
        BankAccount first = new BankAccount(name, pass, b);
        String space = s.nextLine();

        System.out.print("Enter an account name: ");
        String name2 = s.nextLine();
        System.out.print("Your password will be set to: ");
        String pass2 = s.nextLine();
        System.out.print("Your initial balance is? ");
        double b2 = s.nextDouble();
        BankAccount second = new BankAccount(name2, pass2, b2);
        String space2 = s.nextLine();

        System.out.print("How much would you like to transfer from savings to checking? ");
        double b3 = s.nextDouble();
        String space3 = s.nextLine();
        System.out.print("What is the password for the first account? ");
        String pass3 = s.nextLine();
        first.transfer(second, pass3, b3);
        System.out.println("Savings balance: " + first.getBalance(pass));
        System.out.println("Checking balance: " + second.getBalance(pass2));

        // milestone 3

        /*Scanner s = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = s.nextLine();
        System.out.print("Your password will be set to: ");
        String pass = s.nextLine();
        System.out.print("Your initial balance is? ");
        double b = s.nextDouble();
        BankAccount myAccount = new BankAccount(name, pass, b);
        System.out.print("Enter your password to view your balance: ");
        String space = s.nextLine();
        String check = s.nextLine();
        System.out.println(myAccount.getBalance(check));*/

    }

}
