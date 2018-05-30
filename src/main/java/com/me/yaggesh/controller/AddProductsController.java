package com.me.yaggesh.controller;

import java.util.Date;
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

import com.me.yaggesh.validator.ValidatorProduct;
import com.me.yaggesh.validator.ValidatorSeller;
import com.me.yaggesh.dao.ProductDAO;
import com.me.yaggesh.dao.SellerDAO;
import com.me.yaggesh.dao.UserDAO;
import com.me.yaggesh.pojo.Product;
import com.me.yaggesh.pojo.Seller;
import com.me.yaggesh.pojo.User;

@Controller
@RequestMapping("addProducts.htm")
public class AddProductsController {
	
	@Autowired
	@Qualifier("productValidator")
	 ValidatorProduct productValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(productValidator);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String doSubmitAction(@ModelAttribute("product")Product product, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		User loggedUser = (User) session.getAttribute("loggedUser");
		
		if(loggedUser == null)
		{
			return "errorPage";
		}
		productValidator.validate(product, result);
		if(result.hasErrors())
		{
			return "addProducts";
		}
		
		try 
		{
			String username= product.getPostedBy();
			String brand = product.getBrand();
			String productName = product.getProductName();
			String description = product.getDescription();
			int price = product.getPrice();
			Date postedDate = new Date();
			byte[] image = product.getImage();
			
			
			UserDAO userdao = new UserDAO();
			SellerDAO sellerdao = new SellerDAO();
			ProductDAO productdao = new ProductDAO();
			
			User user = userdao.get(username);
			Seller seller = sellerdao.get(brand);
			Product products = productdao.create(productName, description, price, postedDate, user, seller.getSellerId(), image, seller.getBrand());
			
			seller.addProduct(products);
			sellerdao.save(seller);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			session.invalidate();
			return "errorPage";
		}
		return "productAdded";
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("product")Product product, BindingResult result) { 
   
		
        return "addProducts"; 
    }

}