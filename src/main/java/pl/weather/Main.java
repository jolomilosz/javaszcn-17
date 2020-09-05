package pl.weather;

import pl.weather.Garage.GarageService;
import pl.weather.Garage.Truck;

public class Main {
    public static void main(String[] args) {
        GarageService monsterGarage = GarageService.getInstance(10,10,10);

        Truck truck = new Truck(0.1, "SSS", 120.12, 1);

        System.out.println(truck.isParked());

        truck.park(monsterGarage);

        System.out.println(truck.isParked());
    }
}
