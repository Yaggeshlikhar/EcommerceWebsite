package com.me.yaggesh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.yaggesh.dao.ProductDAO;
import com.me.yaggesh.exception.AdException;
import com.me.yaggesh.pojo.Product;
import com.me.yaggesh.pojo.User;
import com.me.yaggesh.validator.ValidatorProduct;


@Controller
@RequestMapping("/searchProduct.htm")
public class SearchProductController {
	
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("errorPage");
			return mv;
		}
		List productList = new ArrayList();
		try
		{
			
			
			//System.out.println(priceRange, brand, productName, description);
			
			ProductDAO productDao = new ProductDAO();
			productList  = productDao.search(request.getParameter("searchBy"), request.getParameter("values"));
			System.out.println(productList.size());
			ModelAndView mv = new ModelAndView("productResult", "productResult", productList);
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
