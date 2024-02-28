package com.doza.pfp.dao;

import com.doza.pfp.entity.Project;
import com.doza.pfp.entity.Task;
import com.doza.pfp.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProjectDAO implements Dao<Long, Project>{

    private static final ProjectDAO INSTANCE = new ProjectDAO();
    private static final String FIND_ALL =
    """
    SELECT *
    FROM project
    """;

    private ProjectDAO() {
    }

    @Override
    public List<Project> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Project> projects = new ArrayList<>();
            while (resultSet.next()) {
                projects.add(buildProject(resultSet));
            }
            return projects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Project> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Project entity) {

    }

    @Override
    public Project save(Project entity) {
        return null;
    }

    public static ProjectDAO getInstance() {
        return INSTANCE;
    }

    private Project buildProject(ResultSet resultSet) {
        try {
            return new Project(
                    resultSet.getObject("id", Integer.class),
                    resultSet.getObject("name", String.class),
                    resultSet.getObject("description", String.class),
                    resultSet.getObject("createDate", Timestamp.class).toLocalDateTime(),
                    Collections.singletonList(resultSet.getObject("task_id", Integer.class))
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
