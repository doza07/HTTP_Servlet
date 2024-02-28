package com.doza.pfp.dao;

import com.doza.pfp.entity.Task;
import com.doza.pfp.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskDAO implements Dao<Long, Task> {

    private static final TaskDAO INSTANCE = new TaskDAO();
    private static final String FIND_ALL_BY_PROJECT_ID = """
                    SELECT *
                    FROM task
                    WHERE project_id = ?
            """;

    private TaskDAO() {
    }

    public static TaskDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    public List<Task> findAllByTaskId(Long projectId) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_PROJECT_ID)) {
            preparedStatement.setObject(1, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Task> tasks = new ArrayList<>();
            while (resultSet.next()) {
                tasks.add(buildTask(resultSet));
            }
            return tasks;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Task> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Task entity) {

    }

    @Override
    public Task save(Task entity) {
        return null;
    }


    private Task buildTask(ResultSet resultSet) {
        try {
            return new Task(
                    resultSet.getObject("id", Integer.class),
                    resultSet.getObject("name", String.class),
                    resultSet.getObject("description", String.class),
                    resultSet.getObject("create_date", Timestamp.class).toLocalDateTime(),
                    resultSet.getObject("edite_date", Timestamp.class).toLocalDateTime(),
                    resultSet.getObject("is_done", Boolean.class),
                    resultSet.getObject("project_id", Integer.class)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
