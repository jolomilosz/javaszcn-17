
package pl.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sys {

    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("message")
    @Expose
    private double message;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("sunrise")
    @Expose
    private double sunrise;

    @SerializedName("sunset")
    @Expose
    private double sunset;

}
