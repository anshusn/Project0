package com.app.ShoppingService;

import com.app.exception.BusinessException;
import com.app.model.Customerlogin;
import com.app.model.Employeelogin;

public interface LoginService {
	public Customerlogin cusLogin(Customerlogin customerlogin) throws BusinessException;
	public Employeelogin empLogin(Employeelogin employeelogin) throws BusinessException;

}
