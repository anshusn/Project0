package com.app.ShoppingdaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Shoppingdao.ShoppingDAO;
import com.app.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customerdetails;
import com.app.model.Customerlogin;
import com.app.model.Employeelogin;
import com.app.model.Orderproduct;
import com.app.model.Product;
import com.app.model.Customerlogin;
import com.mysql.cj.protocol.Resultset;

public class ShoppingDAOImpl implements ShoppingDAO{
	private static Logger log=Logger.getLogger(ShoppingDAO.class);

	@Override
	public Product Addproduct(Product product) throws BusinessException {
		try(Connection connection=MySqlDbConnection.getConnection()){
		String sql="insert into Product(proName,numOfItems,proPrice) values(?,?,?)";
		PreparedStatement preparedstatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		preparedstatement.setString(1, product.getProName());	
		preparedstatement.setInt(2, product.getNumofItems());	
		preparedstatement.setFloat(3, product.getProPrice());	
		int c=preparedstatement.executeUpdate();
		if(c!=1) {
			log.info("Rows not affected");
		}}
		catch(ClassNotFoundException | SQLException e){
		log.warn(e);
		log.info("Internal error occurred....Kindly contact SYSADMIN");
	}
		return product;
	}

	@Override
	public Customerlogin Signup(Customerlogin signupcus) throws BusinessException {
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into customerlogin(cusfirstname,cuslastname,cusemail,cuspassword) values(?,?,?,?)";
			PreparedStatement preparedstatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedstatement.setString(1, signupcus.getCusfirstname());	
			preparedstatement.setString(2, signupcus.getCuslastname());	
			preparedstatement.setString(3, signupcus.getCusemail());	
			preparedstatement.setString(4, signupcus.getCuspassword());
		    int rowAffected = preparedstatement.executeUpdate();
			if(rowAffected!=1) {
				log.info("Rows not affected");
			}
			}catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			log.info("Internal error occurred....kindly contact SYSADMIN");
		}
		return signupcus;
	}

	@Override
	public List<Product> Viewproducts() throws BusinessException {
		List<Product> productlist = new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select proName,numOfItems,proPrice from Product";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product.setProName(resultSet.getString("proName"));
				product.setNumofItems(resultSet.getInt("numOfItems"));
				product.setProPrice(resultSet.getFloat("proPrice"));
				productlist.add(product);
			}
			System.out.println("There are "+productlist.size()+" different products having some count are available ");
			if(productlist.size()==0) {
				throw new BusinessException("No product exists as of now");
			}
		}catch(ClassNotFoundException | SQLException | NullPointerException e) {
			log.warn(e);
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
		return productlist;
	}

	@Override
	public Cart Addtocart(Cart cart) throws BusinessException {
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into Cart(product,countproduct,cus_id,total) values(?,?,?,?)";
			PreparedStatement preparedstatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedstatement.setString(1, cart.getProduct());	
			preparedstatement.setInt(2, cart.getCountproduct());	
			preparedstatement.setInt(3, cart.getCusid());	
			preparedstatement.setFloat(4, cart.getTotal());	
			int c=preparedstatement.executeUpdate();
			if(c!=1) {
				log.info("rows not affected");
				}
		}
		catch(ClassNotFoundException | SQLException e){
			log.warn(e);
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
			return cart;
	    }

	@Override
	public Customerdetails Viewprofile(int id) throws BusinessException {
		Customerdetails profile=new Customerdetails();
		Customerlogin login=new Customerlogin();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select loginid,name,email,address,gender,cuspassword from customerdetails c join customerlogin l on c.loginid=l.id where l.id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				profile.setId(resultSet.getInt("loginid"));
				profile.setName(resultSet.getString("name"));
				profile.setEmail(resultSet.getString("email"));
				profile.setAddress(resultSet.getString("address"));
				profile.setGender(resultSet.getString("gender"));
				login.setCuspassword(resultSet.getString("cuspassword"));
				profile.setCustomerlogin(login);
			}
		}catch(ClassNotFoundException | SQLException | NullPointerException e) {
			log.warn(e);
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
		return profile;
	}

	@Override
	public Cart Viewmycart(int id) throws BusinessException {
		Cart cart=new Cart();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select cus_id,product,countproduct,total from cart where cus_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				cart.setCusid(resultSet.getInt("cus_id"));
				cart.setProduct(resultSet.getString("product"));
				cart.setCountproduct(resultSet.getInt("countproduct"));
				cart.setTotal(resultSet.getFloat("total"));
			}
		}catch(ClassNotFoundException | SQLException | NullPointerException e) {
			log.warn(e);
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
		return cart;
	}

	@Override
	public Customerdetails getcustomerbyemail(String email) throws BusinessException {
		Customerdetails byemail=new Customerdetails();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select id,name,email,address,gender from customerdetails where email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				byemail.setId(resultSet.getInt("id"));
				byemail.setName(resultSet.getString("name"));
				byemail.setEmail(resultSet.getString("email"));
				byemail.setAddress(resultSet.getString("address"));
				byemail.setGender(resultSet.getString("gender"));
			}
		}catch(ClassNotFoundException | SQLException e) {
			log.warn(e);
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
		return byemail;
	}

	@Override
	public Orderproduct getcustomerbyordernum(int ordernum) throws BusinessException {
		Orderproduct byorderid1=new Orderproduct();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select id,name,email,address,gender,orderid from orderproduct o join customerdetails c on o.customerid=c.id where o.orderid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
		    preparedStatement.setInt(1, ordernum);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customerdetails byorderid=new Customerdetails();
				byorderid.setId(resultSet.getInt("id"));
				byorderid.setName(resultSet.getString("name"));
				byorderid.setEmail(resultSet.getString("email"));
				byorderid.setAddress(resultSet.getString("address"));
				byorderid.setGender(resultSet.getString("gender"));
				byorderid1.setOrderid(resultSet.getInt("orderid"));
				byorderid1.setCustomerdetails(byorderid);
			}
		}catch(ClassNotFoundException | SQLException | NullPointerException e) {
			log.warn(e);
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
		return byorderid1;
	}

	@Override
	public Customerdetails getcustomerbyaddress(String address) throws BusinessException {
		Customerdetails byaddress=new Customerdetails();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select id,name,email,address,gender from customerdetails where address=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, address);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				byaddress.setId(resultSet.getInt("id"));
				byaddress.setName(resultSet.getString("name"));
				byaddress.setEmail(resultSet.getString("email"));
				byaddress.setAddress(resultSet.getString("address"));
				byaddress.setGender(resultSet.getString("gender"));
			}
		}catch(ClassNotFoundException | SQLException | NullPointerException e) {
			log.warn(e);
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
		return byaddress;
	}

	@Override
	public Customerdetails getcustomerbyname(String cusname) throws BusinessException {
		Customerdetails byname=new Customerdetails();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select id,name,email,address,gender from customerdetails where name=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, cusname);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				byname.setId(resultSet.getInt("id"));
				byname.setName(resultSet.getString("name"));
				byname.setEmail(resultSet.getString("email"));
				byname.setAddress(resultSet.getString("address"));
				byname.setGender(resultSet.getString("gender"));
			}
		}catch(ClassNotFoundException | SQLException | NullPointerException e) {
			log.warn(e);
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
		return byname;
	}
}