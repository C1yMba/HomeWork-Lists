package pro.sky.professionsspringdemo;

import java.util.List;

public interface DepartmentService {
    public List<String> printAllEmployees();

    List<Employee> printAllEmployeesDepartment(int department);
    Employee getDepartmentMinSalary(int department);

    Employee getDepartmentMaxSalary(int department);
}
