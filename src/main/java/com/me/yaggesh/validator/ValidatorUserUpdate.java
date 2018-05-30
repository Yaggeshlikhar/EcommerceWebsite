package com.me.yaggesh.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.yaggesh.pojo.User;





public class ValidatorUserUpdate implements Validator 
{
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String NON_NUMERIC = "([A-Za-z]+)";
	private static final String NON_ALPHA = "([0-9]+)";
	
    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userType", "error.invalid.userType", "User Type Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "error.invalid.street", "Street Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.city", "City Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.state", "State Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.invalid.zip", "ZIP code Required");
    
        String username = user.getUsername();

        
        Pattern patternEmail = Pattern.compile(EMAIL_PATTERN);
        Pattern patternNonNumeric = Pattern.compile(NON_NUMERIC);
        Pattern patternNonAlpha = Pattern.compile(NON_ALPHA);
        Matcher matcherEmail = patternEmail.matcher(user.getEmail());
        Matcher matcherFN = patternNonNumeric.matcher(user.getFname());
        Matcher matcherLN = patternNonNumeric.matcher(user.getLname());
        Matcher matcherCT = patternNonNumeric.matcher(user.getCity());
        Matcher matcherST = patternNonNumeric.matcher(user.getState());
        Matcher matcherZIP = patternNonAlpha.matcher(user.getZip());
        

        if(!matcherEmail.matches()) 
        {
                   errors.rejectValue("email","Test","Invalid Email");
        }
        if(!matcherFN.matches())
        {
        	errors.rejectValue("firstName", "Test", "Alphabets only!");
        }
        if(!matcherLN.matches())
        {
        	errors.rejectValue("lastName", "Test", "Alphabets only!");
        }
        if(!matcherCT.matches())
        {
        	errors.rejectValue("city", "Test", "Alphabets only!");
        }
        if(!matcherST.matches())
        {
        	errors.rejectValue("state", "Test", "Alphabets only!");
        }
        if(!matcherZIP.matches())
        {
        	errors.rejectValue("zip", "Test", "Numbers only!");
        }
    }
    
    
}
