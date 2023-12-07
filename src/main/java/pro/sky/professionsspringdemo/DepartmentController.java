package pro.sky.professionsspringdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService employee;
    public DepartmentController(DepartmentService employee) {

        this.employee = employee;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam int department, @RequestParam double salary) {
        return employee.addEmployee(firstName,lastName,department,salary);
    }

    @GetMapping(path = "/remove")
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                   @RequestParam int department, @RequestParam double salary) {
        return employee.removeEmployee(firstName,lastName,department,salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                 @RequestParam int department, @RequestParam double salary) {
        return employee.findEmployee(firstName,lastName,department,salary);
    }

    @GetMapping(path = "/max-salary")
    public Employee getDepartmentMaxSalary(@RequestParam int departmentId) {
        return employee.getDepartmentMaxSalary(departmentId);
    }
    @GetMapping(path = "/min-salary")
    public Employee getDepartmentMinSalary(@RequestParam int departmentId) {
        return employee.getDepartmentMinSalary(departmentId);
    }
    @GetMapping(path = "/all")
    public List<?> printAllEmployees(@RequestParam(required = false) Integer departmentId) {
        if (departmentId != null) {
            return employee.printAllEmployeesDepartment(departmentId);
        } else {
            return employee.printAllEmployees();
        }
    }



}
