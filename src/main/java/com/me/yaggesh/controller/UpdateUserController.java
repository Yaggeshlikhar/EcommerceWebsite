package com.me.yaggesh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.yaggesh.dao.UserDAO;
import com.me.yaggesh.exception.AdException;
import com.me.yaggesh.pojo.User;
import com.me.yaggesh.validator.ValidatorUserUpdate;


@Controller
@RequestMapping("/updateUser.htm")
public class UpdateUserController {
	
	@Autowired
	@Qualifier("userUpdateValidator")
	ValidatorUserUpdate validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			return "errorPage";
		}
		
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "updateUserForm";
		}

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			User updatedUser = userDao.update(user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getEmail(), user.getUserType(), user.getStreet(), user.getCity(), user.getState(), user.getZip(), user);
			//userDao.update(user.getName(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserType(), user.getStreet(), user.getCity(), user.getState(), user.getZip());
			return "userUpdated";
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
			session.invalidate();
			return "errorPage";
		}
		}
		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView initializeForm(@ModelAttribute("user") User user, BindingResult result, HttpSession session) {

			User loggedUser = (User) session.getAttribute("loggedUser");
			if(loggedUser == null)
			{
				ModelAndView mv = new ModelAndView("errorPage");
				return mv;
			}

			try 
			{
				User usr = null;
				UserDAO userDao = new UserDAO();
				usr = userDao.get(loggedUser.getUsername());
				ModelAndView mv = new ModelAndView("updateUserForm", "user",usr);
				return mv;
			} 
			catch (AdException e) 
			{
				e.printStackTrace();
				session.invalidate();
				ModelAndView mv = new ModelAndView("errorPage");
				return mv;
			}
			
		}

}
