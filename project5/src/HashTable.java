//  Written by Owen Keating, keati090

import java.util.Scanner;
import java.io.*;

public class HashTable<T> {

    //  INSTANCE VARIABLES

    private NGen<T>[] table;
    private String type;
    private int numTokens;          // keeps track of the number of unique tokens

    //  CONSTRUCTORS

    public HashTable(int size, String type){
        table = new NGen[size];     // hash table length based on size parameter
        this.type = type;           // type initialized to "general" or "specific"
        numTokens = 0;
    }

    //  METHODS

    /*
    read() method was implemented using code from the source files that are located on
    Canvas. I decided not to reference other files in this project other than the given
    text (.txt) documents. read() takes in a String parameter that represents the name
    of the file that is being hashed. The function recognizes a token to be a String of
    characters separated by either a space or new line. References TextScan.java file.
     */

    public void read(String filename){
        try {
            Scanner file = new Scanner(new File(filename));
            while (file.hasNext()) {
                add((T) file.next());
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /*
    add() method is called by the read() function. After each token runs through the
    Scanner, add() determines if the token is a duplicate or not and assigns non-duplicates
    with a hash value using the most efficient hash function
     */

    public void add(T item){

        //  searches through all previous nodes for duplicates to input parameter

        for(int i = 0; i<table.length; i++){
            NGen<T> compare = table[i];
            if(compare!=null){
                if(compare.getData().equals(item)) return;
                while(compare.getNext()!=null){
                    compare = compare.getNext();
                    if(compare.getData().equals(item)) return;
                }
            }
        }

        //  checks type variable to determine most efficient hash function to implement

        int hash;
        if(type.equals("general")) hash = hash2(item);
        else hash = hash3(item);

        //  new token created and ptr used to search through nodes when a collision occurs

        NGen<T> token = new NGen<T>(item, null);
        if(table[hash]==null) table[hash] = token;
        else{
            NGen<T> ptr = table[hash];
            while(ptr.getNext()!=null){
                ptr = ptr.getNext();
            }
            ptr.setNext(token);
        }
        numTokens++;

    }

    /*
    display() method is called in main() after a hash table object has been initialized and
    filled. This function helps the user understand the efficiency of the hash functions by
    outputting statistics including average collision length and longest chain
     */

    public void display(){

        //  local variables to keep track of the longest chain and number of empty indices

        int max = 0;
        int empty = 0;

        //  loops through table, displaying the index and length of chain at the index

        for(int i = 0; i<table.length; i++){
            int num = 0;
            if(table[i]!=null){
                num = 1;
                NGen<T> ptr = table[i];
                while(ptr.getNext()!=null){
                    ptr = ptr.getNext();
                    num++;
                }
                if(num>max) max = num;
            }
            else empty++;
            System.out.println(i + ": " + num);
        }

        //  statistics that demonstrate the collision behavior in the hash table

        System.out.println("average collision length: " + 1.0 * numTokens / (table.length - empty));
        System.out.println("longest chain: " + max);
        System.out.println("unique tokens: " + numTokens);
        System.out.println("empty indices: " + empty);
        System.out.println("non-empty indices: " + (table.length - empty));

    }

    //  HASH FUNCTIONS

    /*
    hash1() was the first and least effective hash function that I implemented. The
    function returns the remainder of the sum of two ASCII values and the length of the
    hash table. In cases when the token is only one character long, only the first
    character is used in the sum. In all other cases, the first character is added with
    the middle character. For the "gettysburg.txt" file, the average collision length was
    3.35 and the longest chain was 10. For the "keywords.txt" file, the average collision
    length was 1.92 and the longest chain was 4.
     */
    private int hash1(T key){
        if(key.toString().length()==1){
            return key.toString().charAt(0) % table.length;
        }
        return (key.toString().charAt(0) + key.toString().charAt(key.toString().length()/2)) % table.length;
    }

    /*
    hash2() took a different approach than the first hash function because it accounted for
    the length of the tokens rather than just the first and middle characters. I considered
    this hash function to be more effective because there were less empty indices and a
    smaller average collision length for both text documents. The function returns the
    remainder of the ASCII value of the last character in the token times the prime number
    131 divided by the length of the token. For the "gettysburg.txt" file, the average
    collision length was 2.60 and the longest chain was 8. For the "keywords.txt" file, the
    average collision length was 1.39 and the longest chain was 5. hash2() was the most
    effective hash function for the general solution.
     */
    private int hash2(T key){
        return (key.toString().charAt(key.toString().length()-1) * 131 / key.toString().length()) % table.length;
    }

    /*
    hash3() was the longest hash function overall. I started with a local variable that
    represents the middle index of the token. Starting at the middle index and working back
    towards the first index, I multiplied the letter at the given index by a prime number in
    the range (10,50). I added this product to a sum and the hash value was set to remainder
    of the sum divided by the length of the hash table. This function was the most
    effective for the specific hash table. For the "keywords.txt" file, the average collision
    length was 1.25 and the longest chain was 3. hash3() was slightly less effective for the
    general solution. The longest chain for the "gettysburg.txt" file was 9 for hash3(),
    compared to 8 in hash2(). In conclusion, hash2() will be used for the general solution,
    while hash3() will be used for the specific solution.
     */
    private int hash3(T key){
        int index = 0; int sum = 0; int count = 0;
        if(key.toString().length()!=1) index = key.toString().length()/2;
        int[] primes = {11,13,17,19,23,29,31,37,41,43,47};
        for(int i = index; i>0; i--){
            sum += key.toString().charAt(i)*primes[count%primes.length];
            count++;
        }
        return sum % table.length;
    }

    //  MAIN

    public static void main(String[] args){
        HashTable general = new HashTable(139, "general");
        general.read("gettysburg.txt");
        System.out.println("\nhash2() implementation of gettysburg.txt\n");
        general.display();
        HashTable specific = new HashTable(139, "specific");
        specific.read("keywords.txt");
        System.out.println("\nhash3() implementation of keywords.txt\n");
        specific.display();
    }

}