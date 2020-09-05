package pl.weather.Garage;

public enum VehicleType {

    CAR(10.20),
    MOTORCYCLE(0.1),
    TRUCK(50.40),
   BOAT(44.01);

    private double parkCost;

    VehicleType(double parkCost) {
        this.parkCost = parkCost;
    }


    public double getparkCost() {
        return parkCost;
    }
}
