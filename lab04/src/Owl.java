public class Owl {

    private String name;
    private int age;
    private double weight;

    public Owl(String n, int a, double w){
        name = n;
        age = a;
        weight = w;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int a){
        age = a;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double w){
        weight = w;
    }

    public boolean equals(Owl other){
        if(name.equals(other.name) && age==other.age && weight==other.weight){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        Owl a = new Owl("Owen",19,160);
        Owl b = new Owl("Owe",19,160);
        /*Owl a = new Owl("Owen",19,160);
        Owl b = new Owl("Owen",19,160);*/
        System.out.println(a.equals(b));
    }

}
