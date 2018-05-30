package com.me.yaggesh.pojo;

import java.util.Date;
import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productTable")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="productId")
	private int productId;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="description")
	private String description;

	@Column(name="price")
	private int price;
	
	@Column(name="postedDate")
	private Date postedDate;
	
	@Column(name="image")
	private byte[] image;
	
	@Transient
	private String postedBy;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;
	
	@JoinColumn(name = "sellerId")
	private int sellerId;
	
	public Product(String brand, String productName, String description, int price, Date postedDate,
			 User user, int sellerId, byte[] image) {
		this.brand = brand;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.postedDate = postedDate;
		this.user = user;
		this.sellerId = sellerId;
		this.image = image;
	}


	Product() {
		
	}
	
	
	


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}


	public String getPostedBy() {
		return postedBy;
	}


	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	

}
