package com.me.yaggesh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.yaggesh.dao.ProductDAO;
import com.me.yaggesh.exception.AdException;
import com.me.yaggesh.pojo.Product;
import com.me.yaggesh.pojo.User;


@Controller
@RequestMapping("/productDetails.htm")
public class ProductDetailsController {
	
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("errorPage");
			return mv;
		}
		
		
		try
		{
			Product product = null;
			ProductDAO productDao = new ProductDAO();
			product = productDao.searchById(Integer.parseInt(request.getParameter("id")));
			
			ModelAndView mv = new ModelAndView("productDetails", "details", product);
			return mv;
		}
		catch (AdException e) 
		{
            System.out.println(e.getMessage());
            session.invalidate();
            ModelAndView mv = new ModelAndView("errorPage");
			return mv;
        }
		}

}
