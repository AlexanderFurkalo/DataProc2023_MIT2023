package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Boots;
import servlet.LabCRUDInterface;
public class SqlCRUD implements LabCRUDInterface<Boots>{

    Connection connection;

    public SqlCRUD() {

        this.connection = new Connect().getCon();
        System.out.println(connection);

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Boots it) {
        try(
                PreparedStatement st = connection.prepareStatement("INSERT INTO boots (name, size, price, image) "
                        + "VALUES (?, ?, ?, ?);")){
            st.setString(1, it.getName());
            st.setInt(2, it.getSize());
            st.setInt(3, it.getPrice());
            st.setString(4, it.getImage());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Boots> read() {
        List<Boots> list = new ArrayList<>();

        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM boots;");) {
            while (rs.next()) {
                list.add(new Boots(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(int id, Boots t) {
        try (PreparedStatement st = connection
                .prepareStatement("UPDATE boots " + "SET \"name\"=?, \"size\"=?, \"price\"=?, \"image\"=? WHERE id=?;")) {
            st.setString(1, t.getName());
            st.setInt(2, t.getSize());
            st.setInt(3, t.getPrice());
            st.setString(4, t.getImage());
            st.setInt(5, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (PreparedStatement st = connection
                .prepareStatement("DELETE FROM boots WHERE id=?;")) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
