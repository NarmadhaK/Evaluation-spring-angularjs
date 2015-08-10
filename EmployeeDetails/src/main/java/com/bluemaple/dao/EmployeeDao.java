package com.bluemaple.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.bluemaple.dto.GetEmployeeDetails;

@Repository
public class EmployeeDao implements EmployeeDaoInterface {
      
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public GetEmployeeDetails doLogin(String username, String password) {
		
		String sql="SELECT * FROM user WHERE user_name=? AND password=?"+username+""+password;
			
			try {
				GetEmployeeDetails user = jdbcTemplate.query(sql,
						new ResultSetExtractor<GetEmployeeDetails>() {

							public GetEmployeeDetails extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								if (rs.next()) {
									GetEmployeeDetails user = new GetEmployeeDetails();
									user.setUsername(rs.getString(1));
									user.setPassword(rs.getString(2));
									user.setTemp_password(rs.getString(3));
									user.setEmail_address(rs.getString(4));
									user.setFirst_name(rs.getString(5));
									user.setLast_name(rs.getString(6));
									user.setDob(rs.getString(7));
									user.setAge(rs.getString(8));
									user.setSex(rs.getString(9));

									return user;
								}
								return null;
							}
						}, new Object[] {username,password});
				if (user != null) { 
					return user;
				}
			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
			return null;
		}
	
	

	public GetEmployeeDetails doRegistration(GetEmployeeDetails user) {
		String sql = "INSERT INTO employeedb.user"
				+ "(username,password,temp_password,email_address,first_name,last_name,dob,age,sex) VALUES (?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getUsername(),user.getPassword(),user.getTemp_password(),user.getEmail_address(),user.getFirst_name(),user.getLast_name(),user.getDob(),user.getAge(),user.getSex());
		return null;
	}
}
