package pro.sky.professionsspringdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService employee;
    public DepartmentController(DepartmentService employee) {
        this.employee = employee;
    }
    @GetMapping(path = "/max-salary")
    public Employee getDepartmentMaxSalary(@RequestParam int departmentId) {
        return employee.getDepartmentMaxSalary(departmentId);
    }
    @GetMapping(path = "/min-salary")
    public Employee getDepartmentMinSalary(@RequestParam int departmentId) {
        return employee.getDepartmentMinSalary(departmentId);
    }
    @GetMapping(value = "/all", params = {"departmentId"})
    public List<Employee> getEmployeesFromDepartment(@RequestParam int departmentId){
        return employee.printAllEmployeesDepartment(departmentId);
    }
    @GetMapping("/all")
    public List<String> getEmployeesGroupedByDepartment() {
        return employee.printAllEmployees();
    }
}
