package com.me.yaggesh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.yaggesh.dao.ProductDAO;
import com.me.yaggesh.dao.SellerDAO;
import com.me.yaggesh.pojo.User;


@Controller
@RequestMapping("/viewSellerProducts.htm")
public class ViewSellerProductsController {
	
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			ModelAndView mv = new ModelAndView("errorPage");
			return mv;
		}
		try
		{
			int page = 1;
			int recordsPerPage = 5;
			if(request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			
			SellerDAO brands = null;
			List brandlist = null;
			List productlist = new ArrayList();
			
			ProductDAO productDao = new ProductDAO();
			productlist = productDao.listAllProducts(page);
			request.setAttribute("noOfPages", 5);
			request.setAttribute("currentPage", page);

			ModelAndView mv = new ModelAndView("viewSellerProducts", "products", productlist);
			return mv;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			session.invalidate();
			ModelAndView mv = new ModelAndView("errorPage");
			return mv;
			
		}
	}

}
