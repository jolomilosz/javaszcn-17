package pl.weather;

import pl.weather.Garage.GarageService;
import pl.weather.Garage.Truck;
import pl.weather.Garage.Vehicle;
import pl.weather.tools.hibernate.GarageDbService;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        GarageDbService garageDbService = new GarageDbService();
        GarageService monsterGarage = GarageService.getInstance(10,10,10)
                .addDbService(garageDbService);

        Truck truck = new Truck(0.1, "SSS", 120.12, 1);

        System.out.println(truck.isParked());

        truck.park(monsterGarage);

        System.out.println(truck.isParked());

        Optional<List<Truck>> vehiclesList = garageDbService.getAllVehicles();

        if(vehiclesList.isPresent()) for (Vehicle vehicle : vehiclesList.get()) {
            System.out.println(vehicle.toString());
        }
    }
}
