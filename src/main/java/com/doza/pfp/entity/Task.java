package com.doza.pfp.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime editeDate;
    private Boolean isDone;
    private Integer project_id;

    public Task(Integer id, String name, String description, LocalDateTime createDate, LocalDateTime editeDate, Boolean isDone, Integer project_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.editeDate = editeDate;
        this.isDone = isDone;
        this.project_id = project_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getEditeDate() {
        return editeDate;
    }

    public void setEditeDate(LocalDateTime editeDate) {
        this.editeDate = editeDate;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", editeDate=" + editeDate +
                ", isDone=" + isDone +
                ", project_id=" + project_id +
                '}';
    }
}
