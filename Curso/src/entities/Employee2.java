package entities;

public class Employee2 {
    private Integer id;
    private String name;
    private Double salary;

    public Employee2(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary(double percentage) {
        salary += salary + (salary * percentage / 100);
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %.2f", id, name, salary);
    }
}
