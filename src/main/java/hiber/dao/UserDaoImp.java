package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void getUserOwnerCarByModelsAndSeries(String model, int series) {
        String HQL = "select c from Car c left join fetch c.user where c.model=:model and c.series=:series";
        try {
            Car car = sessionFactory.getCurrentSession().createQuery(HQL, Car.class)
                    .setParameter("model", model)
                    .setParameter("series", series)
                    .getSingleResult();
            User user = car.getUser();
            System.out.println(user);
        } catch (NoResultException e) {
            System.out.println("Пользователя с такой моделью: " + model
                    + ", и с таким номером '" + series + "' не существует !!!");
        }
    }
}
