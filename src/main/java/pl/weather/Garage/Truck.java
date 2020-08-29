package pl.weather.Garage;

import java.math.BigDecimal;

public class Truck extends Vehicle implements Parkable {

    private Integer weight;

    public Truck(double size, String plate,  double pocketMoney, Integer weight) {
        super(size + weight, plate, pocketMoney);
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

    @Override
    public String toString(){
        return "," + getType();
    }

    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
