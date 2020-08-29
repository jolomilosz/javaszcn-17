package pl.weather;

public enum Units {
    KELVIN("kelvin"), CELSIUS("metric"), FAHRENHEIT("imperial");

    private final String unitName;

    Units(String unitName) {
        this.unitName = unitName;
    }

    public String unitName() {
        return unitName;
    }
}
