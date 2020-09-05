package pl.weather.tools.intervalchecker;

public enum TimePeriod {

    /**
     *  TODO
     *  1. Zaimplementuj kilka różnych opcji czasowych
     *  2. Zaimplementuj metodę, pobierającą najbliższą opcje w stosunku do podanej wartości w milisekundach
     */
    OFTEN(5000),
    NORMAL(10000),
    REGULAR(15000),
    OCASIONAL(20000),
    RARLY(25000);

    private final long timeInMilis;

    TimePeriod(long timeInMilis) {
        this.timeInMilis = timeInMilis;
    }

    public long getTimeInMilis() {
        return this.timeInMilis;
    }

    public static TimePeriod getPeriodEquals(long timeInMilis) {
        for(TimePeriod period : values()) {
            if(timeInMilis == period.timeInMilis) {
                return period;
            }
        }
        return NORMAL;
    }

}