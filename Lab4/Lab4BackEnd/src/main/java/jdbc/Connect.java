package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private String url = "jdbc:postgresql://localhost:5433/dp2023f";
    private Connection con;

    public Connect() {

        try {
            this.con = DriverManager.getConnection(url,"sample1", "111");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void closeCon() {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}