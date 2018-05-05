package com.alpha;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BacklogV2 {
    private Integer id;
    private String title;
    private String description;
    private String path;
    private Date dueTime;
    private Address address;
    private List<Cooperator> cooperators;
    private BacklogState state;

    public BacklogV2() {
        cooperators = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Cooperator> getCooperators() {
        return cooperators;
    }

    public void setCooperators(List<Cooperator> cooperators) {
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
