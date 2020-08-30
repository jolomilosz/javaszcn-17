package pl.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString()
public class Settings {
    private String lastCheckLocation;
    private long lastUsedInterval;
}
