package com.me.yaggesh.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.me.yaggesh.exception.AdException;
import com.me.yaggesh.pojo.Product;
import com.me.yaggesh.pojo.User;

public class ProductDAO extends DAO{
	
	public Product create(String productName, String description, int price, Date postedDate, User user, int sellerId, byte[] image, String brand) throws AdException
	{
		try {
			begin();
			Product product = new Product(brand, productName, description, price, postedDate, user, sellerId, image);
			getSession().save(product);
			commit();
			return product;
		}catch(HibernateException e)
		{
			rollback();
			throw new AdException("Exception while adding a product" +e.getMessage());
		}
	}
	
	public Product searchById(int productId) throws AdException
	{
		try {
			begin();
			Query q = getSession().createQuery("from Product where productId = :productId");
			q.setInteger("productId", productId);
			Product product = (Product) q.uniqueResult();
			return product;
		}catch(HibernateException e) {
			rollback();
			throw new AdException("No results found with id " +productId+ " " +e.getMessage());
		}
	}
	
	public List searchByUser(long personId) throws AdException
	 {
		 try
		 {
			 begin();
			 Query q = getSession().createQuery("from Property where user = :personId");
			 q.setLong("personId", personId);
			 List list = q.list();
			 return list;
		 }catch(HibernateException e)
		 {
			 rollback();
			 throw new AdException("No property found with user " + personId + " " +e.getMessage());
		 }
	 }
	
	public List searchByUser(int page, User user) throws AdException
	 {
		 try
		 {
			 begin();
			 Criteria crit = getSession().createCriteria(Product.class);
			 crit.add(Restrictions.eq("user", user));
			 crit.setFirstResult(page);
			 crit.setMaxResults(3);
			 List<Product> results = crit.list();
			 return results;
		 }catch(HibernateException e)
		 {
			 rollback();
			 throw new AdException("No products found " +e.getMessage());
		 }
	 }
	
	public List listAllProducts(int page) throws AdException
	 {
		 try
		 {
			 begin();
			 Criteria crit = getSession().createCriteria(Product.class);
			 crit.setFirstResult(page);
			 crit.setMaxResults(5);
			 List<Product> results = crit.list();
			 return results;
		 }catch(HibernateException e)
		 {
			 rollback();
			 throw new AdException("No properties found " +e.getMessage());
		 }
	 }
	
	public List searchByPrice(int price,String brand, String brandName, String description) throws AdException
	{
		List<Product> products;
		try {
			begin();
			Criteria crit = getSession().createCriteria(Product.class);
			crit.add(Restrictions.lt("price", price));
			crit.add(Restrictions.eq("brand", brand));
			crit.add(Restrictions.eq("brandName", brandName));
			crit.add(Restrictions.eq("description", description));
			products = crit.list();
		}catch(HibernateException e)
		{
			rollback();
			throw new AdException("No Products found " + price + " " + e.getMessage());
		}
		return products;
	}
	
	public List searchByBrand(int price,String productName, String brand, String description) throws AdException
	{
		List<Product> products;
		try {
			begin();
			Criteria crit = getSession().createCriteria(Product.class);
			crit.add(Restrictions.ilike("brand", brand));
			crit.add(Restrictions.eq("price", price));
			crit.add(Restrictions.eq("productName", productName));
			crit.add(Restrictions.eq("description", description));
			products = crit.list();
		}catch(HibernateException e)
		{
			rollback();
			throw new AdException("No Products found " + brand + " " + e.getMessage());
		}
		return products;
	}
	
	public List search(String type, String query) throws AdException
	{
		List<Product> products = null;
		try {
			begin();
			Criteria crit = getSession().createCriteria(Product.class);
			if(type.equalsIgnoreCase("price"))
				crit.add(Restrictions.eq(type, Integer.parseInt(query)));
			else
				crit.add(Restrictions.ilike(type, query));
			products = crit.list();
		}catch(HibernateException e)
		{
			rollback();
			e.printStackTrace();
		}
		return products;
	}
	
	public List searchByDesc(int price,String productName, String brand, String description) throws AdException
	{
		List<Product> products;
		try {
			begin();
			Criteria crit = getSession().createCriteria(Product.class);
			crit.add(Restrictions.ilike("description", description));
			crit.add(Restrictions.eq("price", price));
			crit.add(Restrictions.eq("brand", brand));
			crit.add(Restrictions.eq("productName", productName));
			products = crit.list();
		}catch(HibernateException e)
		{
			rollback();
			throw new AdException("No Products found " + productName + " " + e.getMessage());
		}
		return products;
	}
	
	
	public void delete(Product product)
            throws AdException {
        try {
            begin();
            getSession().delete(product);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete product", e);
        }
    }
	

}
