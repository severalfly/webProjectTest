package com.leon.loco.corpation.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Employee implements Cloneable
{
	private int id;
	private String name;
	private boolean sex;
	private Date birth;
	private String phone;
	private String place;
	private Timestamp createTime;
	private String password;
	private boolean isLead;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isSex()
	{
		return sex;
	}

	public void setSex(boolean sex)
	{
		this.sex = sex;
	}

	public Date getBirth()
	{
		return birth;
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getPlace()
	{
		return place;
	}

	public void setPlace(String place)
	{
		this.place = place;
	}

	public Timestamp getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isLead()
	{
		return isLead;
	}

	public void setLead(boolean isLead)
	{
		this.isLead = isLead;
	}

}
