package group.msg.examples.day13;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private String role;


    public Employee(String name,String role) {
        this.name = name;
        this.role=role;
    }
}
