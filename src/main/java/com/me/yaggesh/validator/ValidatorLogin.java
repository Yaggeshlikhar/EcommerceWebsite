package com.me.yaggesh.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.yaggesh.pojo.User;



public class ValidatorLogin implements Validator
{
	public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User ID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required");
    }
    
    
}
