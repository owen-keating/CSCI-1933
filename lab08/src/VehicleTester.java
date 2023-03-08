public class VehicleTester {

    public static void main(String[] args){
        Car car = new Car(30.0);
        System.out.println(car);
        car.movingForward();
        car.start();
        car.movingBackward();

        Helicopter helicopter = new Helicopter(4.0);
        System.out.println(helicopter);
        helicopter.movingForward();
        helicopter.movingBackward();

        Train train = new Train();
        System.out.println(train);
        train.movingForward();
        train.movingBackward();

        System.out.println("Total Number of Vehicles: " + Vehicle.getNumVehicles());
    }

}
