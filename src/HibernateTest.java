import Models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Burak Köken on 5.7.2017.
 */
public class HibernateTest {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        String hql = "FROM Product";
        Query query = session.createQuery(hql);
        query.setFirstResult(2);
        query.setMaxResults(3);

        List<Product> productList = query.list();
        for(Product product : productList){
            System.out.println("id : " + product.getId() + ", name : " + product.getName());
        }

        session.close();

    }
}
