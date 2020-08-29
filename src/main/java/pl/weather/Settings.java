package pl.weather;

public class Settings {
    private String lastCheckLocation;
    private long lastUsedInterval;

    public Settings(String lastCheckLocation, long lastUsedInterval) {
        this.lastCheckLocation = lastCheckLocation;
        this.lastUsedInterval = lastUsedInterval;
    }

    public String getLastCheckLocation() {
        return lastCheckLocation;
    }

    public void setLastCheckLocation(String lastCheckLocation) {
        this.lastCheckLocation = lastCheckLocation;
    }

    public long getLastUsedInterval() {
        return lastUsedInterval;
    }

    public void setLastUsedInterval(long lastUsedInterval) {
        this.lastUsedInterval = lastUsedInterval;
    }
}
