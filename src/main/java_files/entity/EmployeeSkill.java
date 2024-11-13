package entity;

public class EmployeeSkill {

    private int id;
    private String name;
    private int experience;
    private Employee employee;

    public EmployeeSkill() {
        super();
    }

    public EmployeeSkill(int id, String name, int experience, Employee employee) {
        super();
        this.id = id;
        this.name = name;
        this.experience = experience;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeSkill [id=" + id + ", name=" + name + ", experience=" + experience + ", employee=" + employee + "]";
    }
}
