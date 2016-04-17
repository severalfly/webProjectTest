package com.leon.loco.corpation.factory;

import com.leon.loco.corpation.dao.ReplyDAO;
import com.leon.loco.corpation.daoImpl.ReplyDAOImpl;

public class ReplyDAOFactory
{
	public static ReplyDAO getReplyDAOInstance()
	{
		return new ReplyDAOImpl();
	}
}
