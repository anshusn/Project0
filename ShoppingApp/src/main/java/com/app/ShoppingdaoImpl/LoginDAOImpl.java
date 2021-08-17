package com.app.ShoppingdaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Shoppingdao.LoginDAO;
import com.app.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.CustomerLogin;
import com.app.model.EmployeeLogin;

public class LoginDAOImpl implements LoginDAO {
		private static Logger log=Logger.getLogger(LoginDAO.class);
		@Override
		public CustomerLogin cusLogin(CustomerLogin customerlogin) throws BusinessException {
			try(Connection connection=MySqlDbConnection.getConnection()){
				String sql="select cusemail,cuspassword from shopingapp.customerlogin";
				PreparedStatement preparedstatement=connection.prepareStatement(sql);
				ResultSet resultset=preparedstatement.executeQuery();
				while(resultset.next()) {
					customerlogin.setCusemail(resultset.getString("cusemail"));
					customerlogin.setCuspassword(resultset.getString("cuspassword"));
				}
			}catch(ClassNotFoundException | SQLException e) {
				log.warn(e.getMessage());
				log.info("Internal error occurred....Kindly contact SYSADMIN");
			}
		return customerlogin;
		
		}
	@Override
	public EmployeeLogin empLogin(EmployeeLogin employeelogin) throws BusinessException {
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select empemail,empfirstname,emplastname,emppassword from employeelogin";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next()) {
				employeelogin.setEmpemail(resultset.getString("empemail"));
				employeelogin.setEmpfirstname(resultset.getString("empfirstname"));
				employeelogin.setEmplastname(resultset.getString("emplastname"));
				employeelogin.setEmppassword(resultset.getInt("emppassword"));
			}
		}catch(ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
	return employeelogin;
	}
}
