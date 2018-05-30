package com.me.yaggesh.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.yaggesh.pojo.Seller;





@Component
public class ValidatorSeller implements Validator 
{
	private static final String NON_NUMERIC = "([A-Za-z]+)";
	
    public boolean supports(Class aClass)
    {
        return aClass.equals(Seller.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Seller newCategory = (Seller) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "error.invalid.brand", "Brand Required");
    
        Pattern patternNonNumeric = Pattern.compile(NON_NUMERIC);
        
        Matcher matcherCT = patternNonNumeric.matcher(newCategory.getBrand());
    }
}
