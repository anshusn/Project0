package com.app.ShoppingServiceImpl;

import com.app.ShoppingService.LoginService;
import com.app.Shoppingdao.LoginDAO;
import com.app.ShoppingdaoImpl.LoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;
import com.app.model.EmployeeLogin;

public class LoginServiceImpl implements LoginService {
	LoginDAO logindao=new LoginDAOImpl();
	@Override
	public CustomerLogin cusLogin(CustomerLogin customerlogin) throws BusinessException {
		if(customerlogin.getCusemail()!=null && customerlogin.getCuspassword()!=null) {
			customerlogin=logindao.cusLogin(customerlogin);
		}else{
			throw new BusinessException("invalid details!!");
		}
		return customerlogin;
	}

	@Override
	public EmployeeLogin empLogin(EmployeeLogin employeelogin) throws BusinessException {
		if(employeelogin.getEmpemail()!=null && employeelogin.getEmppassword()!=0) {
			employeelogin=logindao.empLogin(employeelogin);
		}else{
			throw new BusinessException("invalid details!!");
		}
		return employeelogin;
	}

}
