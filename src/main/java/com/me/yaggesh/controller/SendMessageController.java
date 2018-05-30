package com.me.yaggesh.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.yaggesh.dao.MessageDAO;
import com.me.yaggesh.dao.UserDAO;
import com.me.yaggesh.pojo.Message;
import com.me.yaggesh.pojo.User;


@Controller
@RequestMapping("/sendMessage.htm")
public class SendMessageController 
{
	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView sendMessage(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("errorPage");
			return mv;
		}
		try
		{
		UserDAO userDao = new UserDAO();
		MessageDAO msgDAO = new MessageDAO();
		
		//User loggedUser = (User) session.getAttribute("loggedUser");
		User sender = userDao.get(loggedUser.getUsername());
		System.out.println(request.getParameter("to"));
		User receiver = userDao.byEmail(request.getParameter("to"));
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");
		Date date = new Date();
		
		
		Message messg = msgDAO.createMessage(receiver.getUsername(), sender.getUsername(), subject, body,date, sender, sender.getPersonId());
		receiver.addMessage(messg);
		userDao.save(receiver);
		
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("body"));
		ModelAndView mv = new ModelAndView("msgSent", "sentTo", receiver);
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
