package com.leon.loco.corpation.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leon.loco.corpation.bean.Employee;
import com.leon.loco.corpation.bean.Reply;
import com.leon.loco.corpation.dao.ReplyDAO;
import com.leon.loco.corpation.factory.ReplyDAOFactory;
import com.leon.loco.corpation.util.ObjectUtils;

public class CommitReply extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String replyContent = request.getParameter("replyContent");
		int messageID = ObjectUtils.getInt(request.getParameter("messageID"));
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if (ObjectUtils.isNull(employee))
		{
			request.setAttribute("error", "首先要进行身份验证");
		}
		else
		{
			if (ObjectUtils.isNull(replyContent))
			{
				request.setAttribute("error", "必须输入回复内容");
			}
			Reply reply = new Reply();
			reply.setContent(replyContent);
			reply.setMessageId(messageID);
			reply.setEmployeeID(employee.getId());
			reply.setReplyTime(new Timestamp(System.currentTimeMillis()));
			ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
			replyDAO.addReply(reply);

		}
		request.getRequestDispatcher("/servlet/GetMessage?messageID=" + messageID).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
