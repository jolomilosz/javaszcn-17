package pl.weather.Garage;

public class Truck extends Vehicle implements Parkable {

    private static final double price = 35;
    private Integer weight;

    public Truck(double size, String plate,  double pocketMoney, Integer weight) {
        super(size + weight, plate, price, pocketMoney);
        this.weight = weight;
    }

    @Override
    public boolean park(GarageService garageService) {
        canAffordPark.test(getType().getparkCost());
        if(canAffordPark.test(getType().getparkCost())){
            return garageService.attemptToPark(this);
        }
        return false;
    }



    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
