
package pl.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class WeatherForCity {

    @Expose
    @SerializedName("name")
    private String cityName;

    @Expose
    @SerializedName("cod")
    private int cod;

    @Expose
    @SerializedName("base")
    private String stations;

    @Expose
    @SerializedName("visibility")
    private int visibility;

    @Expose
    @SerializedName("dt")
    private long dt;

    @Expose
    @SerializedName("timezone")
    private int timezone;

    @Expose
    @SerializedName("coord")
    private Coord coordinates;

    @Expose
    @SerializedName("sys")
    private Sys sys;

    @Expose
    @SerializedName("main")
    private Details details;

    @Expose
    @SerializedName("weather")
    private List<Weather> weatherList;

}
