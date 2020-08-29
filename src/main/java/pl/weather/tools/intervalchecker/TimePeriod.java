package pl.weather.tools.intervalchecker;

public enum TimePeriod {

    OFTEN(5000), NORMAL(10000), REGULAR(15000), OCASIONAL(20000), RARLY(25000);

    private final long timeInMillis;
    TimePeriod(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }
    public long getTimeInMillis() {
        return timeInMillis;
    }
    public static TimePeriod getPeriodEquals(long timeInMillis) {
        for (TimePeriod period : values()) {
            if (timeInMillis == period.timeInMillis) {
                return period;
            }
        }
        return NORMAL;
    }

    /**
     *  TODO
     *  1. Zaimplementuj kilka różnych opcji czasowych
     *  2. Zaimplementuj metodę, pobierającą najbliższą opcje w stosunku do podanej wartości w milisekundach
     */

}