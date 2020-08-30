package pl.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.weather.api.WeatherListener;
import pl.weather.models.SimpleWeather;
import pl.weather.storage.DataFileManager;
import pl.weather.storage.FileStorage;
import pl.weather.tools.hibernate.HibernateUtil;
import pl.weather.tools.intervalchecker.TimePeriod;
import pl.weather.tools.intervalchecker.WeatherIntervalCheckExecutor;
import pl.weather.tools.intervalchecker.WeatherIntervalCheckTask;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main implements WeatherListener {
    private static final Settings DEFAULT_SETTINGS = new Settings("Szczecin", TimePeriod.NORMAL.getTimeInMillis());

    public static void main(String[] args) {
        DataFileManager<Settings> fileManager = new DataFileManager<>(new FileStorage());
        Optional<Settings> settingsFromFile = fileManager.readFromFile(Settings.class);
        Settings settings = settingsFromFile.orElse(DEFAULT_SETTINGS);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        WeatherIntervalCheckTask task = new WeatherIntervalCheckTask(new Main(), settings.getLastCheckLocation());

        WeatherIntervalCheckExecutor checkExecutor = new WeatherIntervalCheckExecutor();
        checkExecutor.checkInInterval(task, TimePeriod.getPeriodEquals(settings.getLastUsedInterval()));

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            checkExecutor.stopChecking();
            sessionFactory.close();
        }


    }

    @Override
    public void onSuccess(SimpleWeather simpleWeather) {

        System.out.println(simpleWeather);

        // write to file
        DataFileManager<SimpleWeather> fileManager = new DataFileManager<>(new FileStorage());
        fileManager.writeToFile(simpleWeather);

        // write to database
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save simpleWeather
            session.save(simpleWeather);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void onFail(String errorMassage) {
        System.out.println("ups: " + errorMassage);
    }

}
