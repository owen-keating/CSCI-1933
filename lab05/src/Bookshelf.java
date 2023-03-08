import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class Bookshelf {

    private int size;
    private int nextEmpty;
    private Book[] library;

    public Bookshelf(){
        size = 20;
        nextEmpty = 0;
        library = new Book[20];
    }

    public Bookshelf(int size) {
        this.size = size;
        this.nextEmpty = 0;
        this.library = new Book[size];
    }

    public boolean add(Book newBook){
        if(nextEmpty==size){
            return false;
        }
        else{
            library[nextEmpty] = newBook;
            nextEmpty++;
            return true;
        }
    }

    public Bookshelf getBooksByAuthor(String author){
        Bookshelf b = new Bookshelf(size);
        for(int i = 0; i<nextEmpty; i++){
            if(library[i].getAuthor().equals(author)){
                b.add(library[i]);
            }
        }
        return b;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i<nextEmpty; i++){
            str = str + library[i] + "\n";
        }
        return str;
    }

    public void sort(char sortBy){
        if(sortBy=='t'){
            for(int j = 0; j<nextEmpty-1; j++){
                for(int i = 0; i<nextEmpty-1; i++){
                    int x = library[i].compareTo(library[i+1], 't');
                    if(x>0){
                        Book temp = new Book(library[i+1].getTitle(),library[i+1].getAuthor(),library[i+1].getRating());
                        library[i+1] = library[i];
                        library[i] = temp;
                    }
                }
            }
        }
        if(sortBy=='a'){
            for(int j = 0; j<nextEmpty-1; j++){
                for(int i = 0; i<nextEmpty-1; i++){
                    int x = library[i].compareTo(library[i+1], 'a');
                    if(x>0){
                        Book temp = new Book(library[i+1].getTitle(),library[i+1].getAuthor(),library[i+1].getRating());
                        library[i+1] = library[i];
                        library[i] = temp;
                    }
                }
            }
        }
        if(sortBy=='r'){
            for(int j = 0; j<nextEmpty-1; j++){
                for(int i = 0; i<nextEmpty-1; i++){
                    int x = library[i].compareTo(library[i+1], 'r');
                    if(x>0){
                        Book temp = new Book(library[i+1].getTitle(),library[i+1].getAuthor(),library[i+1].getRating());
                        library[i+1] = library[i];
                        library[i] = temp;
                    }
                }
            }
        }
    }

    public static Bookshelf readBooksFromFile(String fileName){
        Bookshelf t = new Bookshelf();
        Scanner s = null;
        try{
            s = new Scanner(new File(fileName));
            while(s.hasNextLine()) {
                String str = s.nextLine();
                String[] arr = str.split(",");
                Book b = new Book(arr[0], arr[1], Double.parseDouble(arr[2]));
                t.add(b);
            }
            s.close();
        } catch(Exception e){
            return null;
        }
        return t;
    }

    public static void writeShelfToFile(Bookshelf b, String fileName){
        PrintWriter p = null;
        try{
            p = new PrintWriter(new File(fileName));
            for(int i = 0; i<b.nextEmpty; i++){
                p.println(b.library[i]);
            }
            p.close();
        } catch(Exception e){
            System.out.println("Invalid file name.");
        }
    }

    public static void main(String[] args){

        // milestone 3

        Bookshelf test = readBooksFromFile("bookinput.txt");
        System.out.println(test + "\n");
        test.sort('r');
        writeShelfToFile(test, "output.txt");

        // milestone 2

        /*Bookshelf bksf = new Bookshelf(4);
        Book a = new Book("Hunger Games", "Author1", 85);
        Book b = new Book("The Hobbit", "Author2", 87);
        Book c = new Book("Catching Fire", "Author1", 98);
        Book d = new Book("Mockingjay", "Author1", 92);
        bksf.add(a);
        bksf.add(b);
        bksf.add(c);
        bksf.add(d);
        System.out.println(bksf);
        System.out.println(bksf.getBooksByAuthor("Author1"));
        bksf.sort('t');
        System.out.println(bksf);
        bksf.sort('a');
        System.out.println(bksf);
        bksf.sort('r');
        System.out.println(bksf);*/

    }

}
