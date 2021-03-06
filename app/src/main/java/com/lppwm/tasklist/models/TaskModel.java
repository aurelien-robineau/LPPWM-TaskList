package com.lppwm.tasklist.models;

import java.util.Date;

public class TaskModel {
    private static int lastId = 0;

    private int id;
    private String title;
    private Date date;
    private Boolean done;

    public TaskModel(String title, Date date) {
        this.id = lastId++;
        this.title = title;
        this.date = date;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public Boolean isDone() {
        return done;
    }
}
