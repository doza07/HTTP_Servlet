package com.doza.pfp.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
