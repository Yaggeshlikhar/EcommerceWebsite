package com.me.yaggesh.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.me.yaggesh.pojo.User;


@Controller
@RequestMapping("/contactSeller.htm")
public class ContactSellerFormController 
{
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("errorPage");
			return mv;
		}
		
		try
		{
		String sellerEmail = request.getParameter("email").toString();
		System.out.println("Seller email  :" +sellerEmail);
		User user = (User) session.getAttribute("loggedUser");
		System.out.println(user.getUsername());
		System.out.println("Contact Controller");
		System.out.println(sellerEmail);
		ModelAndView mv = new ModelAndView("contactSeller", "email", sellerEmail);
		System.out.println(sellerEmail);
		return mv;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
            session.invalidate();
            ModelAndView mv = new ModelAndView("errorPage");
			return mv;
		}
	}
}
