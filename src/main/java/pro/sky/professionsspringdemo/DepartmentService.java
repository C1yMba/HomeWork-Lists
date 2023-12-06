package pro.sky.professionsspringdemo;

import java.util.List;
import java.util.OptionalDouble;

public interface DepartmentService {
    List<String> printAllEmployees();

    double getAllSalariesCost();

    Employee getMinSalary();

    Employee getMaxSalary();

    OptionalDouble getMediumSalariesCost();

    List<String> getNames();

    void indexAllSalaries(double percent);

    Employee getDepartmentMinSalary(int department);

    Employee getDepartmentMaxSalary(int department);

    double getDepartmentSumSalary(int department);

    OptionalDouble getDepartmentAverageSalary(int department);

    void indexDepartmentSalaries(int department, double percent);

    List<Employee> printAllEmployeesDepartment(int department);

    List<Employee> getLessSalary(int number);

    List<Employee> getMoreSalary(int number);

    Employee addEmployee(String firstName, String lastName, int department, double salary);
    Employee removeEmployee(String firstName, String lastName, int department, double salary);
    Employee findEmployee(String firstName, String lastName, int department, double salary);
}
