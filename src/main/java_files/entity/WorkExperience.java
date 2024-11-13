package entity;

import java.util.Date;

public class WorkExperience {

    private int id;
    private String company;
    private String position;
    private Date startDate;
    private Date endDate;
    private Employee employee;

    public WorkExperience() {
        super();
    }

    public WorkExperience(int id, String company, String position, Date startDate, Date endDate, Employee employee) {
        super();
        this.id = id;
        this.company = company;
        this.position = position;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        return "WorkExperience [id=" + id + ", company=" + company + ", position=" + position + ", startDate=" + startDate
                + ", endDate=" + endDate + "]";
    }
}
