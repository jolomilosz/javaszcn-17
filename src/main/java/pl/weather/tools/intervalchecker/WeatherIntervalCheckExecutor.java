package pl.weather.tools.intervalchecker;

import java.util.Timer;

public class WeatherIntervalCheckExecutor extends Timer {
    public void checkInInterval(WeatherIntervalCheckTask task, TimePeriod timePeriod) {
        schedule(task, 0, timePeriod.getTimeInMillis());

        /**
         *  TODO
         *  1. Zaimplementuj zadanie w oparciu o klasę bazową (schedule)
         *  2. Dopisz metodę anulującą zadanie
         */
    }

    public void stopChecking() {
        cancel();
    }

}
