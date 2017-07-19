package com.primeStore.musicStore.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable{	
	private static final long serialVersionUID = 1056988232992810973L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProduct;
	@NotEmpty(message="the product name must not be null")
	private String productName;
	private String productCategory;
	private String productDescription;
	@Min(value=0,message="The product price must no be less than zero")
	private double productPrice;
	private String productCondition;
	private String productStatus;
	@Min(value=0,message="The product price must no be less than zero")
	private int unitStack;
	private String productManufacture;
    @Transient
    private MultipartFile productImage;
    //mappedBy mapping this class into Cart Item like product field
    //CascadeType.ALL apply CRUD to child of products
    //Parent always is One and Many is childs
    //FetchType.EAGER updates the objects before make a query, default is LAZY
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemsList;
    
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String prouctDescription) {
		this.productDescription = prouctDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getUnitStack() {
		return unitStack;
	}
	public void setUnitStack(int unitStack) {
		this.unitStack = unitStack;
	}
	public String getProductManufacture() {
		return productManufacture;
	}
	public void setProductManufacture(String productManufacture) {
		this.productManufacture = productManufacture;
	}
        public MultipartFile getProductImage(){
            return productImage;
        }
        public void setProductImage(MultipartFile productImage){
            this.productImage = productImage;
        }
	
}
