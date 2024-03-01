package com.doza.pfp.service;

import com.doza.pfp.dao.UserDAO;
import com.doza.pfp.dto.CreateUserDTO;
import com.doza.pfp.entity.User;
import com.doza.pfp.exception.ValidationException;
import com.doza.pfp.mapper.CreateUserMapper;
import com.doza.pfp.validator.CreateUserValidator;
import com.doza.pfp.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDAO userDAO = UserDAO.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public Integer create(CreateUserDTO userDTO) {
        ValidationResult valid = createUserValidator.isValid(userDTO);
        if (!valid.isValid()) {
            throw new ValidationException(valid.getErrors());
        }
        User user = createUserMapper.mapFrom(userDTO);
        userDAO.save(user);
        //validation
        //map
        //userDAO.save
        //return id
        return user.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
