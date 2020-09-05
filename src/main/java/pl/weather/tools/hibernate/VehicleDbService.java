package pl.weather.tools.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.weather.Garage.Vehicle;
import pl.weather.models.SimpleWeather;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class VehicleDbService {
    private static VehicleDbService INSTANCE;

    private Transaction transaction = null;

    private VehicleDbService() {
    }

    public static VehicleDbService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VehicleDbService();
        }
        return INSTANCE;
    }

    public Optional<List<Vehicle>> getListWithCriteria(String fieldName, Object searchedValue ){

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);

            Root<Vehicle> root = cr.from(Vehicle.class);
            cr.select(root).where(cb.equal(root.get("temp"),searchedValue));

            Query<Vehicle> query = session.createQuery(cr);
            //opcjonalnie można ograniczyć liczbę wyyników
            query.setMaxResults(1);
            List<Vehicle> result = query.getResultList();
            session.close();

            return Optional.of(result);
        } catch (Exception e) {
            return rollBackTransaction(e);
        }

    }

    public Optional getVehicle(int id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Vehicle vehicle = session.get(Vehicle.class, id);

            transaction.commit();
            session.close();
            return Optional.of(vehicle);
        } catch (Exception e) {
            return rollBackTransaction(e);
        }
    }

    public void removeVehicle(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Vehicle vehicle = session.get(Vehicle.class, id);
            if (vehicle != null) {
                session.remove(vehicle);
                System.out.println( String.format("Vehicle %s is deleted", vehicle.toString()));
            }

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Optional<List<Vehicle>> getArchiveList(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Vehicle> vehicleArchive = session.createQuery("from Vehicle", Vehicle.class).list();
            transaction.commit();
            session.close();
            return Optional.of(vehicleArchive);
        } catch (Exception e) {
            return rollBackTransaction(e);
        }
    }

    private Optional<List<Vehicle>> rollBackTransaction(Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
        return Optional.empty();
    }
}
