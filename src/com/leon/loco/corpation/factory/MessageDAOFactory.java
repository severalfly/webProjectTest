package com.leon.loco.corpation.factory;

import com.leon.loco.corpation.dao.MessageDAO;
import com.leon.loco.corpation.daoImpl.MessageDAOImpl;

public class MessageDAOFactory
{
	public static MessageDAO getMessageDAOInstance()
	{
		return new MessageDAOImpl();
	}
}
