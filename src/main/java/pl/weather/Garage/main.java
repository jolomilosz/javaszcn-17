package pl.weather.Garage;
import java.util.*;

public class main {
    public static void main(String[] args) {

        GarageService GarageService1 = new GarageService(3,3,2);
        Truck Truck1 = new Truck(1, "zka13999",13.99,15);
        Motorcycle Motorcycle1 = new Motorcycle(1, "zka13998",99.99);
        Car Car1 = new Car(1, "zka13997",13.99);

        Truck1.park(GarageService1);

        System.out.println(Car1);

        GarageService1.attemptToPark(Truck1);
        GarageService1.attemptToPark(Motorcycle1);
        GarageService1.attemptToPark(Car1);

        System.out.println("lista1");
        Set set = GarageService1.parkedVehiclesBook.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());

            System.out.println("lista2");
        System.out.println(GarageService1.parkedVehiclesBook);

    }
}}
