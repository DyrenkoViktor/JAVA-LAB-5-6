package lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class Manager {

    private Connection conn;

    public Manager(){

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
    public void createTableCompany() throws SQLException{

        String t="CREATE TABLE company(Id_company INT(15) PRIMARY KEY , Name_company VARCHAR (30) NOT NULL ,"+
                " Phone_company VARCHAR (30) NOT NULL , CodeCity INT(30), FOREIGN KEY (CodeCity) REFERENCES city (Id_city));";
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(t);
    }



    public void deleteTableCompany() throws SQLException{

        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("DROP TABLE company;");
    }


    //ADD COMPANY
    public void addCompany(Company company) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO company VALUES (?,?,?,?);");
        stmt.setInt(1,company.getId());
        stmt.setString(2,company.getName());
        stmt.setString(3,company.getPhoneCompany());
        stmt.setInt(4,company.getIdCity());

        stmt.execute();


        System.out.println("Added 1 company");
    }



    //SELECT OPERATIONS

    //1)SELECT ALL COMPANY
    public Collection<Company> selectAll() throws SQLException{

        Collection<Company>companies = new ArrayList<Company>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM company;");
        System.out.println("OK");
        while(rs.next()){
            System.out.println("OK");
            Company company = new Company(rs.getInt("Id_company"),rs.getString("Name_company"),rs.getString("Phone_company"),rs.getInt("CodeCity"));
            companies.add(company);
        }

        return companies;

    }


    //2) SELECT COMPANIES WHICH ARE LOCATED IN SPECIFIC CITY
    public Collection<Company> selectWorkerForCity(String city) throws SQLException{
        ResultSet rs = null;
        Collection<Company> companies = new ArrayList<Company>();

        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM company,city WHERE company.CodeCity=city.Id_city AND city.Name_city=?;");
        stmt.setString(1,city);
        rs = stmt.executeQuery();

        while(rs.next()){
            Company company = new Company(rs.getInt("Id_company"),rs.getString("Name_company"),rs.getString("Phone_company"),rs.getInt("CodeCity"));
            companies.add(company);
        }

        return companies;
    }



    //UPDATE OPERATIONS

    //1) UPDATE NUMBERS IN THAT COMPANIES WHICH ARE LOCATED IN SPECIFIC CITY
    public void updatePhone(String number, String city) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("UPDATE company,city SET company.Phone_company = ? WHERE company.CodeCity=city.Id_city AND city.Name_city=?;");
        stmt.setString(1,number);
        stmt.setString(2,city);

        stmt.executeUpdate();
    }



    //DELETE OPERATIONS
    public void deleteForName(String nameCompany) throws SQLException{

        PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM company WHERE Name_company=?;");
        stmt.setString(1,nameCompany);
        stmt.executeUpdate();
    }


    public void deleteAll() throws SQLException{

        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("DELETE FROM company WHERE TRUE;");
        System.out.println("Delete info");
    }

}
