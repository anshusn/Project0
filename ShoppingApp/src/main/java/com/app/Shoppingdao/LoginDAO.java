package com.app.Shoppingdao;

import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;
import com.app.model.EmployeeLogin;

public interface LoginDAO {
	public CustomerLogin cusLogin(CustomerLogin customerlogin) throws BusinessException;
	public EmployeeLogin empLogin(EmployeeLogin employeelogin) throws BusinessException;

}
