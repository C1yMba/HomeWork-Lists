package pro.sky.professionsspringdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public Employee removeEmployee(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return employee.removeEmployee(firstName,lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return employee.findEmployee(firstName, lastName);
    }



}
