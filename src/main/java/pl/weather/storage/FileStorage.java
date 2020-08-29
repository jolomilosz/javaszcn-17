package pl.weather.storage;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class FileStorage implements Storage {
    @Override
    public void saveToFile(String fileName, String json) {
        File file = new File(fileName);
        try {
            FileUtils.write(file, json, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Optional<String> loadFromFile(String fileName) {
        File file = new File(fileName);
        try {
            return Optional.of(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}