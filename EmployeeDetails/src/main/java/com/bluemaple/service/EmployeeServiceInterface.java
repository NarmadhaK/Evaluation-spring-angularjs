package com.bluemaple.service;

import com.bluemaple.dto.GetEmployeeDetails;

public interface EmployeeServiceInterface {

	public GetEmployeeDetails doLogin(String username, String password);

	public GetEmployeeDetails doRegistration(GetEmployeeDetails user);

	

}
