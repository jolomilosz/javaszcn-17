package pl.weather.Garage;

public class MainGarage {
    public static void main(String[] args) {
        GarageService garageService = new GarageService(1,1,1);

        Vehicle car = new Car(10,"AVG-998",5.5);
        Vehicle truck = new Truck(30,"AAA-876",25,2000);
        Vehicle motorcycle = new Motorcycle(5,"SSE-765",5);


        garageService.attemptToPark(car);
        garageService.attemptToPark(truck);
        garageService.attemptToPark(motorcycle);


    }

}
