package pl.weather;

import pl.weather.Garage.GarageService;
import pl.weather.Garage.Truck;
import pl.weather.Garage.Vehicle;

public class TestGarage {

    public static void main(String[] args) {
        // create garage service
        GarageService garageService = GarageService.getInstance(2, 5, 7);

        // create few trucks
        Vehicle truck1 = new Truck(5, "truck plate 1", 230, 8000);
        Vehicle truck2 = new Truck(4, "truck plate 2", 2, 6000);
        Vehicle truck3 = new Truck(6, "truck plate 3", 145, 9000);
        Vehicle truck4 = new Truck(7, "truck plate 4", 16, 10000);

        // park trucks
        System.out.println(garageService.attemptToPark(truck1));
        System.out.println(truck1);
        System.out.println(garageService.attemptToPark(truck2));
        System.out.println(truck2);
        System.out.println(garageService.attemptToPark(truck3));
        System.out.println(truck3);
        System.out.println(garageService.attemptToPark(truck4));
        System.out.println(truck4);

        System.out.println(garageService.getParkedVehiclesBook().size());
        System.out.println(garageService.getParkedVehiclesBook());

    }
}
