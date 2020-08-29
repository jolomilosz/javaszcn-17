package pl.weather.Garage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainGarage {
    public static void main(String[] args) {
        GarageService garageService = new GarageService(1, 1, 1);

        Vehicle car = new Car(10, "AVG-998", 40);
        Vehicle truck = new Truck(30, "AAA-876", 60, 1900);
        Vehicle motorcycle = new Motorcycle(5, "SSE-765", 5);


       /* garageService.attemptToPark(car);
        garageService.attemptToPark(truck);
        garageService.attemptToPark(motorcycle);

        System.out.println(motorcycle.pocketMoney);
        garageService.removeVehicle(car);
        garageService.removeVehicle(truck);
        garageService.removeVehicle(motorcycle);
        */
       // garageService.attemptToPark(car);
        garageService.attemptToPark(truck);
        garageService.attemptToPark(motorcycle);

        Set set = garageService.parkedVehiclesBook.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}
