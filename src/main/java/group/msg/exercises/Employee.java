package group.msg.exercises;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private double salary;
    public Employee(){}

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}