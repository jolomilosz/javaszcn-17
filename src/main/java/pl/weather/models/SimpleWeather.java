package pl.weather.models;

public class SimpleWeather {
    private String name;
    private String description;
    private double temp;
    private double feelsLike;
    private int pressure;
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
                ", opis: " + description +
                ", temperatura: " + temp +
                ", temp odczuwalna: " + feelsLike +
                ", cisnienie: " + pressure +
                ", wilgotnosc: " + humidity;
    }
}
