package com.me.yaggesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.yaggesh.dao.UserDAO;
import com.me.yaggesh.exception.AdException;
import com.me.yaggesh.pojo.User;
import com.me.yaggesh.validator.ValidatorUser;


@Controller
@RequestMapping("/adduser.htm")
public class AddUserController {
	
	@Autowired
	@Qualifier("userValidator")
	ValidatorUser validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception
	{
		if(result.hasErrors()) {
			return "adduser";
		}
		try {
			System.out.println("testing 1");
			UserDAO userdao = new UserDAO();
			System.out.println("testing 2");
			
			userdao.create(user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getEmail(), user.getUserType(), user.getStreet(), user.getCity(), user.getState(), user.getZip());
		}
		catch(AdException e)
		{
			System.out.println("Exception" + e.getMessage());
		}
		return "useradded";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "adduser";
	}
	

}
