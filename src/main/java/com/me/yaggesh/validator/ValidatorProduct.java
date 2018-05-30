package com.me.yaggesh.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.yaggesh.pojo.Product;




@Component
public class ValidatorProduct implements Validator {

	
	private static final String NON_NUMERIC = "([A-Za-z]+)";
	private static final String NON_ALPHA = "([0-9]+)";
	
    public boolean supports(Class aClass)
    {
        return aClass.equals(Product.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Product property = (Product) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "error.invalid.property", "Brand Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "error.invalid.property", "Product Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.property", "Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.property", "Price Required");
    
    
        Pattern patternNonNumeric = Pattern.compile(NON_NUMERIC);
        Pattern patternNonAlpha = Pattern.compile(NON_ALPHA);
        
        Matcher matcherBD = patternNonNumeric.matcher(property.getBrand());
        Matcher matcherNM = patternNonNumeric.matcher(property.getProductName());
        
        if(!matcherBD.matches())
        {
        	errors.rejectValue("brand", "Test", "Alphabets only!");
        }
        if(!matcherNM.matches())
        {
        	errors.rejectValue("productName", "Test", "Alphabets only!");
        }
    }
    
   
}
