package com.doza.pfp.validator;

import com.doza.pfp.dto.CreateUserDTO;
import com.doza.pfp.entity.Gender;
import com.doza.pfp.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDTO> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDTO object) {
        var validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (object.getGender() == null || Gender.valueOf(object.getGender()) == null) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
