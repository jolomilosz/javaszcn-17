
package pl.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data()
public class Details {

    @Expose
    @SerializedName("temp")
    private double temp;

    @Expose
    @SerializedName("feels_like")
    private double feelsLike;

    @Expose
    @SerializedName("temp_min")
    private double tempMin;

    @Expose
    @SerializedName("temp_max")
    private double tempMax;

    @Expose
    @SerializedName("pressure")
    private int pressure;

    @Expose
    @SerializedName("humidity")
    private int humidity;

}
