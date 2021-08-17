package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.ShoppingService.LoginService;
import com.app.ShoppingServiceImpl.LoginServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;
import com.app.model.EmployeeLogin;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		log.info("      WELCOME TO ANSHU'S ONLINE SHOPPING APP     ");
		log.info("==================================================");
		int ch = 0;
		do {
			log.info("\nShopping Menu: ");
			log.info("1).Log in");
			log.info("2).Register as a Customer");
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
				log.info("\n------Welcome to Log-in Menu------");
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
					EmployeeLogin employeelogin = null;
					for (int i = 3; i > 0; i--) {
						log.info("\nWELCOME TO EMPLOYEE LOGIN SCREEN");
						log.info("=================================");
						log.info("\nEnter your UserName as email/firstname/lastname: ");
						String euser = sc.nextLine();
						log.info("\nEnter your password: ");
						int epassword = Integer.parseInt(sc.nextLine());
						employeelogin = new EmployeeLogin(euser, euser, euser, epassword);
						try {
							loginservice = new LoginServiceImpl();
							employeelogin = loginservice.empLogin(employeelogin);
							boolean b = false;
							if (employeelogin.getEmpemail().equals(euser)
									|| employeelogin.getEmpfirstname().equals(euser)
									|| employeelogin.getEmplastname().equals(euser)) {
								b = true;
							}
							if (employeelogin.getEmppassword() == (epassword) && b) {
								log.info("\nEmployee Login Successfully!!");

								int choice = 0;
								do {
									log.info("\nWelcome " + euser);
									log.info("\n1).View Profile");
									log.info("2).View customers using different filters");
									log.info("3).LogOut");
									log.info("Enter choice between 1-3: ");
									try {
										choice = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
									}
									switch (choice) {
									case 1:
										log.info("\nprocessing...");
										break;
									case 2:
										int choice1 = 0;
										log.info("\n1).view customers using email");
										log.info("2).View customers using order number");
										log.info("3).View customers using Address");
										log.info("4).View customers using First name");
										log.info("5).Go to previous Screen");
										log.info("Enter choice between 1-5: ");
										try {
											choice1 = Integer.parseInt(sc.nextLine());
										} catch (NumberFormatException e) {
										}
										switch (choice1) {
										case 1:
											log.info("Enter Customer Email you want to view: ");
											String email1 = sc.nextLine();

										}

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
							// throw new BusinessException("Invalid Details!!");
						}
					}
					break;
				case 2:
					CustomerLogin customerlogin = null;
					for (int j = 3; j > 0; j--) {
						log.info("\nWELCOME TO CUSTOMER LOGIN SCREEN");
						log.info("=================================");
						log.info("\nEnter your email: ");
						String cuser = sc.nextLine();
						log.info("Enter your password: ");
						String cpassword = sc.nextLine();
						log.info(cuser);
						log.info(cpassword);
						customerlogin = new CustomerLogin(cuser, cpassword);
						try {
							loginservice = new LoginServiceImpl();
							customerlogin = loginservice.cusLogin(customerlogin);
							
							log.info(customerlogin.getCuspassword());
							log.info(cpassword);
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
										log.info("processing...");
										break;
									case 2:
										log.info("processing...");
										break;
									case 3:
										log.info("processing...");
										break;
									case 4:
										log.info("\nlogged out successfully!!!!");
										log.info("\n===========================");
										break;
									}
								} while (choice != 4);
								j = 0;
							} else {
								log.info("\nCustomer login failed...you have left with " + (j - 1) + " chance");
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
							// throw new BusinessException("Customer login failed!!");
						}
					}
					break;
				case 3:
					log.info("you are in main menu now.");
					break;
				}
				break;
			case 2:
				log.info("\n   ~~~~WELCOME TO REGISTRATION SCREEN~~~~   ");
				break;
			case 3:
				log.info("\nThank you for visiting this app! See you soon!!!!");
				break;
			default:
				log.warn("\ndefault choice");
				break;
			}

		} while (ch != 3);
	}
}