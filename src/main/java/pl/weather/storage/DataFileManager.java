package pl.weather.storage;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class DataFileManager<T> {
    private static final String DEFAULT_DATA_EXTENSION = ".json";
    private final Storage storage;
    private final Gson gson = new Gson();

    public DataFileManager(Storage storage) {
        this.storage = storage;
    }

    public void writeToFile(T dataToSave) {

    }

    public Optional<T> readFromFile(Class<T> dataToLoad) {
        return null;
    }

    @NotNull
    private String createStorageName(Class<?> dataToSave) {
        return null;
    }
}
