package pl.weather;

import pl.weather.Garage.*;
import pl.weather.tools.hibernate.GarageDbService;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        GarageDbService garageDbService = new GarageDbService();
        GarageService monsterGarage = GarageService.getInstance(10,10,10)
                .addDbService(garageDbService);

        Car car1 = new Car(1080, "ZPL 63906", 100.00);
        Car car2 = new Car(990, "ZPL 43563", 89.90);
        Truck truck1 = new Truck(4500,"ZS 12344", 19.90, 1500);
        Motorcycle motorcycle = new Motorcycle(100, "ZS 141508", 14.00);



        Optional<List<Truck>> vehiclesList = garageDbService.getAllVehicles();

        if(vehiclesList.isPresent()) for (Vehicle vehicle : vehiclesList.get()) {
            System.out.println(vehicle.toString());
        }
    }
}
