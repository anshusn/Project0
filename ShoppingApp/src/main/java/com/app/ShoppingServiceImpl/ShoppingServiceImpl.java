package com.app.ShoppingServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.app.ShoppingService.ShoppingService;
import com.app.Shoppingdao.ShoppingDAO;
import com.app.ShoppingdaoImpl.ShoppingDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customerdetails;
import com.app.model.Orderproduct;
import com.app.model.Product;
import com.app.model.Customerlogin;

public class ShoppingServiceImpl implements ShoppingService{
	ShoppingDAO shoppingdao=new ShoppingDAOImpl();
	@Override
	public Product Addproduct(Product product) throws BusinessException {
		if(product.getProName()!=null && product.getNumofItems()!=0 && product.getProPrice()!=0.00) {
			product= shoppingdao.Addproduct(product);
		}
		else {
			throw new BusinessException("Invalid Details...");
		}
		return product;
	}
	@Override
	public Customerlogin Signup(Customerlogin viewcustomer) throws BusinessException {
		if(viewcustomer.getCusfirstname()!=null && viewcustomer.getCuslastname()!=null &&
				viewcustomer.getCusemail()!=null && viewcustomer.getCuspassword()!=null) {
			viewcustomer= shoppingdao.Signup(viewcustomer);
		}
		else {
			throw new BusinessException("Invalid Details...");
		}
	    return viewcustomer;
	}
	@Override
	public List<Product> Viewproducts() throws BusinessException {
		List<Product> productlist = new ArrayList<>();
		productlist = shoppingdao.Viewproducts();
		return productlist;
	}
	@Override
	public Cart Addtocart(Cart cart) throws BusinessException {
		if(cart.getProduct()!=null && cart.getCountproduct()!=0 && cart.getCusid()!=0
				&& cart.getTotal()!=0) {
			cart= shoppingdao.Addtocart(cart);
		}
		else {
			throw new BusinessException("Invalid Details...");
		}
		return cart;
	}
	@Override
	public Customerdetails Viewprofile(int id) throws BusinessException {
		Customerdetails profile=new Customerdetails();
		if(id!=0) {
			profile=shoppingdao.Viewprofile(id);
		}
		return profile;
	}
	@Override
	public Cart Viewmycart(int id) throws BusinessException {
		Cart cart=new Cart();
		if(id!=0) {
			cart=shoppingdao.Viewmycart(id);
		}
		return cart;
	}
	@Override
	public Customerdetails getcustomerbyemail(String email) throws BusinessException {
		Customerdetails byemail=new Customerdetails();
		if(email!=null) {
			byemail=shoppingdao.getcustomerbyemail(email);
		}
		return byemail;
	}

	@Override
	public Orderproduct getcustomerbyordernum(int ordernum) throws BusinessException {
		Orderproduct byorderid=new Orderproduct();
		if(byorderid!=null) {
			byorderid=shoppingdao.getcustomerbyordernum(ordernum);
		}
		return byorderid;
	}
	
	@Override
	public Customerdetails getcustomerbyaddress(String address) throws BusinessException {
		Customerdetails byaddress=new Customerdetails();
		if(address!=null) {
			byaddress=shoppingdao.getcustomerbyaddress(address);
		}
		return byaddress;
	}

	@Override
	public Customerdetails getcustomerbyname(String cusname) throws BusinessException {
		Customerdetails byname=new Customerdetails();
		if(cusname!=null) {
			byname=shoppingdao.getcustomerbyname(cusname);
		}
		return byname;
	}

}
