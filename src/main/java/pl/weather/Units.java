package pl.weather;

public enum Units {
    METRIC("metric"),
    IMPERIAL("imperial");

    public final String units;

    Units(String units) {
        this.units = units;
    }

    public String getUnits() {
        return units;
    }
}
