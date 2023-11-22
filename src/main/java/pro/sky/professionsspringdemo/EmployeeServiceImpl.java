package pro.sky.professionsspringdemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
        private final int numberOfEmployees = 10;
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Вася", "Пупкин"),
                new Employee("Дима", "Капустин"),
                new Employee("Вася", "Кирилин"),
                new Employee("Христофор", "Иванов")
        ));
        public Collection<Employee> printAll() {
                return Collections.unmodifiableList(employees);
        }

        public Employee addEmployee(String firstName, String lastName) {
                if (employees.size() == numberOfEmployees) {
                        throw new EmployeeStorageIsFullException("Company is staffed");
                }
                Employee employee = new Employee(firstName, lastName);
                        if (employees.contains(employee)) {
                                throw new EmployeeAlreadyAddedException("Employee is already added in list!");
                        }
                employees.add(employee);
                return employee;
        }

        public Employee removeEmployee(String firstName, String lastName) {
                Employee employee = new Employee(firstName, lastName);
                        if (employees.contains(employee)){
                                employees.remove(employee);
                                return employee;
                        }
                throw new EmployeeNotFoundException("Сотрудник с именем " + firstName +" и фамилией " + lastName + " не был найден!");
        }

        public Employee findEmployee(String firstName, String lastName){
                Employee employee = new Employee(firstName, lastName);
                if (employees.contains(employee)){
                                return employee;
                        }
                throw new EmployeeNotFoundException("Сотрудник с именем " + firstName +" и фамилией " + lastName + " не был найден!");
        }
}
