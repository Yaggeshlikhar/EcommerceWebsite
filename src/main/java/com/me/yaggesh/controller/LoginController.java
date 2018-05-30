package com.me.yaggesh.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.yaggesh.dao.UserDAO;
import com.me.yaggesh.pojo.User;
import com.me.yaggesh.validator.ValidatorLogin;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	
	@Autowired
	@Qualifier("loginValidator")
	ValidatorLogin validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doLogin(@ModelAttribute("user") User user, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model, BindingResult result)
	{
		validator.validate(user, result);
		if(result.hasErrors())
			return "login";
		
		try {
			UserDAO userdao = new UserDAO();
			User u = userdao.get(user.getUsername());
			session.setAttribute("loggedUser", u);
			
			Cookie userCookie = new Cookie("username", request.getParameter("username"));
            Cookie passwordCookie = new Cookie ("password", request.getParameter("password"));
			
            response.addCookie(userCookie);
            response.addCookie(passwordCookie);
            
			if(u != null && u.getPassword().equals(user.getPassword()) && u.getUserType().equalsIgnoreCase("Buyer"))
				return "BuyerHome";
			

			else if(u != null && u.getPassword().equals(user.getPassword()) && u.getUserType().equalsIgnoreCase("Seller"))
				return "SellerHome";
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e.getMessage());
			session.invalidate();
			return "login";
		}
		return "login";
			
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result)
	{
		return "login";
	}

}
