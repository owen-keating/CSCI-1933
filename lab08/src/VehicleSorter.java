import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VehicleSorter {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        //TODO: add vehicle objects of different types to your list
        //	e.g. vehicles.add(new Vehicle());
        vehicles.add(new Car(20.3));
        vehicles.add(new Train());
        vehicles.add(new Helicopter(13.2));
        vehicles.add(new Car(11.5));
        vehicles.add(new Car(41.6));
        vehicles.add(new Helicopter(3.2));
        vehicles.add(new Train(219.4));

        Collections.sort(vehicles);
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}
