package com.alpha;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/*@Alias(value = "nickName")*/
public class Backlog {
    private String backlogTitle;
    private String description;
    private String path;
    private Date dueTime;
    private BacklogState state;

    public Backlog() {
    }

    public Backlog(String backlogTitle, String description, String path, Date dueTime, BacklogState state) {
        this.backlogTitle = backlogTitle;
        this.description = description;
        this.path = path;
        this.dueTime = dueTime;
        this.state = state;
    }

    public String getBacklogTitle() {
        return backlogTitle;
    }

    public void setBacklogTitle(String backlogTitle) {
        this.backlogTitle = backlogTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public BacklogState getState() {
        return state;
    }

    public void setState(BacklogState state) {
        this.state = state;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
