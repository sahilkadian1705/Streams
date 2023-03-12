import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class Employee
{
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }

    public String getGender()
    {
        return gender;
    }

    public String getDepartment()
    {
        return department;
    }

    public int getYearOfJoining()
    {
        return yearOfJoining;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString()
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
}
public class Main {
    public static void main(String[] args){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
//        Q1.
        Map<String,Long>maleFemaleCount=
                employeeList.stream()
                        .collect(groupingBy(Employee::getGender, counting()));
        System.out.println(maleFemaleCount);
        System.out.println();
//        Q2.
        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
        System.out.println();
//        Q3.
        Map<String,Double> averageAge=
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAge);
        System.out.println();
//        Q4.
        Optional<Employee> e1=
                employeeList.stream()
                        .max(Comparator.comparing(Employee::getSalary));
        System.out.println(e1);
        System.out.println();
//        Q5.
        employeeList.stream()
                .filter(e->e.yearOfJoining>2015)
                .forEach(e-> System.out.println(e.getName()));
        System.out.println();
//        Q6.
        Map<String,Long> noOfEmp=
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        for(Map.Entry<String,Long>map:noOfEmp.entrySet()){
            System.out.println(map.getKey()+" - "+ map.getValue());
        }
        System.out.println();
//        Q7.
        Map<String,Double> avgSalary=
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalary);
        System.out.println();
//        Q8.
        Optional<Employee>e2=
                employeeList.stream()
                        .filter(e->e.department=="Product Development" && e.gender=="Male")
                        .max(Comparator.comparing(Employee::getYearOfJoining));
        Employee emp=e2.get();
        System.out.println(emp.getName());
//        Q.9
        Optional<Employee>e3=
                employeeList.stream()
                        .min(Comparator.comparing(Employee::getYearOfJoining));
        Employee highestExp=e3.get();
        System.out.println(highestExp);
        System.out.println();
//        Q10.
        Map<String,Long> maleAndFemale=
                employeeList.stream()
                        .filter(e->e.department=="Sales And Marketing")
                        .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        for(Map.Entry<String,Long>map:maleAndFemale.entrySet()){
            System.out.println(map.getKey()+" - "+map.getValue());
        }
        System.out.println();
//        Q11.
        Map<String,Double>avgSalaryMaleAndFemale=
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        for(Map.Entry<String,Double>map:avgSalaryMaleAndFemale.entrySet()){
            System.out.println(map.getKey()+" - "+map.getValue());
        }
//        Q12.
        Map<String,List<Employee>>listOfEmp=
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        for(Map.Entry<String,List<Employee>>map:listOfEmp.entrySet()){
            System.out.println("_______________________");
            System.out.println(map.getKey());
            System.out.println("_______________________");
            List<Employee>ls=map.getValue();
            for(Employee e:ls){
                System.out.println(e.getName());
            }
        }
        System.out.println();
//        Q13.
        Double avgSalaryCompany=
                employeeList.stream()
                        .collect(averagingDouble(Employee::getSalary));
        System.out.println("Average Salary is :"+avgSalaryCompany);
        Double totalSalary=
                employeeList.stream()
                        .collect(summingDouble(Employee::getSalary));
        System.out.println("Total Salary is : "+totalSalary);
        System.out.println();
//        Q15.
        Optional<Employee>e4=
                employeeList.stream()
                        .max(Comparator.comparing(Employee::getAge));
        Employee old=e4.get();
        System.out.println("Name: "+old.getName());
        System.out.println("Age: "+old.getAge());
        System.out.println("Department: "+old.getDepartment());

        Map<String, Long> e12=
                employeeList.stream()
                        .collect(groupingBy(Employee::getDepartment, counting()));
    }
}
