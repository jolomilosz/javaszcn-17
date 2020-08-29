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
        String json = gson.toJson(dataToSave);
        storage.saveToFile(createStorageName(dataToSave.getClass()), json);
    }
    public Optional<T> readFromFile(Class<T> dataToLoad) {
        return storage.loadFromFile(createStorageName(dataToLoad))
                .map(json -> gson.fromJson(json, dataToLoad));
    }
    @NotNull
    private String createStorageName(Class<?> dataToSave) {
        String className = dataToSave.getSimpleName();
        return className.toLowerCase() + DEFAULT_DATA_EXTENSION;
    }
}
