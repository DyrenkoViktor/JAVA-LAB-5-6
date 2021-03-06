package lab5;

import java.sql.*;
import java.util.*;
public class Company {

    private int id;
    private String name;
    private String phoneCompany;
    private int idCity;

    public Company(int id, String name, String phoneCompany, int idCity){
        this.id = id;
        this.name = name;
        this.phoneCompany = phoneCompany;
        this.idCity = idCity;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(String phoneCompany) {
        this.phoneCompany = phoneCompany;
    }





    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneCompany='" + phoneCompany + '\'' +
                ", idCity=" + idCity +
                '}';
    }



    public static void main(String[] args) throws SQLException{
        Company company1 = new Company(1,"Softserve","23-55-15",1);
        Company company2 = new Company(2,"Glovo","034-43-11-231",2);
        Company company3 = new Company(3,"Happy","765-09-00",1);
        Company company4 = new Company(4,"Okko","321-45-22",2);
        Company company5 = new Company(5,"Love","098-12-90-098",2);

        Manager manager = new Manager();
        //manager.createTableCompany();

//        manager.addCompany(company1);
//        manager.addCompany(company2);
//        manager.addCompany(company3);
//        manager.addCompany(company4);
//        manager.addCompany(company5);




        //SELECT OPERATIONS

//        1) SELECT ALL COMPANIES
//        Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//             ) {
//            System.out.println(company);
//        }
//
//
//
//
//        2) SELECT COMPANY WHICH ARE LOCATED IN SPECIFIC CITY
//       Collection<Company> companies = manager.selectWorkerForCity("Chernivtsi");
//        for (Company company : companies
//                ) {
//            System.out.println(company);
//        }
//
//
//
//        UPDATE OPERATION
//        UPDATE PHONE COMPANY
//        manager.updatePhone("22-222-22","Chernivtsi");
//                Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//             ) {
//            System.out.println(company);
//        }
//
//
//        DELETE INFROMATION
//
//
//        //1) DELETE COMPANY FOR NAME
//        manager.deleteForName("Okko");
//        Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//             ) {
//            System.out.println(company);
//        }
//
//
//
//        2) DELETE ALL COMPANIES
//        manager.deleteAll();
//        Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//        ) {
//            System.out.println(company);
//        }

        manager.closeConn();
    }
}
