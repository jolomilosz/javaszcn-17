package pl.weather.models;

import javax.persistence.*;

@Entity
@Table(name = "SimpleWeather")
public class SimpleWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double temp;
    @Column
    private double feelsLike;
    @Column
    private int pressure;
    @Column
    private int humidity;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "Pogoda w: " + name +
                ", opis:" + description +
                ", temperatura: " + temp +
                ", temp odczuwalna: " + feelsLike +
                ", cisnienie: " + pressure +
                ", wilgotnosc: " + humidity;
    }
}
