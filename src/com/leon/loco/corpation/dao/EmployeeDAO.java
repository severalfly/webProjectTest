package com.leon.loco.corpation.dao;

import java.util.List;

import com.leon.loco.corpation.bean.Employee;

public interface EmployeeDAO
{
	public void addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int employeeID);

	public List<Employee> findAllEmployee();

	public Employee findEmployeeById(int employeeID);
}
