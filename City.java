package lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class City {

    private int id;
    private String Name;

    public City(int id, String Name){
        this.id = id;
        this.Name = Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public static void main(String[] args) throws SQLException{
        City city1 = new City(1,"Chernivtsi");
        City city2 = new City(2,"Lviv");

        ManagerCity managerCity = new ManagerCity();
        //managerCity.createTableCity();
//
//        managerCity.addToTable(city1);
//        managerCity.addToTable(city2);

        //managerCity.deleteTable();

        //managerCity.deleteInfo();
//        Collection<City> city = new ArrayList<City>();
//
//       city = managerCity.selectAll();
//
//        for (City cities: city
//             ) {
//            System.out.println(cities);
//        }
        managerCity.closeConn();
    }
}
