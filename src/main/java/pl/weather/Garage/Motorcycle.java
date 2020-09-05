package pl.weather.Garage;

import javax.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle implements Parkable {

    public Motorcycle() {

    }

    public Motorcycle(double size, String plate, double pocketMoney) {
        super(size, plate, pocketMoney);
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
