package com.doza.pfp.mapper;

import com.doza.pfp.dto.CreateUserDTO;
import com.doza.pfp.entity.Gender;
import com.doza.pfp.entity.Role;
import com.doza.pfp.entity.User;
import com.doza.pfp.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDTO, User>{

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDTO object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
