package pl.weather.Garage;

import javax.persistence.*;
import java.util.function.Predicate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("VEHICLE")
public abstract class Vehicle {

    @Id
    @GeneratedValue
    private int id;

    private double size;
    private String plate;
    protected boolean parked;
    protected double pocketMoney;

    @Transient
    public Predicate<Double> canAffordPark = i -> (i < pocketMoney);

    public Vehicle(double size, String plate, double pocketMoney) {

        this.size = size;
        this.plate = plate;
        this.parked = false;
        this.pocketMoney = pocketMoney;
    }

    public Vehicle() {

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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", size=" + size +
                ", plate='" + plate + '\'' +
                '}';
    }
}
