public class Car extends Vehicle {

    private double MPG;

    public Car(){
        MPG = 30.0;
        nVehicles++;
    }

    public Car(double m){
        MPG = m;
        nVehicles++;
    }

    public String toString(){
        return "Car: " + MPG;
    }

    public void movingBackward(){
        System.out.println("Car Moving Backward");
    }

    public void movingForward(){
        System.out.println("Car Moving Forward");
    }

    public double getMPG(){
        return MPG;
    }

}
