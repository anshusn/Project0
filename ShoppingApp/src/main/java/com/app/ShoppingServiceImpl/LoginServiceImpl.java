package com.app.ShoppingServiceImpl;

import com.app.ShoppingService.LoginService;
import com.app.Shoppingdao.LoginDAO;
import com.app.ShoppingdaoImpl.LoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customerlogin;
import com.app.model.Employeelogin;

public class LoginServiceImpl implements LoginService {
	LoginDAO logindao=new LoginDAOImpl();
	@Override
	public Customerlogin cusLogin(Customerlogin customerlogin) throws BusinessException {
		if(customerlogin.getCusemail()!=null && customerlogin.getCuspassword()!=null) {
			customerlogin=logindao.cusLogin(customerlogin);
		}else{
			throw new BusinessException("invalid details!!");
		}
		return customerlogin;
	}

	@Override
	public Employeelogin empLogin(Employeelogin employeelogin) throws BusinessException {
		if(employeelogin.getEmpemail()!=null && employeelogin.getEmppassword()!=null) {
			employeelogin=logindao.empLogin(employeelogin);
		}else{
			throw new BusinessException("invalid details!!");
		}
		return employeelogin;
	}

}
