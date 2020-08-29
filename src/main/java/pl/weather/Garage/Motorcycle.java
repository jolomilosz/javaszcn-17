package pl.weather.Garage;

public class Motorcycle extends Vehicle implements Parkable {


    private static final double price = 20;

    public Motorcycle(double size, String plate, double pocketMoney) {
        super(size, plate, price, pocketMoney);
    }


    @Override
    public VehicleType getType() {
        return VehicleType.MOTORCYCLE;
    }

    @Override
    public boolean park(GarageService garageService) {
        // place for other Motorcycle related actions
        if(canAffordPark.test(getType().getparkCost())){
            this.parked = garageService.attemptToPark(this);
        }
        return parked;
    }
}
//kjdfijsdjjldslfd