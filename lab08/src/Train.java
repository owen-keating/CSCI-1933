public class Train extends Vehicle {

    private double MPG;

    public Train(){
        MPG = 470.0;
        nVehicles++;
    }

    public Train(double m){
        MPG = m;
        nVehicles++;
    }

    public String toString(){
        return "Train: " + MPG;
    }

    public void movingBackward(){
        System.out.println("Train Moving Backward");
    }

    public void movingForward(){
        System.out.println("Train Moving Forward");
    }

    public void leavingStation(){
        System.out.println("Train Leaving Station");
    }

    public void enteringStation(){
        System.out.println("Train Entering Station");
    }

    public double getMPG(){
        return MPG;
    }

}
