package pro.sky.professionsspringdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employee;
    public EmployeeController(EmployeeService employee) {

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
}
