package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public List<Car> listCars() {
      Query<Car> query = sessionFactory.getCurrentSession().createQuery("from Car", Car.class);
      return query.getResultList();
   }
}
