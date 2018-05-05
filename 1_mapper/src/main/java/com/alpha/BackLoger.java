package com.alpha;
import java.util.Date;
public class BackLoger {
    private String title;
    private String description;
    private String path;
    private Date dueTime;
    private BacklogState state;

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

    public BacklogState getState() {
        return state;
    }

    public void setState(BacklogState state) {
        this.state = state;
    }
}
