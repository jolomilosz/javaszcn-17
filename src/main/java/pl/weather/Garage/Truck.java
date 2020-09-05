package pl.weather.Garage;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Truck extends Vehicle implements Parkable {

    @Column
    private Integer weight;

    public Truck(double size, String plate,  double pocketMoney, Integer weight) {
        super(size + weight, plate, pocketMoney);
        this.weight = weight;
    }

    public Truck() {
    }

    @Override
    public boolean park(GarageService garageService) {
        if(canAffordPark.test(getType().getparkCost())){
            return garageService.attemptToPark(this);
        }
        return false;
    }



    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
