package group.msg.exercises;

public class Employee {

    private String name;
    private String cnp;
    private int age;

    public String getName() {
        return name;
    }

    public String getCnp() {
        return cnp;
    }

    public int getAge() {
        return age;
    }

    public Employee(String name, String cnp, int age) {
        this.name = name;
        this.cnp = cnp;
        this.age = age;
    }
}
