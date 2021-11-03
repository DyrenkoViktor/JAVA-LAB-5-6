package lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ManagerWorker {

    private Connection conn;

    public ManagerWorker(){

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

    public void createTableWorkers() throws SQLException{

        String t="CREATE TABLE workers(Id_worker INT(15) PRIMARY KEY , Surname VARCHAR (30) NOT NULL ," +
                " Name VARCHAR (30) NOT NULL , Lastname VARCHAR(30) NOT NULL , Age INT(2) NOT NULL,"+
                " Salary FLOAT (10) NOT NULL , Experience INT(2) NOT NULL, CodeCompany INT(10), "+
                "FOREIGN KEY(CodeCompany) REFERENCES company(Id_company));";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t);



    }


    public void deleteTable() throws SQLException{

        String t1 = "DROP TABLE workers;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t1);
        System.out.println("Deleted table");



    }




    //ADD WORKER


    public void addWorkerToTable(Worker obj) throws SQLException{
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO workers VALUES(?,?,?,?,?,?,?,?);");
        stmt.setInt(1,obj.getId());
        stmt.setString(2,obj.getSurname());
        stmt.setString(3,obj.getName());
        stmt.setString(4,obj.getLastname());
        stmt.setInt(5,obj.getAge());
        stmt.setFloat(6,obj.getSalary());
        stmt.setInt(7,obj.getExperience());
        stmt.setInt(8,obj.getCodeCompany());

        stmt.execute();


        System.out.println("Added 1 worker");

    }


    //SELECT OPERATIONS

    //1) SELECT ALL AVAILABLE WORKERS;

    public Collection<Worker> selectAll() throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM workers;");

        while(rs.next()){
            Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getInt("CodeCompany"));
            workers.add(w1);
        }

        return workers;
    }




    //2) WORKERS WHO HAVE SALARY MORE THAN GIVEN
    public Collection<Worker> selectMoreSalary(float new_salary) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();
        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM workers WHERE Salary > ?;");
        stmt.setFloat(1,new_salary);
        rs = stmt.executeQuery();

        while(rs.next()){
            Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getInt("CodeCompany"));
            workers.add(w1);
        }

        return workers;
    }



    //3) WORKERS WHO WORK AT CITY
    public  Collection<Worker> selectWorkerInCompany(int idCity) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM workers, company,city WHERE workers.CodeCompany=company.Id_company AND company.CodeCity=city.Id_city AND city.Id_city=?;");
        stmt.setFloat(1,idCity);
        rs = stmt.executeQuery();

        while(rs.next()){
            Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getInt("CodeCompany"));
            workers.add(w1);
        }

        return workers;
    }


    //UPDATE OPERATIONS

    //1)UPDATE SALARY WORKERS WHO WORK AT COMPANY
    public void UpdateSalary(float salary, int Idcompany) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();
        PreparedStatement stmt = conn.prepareStatement("UPDATE workers SET Salary=? WHERE CodeCompany=?;");
        stmt.setFloat(1,salary);
        stmt.setInt(2,Idcompany);
        stmt.executeUpdate();


    }


    //2)UPDATE SALARY WORKERS WHO HAVE EXPERIENCE LESS THAN 5 YEARS
    public void UpdateSalaryWithExperience() throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE workers SET Salary=Salary*0.75 WHERE Experience < 5;");

    }



    //DELETE OPERATIONS

    //1) DELETE WORKERS WHO HAVE AGE MORE THAN GIVEN AGE
    public void DeleteWorkersForAge(int age) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM workers WHERE Age > ?");
        stmt.setInt(1,age);
        stmt.executeUpdate();

    }


    //2) DELETE WORKERS WHO HAVE GIVEN NAME

    public void deleteWorkerForName(String name) throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();

        PreparedStatement stmt = conn.prepareStatement("DELETE FROM workers WHERE Name = ?");
        stmt.setString(1,name);
        stmt.executeUpdate();

    }


    //3) DELETE ALL INFORMATION FROM TABLE
    public void deleteAll() throws SQLException{

        String t1 = "DELETE FROM workers WHERE TRUE ;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t1);
        System.out.println("Deleted info");
    }
}
