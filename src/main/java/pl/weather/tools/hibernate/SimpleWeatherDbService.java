package pl.weather.tools.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.weather.models.SimpleWeather;
import pl.weather.tools.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class SimpleWeatherDbService {

    private static SimpleWeatherDbService INSTANCE;

    private Transaction transaction = null;

    private SimpleWeatherDbService() {
    }

    public static SimpleWeatherDbService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SimpleWeatherDbService();
        }
        return INSTANCE;
    }


    public Optional<List<SimpleWeather>> getListWithCriteria(String fieldName, Object searchedValue ){

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<SimpleWeather> cr = cb.createQuery(SimpleWeather.class);

            Root<SimpleWeather> root = cr.from(SimpleWeather.class);
            cr.select(root).where(cb.equal(root.get("temp"),searchedValue));

            Query<SimpleWeather> query = session.createQuery(cr);
            //opcjonalnie można ograniczyć liczbę wyyników
            query.setMaxResults(1);
            List<SimpleWeather> result = query.getResultList();
            session.close();

            return Optional.of(result);
        } catch (Exception e) {
            return rollBackTransaction(e);
        }

    }

    public Optional getWeather(int id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            SimpleWeather simpleWeather = session.get(SimpleWeather.class, id);

            transaction.commit();
            session.close();
            return Optional.of(simpleWeather);
        } catch (Exception e) {
           return rollBackTransaction(e);
        }
    }

    public Optional saveWeather(SimpleWeather simpleWeather){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Optional id = Optional.of(session.save(simpleWeather));

            transaction.commit();
            session.close();
            return id;
        } catch (Exception e) {
            return rollBackTransaction(e);
        }
    }

    public void removeWeather(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            SimpleWeather simpleWeather = session.get(SimpleWeather.class, id);
            if (simpleWeather != null) {
                session.remove(simpleWeather);
                System.out.println( String.format("SimpleWeather %s is deleted", simpleWeather.toString()));
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

    public Optional<List<SimpleWeather>> getArchiveList(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<SimpleWeather> weatherArchive = session.createQuery("from SimpleWeather", SimpleWeather.class).list();
            transaction.commit();
            session.close();
            return Optional.of(weatherArchive);
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
