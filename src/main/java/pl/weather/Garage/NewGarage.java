package pl.weather.Garage;

public class NewGarage {
    public static void main(String[] args) {
        GarageService newGarage = new GarageService(20, 30, 50);
        Car car1 = new Car(2.2, "WW 9922P", 10);
        Car car2 = new Car(1.9, "ZS 1299S", 10);
        Car car3 = new Car(1.2, "GD 1298S", 10);
        Car car4 = new Car(2.5, "ZS 4252S", 10);
        Car car5 = new Car(2.0, "LU 3399S", 10);

        Truck truck1 = new Truck(3.4, "WW 9999O", 25, 3000);
        Truck truck2 = new Truck(3.0, "ZS 1999O", 25, 1500);
        Truck truck3 = new Truck(2.9, "WW 1212Z", 25, 2000);
        Truck truck4 = new Truck(4.0, "LU 1211P", 25, 1999);
        Truck truck5 = new Truck(6.0, "XX 2232X", 25, 2001);

        Motorcycle moto1 = new Motorcycle(0.4, "GG 2222L", 7);
        Motorcycle moto2 = new Motorcycle(0.7, "ZS 1234H", 7);
        Motorcycle moto3 = new Motorcycle(0.5, "WW 2345K", 7);
        Motorcycle moto4 = new Motorcycle(0.9, "DD 6789K", 7);
        Motorcycle moto5 = new Motorcycle(1.0, "EE 2222U", 7);

        car1.park(newGarage);
        car3.park(newGarage);
        truck1.park(newGarage);

        System.out.println(newGarage);




    }
}
