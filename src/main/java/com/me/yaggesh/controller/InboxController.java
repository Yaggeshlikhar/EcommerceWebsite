package com.me.yaggesh.controller;

import java.util.List;

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
import com.me.yaggesh.pojo.User;


@Controller
@RequestMapping("/inbox.htm")
public class InboxController {
	
	@RequestMapping(method=RequestMethod.GET)
	protected ModelAndView doGet(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	{
		
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null )
		{
			ModelAndView mv = new ModelAndView("errorPage");
			return mv;
		}
		
		try
		{
		String username = loggedUser.getUsername();
		List list = null;
		
			MessageDAO msgDao = new MessageDAO();
			UserDAO userDao = new UserDAO();
			//User u = userDao.get(loggedUser.getName());
			list = msgDao.listMessage(username);
			ModelAndView mv = new ModelAndView("inbox", "messageList", list);
			return mv;
		}
		catch (Exception e) 
		{
            System.out.println(e.getMessage());
            ModelAndView mv = new ModelAndView("errorPage");
			return mv;
        }
		
		
	}

}
