package com.leon.loco.corpation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leon.loco.corpation.bean.Message;
import com.leon.loco.corpation.dao.MessageDAO;
import com.leon.loco.corpation.factory.MessageDAOFactory;
import com.leon.loco.corpation.util.ObjectUtils;
import com.leon.loco.corpation.util.Page;
import com.leon.loco.corpation.util.PageUtil;

public class GetMessageList extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if (ObjectUtils.isNull(currentPageStr))
		{
			currentPage = 1;
		}
		else
		{
			currentPage = ObjectUtils.getInt(currentPageStr);
		}
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
		List<Message> messages = messageDAO.findAllMessage(page);
		request.setAttribute("messageList", messages);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/msgList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
