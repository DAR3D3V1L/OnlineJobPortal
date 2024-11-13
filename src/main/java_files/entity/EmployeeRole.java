package entity;

public class EmployeeRole {
    private int id;
    private String name;
    private Employee employee;

    public EmployeeRole() {
        super();
    }

    public EmployeeRole(int id, String name, Employee employee) {
        super();
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeSkill [id=" + id + ", name=" + name + ", employee=" + employee + "]";
    }
}
