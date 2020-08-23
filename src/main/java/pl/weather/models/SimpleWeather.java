package pl.weather.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimpleWeather {
    private String name;
    private String description;
    private double temp;
    private double feelsLike;
    private int pressure;
    private int humidity;

    @Override
    public String toString() {
        return "Pogoda w: " + name +
                ", opis: " + description +
                ", temperatura: " + temp +
                ", temp odczuwalna: " + feelsLike +
                ", cisnienie: " + pressure +
                ", wilgotnosc: " + humidity;
    }
}
