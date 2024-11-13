package entity;

public class EmployerRole {
	    private int id;
	    private String name;
	    private Employer employer;

	    public EmployerRole() {
	        super();
	    }

	    public EmployerRole(int id, String name, Employer employer) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.employer = employer;
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

	    public Employer getEmployer() {
	        return employer;
	    }

	    public void setEmployer(Employer employer) {
	        this.employer = employer;
	    }

	    @Override
	    public String toString() {
	        return "EmployerRole [id=" + id + ", name=" + name + ", employer=" + employer + "]";
	    }
	}