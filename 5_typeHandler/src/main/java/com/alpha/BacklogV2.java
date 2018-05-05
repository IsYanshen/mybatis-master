package com.alpha;

import java.util.Date;

public class BacklogV2 {
    private String title;
    private String description;
    private String path;
    private Date dueTime;
    private Address address;
    private Cooperator[] cooperators;
    private BacklogState state;

    public BacklogV2() {
        cooperators = new Cooperator[]{new Cooperator(), new Cooperator()};
    }

    public Cooperator[] getCooperators() {
        return cooperators;
    }

    public void setCooperators(Cooperator[] cooperators) {
        this.cooperators = cooperators;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BacklogState getState() {
        return state;
    }

    public void setState(BacklogState state) {
        this.state = state;
    }
}
