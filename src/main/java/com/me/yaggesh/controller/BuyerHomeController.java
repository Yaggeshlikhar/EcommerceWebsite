package com.me.yaggesh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.yaggesh.pojo.User;


@Controller
@RequestMapping("/BuyerHome.htm")
public class BuyerHomeController 
{
	@RequestMapping(method=RequestMethod.GET)
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
		ModelAndView mv = new ModelAndView("BuyerHome","user", session.getAttribute("loggedUser"));
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