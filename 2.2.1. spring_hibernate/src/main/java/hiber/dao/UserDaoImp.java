package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("From User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(String model, int series) {
        TypedQuery<User> userTypedQuery = sessionFactory.getCurrentSession()
                .createQuery("From User where cars.model=:model and cars.series=:series", User.class)
                .setParameter("model", model)
                .setParameter("series", series);
        return userTypedQuery.getSingleResult();

    }

}
