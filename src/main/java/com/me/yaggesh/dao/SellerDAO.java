package com.me.yaggesh.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.yaggesh.exception.AdException;
import com.me.yaggesh.pojo.Seller;

public class SellerDAO extends DAO{
	
	public Seller get(String brand) throws AdException{
		
		try {
			begin();
			Query q = getSession().createQuery("from Seller where brand = :brand");
			q.setString("brand", brand);
			Seller seller = (Seller)q.uniqueResult();
			commit();
			return seller;
		}catch(HibernateException e) {
			rollback();
			throw new AdException("Could not obtain the Brandname " + brand + " " + e.getMessage());
		}
	}
	public List list() throws AdException
	{
		try {
			begin();
			Query q = getSession().createQuery("from Seller");
			List list = q.list();
			commit();
			return list;
		}catch(HibernateException e) {
			rollback();
			throw new AdException("Could not list the BrandNames", e);
		}
	}
	
	public Seller create(String brand) throws AdException
	{
		try {
			begin();
			Seller seller = new Seller(brand);
			getSession().save(seller);
			commit();
			return null;
		}catch(HibernateException e) {
			rollback();
			throw new AdException("Exception while adding BrandName: " + e.getMessage());
		}
	}
	
	public void save(Seller brand) throws AdException{
		try {
			begin();
			getSession().update(brand);
			commit();
		}catch(HibernateException e) {
			rollback();
			throw new AdException("Could not save BrandName", e);
		}
	}
	
	public void delete(Seller brand) throws AdException{
		try {
			begin();
			getSession().delete(brand);
			commit();
		}catch(HibernateException e) {
			rollback();
			throw new AdException("Could not delete the BrandName", e);
		}
	}
}
