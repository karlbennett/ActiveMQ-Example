package uk.co.dailymail.run;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import uk.co.dailymail.dao.GenericDao;
import uk.co.dailymail.dao.hibernate.HibernateDao;
import uk.co.dailymail.domain.Address;
import uk.co.dailymail.domain.User;

import java.util.Date;
import java.util.List;

/**
 * User: Karl Bennett
 * Date: 27-Jan-2011
 */
public class DailyMail {

    private static final SessionFactory SESSION_FACTORY;

    static {
        SESSION_FACTORY = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static void main(String[] args) {
        GenericDao dao = new HibernateDao(SESSION_FACTORY);

        User user = new User();
        Address address = new Address();

        user.setFirstName("Some");
        user.setLastName("One");
        user.setDateOfBirth(new Date());
        user.setAddress(address);

        address.setStreet("1 That St");
        address.setProvence("There");
        address.setCity("London");
        address.setPostCode("NX5 6MN");
        address.setCountry("England");
        address.setUser(user);

        dao.creat(user);

        List<User> users = dao.retrieveAll(User.class);

        for (User u : users) System.out.println(u);
    }
}
