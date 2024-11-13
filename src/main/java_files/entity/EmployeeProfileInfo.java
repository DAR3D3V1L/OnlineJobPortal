package entity;

public class EmployeeProfileInfo {

    private int id;
    private String photoPath;
    private String github;
    private String linkedin;
    private String bio;
    private String website;
    private String resumePath;
    private Employee employee;

    public EmployeeProfileInfo() {
        super();
    }

    public EmployeeProfileInfo(int id, String photoPath, String github, String linkedin, String bio, String website,
                               String resumePath, Employee employee) {
        super();
        this.id = id;
        this.photoPath = photoPath;
        this.github = github;
        this.linkedin = linkedin;
        this.bio = bio;
        this.website = website;
        this.resumePath = resumePath;
        this.employee = employee;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeProfileInfo [id=" + id + ", photoPath=" + photoPath + ", github=" + github + ", linkedin="
                + linkedin + ", bio=" + bio + ", website=" + website + ", resumePath=" + resumePath + ", employee="
                + employee + "]";
    }
}
