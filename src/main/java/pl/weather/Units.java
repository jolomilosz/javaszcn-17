package pl.weather;

public enum Units {
    METRIC("METRIC"),
    IMPERIAL("IMPERIAL");

    String unit;

    Units(String unit) {
        this.unit = unit;
    }

    public String getUnitName() {
        return this.unit;
    }
}
