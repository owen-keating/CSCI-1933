import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

public class OwlPopulation {

    private String fileName;
    private Owl[] data;

    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];
        scanner = new Scanner(f);

        String[] lst = new String[numLines];
        for(int i = 0; i<numLines; i++){
            lst[i] = scanner.nextLine();
            String[] nlst = lst[i].split(",");
            data[i] = new Owl(nlst[0],Integer.parseInt(nlst[1]),Double.parseDouble(nlst[2]));
        }
        return numLines;
    }

    public double averageAge(){
        double total = 0.0;
        for(int i = 0; i<data.length; i++){
            total+=data[i].getAge();
        }
        return total/data.length;
    }

    public Owl getYoungest(){
        Owl young = data[0];
        for(int i = 0; i<data.length; i++){
            if(data[i].getAge()<young.getAge()){
                young = data[i];
            }
        }
        return young;
    }

    public Owl getHeaviest(){
        Owl heavy = data[0];
        for(int i = 0; i<data.length; i++){
            if(data[i].getWeight()>heavy.getWeight()){
                heavy = data[i];
            }
        }
        return heavy;
    }

    public String toString(){
        String str = "Average age: " + averageAge() + "\nYoungest Owl: " + getYoungest().getName() + "\nHeaviest Owl: " + getHeaviest().getName() + "\nPopulation: " + popSize();
        return str;
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        populateData();
    }

    public int popSize(){
        return data.length;
    }

    public boolean containsOwl(Owl other){
        for(int i = 0; i<data.length; i++){
            if(other.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    public void merge(OwlPopulation other){
        int add = 0;
        for(int i = 0; i<other.data.length; i++){
            if(!containsOwl(other.data[i])){
                add++;
            }
        }
        int y = 0;
        Owl[] a = new Owl[add];
        for(int i = 0; i<other.data.length; i++){
            if(!containsOwl(other.data[i])){
                a[y] = other.data[i];
                y++;
            }
        }
        Owl[] b = new Owl[data.length];
        for(int i = 0; i<data.length; i++){
            b[i] = data[i];
        }
        data = new Owl[a.length+b.length];
        int x = 0;
        for(int i = 0; i<b.length; i++){
            data[x] = b[i];
            x++;
        }
        for(int i = 0; i<a.length; i++){
            data[x] = a[i];
            x++;
        }

    }

    public static void main(String[] args) {
        try {
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1 (2).csv");
            System.out.println(pop1);

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);

            pop1.merge(pop2);
            System.out.println(pop1);
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }

}
