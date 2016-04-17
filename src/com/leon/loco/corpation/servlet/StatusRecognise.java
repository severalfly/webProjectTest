package com.leon.loco.corpation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leon.loco.corpation.bean.Employee;
import com.leon.loco.corpation.dao.EmployeeDAO;
import com.leon.loco.corpation.factory.EmployeeDAOFactory;
import com.leon.loco.corpation.util.ObjectUtils;

public class StatusRecognise extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String employeeID = request.getParameter("employeeID");
		String password = request.getParameter("password");
		if (ObjectUtils.isNull(employeeID))
		{
			request.setAttribute("error", "请输入员工编号");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
		}
		else if (ObjectUtils.isNull(password))
		{
			request.setAttribute("error", "请输入员工系统口令");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
		}
		else
		{
			EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
			Employee employee = employeeDAO.findEmployeeById(ObjectUtils.getInt(employeeID));
			if (ObjectUtils.isNull(employee))
			{
				request.setAttribute("error", "该员工编号不存在");
				dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			}
			else if (password.equals(employee.getPassword()))
			{
				request.getSession().setAttribute("employee", employee);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			else
			{
				request.setAttribute("error", "系统口令不正确");
				dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
