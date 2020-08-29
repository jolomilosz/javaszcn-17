package pl.weather.tools.intervalchecker;

import java.util.Timer;

public class WeatherIntervalCheckExecutor extends Timer {


    public void checkInInterval(WeatherIntervalCheckTask task, TimePeriod timePeriod) {
        schedule(task, 0, timePeriod.getTimeInMillis());
    }

    public void stopChecking() {
        cancel();
    }

}
