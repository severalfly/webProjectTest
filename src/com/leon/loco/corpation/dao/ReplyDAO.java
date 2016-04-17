package com.leon.loco.corpation.dao;

import java.util.List;

import com.leon.loco.corpation.bean.Reply;
import com.leon.loco.corpation.util.Page;

public interface ReplyDAO
{
	public void addReply(Reply reply);

	public List<Reply> findReplyByMsgID(int messageID, Page page);

	public int findCountByMsgID(int messageID);
}
