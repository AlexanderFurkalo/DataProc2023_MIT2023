package jdbc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Boots;
import servlet.LabCRUDInterface;
public class app {
    public static void main(String[] args)  {
        LabCRUDInterface crud = new SqlCRUD();
        Connection connection = new Connect().getCon();

        List<Boots> entities;
        List<Boots> list = new ArrayList<>();


//JDBC connection
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM boots;");) {
            while (rs.next()) {
                list.add(new Boots(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("JDBC");
        for (Boots item : list) {
            System.out.println(item);
        }


//JPA connection
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Boots.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(new Boots(3, "name3", 33, 333, "img3"));
            session.save(new Boots(2, "name2", 22, 222, "img2"));

            Boots updateEntity1 = new Boots(1, "new-name1", 10, 101, "new-img1");
            session.update(updateEntity1);
            session.delete(new Boots(2, "name2", 22, 222, "img2"));

            entities = (List<Boots>) session.createQuery("from Boots").list();

            session.getTransaction().commit();

        }

        System.out.println("JPA");
        for (Boots item : entities) {
            System.out.println(item);
        }
        System.out.println("Success.");
    }
}
