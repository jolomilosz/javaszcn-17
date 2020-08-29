package pl.weather.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
import javax.persistence.*;

@Entity
@Table(name = "SimpleWeather")
public class SimpleWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Pogoda w: " + name +
                ", opis: " + description +
                ", temperatura: " + temp +
                ", temp odczuwalna: " + feelsLike +
                ", ciśnienie: " + pressure +
                ", wilgotność: " + humidity;
    }
}
