package pl.weather.Garage;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Car extends Vehicle implements Parkable {

    public Car() {

    }

    public Car(double size, String plate, double pocketMoney) {
        super(size, plate, pocketMoney);
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
