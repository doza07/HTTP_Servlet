package com.doza.pfp.dao;

import com.doza.pfp.entity.User;
import com.doza.pfp.util.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDAO implements Dao<Integer, User> {

    private static final UserDAO INSTANCE = new UserDAO();
    public static final String SAVE_SQL =
            "INSERT INTO users(name, birthday, email, password, role, gender) VALUES" +
            "(?, ?, ?, ?, ?, ?)";

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User save(User entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserDAO getInstance() {
        return INSTANCE;
    }
}
