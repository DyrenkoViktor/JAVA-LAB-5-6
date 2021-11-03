package lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ManagerCity {

    private Connection conn;

    public ManagerCity(){

        try {
            String url = "jdbc:mysql://localhost:3306/lab5_1";
            String user = "root";
            String pass = "Dyrenko Viktor";

            this.conn = DriverManager.getConnection(url, user, pass);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void closeConn() throws SQLException{
        conn.close();
    }


    //TABLE OPERATIONS

    public void createTableCity() throws SQLException{

        String t="CREATE TABLE city(Id_city INT(15) PRIMARY KEY , Name_city VARCHAR (30) NOT NULL);";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t);
    }



    //ADD CITY
    public void addCity(City city) throws SQLException{

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO city VALUES(?,?);");
        stmt.setInt(1,city.getId());
        stmt.setString(2,city.getName());

        stmt.execute();
    }


    public Collection<City> selectAll() throws SQLException{

        Statement stmt = conn.createStatement();
        ResultSet rs = null;

        Collection<City> cities = new ArrayList<City>();
        rs = stmt.executeQuery("SELECT * FROM city;");

        while(rs.next()){
            City city = new City(rs.getInt("Id_city"),rs.getString("Name_city"));
            cities.add(city);
        }

        return cities;
    }

    //DELETE OPERATIONS
    public void deleteTable() throws SQLException {

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE city;");

    }


    public void deleteInfo() throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM city WHERE TRUE;");

    }

}
