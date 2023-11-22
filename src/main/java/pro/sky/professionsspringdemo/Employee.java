package pro.sky.professionsspringdemo;

import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {

        return this.firstName;
    }

    public String getLastName() {

        return this.lastName;
    }
    @Override
    public String toString() {
        return "Имя сотрудника: " + this.getFirstName() + " Фамилия сотрудника: " + this.getLastName();
    }
    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        Employee employee = (Employee) other;
        if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(firstName,lastName);
    }

}

