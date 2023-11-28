package pro.sky.professionsspringdemo;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
        private final int numberOfEmployees = 10;
        Map<Employee,String> employees = new HashMap<>(Map.of(
                new Employee("Вася", "Пупкин"),"ВасяПупкин",
                new Employee("Дима", "Капустин"), "ДимаКапустин",
                new Employee("Вася", "Кирилин"), "ВасяКирилин",
                new Employee("Христофор", "Иванов"), "ХристофорИванов"
        ));

        public Employee addEmployee(String firstName, String lastName) {
                if (employees.size() == numberOfEmployees) {
                        throw new EmployeeStorageIsFullException("Company is staffed");
                }
                Employee employee = new Employee(firstName, lastName);
                        if (employees.containsKey(employee)) {
                                throw new EmployeeAlreadyAddedException("Employee is already added in list!");
                        }
                employees.put(employee,firstName+lastName);
                return employee;
        }

        public Employee removeEmployee(String firstName, String lastName) {
                Employee employee = new Employee(firstName, lastName);
                        if (employees.containsKey(employee)){
                                employees.remove(employee);
                                return employee;
                        }
                throw new EmployeeNotFoundException("Сотрудник с именем " + firstName +" и фамилией " + lastName + " не был найден!");
        }

        public Employee findEmployee(String firstName, String lastName){
                Employee employee = new Employee(firstName, lastName);
                if (employees.containsKey(employee)){
                                return employee;
                        }
                throw new EmployeeNotFoundException("Сотрудник с именем " + firstName +" и фамилией " + lastName + " не был найден!");
        }

}
