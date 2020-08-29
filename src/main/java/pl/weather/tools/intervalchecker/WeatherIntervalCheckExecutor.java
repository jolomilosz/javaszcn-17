package pl.weather.tools.intervalchecker;

import java.util.Timer;

/*
 *  1. Zaimplementuj zadanie w oparciu o klasę bazową (schedule)
 *  2. Dopisz metodę anulującą zadanie
 */

public class WeatherIntervalCheckExecutor extends Timer {


    public void checkInInterval(WeatherIntervalCheckTask task, TimePeriod timePeriod) {
        //korzystamy z metody zapozyczonej z klasy Timer (schedule) w konstruktorze
        schedule(task, 0, timePeriod.getTimeInMillis());
    }

    public void stopCheking() {
        cancel();
    }
}
