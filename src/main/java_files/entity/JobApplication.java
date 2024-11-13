package entity;

import java.time.LocalDateTime;

public class JobApplication {

    private int id;
    private String status;
    private LocalDateTime appliedDate;
    private Employee employee;
    private Job job;

    public JobApplication() {
        super();
    }

    public JobApplication(int id, String status, LocalDateTime appliedDate, Employee employee, Job job) {
        super();
        this.id = id;
        this.status = status;
        this.appliedDate = appliedDate;
        this.employee = employee;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDateTime appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "JobApplication [id=" + id + ", status=" + status + ", appliedDate=" + appliedDate + ", employee=" + employee
                + ", job=" + job + "]";
    }
}
