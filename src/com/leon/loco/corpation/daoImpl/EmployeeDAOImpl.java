package com.leon.loco.corpation.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.leon.loco.corpation.bean.Employee;
import com.leon.loco.corpation.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO
{

	@Override
	public void addEmployee(Employee employee)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(Employee employee)
	{

	}

	@Override
	public void deleteEmployee(int employeeID)
	{

	}

	@Override
	public List<Employee> findAllEmployee()
	{
		List<Employee> list = new ArrayList<Employee>();
		Employee result = new Employee();
		result.setId(1);
		result.setPassword("123");
		result.setBirth(new Date());
		result.setLead(false);
		result.setSex(true);
		result.setName("123");
		list.add(result);

		result = new Employee();
		result.setId(2);
		result.setPassword("23");
		result.setBirth(new Date());
		result.setLead(false);
		result.setSex(true);
		result.setName("23");
		list.add(result);
		return list;
	}

	@Override
	public Employee findEmployeeById(int employeeID)
	{
		Employee result = new Employee();
		result.setId(employeeID);
		result.setPassword("123");
		result.setBirth(new Date());
		result.setLead(false);
		result.setSex(true);
		result.setName("123");
		return result;
	}

}
