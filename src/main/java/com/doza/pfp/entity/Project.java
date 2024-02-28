package com.doza.pfp.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Project {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createDate;
    private List<Integer> task_id;

    public Project(Integer id, String name, String description, LocalDateTime createDate, List<Integer> task_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.task_id = task_id;
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

    public List<Integer> getTask_id() {
        return task_id;
    }

    public void setTask_id(List<Integer> task_id) {
        this.task_id = task_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", task_id=" + task_id +
                '}';
    }
}
