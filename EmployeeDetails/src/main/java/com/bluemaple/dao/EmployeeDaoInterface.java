package com.bluemaple.dao;

import com.bluemaple.dto.GetEmployeeDetails;

public interface EmployeeDaoInterface 
{
	public GetEmployeeDetails doLogin(String username, String password);
	
	public GetEmployeeDetails doRegistration(GetEmployeeDetails user);
}
