package pro.sky.professionsspringdemo;

import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private double employeeSalary;

    public Employee(String firstName, String lastName, int department, double employeeSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.employeeSalary = employeeSalary;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public int getDepartment() {
        return department;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }
    public String getFirstName() {

        return this.firstName;
    }

    public String getLastName() {

        return this.lastName;
    }
    @Override
    public String toString() {
        return "Имя сотрудника: " + this.getFirstName() + " Фамилия сотрудника: " + this.getLastName() + " Департамент: "
                + this.getDepartment() + " Запралата: " + this.getEmployeeSalary();
    }
    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        Employee employee = (Employee) other;
        if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName()) &&
        department == employee.getDepartment() && employeeSalary == employee.getEmployeeSalary()) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(firstName,lastName,department,employeeSalary);
    }

}

