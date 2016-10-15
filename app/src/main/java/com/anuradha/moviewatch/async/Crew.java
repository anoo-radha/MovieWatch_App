package com.anuradha.moviewatch.async;


public class Crew {
    private String id;

    private String credit_id;

    private String department;

    private String name;

    private String job;

//    private null profile_path;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "ClassPojo [department = " + department + ", name = " + name + ", job = " + job + " ]";
    }
}

