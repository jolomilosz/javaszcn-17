package pl.weather;

public enum Menu {
    SINGLE_CHECK(0, "Sprawdź pogodę dla miasta"),
    INTERVAL_CHECK(1, "Sprawdzaj pogode cyklicznie"),
    SETTINGS(2, "Ustawienia"),
    EXIT(3, "Wyjdz");


    private final int menuPosition;
    private final String menuLabel;

    Menu(int menuPosition, String menuLabel) {
        this.menuPosition = menuPosition;
        this.menuLabel = menuLabel;
    }

    public int getMenuPosition() {
        return menuPosition;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public static Menu getMenuForPosition(int menuPosition) {
        for (Menu item : Menu.values()) {
            if (item.menuPosition == menuPosition) {
                return item;
            }
        }

        return EXIT;
    }
}
