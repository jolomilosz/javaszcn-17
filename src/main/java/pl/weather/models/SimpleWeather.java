package pl.weather.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "simple_weather")
public class SimpleWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double temp;
    @Column(name = "feels_like")
    private double feelsLike;
    @Column
    private int pressure;
    @Column
    private int humidity;



    public SimpleWeather(
            String name,
            String description,
            double temp,
            double feelsLike,
            int pressure,
            int humidity
    ) {
        this.name = name;
        this.description = description;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
    }

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
