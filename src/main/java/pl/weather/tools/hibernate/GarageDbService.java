package pl.weather.tools.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.weather.Garage.Truck;
import pl.weather.Garage.Vehicle;
import pl.weather.models.SimpleWeather;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class GarageDbService {

    private static GarageDbService INSTANCE;

    private Transaction transaction = null;

    private GarageDbService() {
    }

    public static GarageDbService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GarageDbService();
        }
        return INSTANCE;
    }

    public Optional<Long> saveVehicle(Vehicle vehicle){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Optional<Long> id = Optional.of((Long)session.save("Truck", vehicle));

            transaction.commit();
            session.close();
            return id;
        } catch (Exception e) {
            return rollBackTransaction(e);
        }
    }

    public Optional getVehicle(Long id, String entityName) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Object vehicle = session.get(entityName, id);

            transaction.commit();
            session.close();
            return Optional.of(vehicle);
        } catch (Exception e) {
            return rollBackTransaction(e);
        }
    }

    private Optional rollBackTransaction(Exception e){
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
        return Optional.empty();
    }
}
