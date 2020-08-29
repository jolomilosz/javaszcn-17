package pl.weather.storage;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class FileStorage implements Storage {

    @Override
    public void saveToFile(String fileName, String json) {
    }

    @Override
    public Optional<String> loadFromFile(String fileName) {

        return null;
    }
}
