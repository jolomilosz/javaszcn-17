package pl.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coord {

    @SerializedName("lon")
    @Expose
    private double lon;

    @SerializedName("lat")
    @Expose
    private double lat;

}
