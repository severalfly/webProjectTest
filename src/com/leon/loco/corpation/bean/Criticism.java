package com.leon.loco.corpation.bean;

import java.sql.Timestamp;

public class Criticism
{
	private int id;
	private String content;
	private int employeeID;
	private Timestamp criticismTime;
	private int messageID;

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

	public Timestamp getCriticismTime()
	{
		return criticismTime;
	}

	public void setCriticismTime(Timestamp criticismTime)
	{
		this.criticismTime = criticismTime;
	}

	public int getMessageID()
	{
		return messageID;
	}

	public void setMessageID(int messageID)
	{
		this.messageID = messageID;
	}

}
