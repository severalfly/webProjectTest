package com.leon.loco.corpation.dao;

import java.util.List;

import com.leon.loco.corpation.bean.Message;
import com.leon.loco.corpation.util.Page;

public interface MessageDAO
{
	public void addMessage(Message message);

	public void updateMessage(Message message);

	public void deleteMessage(int messageID);

	public List<Message> findAllMessage(Page page);

	public Message findMessageByID(int messageID);

	public int findAllCount();
}
