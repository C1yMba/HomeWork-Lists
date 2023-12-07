package pro.sky.professionsspringdemo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeService employeeService;
    private List<Employee> employees;
    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
        employees = employeeService.returnAllEmployees();
    }

    @Override
    public List<String> printAllEmployees() {
        if (employees.isEmpty()){
            throw new StorageOfEmployeesEmptyException("Отсутствуют сотрудники в компании");
        } else {
            Map<Integer, List<Employee>> employeesByDepartment = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));
            List<String> result = new ArrayList<>();
            employeesByDepartment.forEach((department, employeesInDept) -> {
                result.add("Отдел " + department + ":");
                employeesInDept.forEach(emp -> result.add(emp.toString()));
                result.add("---");
            });

            return result;
        }
    }
    @Override
    public List<Employee> printAllEmployeesDepartment(int department) {
        List<Employee> employeesInDepartment = employees.stream()
                .filter(p -> p.getDepartment() == department)
                .collect(Collectors.toList());
        if (employeesInDepartment.isEmpty()) {
            throw new NoSuchElementException("Отдел с номером " + department + " не найден или в нем нет сотрудников");
        }
        return  employeesInDepartment;
    }
    @Override
    public Employee getDepartmentMinSalary(int department) {
        return employees.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getEmployeeSalary))
                .orElseThrow(() -> new NoSuchElementException("Отдел с номером " + department + " не найден или в нем нет сотрудников"));
    }
    @Override
    public Employee getDepartmentMaxSalary(int department) {
        return employees.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getEmployeeSalary))
                .orElseThrow(() -> new NoSuchElementException("Отдел с номером " + department + " не найден или в нем нет сотрудников"));
    }

}
