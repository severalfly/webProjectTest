package com.leon.loco.corpation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leon.loco.corpation.bean.Message;
import com.leon.loco.corpation.bean.Reply;
import com.leon.loco.corpation.dao.MessageDAO;
import com.leon.loco.corpation.factory.MessageDAOFactory;
import com.leon.loco.corpation.factory.ReplyDAOFactory;
import com.leon.loco.corpation.util.ObjectUtils;

public class GetMessage extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int messageID = ObjectUtils.getInt(request.getParameter("messageID"));
		MessageDAO messageDAO= MessageDAOFactory.getMessageDAOInstance();
		Message message = messageDAO.findMessageByID(messageID);
		List<Reply> replyList = ReplyDAOFactory.getReplyDAOInstance().findReplyByMsgID(messageID, null);
		request.setAttribute("message", message);
		request.setAttribute("replyList", replyList);
		request.getRequestDispatcher("/showMsg.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
