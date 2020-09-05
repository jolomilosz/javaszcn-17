package pl.weather;

import pl.weather.Garage.Car;
import pl.weather.Garage.GarageService;
import pl.weather.Garage.Motorcycle;
import pl.weather.Garage.Truck;
import pl.weather.api.WeatherListener;
import pl.weather.models.SimpleWeather;
import pl.weather.storage.DataFileManager;
import pl.weather.storage.FileStorage;
import pl.weather.tools.hibernate.SimpleWeatherDbService;
import pl.weather.tools.hibernate.VehicleDbService;
import pl.weather.tools.intervalchecker.TimePeriod;
import pl.weather.tools.intervalchecker.WeatherIntervalCheckExecutor;
import pl.weather.tools.intervalchecker.WeatherIntervalCheckTask;

import java.util.Optional;
import java.util.Scanner;

public class Main implements WeatherListener {
    private static final Settings DEFAULT_SETTIGS = new Settings("Szczecin", TimePeriod.NORMAL.getTimeInMillis());
    public static SimpleWeatherDbService dbService;
    public static VehicleDbService vehicleDbService;

    public static void main(String[] args) {
        DataFileManager<Settings> fileManager = new DataFileManager<>(new FileStorage());
        Optional<Settings> settingsFromFile = fileManager.readFromFile(Settings.class);
        Settings settings = settingsFromFile.orElse(DEFAULT_SETTIGS);

        WeatherIntervalCheckTask zadanie = new WeatherIntervalCheckTask(new Main(), settings.getLastCheckLocation());

        WeatherIntervalCheckExecutor checkExecutor = new WeatherIntervalCheckExecutor();
        checkExecutor.checkInInterval(zadanie, TimePeriod.getPeriodEquals(settings.getLastUsedInterval()));

        dbService = SimpleWeatherDbService.getInstance();

        vehicleDbService = VehicleDbService.getInstance();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            checkExecutor.stopChecking();
        }


    }


    @Override
    public void onSuccess(SimpleWeather simpleWeather) {
        System.out.println(simpleWeather);

        Motorcycle m1 = new Motorcycle(1.0, "ZS369M", 20.20);
        Truck t1 = new Truck(2.0, "DDDD", 20.20, 1);
        Car c1 = new Car(20.20, "ZS367M", 20.10);

        GarageService garage = new GarageService(10, 20, 30);
        garage.attemptToPark(c1);
        garage.attemptToPark(t1);
        garage.attemptToPark(m1);
        System.out.println(garage);


        vehicleDbService.saveVehicle(m1);
//        dbService.saveWeather(simpleWeather);
//        System.out.println("++++++++++++++LISTA++++++++++++++++++++");
//        System.out.println(dbService.getArchiveList().toString());
//        System.out.println("TEEEEEEMMMMPPPPPPPPPPPPPPPPPPPPPP");
//        System.out.println(dbService.getListWithCriteria("temp", 18.13));

    }


    @Override
    public void onFail(String errorMassage) {
        System.out.println("ups: " + errorMassage);
    }
}
