package pl.weather.Garage;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle implements Parkable {

    public Car(double size, String plate, double pocketMoney) {
        super(size, plate, pocketMoney);
    }

    public Car() {
    }


    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    @Override
    public boolean park(GarageService garageService) {
        if(canAffordPark.test(getType().getparkCost())){
            return garageService.attemptToPark(this);
        }
        return false;
    }
}
