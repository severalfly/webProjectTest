package com.leon.loco.corpation.bean;

import java.sql.Timestamp;

public class Reply
{
	private int id;
	private String content;
	private int employeeID;
	private Timestamp replyTime;
	private int messageId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getEmployeeID()
	{
		return employeeID;
	}

	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}

	public Timestamp getReplyTime()
	{
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime)
	{
		this.replyTime = replyTime;
	}

	public int getMessageId()
	{
		return messageId;
	}

	public void setMessageId(int messageId)
	{
		this.messageId = messageId;
	}

}
