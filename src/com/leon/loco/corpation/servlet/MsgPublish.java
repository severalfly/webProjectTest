package com.leon.loco.corpation.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leon.loco.corpation.bean.Employee;
import com.leon.loco.corpation.bean.Message;
import com.leon.loco.corpation.dao.MessageDAO;
import com.leon.loco.corpation.factory.MessageDAOFactory;
import com.leon.loco.corpation.util.ObjectUtils;

public class MsgPublish extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if (ObjectUtils.isNull(employee))
		{
			request.setAttribute("error", "要发布消息必须首先进行身份识别");
			request.getRequestDispatcher("/publishNewMsg.jsp").forward(request, response);
		}
		else
		{
			if (ObjectUtils.isNull(title))
			{
				request.setAttribute("error", "必须输入消息标题");
				request.getRequestDispatcher("/publishNewMsg.jsp").forward(request, response);
			}
			else
			{
				Message message = new Message();
				message.setTitle(title);
				message.setContent(content);
				message.setPublishTime(new Timestamp(System.currentTimeMillis()));
				MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
				messageDAO.addMessage(message);
				request.getRequestDispatcher("/servlet/GetMessageList").forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
