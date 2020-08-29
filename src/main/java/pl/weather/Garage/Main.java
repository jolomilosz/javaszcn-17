package pl.weather.Garage;

public class Main {
    public static void main(String[] args) {
        System.out.println("Garage:");

        Car car1 = new Car(1080, "ZPL 63906", 100.00);
        Car car2 = new Car(990, "ZPL 43563", 89.90);
        Truck truck1 = new Truck(4500,"ZS 12344", 19.90, 1500);
        Motorcycle motorcycle = new Motorcycle(100, "ZS 141508", 14.00);

        GarageService garageService = new GarageService(10,20,5);

        car1.park(garageService);

    }
}
