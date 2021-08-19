package com.app.ShoppingdaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.app.Shoppingdao.LoginDAO;
import com.app.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customerlogin;
import com.app.model.Employeelogin;

public class LoginDAOImpl implements LoginDAO {
		private static Logger log=Logger.getLogger(LoginDAO.class);
		@Override
		public Customerlogin cusLogin(Customerlogin customerlogin) throws BusinessException {
			try(Connection connection=MySqlDbConnection.getConnection()){
				String sql="select cusemail,cuspassword from customerlogin where cusemail=?";
				PreparedStatement preparedstatement=connection.prepareStatement(sql);
				preparedstatement.setString(1,customerlogin.getCusemail());
					ResultSet resultset=preparedstatement.executeQuery();
					if(resultset.next()) {
						customerlogin.setCusemail(resultset.getString("cusemail"));
						customerlogin.setCuspassword(resultset.getString("cuspassword"));
					}else {
						throw new BusinessException("invalid email");
					}
				
			}catch(ClassNotFoundException | SQLException e) {
				log.warn(e.getMessage());
				log.info("Internal error occurred....Kindly contact SYSADMIN");
			}
		return customerlogin;
		
		}
	@Override
	public Employeelogin empLogin(Employeelogin employeelogin) throws BusinessException {
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select empemail,emppassword from employeelogin";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next()) {
				employeelogin.setEmpemail(resultset.getString("empemail"));
				employeelogin.setEmppassword(resultset.getString("emppassword"));
			}
		}catch(ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			log.info("Internal error occurred....Kindly contact SYSADMIN");
		}
	return employeelogin;
	}
}
