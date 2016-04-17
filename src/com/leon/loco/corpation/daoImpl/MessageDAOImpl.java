package com.leon.loco.corpation.daoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.leon.loco.corpation.bean.Message;
import com.leon.loco.corpation.dao.MessageDAO;
import com.leon.loco.corpation.util.Page;

public class MessageDAOImpl implements MessageDAO
{

	@Override
	public void addMessage(Message message)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMessage(Message message)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMessage(int messageID)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> findAllMessage(Page page)
	{
		List<Message> result = new ArrayList<Message>();
		Message message = new Message();
		message.setContent("今天请假");
		message.setEmployeeID(123);
		message.setId(456);
		message.setPublishTime(new Timestamp(System.currentTimeMillis()));
		message.setTitle("请假");
		result.add(message);

		message = new Message();
		message.setContent("今天请假");
		message.setEmployeeID(123);
		message.setId(456);
		message.setPublishTime(new Timestamp(System.currentTimeMillis()));
		message.setTitle("请假");
		result.add(message);
		return result;
	}

	@Override
	public Message findMessageByID(int messageID)
	{
		Message message = new Message();
		message.setContent("今天请假");
		message.setEmployeeID(messageID);
		message.setId(456);
		message.setPublishTime(new Timestamp(System.currentTimeMillis()));
		message.setTitle("请假");

		return message;
	}

	@Override
	public int findAllCount()
	{
		return 2;
	}

}
