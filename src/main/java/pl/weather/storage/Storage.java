package pl.weather.storage;

import java.util.Optional;

public interface Storage {
    void saveToFile(String fileName, String json);

    Optional<String> loadFromFile(String fileName);
}
