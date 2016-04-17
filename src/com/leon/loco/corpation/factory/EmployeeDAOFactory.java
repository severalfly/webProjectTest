package com.leon.loco.corpation.factory;

import com.leon.loco.corpation.dao.EmployeeDAO;
import com.leon.loco.corpation.daoImpl.EmployeeDAOImpl;

public class EmployeeDAOFactory
{
	public static EmployeeDAO getEmployeeDAOInstance()
	{
		return new EmployeeDAOImpl();
	}
}
