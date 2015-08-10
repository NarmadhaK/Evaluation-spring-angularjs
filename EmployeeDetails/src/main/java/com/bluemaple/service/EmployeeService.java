package com.bluemaple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemaple.dao.EmployeeDao;
import com.bluemaple.dto.GetEmployeeDetails;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	public EmployeeDao dao;
	
	
	public EmployeeDao getDao() {
		return dao;
	}


	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}


	public GetEmployeeDetails doLogin(String username, String password)
	{
		return dao.doLogin(username,password);
	}
	public GetEmployeeDetails doRegistration(GetEmployeeDetails user)
	{
		return dao.doRegistration(user);
	}
}
