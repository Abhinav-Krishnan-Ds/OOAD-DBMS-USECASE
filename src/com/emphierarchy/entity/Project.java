package com.emphierarchy.entity;


// This class is used to print the details of the projects that we are trying to search
public class Project {
    private int id;
    private String projectName;
    private String projectDesc;

    public Project(int id, String projectName, String projectDesc) {
        this.id = id;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public String getProjectDesc() { return projectDesc; }
    public void setProjectDesc(String projectDesc) { this.projectDesc = projectDesc; }
    
    @Override
    public String toString() {
        return "Project [id=" + id + ", projectName=" + projectName + ", projectDesc=" + projectDesc + "]";
    }
}