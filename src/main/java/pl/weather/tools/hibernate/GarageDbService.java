package pl.weather.tools.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.weather.Garage.Truck;
import pl.weather.Garage.Vehicle;

import java.util.List;
import java.util.Optional;

public class GarageDbService {
    private static GarageDbService INSTANCE;

    private Transaction transaction = null;

    public static GarageDbService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GarageDbService();
        }
        return INSTANCE;
    }

    public Optional<List<Truck>> getAllVehicles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Truck> query = session.createQuery("from Truck", Truck.class);

            List<Truck> results = query.getResultList();

            session.close();

            return Optional.of(results);
        } catch (Exception e) {
            return rollbackTransaction(e);
        }
    }

    public Optional saveVehicle(Vehicle vehicle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Optional id = Optional.of(session.save(vehicle));

            transaction.commit();

            return id;
        } catch (Exception e) {
            return rollbackTransaction(e);
        }
    }

    private Optional rollbackTransaction(Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
        return Optional.empty();
    }
}
