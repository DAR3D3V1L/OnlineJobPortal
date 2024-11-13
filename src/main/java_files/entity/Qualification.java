package entity;

import java.util.Date;

public class Qualification {

    private int id;
    private String degree;
    private Date startDate;
    private Date endDate;
    private Employee employee;

    public Qualification() {
        super();
    }

    public Qualification(int id, String degree, Date startDate, Date endDate, Employee employee) {
        super();
        this.id = id;
        this.degree = degree;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Qualification [id=" + id + ", degree=" + degree + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
}
