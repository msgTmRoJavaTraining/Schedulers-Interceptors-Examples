package group.msg.examples.employee;


import lombok.Data;

@Data
public class Employee
{
    private String name;

    public Employee(){}
    public Employee(String name) {
        this.name = name;
    }

}
