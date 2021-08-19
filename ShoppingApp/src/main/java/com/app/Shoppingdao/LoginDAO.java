package com.app.Shoppingdao;

import com.app.exception.BusinessException;
import com.app.model.Customerlogin;
import com.app.model.Employeelogin;

public interface LoginDAO {
	public Customerlogin cusLogin(Customerlogin customerlogin) throws BusinessException;
	public Employeelogin empLogin(Employeelogin employeelogin) throws BusinessException;

}
