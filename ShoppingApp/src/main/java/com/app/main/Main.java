package com.app.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.ShoppingService.LoginService;
import com.app.ShoppingService.ShoppingService;
import com.app.ShoppingServiceImpl.LoginServiceImpl;
import com.app.ShoppingServiceImpl.ShoppingServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customerdetails;
import com.app.model.Customerlogin;
import com.app.model.Employeelogin;
import com.app.model.Orderproduct;
import com.app.model.Product;
import com.app.model.Customerlogin;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		log.info("                     WELCOME TO ANSHU'S ONLINE SHOPPING APP     ");
		log.info("              ==================================================");
		int ch = 0;
		do {
			log.info("Main Menu: ");
			log.info("1).Log in");
			log.info("2).SignUp as a Customer");
			log.info("3).Exit");
			log.info("Enter a number between 1-3: ");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (ch) {
			case 1:
				int option = 0;
				LoginService loginservice = null;
				ShoppingService shoppingservice=new ShoppingServiceImpl();
				Product product=null;
				log.info("\n           ------Welcome to Log-in Menu------");
				log.info("\nLogin menu");
				log.info("\n1).Login As Employee");
				log.info("2).login As Customer");
				log.info("3).go to main menu");
				log.info("Enter your choice: ");
				try {
					option = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					log.info("you have entered wrong digit");
				}
				switch (option) {
				case 1:
					Employeelogin employeelogin = null;
					for (int i = 3; i > 0; i--) {
						log.info("\n         WELCOME TO EMPLOYEE LOGIN SCREEN");
						log.info("          ==================================");
						log.info("\nEnter your email: ");
						String euser = sc.nextLine();
						log.info("\nEnter your password: ");
						String epassword =sc.nextLine();
						employeelogin =new Employeelogin(euser,epassword);
						try {
							loginservice = new LoginServiceImpl();
							employeelogin = loginservice.empLogin(employeelogin);
							
							if (employeelogin.getEmppassword().equals(epassword) && employeelogin.getEmpemail().equals(euser)) {
								log.info("\nEmployee Login Successfully!!");

								int choice = 0;
								do {
									log.info("\nWelcome " + euser);
									log.info("1).Add product");
									log.info("2).View customers using different filters");
									log.info("3).LogOut");
									log.info("Enter choice between 1-3: ");
									try {
										choice = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
									}
								 switch (choice) {
									case 1:
										log.info("\nEnter Product Name: ");
										String pname=sc.nextLine();
										log.info("\nEnter number of product: ");
										int pnumpro=Integer.parseInt(sc.nextLine());
										log.info("\nEnter Product price: ");
										float pprice=Float.parseFloat(sc.nextLine());
										product=new Product(pname,pnumpro,pprice);
										try {
											shoppingservice=new ShoppingServiceImpl();
											shoppingservice.Addproduct(product);
											log.info("product is added successfully");
										}
										catch(BusinessException e) {
											log.warn(e.getMessage());
											throw new BusinessException("Adding Product Failed!!");
										}
										break;
								   case 2:
										int choice1 = 0;
									do{
										log.info("1).view customers using email");
										log.info("2).View customers using order number");
										log.info("3).View customers using Address");
										log.info("4).View customers using name");
										log.info("5).Go to previous Screen");
										log.info("Enter choice between 1-5: ");
										try {
											choice1 = Integer.parseInt(sc.nextLine());
										} catch (NumberFormatException e) {
										}
										switch (choice1) {
										case 1:
											log.info("Enter Customer Email: ");
											try {
											String email1 = sc.nextLine();
											Customerdetails cusdetails=new Customerdetails();
										    cusdetails=shoppingservice.getcustomerbyemail(email1);
										   if(cusdetails!=null) {
											   log.info("\ncustomer with email "+email1+" found successfully... Below is the details");
											   log.info(cusdetails);
										   }
											}catch(BusinessException e) {
												log.error(e);
												log.info("Invalid email entered");
											}
											break;
										case 2:
											Customerdetails cusdetails1=new Customerdetails();
											log.info("Enter ordernumber: ");
											try {
												Orderproduct orderproduct=new Orderproduct();
												int ordernum=Integer.parseInt(sc.nextLine());	
												orderproduct=shoppingservice.getcustomerbyordernum(ordernum);
												}catch(BusinessException e) {
													log.error(e);
													log.info("Invalid email entered");
												}
												break;
										case  3:
											Customerdetails cusdetails2=new Customerdetails();
											log.info("Enter Customer address: ");
										    try {
										    	String address1 = sc.nextLine();
												cusdetails2=shoppingservice.getcustomerbyaddress(address1);
												if(cusdetails2!=null) {
													   log.info("\ncustomer with address "+address1+" found successfully... Below is the details");
													   log.info(cusdetails2);
												}
												}catch(BusinessException e) {
													log.error(e);
													log.info("Invalid email entered");
												}
											break;
										case 4:
											Customerdetails cusdetails3=new Customerdetails();
											log.info("Enter Customer name you want to view: ");
											try {
										    	String cusname1 = sc.nextLine();
												cusdetails3=shoppingservice.getcustomerbyname(cusname1);
												if(cusdetails3!=null) {
													   log.info("\ncustomer with name "+cusname1+" found successfully... Below is the details");
													   log.info(cusdetails3);
												}
											}catch(BusinessException e) {
													log.error(e);
													log.info("Invalid email entered");
												} 
											break;
										case 5:
											log.info("\nNow you are back to Employee Main Screen");
											break;
										}
									}while(choice1!=5);
										break;
								 case 3:
										log.info("\nLogged out successfully!!");
										break;
									}
								} while (choice != 3);

								i = 0;
							} else {
								log.info("\nEmployee Login failed...you have left with " + (i - 1) + " chance");
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
					}
					break;
				case 2:
					Customerlogin customerlogin = null;
					for (int j = 3; j > 0; j--) {
						log.info("\n           WELCOME TO CUSTOMER LOGIN SCREEN");
						log.info("           =====================================");
						log.info("\nEnter your email: ");
						String cuser = sc.nextLine();
						log.info("Enter your password: ");
						String cpassword = sc.nextLine();
						log.info(cuser);
						log.info(cpassword);
						customerlogin = new Customerlogin(cuser, cpassword);
						try {
							loginservice = new LoginServiceImpl();
							customerlogin = loginservice.cusLogin(customerlogin);
							//log.info(customerlogin.getCusemail());
						    ////log.info(cuser);
							//log.info(customerlogin.getCuspassword());
							//log.info(cpassword);
							if (customerlogin.getCuspassword().equals(cpassword) && customerlogin.getCusemail().equals(cuser) ) {
								log.info("\nCustomer Login Successfully!!");
								
								int choice = 0;
								do {
									log.info("\nWelcome " + cuser);
									log.info("\n1).View Profile");
									log.info("2).View Product");
									log.info("3).View Cart");
									log.info("4).LogOut");
									log.info("Enter choice between 1-4: ");
									try {
										choice = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
									}
									switch (choice) {
									case 1:
										log.info("\n===YOUR PROFILE===");
										log.info("id: ");
										int id=Integer.parseInt(sc.nextLine());
										Customerdetails profile=new Customerdetails();
										profile=shoppingservice.Viewprofile(id);
										if(profile!=null) {
											log.info(profile);
										}
										break;
									case 2:
										Cart cart=null;
										log.info("these are all products");
										try {
											shoppingservice=new ShoppingServiceImpl();
											List<Product> productlist=shoppingservice.Viewproducts();
										    for(Product p:productlist) {
										    	log.info(p);
										    }
										}
										    catch(BusinessException | NullPointerException e) {
										    	log.error(e.getMessage());
										    }
										log.info("Enter 1 to add product: ");
										     int add=Integer.parseInt(sc.nextLine());
										     if(add==1){
										    log.info("Enter product name to add to cart: ");
										    String pname=sc.nextLine();
										    log.info("enter number of items: ");
											int pcount=Integer.parseInt(sc.nextLine());
											log.info("enter your cusid: ");
											int cusid=Integer.parseInt(sc.nextLine());
											log.info("enter total: ");
											float total=Float.parseFloat(sc.nextLine());
									        cart=new Cart(pname,pcount,cusid,total);
									        try {
									        	cart=shoppingservice.Addtocart(cart);
									        	log.info("product added to cart successfully!!");
									        }catch(BusinessException e) {
									        	log.error(e);
									        	log.info("Internal error occurred....kindly contact SYSADMIN");
									        }}else {
									        	log.info("invalid number.");
									        }
									     break;
									case 3:
										log.info("\n===your cart===");
										log.info("enter id: ");
										int id1=Integer.parseInt(sc.nextLine());
										cart=shoppingservice.Viewmycart(id1);
									    log.info(cart);
										log.info("Do you want to order these products?yes/no");
										String answer=sc.next();
										if(answer.equals("yes")) {
											log.info("processing....");
										}else if(answer.equals("no")) {
											log.info("these are options you have: ");
										}else {
											log.info("you have entered invalid option");
											log.info("thanku for using cart");
										}
										break;
									case 4:
										log.info("\n         logged out successfully!!!!");
										log.info("\n         ===========================");
										break;
									}
								} while (choice != 4);
								j = 0;
							} else {
								log.info("\nCustomer login failed...you have left with " + (j - 1) + " chance");
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
					}
					break;
				case 3:
					log.info("you are in main menu now.");
					break;
				}
				break;
			case 2:Customerlogin signupcus=null;
				log.info("\n   WELCOME TO SignUp SCREEN   ");
				log.info("Enter your first name: ");
				String firstname=sc.nextLine();
				log.info("Enter your last name: ");
				String lastname=sc.nextLine();
				log.info("Enter your email: ");
				String email=sc.nextLine();
				log.info("Enter new Password: ");
				String password=sc.nextLine();
				signupcus=new Customerlogin(firstname,lastname,email,password);
				try {
					shoppingservice=new ShoppingServiceImpl();
					signupcus=shoppingservice.Signup(signupcus);
					log.info("User Sign Up successfully!!");
				}catch(BusinessException e) {
					log.error(e);
					log.info("Enterred Invalid Details");
				}
				break;
			case 3:
				log.info("\n           Thank you for visiting this app! See you soon!!!!");
				break;
			default:
				log.warn("\ndefault choice");
				break;
			}

		} while (ch != 3);
	}
}