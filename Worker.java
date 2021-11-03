package lab5;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

public class Worker {

    private int id;
    private String Surname;
    private String Name;
    private String Lastname;
    private int age;
    private float salary;
    private int experience;
    private int codeCompany;

    public Worker(int id, String surname, String name, String lastname, int age, float salary, int experience, int codeCompany){
        this.id = id;
        this.Surname = surname;
        this.Name = name;
        this.Lastname = lastname;
        this.age = age;
        this.salary = salary;
        this.experience = experience;
        this.codeCompany = codeCompany;
    }


    public int getCodeCompany() {
        return codeCompany;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setCodeCompany(int codeCompany) {
        this.codeCompany = codeCompany;
    }

    public float getSalary() {
        return salary;
    }


    public int getExperience() {
        return experience;
    }



    public int getId() {
        return id;
    }



    public String getSurname() {
        return Surname;
    }


    public String getName() {
        return Name;
    }


    public String getLastname() {
        return Lastname;
    }



    public int getAge() {
        return age;
    }




    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", experience=" + experience +
                ", codeCompany=" + codeCompany +
                '}';
    }





    public static void main(String[] args) throws SQLException {
        Worker w1 = new Worker(1,"Petrenko","Ivan","Olehovych",45,3500,10,3);

        Worker w2 = new Worker(2,"Kalush","Mariya","Ivanivna",41,2500,7,2);

        Worker w3 = new Worker(3,"Poluk","Petro","Volodymyrovych",20,5000,11,1);

        Worker w4 = new Worker(4,"Maksymov","Petro","Maksymovych",36,4300,14,1);

        Worker w5 = new Worker(5,"Loza","Ihor","Petrovych",19,2400,1,3);

        Worker w6 = new Worker(6,"Kyznecova","Olena","Dmytrivna",54,2400,19,4);

        Worker w7 = new Worker(7,"Vatin","Volodymyr","Viktorovych",35,3200,16,4);

        Worker w8 = new Worker(8,"Andrienko","Petro","Mykolayovych",40,7000,11,2);

        Worker w9 = new Worker(9,"Tritenko","Alina","Petrivna",31,3500,8,4);

        Worker w10 = new Worker(10,"Panchenko","Andriy","Stepanovych",55,9500,35,1);

        Worker w11 = new Worker(11,"Makarchuk","Natalka","Ihorivna",21,2300,2,1);

        Worker w12 = new Worker(12, "Romanuk","Lev","Valentinovych",29,3500,4,5);

        Worker w13 = new Worker(13,"Yahnenko","Zlata","Oleksandivna",40,5000,13,3);

        Worker w14 = new Worker(14,"Petrenko","Andriy","Mykolayovych",38,6000,10,3);

        Worker w15 = new Worker(15,"Atamanuk","Oksana","Serhiivna",20,3500,2,3);


        ManagerWorker managerWorker = new ManagerWorker();

        //managerWorker.createTableWorkers();
//
//        managerWorker.addWorkerToTable(w1);
//        managerWorker.addWorkerToTable(w2);
//        managerWorker.addWorkerToTable(w3);
//        managerWorker.addWorkerToTable(w4);
//        managerWorker.addWorkerToTable(w5);
//        managerWorker.addWorkerToTable(w6);
//        managerWorker.addWorkerToTable(w7);
//        managerWorker.addWorkerToTable(w8);
//        managerWorker.addWorkerToTable(w9);
//        managerWorker.addWorkerToTable(w10);
//        managerWorker.addWorkerToTable(w11);
//        managerWorker.addWorkerToTable(w12);
//        managerWorker.addWorkerToTable(w13);
//        managerWorker.addWorkerToTable(w14);
//        managerWorker.addWorkerToTable(w15);




//SELECT OPERATIONS


        //1)SELECT ALL WORKERS
//        Collection<Worker> workers = new ArrayList<Worker>();
//
//        workers=managerWorker.selectAll();
//                for (Worker worker: workers
//                     ) {
//                    System.out.println(worker);
//
//                }



        //2) WORKERS WHO HAVE SALARY MORE THAN GIVEN
//                        Collection<Worker> workers = new ArrayList<Worker>();
//
//        workers=managerWorker.selectMoreSalary(4500);
//                for (Worker worker: workers
//                     ) {
//                    System.out.println(worker);
//
//                }

        //3) WORKERS WHO WORK AT COMPANY
//        Collection<Worker> workers = new ArrayList<Worker>();
//
//        workers=managerWorker.selectWorkerInCompany(1);
//                for (Worker worker: workers
//                     ) {
//                    System.out.println(worker);
//
//                }



        //UPDATE OPERATION


        //1) UPDATE SALARY WORKERS

//        managerWorker.UpdateSalary(5200,4);
//        Collection<Worker> workers = new ArrayList<Worker>();
//
//        workers=managerWorker.selectAll();
//                for (Worker worker: workers
//                     ) {
//                    System.out.println(worker);
//
//                }




        //2)UPDATE SALARY WORKERS WHO HAVE EXPERIENCE LESS THAN 5 YEARS

//        managerWorker.UpdateSalaryWithExperience();
//        Collection<Worker> workers = new ArrayList<Worker>();
//
//        workers=managerWorker.selectAll();
//                for (Worker worker: workers
//                     ) {
//                    System.out.println(worker);
//
//                }



        //DELETE OPERATIONS

        //1) DELETE WORKERS WHO HAVE AGE MORE THAN GIVEN AGE
//        managerWorker.DeleteWorkersForAge(50);
//        Collection<Worker> workers = new ArrayList<Worker>();
//
//        workers=managerWorker.selectAll();
//                for (Worker worker: workers
//                     ) {
//                    System.out.println(worker);
//
//                }

        //2)  DELETE WORKERS WHO HAVE GIVEN NAME
//        managerWorker.deleteWorkerForName("Petro");
//                Collection<Worker> workers = new ArrayList<Worker>();
//
//        workers=managerWorker.selectAll();
//                for (Worker worker: workers
//                     ) {
//                    System.out.println(worker);
//
//                }

        //3)DELETE ALL WORKERS
//         managerWorker.deleteAll();
//        Collection<Worker> workers = new ArrayList<Worker>();
//
//        workers=managerWorker.selectAll();
//        for (Worker worker: workers
//        ) {
//            System.out.println(worker);
//
//        }

        managerWorker.closeConn();

    }
}

