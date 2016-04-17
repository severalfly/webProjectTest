package com.leon.loco.corpation.daoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.leon.loco.corpation.bean.Reply;
import com.leon.loco.corpation.dao.ReplyDAO;
import com.leon.loco.corpation.util.Page;

public class ReplyDAOImpl implements ReplyDAO
{

	@Override
	public void addReply(Reply reply)
	{

	}

	@Override
	public List<Reply> findReplyByMsgID(int messageID, Page page)
	{
		List<Reply> result = new ArrayList<Reply>();
		Reply reply = new Reply();
		reply.setContent("reply Content");
		reply.setEmployeeID(123);
		reply.setId(111);
		reply.setMessageId(messageID);
		reply.setReplyTime(new Timestamp(System.currentTimeMillis()));
		result.add(reply);
		return result;
	}

	@Override
	public int findCountByMsgID(int messageID)
	{

		return 1;
	}

}
