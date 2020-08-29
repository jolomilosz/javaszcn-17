package pl.weather.Garage;

public class GarageExx {
    public static void main(String[] args) {
        GarageService garageService = new GarageService(5, 30, 15);

        Car car1 = new Car(12, "KPP111", 13.90);

        Truck truck1 = new Truck(28, "aabbcc", 5.80, 3500);

        Truck truck2 = new Truck(38, "aared", 100.26, 4000);

        garageService.attemptToPark(car1);
        System.out.println(car1.isParked());
        garageService.attemptToPark(truck1);
        System.out.println(truck1.isParked());
        garageService.attemptToPark(truck2);
        System.out.println(truck2.isParked());

        garageService.findVehicle(car1);
        garageService.removeVehicle(car1);
        garageService.findVehicle(car1);


    }

}
