package com.app.ShoppingService;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customerdetails;
import com.app.model.Orderproduct;
import com.app.model.Product;
import com.app.model.Customerlogin;

public interface ShoppingService {
	public Product Addproduct(Product product) throws BusinessException;
	public Customerlogin Signup(Customerlogin viewcustomer) throws BusinessException;
	public List<Product> Viewproducts() throws BusinessException;
	public Cart Addtocart(Cart cart) throws BusinessException;
	public Customerdetails Viewprofile(int id) throws BusinessException;
	public Cart Viewmycart(int id) throws BusinessException;
	public Customerdetails getcustomerbyemail(String email) throws BusinessException;
	public Orderproduct getcustomerbyordernum(int ordernum) throws BusinessException;
	public Customerdetails getcustomerbyaddress(String address) throws BusinessException;
	public Customerdetails getcustomerbyname(String cusname) throws BusinessException;
	
}
