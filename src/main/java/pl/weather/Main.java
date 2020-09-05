package pl.weather;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.weather.Garage.GarageService;
import pl.weather.Garage.Truck;
import pl.weather.Garage.Vehicle;
import pl.weather.Garage.VehicleType;
import pl.weather.api.WeatherListener;
import pl.weather.models.SimpleWeather;
import pl.weather.storage.DataFileManager;
import pl.weather.storage.FileStorage;
import pl.weather.tools.hibernate.GarageDbService;
import pl.weather.tools.hibernate.HibernateUtil;
import pl.weather.tools.hibernate.SimpleWeatherDbService;
import pl.weather.tools.intervalchecker.TimePeriod;
import pl.weather.tools.intervalchecker.WeatherIntervalCheckExecutor;
import pl.weather.tools.intervalchecker.WeatherIntervalCheckTask;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main implements WeatherListener {
    private static final Settings DEFAULT_SETTIGS = new Settings("Szczecin", TimePeriod.NORMAL.getTimeInMillis());
    public static SimpleWeatherDbService dbService;

    public static void main(String[] args) {

        GarageDbService garageDbService = GarageDbService.getInstance();
        GarageService garageService = GarageService.getInstance(2, 5, 10);

        Vehicle truck1 = new Truck(2000, "MAN", 100, 8000);

        boolean isParked = garageService.attemptToPark(truck1);

        System.out.println("isParked: " + isParked);

        if (isParked) {
            Long vehicleId = garageDbService.saveVehicle(truck1).get();
            Optional truck = garageDbService.getVehicle(vehicleId , "pl.weather.Garage.Truck");
            System.out.println(truck);
        }


        /*
        DataFileManager<Settings> fileManager = new DataFileManager<>(new FileStorage());
        Optional<Settings> settingsFromFile = fileManager.readFromFile(Settings.class);
        Settings settings = settingsFromFile.orElse(DEFAULT_SETTIGS);

        WeatherIntervalCheckTask zadanie = new WeatherIntervalCheckTask(new Main(), settings.getLastCheckLocation());

        WeatherIntervalCheckExecutor checkExecutor = new WeatherIntervalCheckExecutor();
        checkExecutor.checkInInterval(zadanie, TimePeriod.getPeriodEquals(settings.getLastUsedInterval()));

        dbService = SimpleWeatherDbService.getInstance();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            checkExecutor.stopChecking();
        }
        */

    }


    @Override
    public void onSuccess(SimpleWeather simpleWeather) {
        System.out.println(simpleWeather);
        dbService.saveWeather(simpleWeather);
        System.out.println("++++++++++++++LISTA++++++++++++++++++++");
        System.out.println(dbService.getArchiveList().toString());
        System.out.println("TEEEEEEMMMMPPPPPPPPPPPPPPPPPPPPPP");
        System.out.println(dbService.getListWithCriteria("temp", 18.13));

    }


    @Override
    public void onFail(String errorMassage) {
        System.out.println("ups: " + errorMassage);
    }
}
