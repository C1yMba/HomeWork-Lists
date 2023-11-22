package pro.sky.professionsspringdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employee;

    public EmployeeController(EmployeeService employee) {
        this.employee = employee;
    }


    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employee.addEmployee(firstName,lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return employee.removeEmployee(firstName,lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return employee.findEmployee(firstName, lastName);
    }
    @GetMapping(path = "/printAll")
    public List<Employee> findEmployee() {
        return employee.printAll();
    }


}
