package com.me.yaggesh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.me.yaggesh.dao.SellerDAO;
import com.me.yaggesh.pojo.Seller;
import com.me.yaggesh.pojo.User;
import com.me.yaggesh.validator.ValidatorSeller;

@Controller
@RequestMapping("/addBrands.htm")
public class AddBrandController {
	
	@Autowired
	@Qualifier("sellerValidator")
	ValidatorSeller sellerValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(sellerValidator);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("brand") Seller seller, BindingResult result, HttpServletRequest request,HttpServletResponse response, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		if(loggedUser == null)
		{
			return "errorPage";
		}
		sellerValidator.validate(seller, result);
		if(result.hasErrors())
		{
			return "addBrands";
		}
		
		try 
		{
			SellerDAO sellerDao = new SellerDAO();
			if(sellerDao.get(seller.getBrand())==null)
			{
				sellerDao.create(seller.getBrand());
				List list = sellerDao.list();
			}	
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			session.invalidate();
			return "errorPage";
		}
		return "brandAdded";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("brand") Seller seller, BindingResult result)
	{
		return "addBrands";
	}

}
