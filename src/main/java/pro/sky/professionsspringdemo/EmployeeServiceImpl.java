package pro.sky.professionsspringdemo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

        private final int numberOfEmployees = 10;
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Вася", "Пупкин",2,10000),
                new Employee("Дима", "Капустин",2,15000),
                new Employee("Вася", "Кирилин",3,12000),
                new Employee("Христофор", "Иванов",4,15000)
        ));
        @Override
        public List<Employee> returnAllEmployees() {
                if (employees.isEmpty()){
                        throw new StorageOfEmployeesEmptyException("Отсутствуют сотрудники в компании");
                } else {
                        return employees;
                }
        }
        @Override
        public double getAllSalariesCost() {
                return employees.stream()
                        .filter(Objects::nonNull)
                        .mapToDouble(Employee::getEmployeeSalary)
                        .sum();
        }

        @Override
        public Employee getMinSalary() {
               return employees.stream()
                        .filter(Objects::nonNull)
                        .min(Comparator.comparingDouble(Employee::getEmployeeSalary))
                        .orElse(null);
        }
        @Override
        public Employee getMaxSalary() {
                return employees.stream()
                        .filter(Objects::nonNull)
                        .max(Comparator.comparingDouble(Employee::getEmployeeSalary))
                        .orElse(null);
        }
        @Override
        public OptionalDouble getMediumSalariesCost() {
                return employees.stream()
                        .filter(Objects::nonNull)
                        .mapToDouble(Employee::getEmployeeSalary)
                        .average();
        }
        @Override
        public List<String> getNames() {
               return employees.stream()
                        .filter(Objects::nonNull)
                        .map(
                       (p -> p.getFirstName() + " " + p.getLastName())
                ).collect(Collectors.toList());
        }
        @Override
        public void indexAllSalaries(double percent) {
                employees.stream()
                        .filter(Objects::nonNull)
                        .map(p -> {
                                double newSalary = p.getEmployeeSalary() * (1 + (percent / 100.0));
                                p.setEmployeeSalary(newSalary);
                                return p;
                        });
        }
        @Override
        public double getDepartmentSumSalary(int department) {
                return employees.stream()
                        .filter(Objects::nonNull)
                        .filter(p -> p.getDepartment() == department)
                        .mapToDouble(Employee::getEmployeeSalary)
                        .sum();
        }
        @Override
        public OptionalDouble getDepartmentAverageSalary(int department) {
                return employees.stream()
                        .filter(Objects::nonNull)
                        .filter(p -> p.getDepartment() == department)
                        .mapToDouble(Employee::getEmployeeSalary)
                        .average();
        }
        @Override
        public void indexDepartmentSalaries(int department, double percent) {
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(p -> p.getDepartment() == department)
                        .map(p -> {
                                double newSalary = p.getEmployeeSalary() * (1 + (percent / 100.0));
                                p.setEmployeeSalary(newSalary);
                                return p;
                        });
        }

        @Override
        public List<Employee> getLessSalary(int number) {
                System.out.println("Сотруники с зп поменьше: ");
                 return (List<Employee>) employees.stream()
                         .filter(p -> p.getEmployeeSalary() < number);
        }
        @Override
        public List<Employee> getMoreSalary(int number) {
                System.out.println("Сотрудники с зп побольше:");
                return (List<Employee>) employees.stream()
                        .filter(p -> p.getEmployeeSalary() > number);
        }


        @Override
        public Employee addEmployee(String firstName, String lastName, int department, double salary) {
                if (employees.size() == numberOfEmployees) {
                        throw new EmployeeStorageIsFullException("Company is staffed");
                }

                Employee employee = new Employee(firstName, lastName, department, salary);
                employees.stream()
                        .filter(e -> e.equals(employee))
                        .findAny()
                        .ifPresent(e -> {
                                throw new EmployeeAlreadyAddedException("Employee is already added in list!");
                        });

                employees.add(employee);
                return employee;
        }

        @Override
        public Employee removeEmployee(String firstName, String lastName, int department, double salary) {
                Employee employee = new Employee(firstName, lastName, department, salary);
                Optional<Employee> foundEmployee = employees.stream()
                        .filter(e -> e.equals(employee))
                        .findAny();

                if (foundEmployee.isPresent()) {
                        employees.remove(employee);
                        return employee;
                } else {
                        throw new EmployeeNotFoundException("Сотрудник с именем " + firstName + " и фамилией " + lastName + " не был найден!");
                }
        }

        @Override
        public Employee findEmployee(String firstName, String lastName, int department, double salary){
                Employee employee = new Employee(firstName, lastName, department, salary);
                Optional<Employee> foundEmployee = employees.stream()
                        .filter(e -> e.equals(employee))
                        .findAny();
                if (foundEmployee.isPresent()) {
                        return employee;
                } else {
                        throw new EmployeeNotFoundException("Сотрудник с именем " + firstName + " и фамилией " + lastName + " не был найден!");
                }
        }

}
