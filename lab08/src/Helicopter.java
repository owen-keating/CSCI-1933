public class Helicopter extends Vehicle {

    private double MPG;

    public Helicopter(){
        MPG = 0.3;
        nVehicles++;
    }

    public Helicopter(double m){
        MPG = m;
        nVehicles++;
    }

    public String toString(){
        return "Helicopter: " + MPG;
    }

    public void movingBackward(){
        System.out.println("Helicopter Moving Backward");
    }

    public void movingForward(){
        System.out.println("Helicopter Moving Forward");
    }

    public void movingDown(){
        System.out.println("Helicopter Moving Down");
    }

    public void movingUp(){
        System.out.println("Helicopter Moving Up");
    }

    public double getMPG(){
        return MPG;
    }

}
