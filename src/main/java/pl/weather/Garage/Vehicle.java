package pl.weather.Garage;

import javax.persistence.*;
import java.util.Optional;
import java.util.function.Predicate;
@MappedSuperclass
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private double size;
    @Column
    private String plate;
    @Column
    protected boolean parked;
    @Column
    protected double pocketMoney;

    @Transient
    public Predicate<Double> canAffordPark = i -> (i > pocketMoney);

    public Vehicle(){}

    public Vehicle(double size, String plate, double pocketMoney) {
        this.size = size;
        this.plate = plate;
        this.parked = false;
        this.pocketMoney = pocketMoney;
    }

    public Double pay(){
        this.pocketMoney -= this.getType().getparkCost();
        return this.pocketMoney;
    }

    protected abstract VehicleType getType();

    public void setParked(boolean parked) {
        this.parked = parked;
    }

    public double getPocketMoney() {
        return pocketMoney;
    }

    public void setPocketMoney(double pocketMoney) {
        this.pocketMoney = pocketMoney;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isParked() {
        return parked;
    }

}
