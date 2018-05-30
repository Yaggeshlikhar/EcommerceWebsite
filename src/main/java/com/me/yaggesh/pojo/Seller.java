package com.me.yaggesh.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "sellertable")
public class Seller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sellerId")
	private int sellerId;
	
	@Column(name="brand")
	private String brand;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sellerId")
	private Set<Product> products = new HashSet<Product>(); 
	
	public Seller(String brand) {
		this.brand= brand;
		this.products = new HashSet<Product>();
	}
	
	public Seller() {
		
	}


	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	
	
	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product)
	{
		getProducts().add(product);
	}
	
	

	

}
