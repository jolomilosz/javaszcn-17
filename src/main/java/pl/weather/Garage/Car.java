package pl.weather.Garage;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Car")
public class Car extends Vehicle implements Parkable {

    public Car() {
        super();
    };

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
